package otm.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonOptionsFactory {

    private JsonOptionsFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates a default ObjectMapper instance with:
     * - CamelCase naming policy for properties
     * - Indented output for readability
     * - Ignores null and default/empty values during serialization (when writing).
     *
     * @return Preconfigured {@link ObjectMapper} object.
     */
    public static ObjectMapper createDefault() {
        return JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE) // CamelCase naming policy
                .configure(SerializationFeature.INDENT_OUTPUT, true) // Indented output
                .serializationInclusion(JsonInclude.Include.NON_NULL) // Ignore null values
                .serializationInclusion(JsonInclude.Include.NON_DEFAULT) // Ignore default values (e.g., 0 for int, false for boolean)
                .build();
    }
}