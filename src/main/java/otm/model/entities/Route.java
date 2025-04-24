package otm.model.entities;

import java.util.List;

/**
 * A route models the path going from one location to at least one other location.
 */
public class Route extends OtmEntity {

    /**
     * The context events provides some optional information about the events that can provide additional
     * information on the current state of this entity.
     * <p>
     * For example: your system might send ETA information for the arrival of a vehicle on a location.  To make it clear
     * what caused this ETA to be updated, we can include some information about what caused this ETA update by including
     * an event as context. If your ETA update was caused by a location update, this event can be included as context.
     * If the ETA was caused by a traffic accident on the route of the vehicle, you can include that event in the context.
     */
    private Object contextEvents;

    /**
     * Geographic representation of this route.
     * todo this attribute type looks to be wrong, this should be a list of possible types
     */
    private LatLonArrayGeoReference geoReferences;

    /**
     * Actors associated with this route, for instance the Company that requires this route as a Last-Mile guidance.
     */
    private List<InlineAssociationActorType> actors;

    /**
     * All the actions that need to be executed on this route.
     */
    private List<InlineAssociationType<StopAction>> actions;

    /**
     * Constraints of using this route, for instance it might only be used by vehicles with below a certain weight.
     */
    private InlineAssociationType<Constraint> constraint;

    // Getters and setters

    /**
     * Gets the context events associated with the route.
     *
     * @return The context events.
     */
    public Object getContextEvents() {
        return contextEvents;
    }

    /**
     * Sets the context events associated with the route.
     *
     * @param contextEvents The context events to set.
     */
    public void setContextEvents(Object contextEvents) {
        this.contextEvents = contextEvents;
    }

    /**
     * Gets the geographic references of the route.
     *
     * @return The geographic references.
     */
    public LatLonArrayGeoReference getGeoReferences() {
        return geoReferences;
    }

    /**
     * Sets the geographic references of the route.
     *
     * @param geoReferences The geographic references to set.
     */
    public void setGeoReferences(LatLonArrayGeoReference geoReferences) {
        this.geoReferences = geoReferences;
    }

    /**
     * Gets the list of actors associated with the route.
     *
     * @return The list of actors.
     */
    public List<InlineAssociationActorType> getActors() {
        return actors;
    }

    /**
     * Sets the list of actors associated with the route.
     *
     * @param actors The list of actors to set.
     */
    public void setActors(List<InlineAssociationActorType> actors) {
        this.actors = actors;
    }

    /**
     * Gets the list of actions associated with the route.
     *
     * @return The list of actions.
     */
    public List<InlineAssociationType<StopAction>> getActions() {
        return actions;
    }

    /**
     * Sets the list of actions associated with the route.
     *
     * @param actions The list of actions to set.
     */
    public void setActions(List<InlineAssociationType<StopAction>> actions) {
        this.actions = actions;
    }

    /**
     * Gets the constraint associated with the route.
     *
     * @return The constraint.
     */
    public InlineAssociationType<Constraint> getConstraint() {
        return constraint;
    }

    /**
     * Sets the constraint associated with the route.
     *
     * @param constraint The constraint to set.
     */
    public void setConstraint(InlineAssociationType<Constraint> constraint) {
        this.constraint = constraint;
    }
}