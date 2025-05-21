package otm.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;


public class JsonValidationHelper {

    // Using a static ObjectMapper for efficiency, configured with default behavior
    // For OTM-specific serialization options (camelCase, enum as string), you'd typically
    // use a pre-configured ObjectMapper similar to JsonOptionsFactory in .NET.
    // For simplicity here, we'll use a basic ObjectMapper.
    // If you need specific configurations for validation, create a new ObjectMapper
    // or use a configured one passed from a factory.
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Allow extra fields in JSON

    /**
     * Validates that JSON is well-formed and deserializable into type T.
     *
     * @param json The JSON string to validate.
     * @param type The target class type to deserialize into.
     * @param <T>  The type of the object to deserialize.
     * @return A {@link JsonValidationResult} indicating success or failure.
     */
    public static <T> JsonValidationResult validateJson(String json, Class<T> type) {
        try {
            // Attempt to deserialize the JSON to the specified type
            objectMapper.readValue(json, type);
            return JsonValidationResult.success();
        } catch (JsonProcessingException ex) {
            // Catch JSON-specific parsing or mapping errors
            return JsonValidationResult.failure("Deserialization error: " + ex.getMessage(), ex);
        } catch (Exception ex) {
            // Catch any other unexpected errors during deserialization
            return JsonValidationResult.failure("Unexpected error: " + ex.getMessage(), ex);
        }
    }

    /**
     * Validates that JSON is syntactically correct.
     *
     * @param json The JSON string to validate.
     * @return A {@link JsonValidationResult} indicating success or failure.
     */
    public static JsonValidationResult validateSyntax(String json) {
        try {
            // Attempt to parse the JSON. If it's not well-formed, a JsonProcessingException will be thrown.
            objectMapper.readTree(json); // Use readTree to parse without binding to a specific class
            return JsonValidationResult.success();
        } catch (JsonProcessingException ex) {
            // Catch JSON-specific parsing errors
            return JsonValidationResult.failure("Malformed JSON: " + ex.getMessage(), ex);
        } catch (Exception ex) {
            // Catch any other unexpected errors during parsing
            return JsonValidationResult.failure("Unexpected error during parsing: " + ex.getMessage(), ex);
        }
    }
}