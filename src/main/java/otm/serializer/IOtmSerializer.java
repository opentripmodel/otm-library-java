package otm.serializer;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public interface IOtmSerializer {

    /**
     * Serializes an object to a JSON string using default options.
     *
     * @param <T> The type of the object to serialize.
     * @param entity The object to serialize.
     * @return The JSON string representation.
     * @throws IOException If an I/O error occurs during serialization.
     */
    <T> String serialize(T entity) throws IOException;

    /**
     * Deserializes a JSON string to an object.
     *
     * @param <T> The target type of the object.
     * @param json The JSON string input.
     * @param valueType The Class object representing the target type T.
     * @return The deserialized object.
     * @throws IOException If an I/O error occurs during deserialization.
     */
    <T> T deserialize(String json, Class<T> valueType) throws IOException;

    /**
     * Serializes an object to a stream in JSON format.
     * Optimized for low-memory scenarios.
     *
     * @param <T> The type of the object to serialize.
     * @param entity The object to serialize.
     * @param outputStream The target output stream.
     * @throws IOException If an I/O error occurs during serialization.
     * @throws IllegalArgumentException If outputStream is null.
     */
    <T> void serializeToStream(T entity, OutputStream outputStream) throws IOException;

    /**
     * Deserializes JSON from a stream into an object.
     *
     * @param <T> The target type of the object.
     * @param inputStream The input stream containing JSON.
     * @param valueType The Class object representing the target type T.
     * @return The deserialized object.
     * @throws IOException If an I/O error occurs during deserialization.
     * @throws IllegalArgumentException If inputStream is null.
     */
    <T> T deserializeFromStream(InputStream inputStream, Class<T> valueType) throws IOException;
}