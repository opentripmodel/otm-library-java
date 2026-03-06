package otm.profile.validation;

/**
 * Identifies the JSON-Schema rule that triggered a
 * {@link ValidationMessage}.
 * Each value maps 1-to-1 to a keyword in the Draft-2020-12 specification.
 */
public enum ValidationCode {
    /**
     * A property declared as required is missing from the instance.
     */
    REQUIRED,

    /**
     * The JSON value’s data-type does not match the schema’s type constraint.
     */
    TYPE,

    /**
     * The value is not one of the permitted options listed under enum.
     */
    ENUM,

    /**
     * An array has fewer elements than the minimum specified by minItems.
     */
    MIN_ITEMS,

    /**
     * A string exceeds the maximum length allowed by maxLength.
     */
    MAX_LENGTH,

    /**
     * A string is shorter than the minimum length required by minLength.
     */
    MIN_LENGTH,

    /**
     * The instance contains a member disallowed because additionalProperties is set to false.
     */
    ADDITIONAL_PROPERTIES,

    /**
     * Fallback code used when the mapper cannot translate a keyword to a dedicated member.
     */
    GENERIC_ERROR
}
