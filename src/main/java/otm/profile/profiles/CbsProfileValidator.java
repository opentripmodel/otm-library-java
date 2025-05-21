package otm.profile.profiles;

import otm.model.entities.Trip;
import otm.profile.validation.ValidationResult;

public class CbsProfileValidator implements IProfileValidator<Trip> { // Using placeholder Trip for OpenTripModel.v5.Trip
    @Override
    public ValidationResult validate(Trip trip) {
        return ValidationResult.success();
    }
}