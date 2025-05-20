package otm.model.entities;

/**
 * <p>
 *     {@code Constraints} can do different things, depending on the context they're used in:
 * </p>
 *
 * <ul>
 *     <li>In the context of a {@code Location}, access to the location is only allowed if the given constraint applies.</li>
 *     <li>In the context of a {@code} Trip, constraints can be used to define constraints that have to be met during the trip, e.g. if the temperature in a refrigerated trailer has to stay below a given maximum during the trip.</li>
 *     <li>In the context of a {@code Shipment}, constraints can be used to e.g. define minimum or maximum temperatures for shipments, or date time constraints for delivery.</li>
 * </ul>
 * <p>
 *     Since OTM5.2 the {@code timeWindowConstraint} is supported which allows you to give (optionally) both the start and end time of the window between which something needs to occur. This replaces the old style where you had to use an and constraint in combination with the <i>startDateTimeConstraint</i> and <i>endDateTimeConstraint</i>. Since the new solution is shorter and simpler the <i>startDateTimeConstraint</i> and <i>endDateTimeConstraint</i> are <b>deprecated</b>.
 * </p>
 * <p>
 *     Note that constraints can be nested and combined using the {@code andConstraint}, {@code orConstraint} and {@code notConstraint}.
 * </p>
 *
 */
public class Constraint extends OtmEntity {
    /**
     * The value of the constraint.
     */
    private ConstraintValueBase value;

//    todo missing  -> enforceability

    /**
     * Get the value of the constraint.
     * @return The value of the constraint.
     */
    public ConstraintValueBase getValue() {
        return value;
    }

    /**
     * Set the value of the constraint.
     * @param value The value of the constraint.
     */
    public void setValue(ConstraintValueBase value) {
        this.value = value;
    }
}
