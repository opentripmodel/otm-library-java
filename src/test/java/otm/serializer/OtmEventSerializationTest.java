package otm.serializer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import otm.model.entities.*;
import otm.profile.profiles.carbonfootprint.CarbonFootprintBaseTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Polymorphic (de)serialization of context events")
public class OtmEventSerializationTest extends CarbonFootprintBaseTest {

    private final OtmSerializer serializer = new OtmSerializer();

    @Test
    @DisplayName("A fuel consumed event in contextEvents round-trips")
    void testFuelConsumedEventRoundTrips() throws IOException {
        String json = serializer.serialize(inputTrip);

        assertThat(json).contains("\"eventType\" : \"fuelConsumedEvent\"");

        Trip deserialized = serializer.deserialize(json, Trip.class);

        assertThat(deserialized.getEvents()).hasSize(1);
        assertThat(deserialized.getEvents().get(0)).isInstanceOf(FuelConsumedEvent.class);

        FuelConsumedEvent fuelConsumedEvent = (FuelConsumedEvent) deserialized.getEvents().get(0);
        assertThat(fuelConsumedEvent.getFuel()).isEqualTo(Fuel.DIESEL);
        assertThat(fuelConsumedEvent.getAmount().getValue()).isEqualTo(23.4);
        assertThat(fuelConsumedEvent.getAmount().getUnit()).isEqualTo("l");
        assertThat(fuelConsumedEvent.getEmissionFactorStandard()).isEqualTo("CO2emissiefactoren.nl");
        assertThat(fuelConsumedEvent.getPeriodStart()).isEqualTo(PERIOD_START);
        assertThat(fuelConsumedEvent.getPeriodEnd()).isEqualTo(PERIOD_END);
    }

    @Test
    @DisplayName("An emission event in contextEvents round-trips")
    void testEmissionEventRoundTrips() throws IOException {
        String json = serializer.serialize(resultTrip);

        assertThat(json).contains("\"eventType\" : \"emissionEvent\"");

        Trip deserialized = serializer.deserialize(json, Trip.class);

        assertThat(deserialized.getEvents()).hasSize(1);
        assertThat(deserialized.getEvents().get(0)).isInstanceOf(EmissionEvent.class);

        EmissionEvent emissionEvent = (EmissionEvent) deserialized.getEvents().get(0);
        assertThat(emissionEvent.getAmount().getValue()).isEqualTo(75.2);
        assertThat(emissionEvent.getAmount().getUnit()).isEqualTo("kgCO2e");
        assertThat(emissionEvent.getCalculationMethod().getFramework()).isEqualTo("GLEC 3.1");
        assertThat(emissionEvent.getCalculationMethod().getDistanceAllocationMethod())
                .isEqualTo(DistanceAllocationMethod.SFD);
        assertThat(emissionEvent.getCalculationMethod().getDataTypeDistribution()).hasSize(2);
    }

    @Test
    @DisplayName("An unknown event type fails deserialization with a clear error")
    void testUnknownEventTypeThrows() {
        String json = "{ \"contextEvents\": [ { \"eventType\": \"somethingElse\" } ] }";

        assertThatThrownBy(() -> serializer.deserialize(json, Trip.class))
                .isInstanceOf(IOException.class)
                .hasRootCauseMessage("Cannot deserialize event: unsupported eventType 'somethingElse'.");
    }
}
