package otm.model.entities;

/**
 * Defines the enforceability status of a rule or entity.
 */
public enum Enforceability {
    /**
     * Indicates that the rule or entity is strictly enforced and must be followed.
     */
    ENFORCED,
    /**
     * Indicates that the rule or entity is a preference,
     * meaning it's recommended but not strictly mandatory.
     */
    PREFERENCE
}