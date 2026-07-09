package otm.profile.profiles.carbonfootprint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import otm.model.entities.EmissionEvent;
import otm.model.entities.Event;
import otm.profile.validation.ValidationResult;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Carbon Footprint result profile validator test")
public class CarbonFootprintResultProfileValidatorTest extends CarbonFootprintBaseTest {

    private final CarbonFootprintResultProfileValidator validator = new CarbonFootprintResultProfileValidator();

    @Test
    @DisplayName("A trip with a complete emission event is valid")
    void testValidTripIsValid() throws Exception {
        ValidationResult validationResult = validator.validate(resultTrip);

        assertThat(validationResult.isValid())
                .withFailMessage(validationResult::toString)
                .isTrue();
    }

    @Test
    @DisplayName("A trip without an emission event is invalid")
    void testMissingEmissionEventIsInvalid() throws Exception {
        resultTrip.setEvents(new ArrayList<>());

        ValidationResult validationResult = validator.validate(resultTrip);

        assertThat(validationResult.isValid()).isFalse();
        // The empty list is omitted during serialization, so the schema reports the missing
        // required property at the root of the document
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("contextEvents"));
    }

    @Test
    @DisplayName("An emission event without an amount is invalid")
    void testMissingAmountIsInvalid() throws Exception {
        replaceEmissionEvent(emissionEvent -> emissionEvent.setAmount(null));

        ValidationResult validationResult = validator.validate(resultTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("amount"));
    }

    @Test
    @DisplayName("An emission event without a calculation method is invalid")
    void testMissingCalculationMethodIsInvalid() throws Exception {
        replaceEmissionEvent(emissionEvent -> emissionEvent.setCalculationMethod(null));

        ValidationResult validationResult = validator.validate(resultTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("calculationMethod"));
    }

    @Test
    @DisplayName("A calculation method without a framework is invalid")
    void testMissingFrameworkIsInvalid() throws Exception {
        replaceEmissionEvent(emissionEvent -> emissionEvent.getCalculationMethod().setFramework(null));

        ValidationResult validationResult = validator.validate(resultTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getMessage().contains("framework"));
    }

    @Test
    @DisplayName("A data type share above 1 is invalid")
    void testShareAboveOneIsInvalid() throws Exception {
        replaceEmissionEvent(emissionEvent ->
                emissionEvent.getCalculationMethod().getDataTypeDistribution().get(0).setShare(1.5));

        ValidationResult validationResult = validator.validate(resultTrip);

        assertThat(validationResult.isValid()).isFalse();
        assertThat(validationResult.getMessages())
                .anyMatch(m -> m.getPath().contains("dataTypeDistribution"));
    }

    private void replaceEmissionEvent(java.util.function.Consumer<EmissionEvent> mutation) {
        EmissionEvent emissionEvent = buildEmissionEvent();
        mutation.accept(emissionEvent);

        var contextEvents = new ArrayList<Event>();
        contextEvents.add(emissionEvent);
        resultTrip.setEvents(contextEvents);
    }
}
