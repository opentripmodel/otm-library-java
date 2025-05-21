package otm.profile.profiles;

import otm.profile.validation.ValidationResult;

/**
 * Defines a contract for validating a specific type of OTM entity against a profile.
 *
 * @param <T> The OTM entity type to validate.
 */
public interface IProfileValidator<T> {
    /**
     * Validates the specified entity and returns a result with any validation messages.
     *
     * @param entity The entity to validate.
     * @return A {@link ValidationResult} containing the validation outcome.
     */
    ValidationResult validate(T entity);
}