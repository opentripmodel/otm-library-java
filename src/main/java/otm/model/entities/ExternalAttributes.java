package otm.model.entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * External attributes are a simple way to add information in an OpenTripModel message that could not
 * fit into one of the OTM fields otherwise. The externalAttributes member is meant for additional metadata
 * and/or additional ID's of an entity. This can also help to identify an OTM entity in a system by the ID
 * of that system.
 */
public class ExternalAttributes extends HashMap<String, Object> implements Serializable {
    // No additional members needed since it's a simple extension of HashMap
}