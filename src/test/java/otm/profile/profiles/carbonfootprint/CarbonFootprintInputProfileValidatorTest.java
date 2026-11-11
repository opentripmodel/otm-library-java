package otm.profile.profiles.carbonfootprint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import otm.model.entities.Event;
import otm.profile.validation.ValidationResult;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Carbon Footprint input profile validator test")
public class CarbonFootprintInputProfileValidatorTest extends CarbonFootprintBaseTest {

    private final CarbonFootprintInputProfileValidator validator = new CarbonFootprintInputProfileValidator();

    @Test
    @DisplayName("A trip with vehicle, load/unload stops, cargo and energy data is valid")
    void testValidTripIsValid() throws Exception {
        ValidationResult validationResult = validator.validate(inputTrip);

        assertThat(validationResult.isValid())
                .withFailMessage(validationResult::toString)
                .isTrue();
    }

    @Test
    @DisplayName("A trip without a license plate is invalid")
    void testMissingLicensePlateIsInvalid() throws Exception {
        inputTrip.getVehicle().getEntity().setLicensePlate(null);

        ValidationResult validationResult = validator.validate(inputTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("licensePlate"));
    }

    @Test
    @DisplayName("A trip without a fuel consumed event is invalid")
    void testMissingFuelConsumedEventIsInvalid() throws Exception {
        inputTrip.setEvents(new ArrayList<>());

        ValidationResult validationResult = validator.validate(inputTrip);

        assertThat(validationResult.isValid()).isFalse();
        // The empty list is omitted during serialization, so the schema reports the missing
        // required property at the root of the document
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("contextEvents"));
    }

    @Test
    @DisplayName("A fuel consumed event without an amount is invalid")
    void testFuelConsumedEventWithoutAmountIsInvalid() throws Exception {
        var fuelConsumedEvent = buildFuelConsumedEvent();
        fuelConsumedEvent.setAmount(null);

        var contextEvents = new ArrayList<Event>();
        contextEvents.add(fuelConsumedEvent);
        inputTrip.setEvents(contextEvents);

        ValidationResult validationResult = validator.validate(inputTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("amount"));
    }

    @Test
    @DisplayName("A stop location without a postal code is invalid")
    void testMissingPostalCodeIsInvalid() throws Exception {
        inputTrip.getActions()[0].getEntity().getLocation().getEntity()
                .getAdministrativeReference().setPostalCode(null);

        ValidationResult validationResult = validator.validate(inputTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("postalCode"));
    }

    @Test
    @DisplayName("A stop without a start time (laaddatum) is invalid")
    void testMissingStartTimeIsInvalid() throws Exception {
        inputTrip.getActions()[0].getEntity().setStartTime(null);

        ValidationResult validationResult = validator.validate(inputTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("startTime"));
    }
}
