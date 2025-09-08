package otm.profile.profiles.cbs.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ArrayNode;
import otm.model.entities.ContactDetailType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class CbsProfileProvider {

    public static JsonSchema getSchema() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper yamlMapper = new YAMLMapper();
        ObjectNode schema;

        try (InputStream inputStream = CbsProfileProvider.class.getClassLoader().getResourceAsStream("CbsSchema_1.0.1")) {
            if (inputStream == null) {
                throw new IOException("File CbsSchema not found in resources!");
            }
            schema = (ObjectNode) yamlMapper.readTree(inputStream);
        }

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);

        ObjectNode propertiesNode = (ObjectNode) schema.get("properties");

        // Add a "definitions" node if it doesn't exist
        ObjectNode definitionsNode = (ObjectNode) schema.get("definitions");
        if (definitionsNode == null) {
            definitionsNode = JsonNodeFactory.instance.objectNode();
            schema.set("definitions", definitionsNode);
        }

        // Tweak 2: /actors/items/properties/entity/properties/locations
        // Navigate to the location CbsSchema to be moved
        ObjectNode actorItemSchema = (ObjectNode) propertiesNode.get("actors").get("items");
        ObjectNode entitySchema = (ObjectNode) actorItemSchema.get("properties").get("entity");
        ObjectNode locationsSchema = (ObjectNode) entitySchema.get("properties").get("locations");

        // Get the actual object CbsSchema from the array's "items" property
        JsonNode locationObjectSchema = locationsSchema.get("items");

        // Register the object CbsSchema in "definitions"
        // This is the core logic: take the node and move it
        definitionsNode.set("Location", locationObjectSchema);

        // Replace the original 'locations' property with a $ref
        ObjectNode newLocationsRef = JsonNodeFactory.instance.objectNode();
        newLocationsRef.put("type", "array");

        ObjectNode refNode = JsonNodeFactory.instance.objectNode();
        refNode.put("$ref", "#/definitions/Location");
        newLocationsRef.set("items", refNode);

        ObjectNode entitySchemaProperties = (ObjectNode) entitySchema.get("properties");
        entitySchemaProperties.set("locations", newLocationsRef);

        JsonSchema finalSchema = factory.getSchema(schema);

        return finalSchema;
    }
}
