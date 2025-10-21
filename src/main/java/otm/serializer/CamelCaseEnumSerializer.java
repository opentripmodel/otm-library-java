package otm.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.base.CaseFormat;
import java.io.IOException;

public class CamelCaseEnumSerializer extends StdSerializer<Enum<?>> {

    @SuppressWarnings("unchecked") // We know for 100% this will never fail.
    public CamelCaseEnumSerializer() {
        super((Class<Enum<?>>)(Class<?>)Enum.class);
    }

    @Override
    public void serialize(Enum<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value != null) {
            String camelCaseName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, value.name());
            gen.writeString(camelCaseName);
        }
    }
}