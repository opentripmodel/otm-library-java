package otm.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.CaseFormat;
import java.io.IOException;

public class CamelCaseEnumDeserializer extends StdDeserializer<Enum<?>> implements ContextualDeserializer  {

    @SuppressWarnings({"rawtypes"})
    private Class<Enum> enumClass;

    public CamelCaseEnumDeserializer() {
        super(Enum.class);
    }

    public CamelCaseEnumDeserializer(Class<Enum> enumClass) {
        super(enumClass);
        this.enumClass = enumClass;
    }

    @SuppressWarnings({"rawtypes"})
    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
        // This is the magic: Jackson tells us what specific enum class we are deserializing
        @SuppressWarnings("unchecked")
        Class<Enum> enumType = (Class<Enum>) ctxt.getContextualType().getRawClass();
        return new CamelCaseEnumDeserializer(enumType);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Enum<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String jsonValue = p.getText();
        String enumName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, jsonValue);

        try {
            return Enum.valueOf(enumClass, enumName);
        } catch (IllegalArgumentException e) {
            ctxt.handleWeirdStringValue(this.enumClass, jsonValue, "value not one of declared Enum constants");
            return null;
        }
    }
}