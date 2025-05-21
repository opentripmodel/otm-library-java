package otm.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Objects; // For Objects.requireNonNull

public class OtmSerializer implements IOtmSerializer {

    private final ObjectMapper objectMapper;

    /**
     * Initializes a new instance of the {@link OtmSerializer} class.
     *
     * @param objectMapper Optional custom Jackson ObjectMapper. If null, a default one is created using {@link JsonOptionsFactory}.
     */
    public OtmSerializer(ObjectMapper objectMapper) {
        this.objectMapper = (objectMapper != null) ? objectMapper : JsonOptionsFactory.createDefault();
    }

    /**
     * Initializes a new instance of the {@link OtmSerializer} class with default Jackson options.
     */
    public OtmSerializer() {
        this(null);
    }

    @Override
    public <T> String serialize(T entity) throws IOException {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new IOException("Error serializing object to JSON string", e);
        }
    }

    @Override
    public <T> T deserialize(String json, Class<T> valueType) throws IOException {
        Objects.requireNonNull(valueType, "valueType cannot be null for deserialization");
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            throw new IOException("Error deserializing JSON string to object", e);
        }
    }

    @Override
    public <T> void serializeToStream(T entity, OutputStream outputStream) throws IOException {
        Objects.requireNonNull(outputStream, "outputStream cannot be null");
        objectMapper.writeValue(outputStream, entity);
    }

    @Override
    public <T> T deserializeFromStream(InputStream inputStream, Class<T> valueType) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        Objects.requireNonNull(valueType, "valueType cannot be null for deserialization from stream");
        return objectMapper.readValue(inputStream, valueType);
    }
}