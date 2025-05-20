package otm.model.entities;

/**
 * The enforceability of the constraint. Indicates whether the constraint is a suggestion/preference or something that is mandatory to adhere to.
 */
public enum ConstraintType {
    GENERIC_CONSTRAINT,
    AND_CONSTRAINT,
    OR_CONSTRAINT,
    TIME_WINDOW_CONSTRAINT,
    VALUE_BOUND_CONSTRAINT
}
//Todo missing the following constraints -> endDateTimeConstraint, temperatureConstraint, sizeConstraint, weightConstraint, speedConstraint, accessConstraint, transportEquipmentTypeConstraint, sensorValueConstraint,emissionStandardConstraint,fuelTypeConstraint,vehicleTypeConstraint,routeEntityConstraint,routeConstraint,notConstraint,