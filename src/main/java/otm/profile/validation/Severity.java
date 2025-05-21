package otm.profile.validation;

/**
 * Specifies the severity level of a validation message.
 */
public enum Severity {
    /**
     * Informational message that does not affect validity.
     */
    Info,

    /**
     * Indicates a potential issue that may require attention.
     */
    Warning,

    /**
     * Indicates a critical issue that renders the entity invalid.
     */
    Error
}
