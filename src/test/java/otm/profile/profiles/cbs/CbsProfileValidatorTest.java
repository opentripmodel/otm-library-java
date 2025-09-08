package otm.profile.profiles.cbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import otm.BaseTest;
import otm.model.entities.*;
import otm.profile.validation.ValidationResult;


@DisplayName("CBS profile validator test")
public class CbsProfileValidatorTest extends BaseTest {

    /*
     * A simple test that checks if the validator works. It takes the trip provided by the BaseTest class
     * and forces an error in to the trip. The validator should detect the error and should not be valid.
     * Next we fix the error and the validator should be valid.
     *
     * Note: Not all validation rules are tested in this test.
     */
    @Test
    @DisplayName( "CBS profile validator test validate if fields are correctly checked")
    void testCbsProfileValidator() throws Exception {
        CbsProfileValidator cbsProfileValidator = new CbsProfileValidator();

        // Remove value from the trip that is not used in the CBS profile
        trip.setName(null);

        // force an error into the trip
        trip.getVehicle().getEntity().setLicensePlate("");

        ValidationResult validationResult = cbsProfileValidator.validate(trip);

        assert !validationResult.isValid();

        // fix the forced error in the trip
        trip.getVehicle().getEntity().setLicensePlate("NL-01-AB");

        validationResult = cbsProfileValidator.validate(trip);

        assert validationResult.isValid();
    }
}
