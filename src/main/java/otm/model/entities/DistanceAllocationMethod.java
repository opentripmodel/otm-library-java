package otm.model.entities;

/**
 * The method used to allocate CO2(e) emissions over transport distance.
 */
public enum DistanceAllocationMethod {
    /**
     * Great circle distance: the shortest distance between two points over the earth's surface.
     */
    GCD,

    /**
     * Shortest feasible distance: the shortest distance that can actually be travelled by the
     * mode of transport.
     */
    SFD
}
