package otm.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import otm.model.entities.EmissionEvent;
import otm.model.entities.Event;
import otm.model.entities.FuelConsumedEvent;

import java.io.IOException;

/**
 * Handles deserialization of the abstract {@link Event} type, e.g. inside {@code contextEvents},
 * using the OTM {@code eventType} field as discriminator. Serialization needs no special
 * handling because Jackson serializes the runtime type of each event.
 */
public class OtmEventDeserializer extends StdDeserializer<Event> {

    public OtmEventDeserializer() {
        super(Event.class);
    }

    @Override
    public Event deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        JsonNode eventTypeNode = node.get("eventType");
        if (eventTypeNode == null) {
            throw new IOException("Cannot deserialize event: required discriminator field 'eventType' is missing.");
        }

        String eventType = eventTypeNode.asText();

        Class<? extends Event> concreteType = resolveType(eventType);
        if (concreteType == null) {
            throw new IOException("Cannot deserialize event: unsupported eventType '" + eventType + "'.");
        }

        // The discriminator is a computed (getter-only) property on the concrete classes, so
        // remove it before mapping the remaining fields
        if (node instanceof ObjectNode objectNode) {
            objectNode.remove("eventType");
        }

        return p.getCodec().treeToValue(node, concreteType);
    }

    private static Class<? extends Event> resolveType(String eventType) {
        // Note: LocationUpdateEvent is not part of this mapping because it extends UpdateEvent,
        // which is not a subtype of Event in this library.
        switch (eventType) {
            case "fuelConsumedEvent":
                return FuelConsumedEvent.class;
            case "emissionEvent":
                return EmissionEvent.class;
            default:
                return null;
        }
    }
}
