package otm.model.entities;

public enum EventType {
    UPDATE_EVENT,
    LOCATION_UPDATE_EVENT,

    /**
     * Fuel/energy consumed during a move, on a trip or per consignment.
     */
    FUEL_CONSUMED_EVENT,

    /**
     * Emission produced during a move, on a trip or per consignment.
     */
    EMISSION_EVENT
}
