package otm.profile.profiles;

import otm.model.entities.TransportOrder;
import otm.profile.validation.ValidationResult;

/**
 * Validates a TransportOrder entity against the default completeness rules.
 */
public class TransportOrderProfileValidator implements IProfileValidator<TransportOrder> { // Using placeholder TransportOrder for v5.TransportOrder
    @Override
    public ValidationResult validate(TransportOrder order) {
        return ValidationResult.failure("Not implemented.");
    }
}