package otm.profile.profiles.carbonfootprint.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

import java.io.IOException;
import java.io.InputStream;

/**
 * Provides the embedded JSON schemas of the OTM Carbon Footprint profile (DRAFT). The message
 * models are maintained by SUTC on the Semantic Treehouse
 * (https://sutc.semantic-treehouse.nl/specifications); these schemas should be regenerated
 * once the profile is formally released.
 */
public class CarbonFootprintProfileProvider {

    private static final String INPUT_SCHEMA_RESOURCE = "CarbonFootprintInputSchema_0.1";
    private static final String RESULT_SCHEMA_RESOURCE = "CarbonFootprintResultSchema_0.1";

    private CarbonFootprintProfileProvider() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @return the schema for the CO2 Calculation Input sub-profile.
     */
    public static JsonSchema getInputSchema() throws IOException {
        return loadSchema(INPUT_SCHEMA_RESOURCE);
    }

    /**
     * @return the schema for the CO2 Calculation Result sub-profile.
     */
    public static JsonSchema getResultSchema() throws IOException {
        return loadSchema(RESULT_SCHEMA_RESOURCE);
    }

    private static JsonSchema loadSchema(String resourceName) throws IOException {
        ObjectMapper yamlMapper = new YAMLMapper();
        JsonNode schema;

        try (InputStream inputStream = CarbonFootprintProfileProvider.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IOException("File " + resourceName + " not found in resources!");
            }
            schema = yamlMapper.readTree(inputStream);
        }

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);

        return factory.getSchema(schema);
    }
}
