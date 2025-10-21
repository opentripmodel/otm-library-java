package otm.model.entities;

import java.util.Arrays;
import java.util.Date;

public class GenericConstraint extends ConstraintValueBase {

    @Override
    public ConstraintType getType() {
        return ConstraintType.GENERIC_CONSTRAINT;
    }

    /**
     * A free text description of the constraint
     */
    private String description;

    // Getter and setter

    /**
     * Get the constraint description
     * @return the constraint description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the constraint description
     * @param description the constraint description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GenericConstraint{" +
                "description='" + description + '\'' +
                '}';
    }
}

class AndConstraint extends GenericConstraint {

    @Override
    public ConstraintType getType() {
        return ConstraintType.AND_CONSTRAINT;
    }

    /**
     * All constraints in the array are combined using a boolean AND relation. This means that the resulting constraint will only apply if all constraints in the array apply.
     */
    private ConstraintValueBase[] and;

    // Getter and setter

    /**
     * Get all the constraints in an "and" configuration
     * @return all the constraints in an "and" configuration
     */
    public ConstraintValueBase[] getAnd() {
        return and;
    }

    /**
     * Set all the {@code AndConstraint} constraints
     * @param and all the {@code AndConstraint} constraints
     */
    public void setAnd(ConstraintValueBase[] and) {
        this.and = and;
    }

    @Override
    public String toString() {
        return "AndConstraint{" +
                "and=" + Arrays.toString(and) +
                '}';
    }
}

class OrConstraint extends GenericConstraint {

    @Override
    public ConstraintType getType() {
        return ConstraintType.OR_CONSTRAINT;
    }

    /**
     * All constraints in the array are combined using a boolean OR relation. This means that the resulting constraint will apply if any of the constraints in the array apply.
     */
    private ConstraintValueBase[] or;

    // Getter and setter

    public ConstraintValueBase[] getOr() {
        return or;
    }

    public void setOr(ConstraintValueBase[] or) {
        this.or = or;
    }

    @Override
    public String toString() {
        return "OrConstraint{" +
                "or=" + Arrays.toString(or) +
                '}';
    }
}

class TimeWindowConstraint extends GenericConstraint {

    @Override
    public ConstraintType getType() {
        return ConstraintType.TIME_WINDOW_CONSTRAINT;
    }

    /**
     * This constraint applies from the given start date/time.
     */
    private Date startTime;

    /**
     * This constraint applies until the given start date/time.
     */
    private Date endTime;

    // Getters and setters

    /**
     * Gets the start time of the time window constraint.
     *
     * @return The start time.
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the time window constraint.
     *
     * @param startTime The start time to set.
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time of the time window constraint.
     *
     * @return The end time.
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the time window constraint.
     *
     * @param endTime The end time to set.
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TimeWindowConstraint{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

enum ValueBoundConstraintValueType {SENSOR, SPEED, WEIGHT, TEMPERATURE, HEIGHT}

/**
 * The upper and lower bounds the value-bound constraint required. Available options are:
 * <ul>
 *     <li>{@code maximum}: All sensor values below and including the maximum value are allowed.</li>
 *     <li>{@code minimum}: All sensor values above and including the minimum value are allowed.</li>
 * </ul>
 */
enum ValueBoundConstraintType {MAXIMUM, MINIMUM, RANGE}

class ValueBoundConstraint extends GenericConstraint {

    @Override
    public ConstraintType getType() {
        return ConstraintType.VALUE_BOUND_CONSTRAINT;
    }

    /**
     * The type of value that has bounds. Currently supported are Sensor (update frequency),
     * Speed (max and min speeds), Weight (max and min weights of the vehicle or goods) and
     * Temperature (max and min temperature of the goods).
     */
    private ValueBoundConstraintValueType valueType;

    /**
     * The type of value that has bounds. Currently supported are Sensor (update frequency),
     * Speed (max and min speeds), Weight (max and min weights of the vehicle or goods) and
     * Temperature (max and min temperature of the goods).
     */
    private ValueBoundConstraintType constraintType;

    /**
     * Maximum value allowed.
     */
    private UnitWithValue maximum;

    /**
     * Minimum value allowed.
     */
    private UnitWithValue minimum;

    // Getters and setters

    public ValueBoundConstraintValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueBoundConstraintValueType valueType) {
        this.valueType = valueType;
    }

    public ValueBoundConstraintType getConstraintType() {
        return constraintType;
    }

    public void setConstraintType(ValueBoundConstraintType constraintType) {
        this.constraintType = constraintType;
    }

    public UnitWithValue getMaximum() {
        return maximum;
    }

    public void setMaximum(UnitWithValue maximum) {
        this.maximum = maximum;
    }

    public UnitWithValue getMinimum() {
        return minimum;
    }

    public void setMinimum(UnitWithValue minimum) {
        this.minimum = minimum;
    }

    @Override
    public String toString() {
        return "ValueBoundConstraint{" +
                "valueType=" + valueType +
                ", constraintType=" + constraintType +
                ", maximum=" + maximum +
                ", minimum=" + minimum +
                '}';
    }
}