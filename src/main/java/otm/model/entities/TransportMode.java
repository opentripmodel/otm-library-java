package otm.model.entities;

/**
 * Method of transport used for the carriage of goods on this trip, can either be using a ship (maritime or inland waterway), a truck/car/van/bike/etc. (road), using the train (rail), or using a plane (air). These values are based on the <a href="https://unece.org/fileadmin/DAM/cefact/recommendations/rec19/rec19_ecetrd138.pdf">recommendation of UNECE</a>.
 */
public enum TransportMode {
    MARITIME,
    ROAD,
    RAIL,
    AIR,
    INLAND_WATERWAY;
}
