package otm.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    /**
     * Sometimes more than one sensor can be associated with a single entity. This is the case e.g. in cooled
     * trailers that are divided into compartments with different temperatures, where each compartment has its
     * own sensor. The placement member can be used to identify where a sensor is placed. Parties using OpenTripModel
     * to exchange sensor data may wish to agree on a standardized naming, but this is too specific to describe in
     * the standard.
     */
    private String placement;

    /**
     * The type of sensor.
     */
    private String sensorType;

    /**
     * The actors associated with this sensor, for instance the owners, the producers or the users of this sensor.
     */
    private List<InlineAssociationType<Actor>> actors = new ArrayList<>();

    /**
     * In the context of a Sensor, only sensorValueConstraints really make sense. You can use such a constraint to
     * model a sensor of which the measured value must be within certain bounds at all times.
     */
    private InlineAssociationType<Constraint> constraint;

    /**
     * Gets the placement of the sensor.
     *
     * @return The placement of the sensor.
     */
    public String getPlacement() {
        return placement;
    }

    /**
     * Sets the placement of the sensor.
     *
     * @param placement The placement of the sensor.
     */
    public void setPlacement(String placement) {
        this.placement = placement;
    }

    /**
     * Gets the type of the sensor.
     *
     * @return The type of the sensor.
     */
    public String getSensorType() {
        return sensorType;
    }

    /**
     * Sets the type of the sensor.
     *
     * @param sensorType The type of the sensor.
     */
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    /**
     * Gets the list of actors associated with this sensor.
     *
     * @return A list of {@link InlineAssociationType} of {@link Actor}s.
     */
    public List<InlineAssociationType<Actor>> getActors() {
        return actors;
    }

    /**
     * Gets the constraint associated with this sensor.
     *
     * @return An {@link InlineAssociationType} of {@link Constraint}.
     */
    public InlineAssociationType<Constraint> getConstraint() {
        return constraint;
    }

    /**
     * Sets the constraint associated with this sensor.
     *
     * @param constraint The {@link InlineAssociationType} of {@link Constraint} to set.
     */
    public void setConstraint(InlineAssociationType<Constraint> constraint) {
        this.constraint = constraint;
    }
}
