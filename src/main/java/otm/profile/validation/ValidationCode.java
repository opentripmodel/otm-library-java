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
    Required,

    /**
     * The JSON value’s data-type does not match the schema’s type constraint.
     */
    Type,

    /**
     * The value is not one of the permitted options listed under enum.
     */
    Enum,

    /**
     * An array has fewer elements than the minimum specified by minItems.
     */
    MinItems,

    /**
     * A string exceeds the maximum length allowed by maxLength.
     */
    MaxLength,

    /**
     * A string is shorter than the minimum length required by minLength.
     */
    MinLength,

    /**
     * The instance contains a member that is disallowed because
     * additionalProperties is set to false.
     */
    AdditionalProperties,

    /**
     * Fallback code used when the mapper cannot translate a keyword
     * to a dedicated member.
     */
    GenericError
}
