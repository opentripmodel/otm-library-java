package otm.model.entities;

/**
 * Defines the various formats in which time information can be expressed.
 */
public enum TimeFormat {
    /**
     * Represents a specific point in time, including date and time components.
     */
    DATE_TIME,
    /**
     * Represents a recurring date and/or time pattern, following a recurrence rule specification.
     */
    RECURRING_DATE_TIME,
    /**
     * Represents a duration of time, typically following the ISO 8601 duration format.
     */
    DURATION
}