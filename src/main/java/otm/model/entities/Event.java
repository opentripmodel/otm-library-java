package otm.model.entities;

import java.util.List;

/**
 * <p>
 * {@code Events} - like {@code actions} - model dynamic entities that couple various static entities at a certain moment in time. Events are used for either real-time updates, or updates on earlier provided data. Notice that in both event types these are updates on earlier provided data, whereas actions are usually used together with the entities they dynamically couple.
 * </p>
 * <p>
 * There are various kinds of events that fall into the two earlier mentioned kinds.
 * </p>
 * <p>
 * <b>Real-time updates:</b>
 *  <ul>
 *      <li>The <b>LocationUpdateEvent</b> that provides location data received from some GPS.</li>
 *      <li>The <b>SensorUpdateEvent</b> that provides sensor value updates (such as temperature or speed measurements) received from a sensor.</li>
 *      <li>The <b>StartMovingEvent, StopMovingEvent, StartEngineEvent, StopEngineEvent</b> that indicate events provided by Fleet Management Systems.</li>
 *  </ul>
 * <b>Both real-time and projected/realized events</b>
 *  <ul>
 *      <li>The <b>EmissionEvent</b> that contains information about how much emission has been produced during a move / on a trip / per consignment. Can be provided as an actual value, projected based on some calculation, or realized as measured by some sensor.</li>
 *      <li>The <b>FuelConsumedEvent</b> that contains information about how much fuel was consumed during a move / on a trip / per consignment. Can be provided as an actual value, projected based on some calculation, or realized as measured by some sensor.</li>
 *  </ul>
 *  <b>Updates on earlier provided data:</b>
 * <ul>
 *     <li>The <b>UpdateEvent</b> that is used to update an earlier provided entity with new information. Note that only the changed data has to be provided.</li>
 *     <li>The <b>AssociationCreatedEvent</b> and <b>AssociationRemovedEvent</b> that allow for static entities to be coupled after the fact. Such as coupling a Vehicle to a Trip.</li>
 * </ul>
 */
public abstract class Event extends OtmEntity {

    /**
     * The type of this event. This is an abstract property that must be implemented by concrete event classes.
     *
     * @return The EventType of this event.
     */
    public abstract EventType getEventType();

    /**
     * A lifecycle models when the data in the action is taking place. You can provide the same action in multiple
     * lifecycles to model how it changes over time. For example the planned and realized time of an action taking
     * place can differ because of unforeseen circumstances (such as traffic jams).
     */
    private Lifecycle lifecycle;

    /**
     * The actors associated with this transport order, for instance the consignor, consignee.
     */
    private List<InlineAssociationActorType> actors; // C# IEnumerable typically maps to Java List or Collection

    /**
     * Get the lifecycle for this event.
     *
     * @return The lifecycle.
     */
    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    /**
     * Set the lifecycle for this event.
     *
     * @param lifecycle The lifecycle to set.
     */
    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    /**
     * Get the actors associated with this event.
     *
     * @return A list of actors.
     */
    public List<InlineAssociationActorType> getActors() {
        return actors;
    }

    /**
     * Set the actors associated with this event.
     *
     * @param actors A list of actors to set.
     */
    public void setActors(List<InlineAssociationActorType> actors) {
        this.actors = actors;
    }
}