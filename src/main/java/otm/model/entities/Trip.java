package otm.model.entities;

import java.util.Arrays;

/**
 * A Trip is an aggregate entity that combines various entities to model visiting various locations, potentially doing one or multiple actions on each location, such as loading or unloading consignments. It is optionally coupled to a {@link Vehicle} that is/was driving this trip.
 */
public class Trip extends OtmEntity {
    /**
     * Whether this trip is a draft, requested, confirmed, in transit, completed or cancelled. The values accepted (replaced by confirmed) and modified (replaced the lastModified field on every entity) are deprecated since OTM5.1, but will be supported for the whole OTM5.X line.
     */
    private TripStatus status;

    /**
     * Method of transport used for the carriage of goods on this trip, can either be using a ship
     * (maritime or inland waterway), a truck/car/van/bike/etc. (road), using the train (rail), or
     * using a plane (air). These values are based on the <a href="https://unece.org/fileadmin/DAM/cefact/recommendations/rec19/rec19_ecetrd138.pdf">recommendation of UNECE</a>.
     */
    private TransportMode transportMode;

    /**
     * The {@link Vehicle} that is driving this trip.
     */
    private InlineAssociationType<Vehicle> vehicle;

    /**
     * The actors associated with this trip, for instance the client or the executing party
     */
    private InlineAssociationActorType[] actors;

    /**
     * All actions that are/were happening on this trip, such as stopping at certain locations and loading and unloading of consignments.
     */
    private InlineAssociationType<StopAction>[] actions;

    /**
     * Constraints this trip has to abide to, such as the start and end date times in which it has to be completed.
     */
    private InlineAssociationType<Constraint>[] constraints;

    private EntityType entityType;

    // Getters and setters

    /**
     * Gets the status of the trip.
     *
     * @return The trip status.
     */
    public TripStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the trip.
     *
     * @param status The trip status to set.
     */
    public void setStatus(TripStatus status) {
        this.status = status;
    }

    /**
     * Gets the transport mode used for the trip.
     *
     * @return The transport mode.
     */
    public TransportMode getTransportMode() {
        return transportMode;
    }

    /**
     * Sets the transport mode used for the trip.
     *
     * @param transportMode The transport mode to set.
     */
    public void setTransportMode(TransportMode transportMode) {
        this.transportMode = transportMode;
    }

    /**
     * Gets the vehicle associated with the trip.
     *
     * @return The vehicle.
     */
    public InlineAssociationType<Vehicle> getVehicle() {
        return vehicle;
    }

    /**
     * Sets the vehicle associated with the trip.
     *
     * @param vehicle The vehicle to set.
     */
    public void setVehicle(InlineAssociationType<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Gets the array of actors associated with the trip.
     *
     * @return The array of actors.
     */
    public InlineAssociationActorType[] getActors() {
        return actors;
    }

    /**
     * Sets the array of actors associated with the trip.
     *
     * @param actors The array of actors to set.
     */
    public void setActors(InlineAssociationActorType[] actors) {
        this.actors = actors;
    }

    /**
     * Gets the array of actions associated with the trip.
     *
     * @return The array of actions.
     */
    public InlineAssociationType<StopAction>[] getActions() {
        return actions;
    }

    /**
     * Sets the array of actions associated with the trip.
     *
     * @param actions The array of actions to set.
     */
    public void setActions(InlineAssociationType<StopAction>[] actions) {
        this.actions = actions;
    }

    /**
     * Gets the array of constraints associated with the trip.
     *
     * @return The array of constraints.
     */
    public InlineAssociationType<Constraint>[] getConstraints() {
        return constraints;
    }

    /**
     * Sets the array of constraints associated with the trip.
     *
     * @param constraints The array of constraints to set.
     */
    public void setConstraints(InlineAssociationType<Constraint>[] constraints) {
        this.constraints = constraints;
    }

    public EntityType getEntityType(){
        return entityType;
    }

    public void setEntityType(EntityType entityType){
        this.entityType = entityType;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "status=" + status +
                ", transportMode=" + transportMode +
                ", vehicle=" + vehicle +
                ", actors=" + Arrays.toString(actors) +
                ", actions=" + Arrays.toString(actions) +
                ", constraints=" + Arrays.toString(constraints) +
                ", entityType=" + entityType +
                '}';
    }
}