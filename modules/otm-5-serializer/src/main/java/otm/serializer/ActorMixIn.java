package otm.serializer;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import otm.v5.model.Actor;

/**
 * This mix-in can be used by Jackson ObjectMapper when reading OTM 5.7 to automatically map to Actor
 * when no type property is present.
 *
 * <p>Usage:</p>
 * <code>
 *     ObjectMapper mapper = new ObjectMapper();<br />
 *     mapper.addMixIn(Actor.class, ActorMixIn.class);
 * </code>
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "type", visible = true, defaultImpl = Actor.class)
public abstract class ActorMixIn {
    // no body: mix-in is used to add additional annotations on target class
}
