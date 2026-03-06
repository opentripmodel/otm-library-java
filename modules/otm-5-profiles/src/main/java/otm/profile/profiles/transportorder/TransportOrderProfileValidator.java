package otm.profile.profiles.transportorder;

import otm.profile.profiles.IProfileValidator;
import otm.profile.validation.ValidationResult;
import otm.v5.model.TransportOrder;

/**
 * Validates a TransportOrder entity against the default completeness rules.
 */
public class TransportOrderProfileValidator implements IProfileValidator<TransportOrder> { // Using placeholder TransportOrder for v5.TransportOrder
    @Override
    public ValidationResult validate(TransportOrder order) {
        return ValidationResult.failure("Not implemented.");
    }
}