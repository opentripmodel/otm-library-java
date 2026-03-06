package otm.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import otm.v5.model.Actor;

public class AppendingActorWithoutTypeSerializer extends StdSerializer<Actor> implements ResolvableSerializer {

    private final JsonSerializer<Object> defaultSerializer;

    public AppendingActorWithoutTypeSerializer(JsonSerializer<Object> defaultSerializer) {
        super(Actor.class);
        this.defaultSerializer = defaultSerializer;
    }

    @Override
    public void serialize(Actor value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException {
        defaultSerializer.serialize(value, gen, serializers);
    }

    @Override
    public void serializeWithType(Actor value, com.fasterxml.jackson.core.JsonGenerator gen,
        SerializerProvider serializers, TypeSerializer typeSer)
        throws IOException {
        serialize(value, gen, serializers);
    }

    @Override
    public void resolve(SerializerProvider provider) throws JsonMappingException {
        // This ensures any nested serializers within the default are linked up
        if (defaultSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) defaultSerializer).resolve(provider);
        }
    }
}