package otm.serializer;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import otm.v5.model.Actor;

/**
 * This module is used to enable the ObjectMapper to be able to serialize/deserialize
 * an OTM actor entity without a type. This is needed to be able to read/write versions of OTM before v5.7
 *
 * <p>Usage:</p>
 * <code>
 *     ObjectMapper mapper = new ObjectMapper();<br />
 *     mapper.registerModule(new SupportActorWithoutTypeModule());
 * </code>
 */
public class SupportActorWithoutTypeModule extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.addBeanSerializerModifier(new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifySerializer(
                SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {

                if (beanDesc.getBeanClass().equals(Actor.class)) {
                    return new AppendingActorWithoutTypeSerializer((JsonSerializer<Object>) serializer);
                }
                return serializer;
            }
        });
    }
}