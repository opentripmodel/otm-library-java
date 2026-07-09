package otm.profile.profiles.carbonfootprint;

import org.junit.jupiter.api.BeforeEach;
import otm.model.entities.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Builds trips that comply with the Carbon Footprint profile; tests mutate them to create
 * invalid variants.
 */
public class CarbonFootprintBaseTest {

    protected static final Date PERIOD_START = Date.from(Instant.parse("2026-06-15T07:30:00Z"));
    protected static final Date PERIOD_END = Date.from(Instant.parse("2026-06-15T09:45:00Z"));

    protected Trip inputTrip;
    protected Trip resultTrip;

    @BeforeEach
    void setupCarbonFootprintTrips() {
        inputTrip = buildInputTrip();
        resultTrip = buildResultTrip();
    }

    @SuppressWarnings("unchecked")
    protected Trip buildInputTrip() {
        Trip trip = new Trip();
        trip.setId("0195d8f1-6a2e-4f35-86e1-dd229ca839e4");
        trip.setName("Rit 2026-045123");
        trip.setEntityType(EntityType.TRIP);
        trip.setStatus(TripStatus.COMPLETED);
        trip.setTransportMode(TransportMode.ROAD);

        // Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setId("a2a0925f-3ad5-4d01-a00a-4031b0e54e09");
        vehicle.setVehicleType("truck");
        vehicle.setLicensePlate("12-ABC-3");
        vehicle.setFuel(Fuel.DIESEL);

        InlineAssociationType<Vehicle> vehicleAssociation = new InlineAssociationType<>();
        vehicleAssociation.setEntity(vehicle);
        trip.setVehicle(vehicleAssociation);

        // Client actor
        Actor actor = new Actor();
        actor.setId("2f86b0c6-383f-40da-9de0-167b26450303");
        actor.setName("Retailer B.V.");

        InlineAssociationActorType actorAssociation = new InlineAssociationActorType();
        actorAssociation.setEntity(actor);
        trip.setActors(new InlineAssociationActorType[]{actorAssociation});

        // Load and unload stop
        trip.setActions(new InlineAssociationType[]{
                buildStop(1, ActionType.LOAD, "3542 AB"),
                buildStop(2, ActionType.UNLOAD, "3818 LE")
        });

        // Energy data
        List<Event> contextEvents = new ArrayList<>();
        contextEvents.add(buildFuelConsumedEvent());
        trip.setEvents(contextEvents);

        return trip;
    }

    protected Trip buildResultTrip() {
        Trip trip = new Trip();
        trip.setId("0195d8f1-6a2e-4f35-86e1-dd229ca839e4");
        trip.setName("Rit 2026-045123");
        trip.setEntityType(EntityType.TRIP);
        trip.setTransportMode(TransportMode.ROAD);

        List<Event> contextEvents = new ArrayList<>();
        contextEvents.add(buildEmissionEvent());
        trip.setEvents(contextEvents);

        return trip;
    }

    protected FuelConsumedEvent buildFuelConsumedEvent() {
        FuelConsumedEvent fuelConsumedEvent = new FuelConsumedEvent();
        fuelConsumedEvent.setId("7a2c4f35-86e1-4d01-a00a-dd229ca839e4");
        fuelConsumedEvent.setFuel(Fuel.DIESEL);
        fuelConsumedEvent.setAmount(UnitWithValue.create(23.4, "l"));
        fuelConsumedEvent.setEmissionFactorStandard("CO2emissiefactoren.nl");
        fuelConsumedEvent.setPeriodStart(PERIOD_START);
        fuelConsumedEvent.setPeriodEnd(PERIOD_END);
        return fuelConsumedEvent;
    }

    protected EmissionEvent buildEmissionEvent() {
        EmissionCalculationMethod calculationMethod = new EmissionCalculationMethod();
        calculationMethod.setFramework("GLEC 3.1");
        calculationMethod.setIsoReference("ISO 14083:2023");
        calculationMethod.setDistanceAllocationMethod(DistanceAllocationMethod.SFD);
        calculationMethod.setGranularity(EmissionDataGranularity.DAY);
        calculationMethod.setDataClassification(EmissionDataClassification.GOLD);

        List<EmissionDataShare> distribution = new ArrayList<>();
        distribution.add(new EmissionDataShare(EmissionDataType.PRIMARY, 0.85));
        distribution.add(new EmissionDataShare(EmissionDataType.DEFAULT, 0.15));
        calculationMethod.setDataTypeDistribution(distribution);

        EmissionEvent emissionEvent = new EmissionEvent();
        emissionEvent.setId("8b3d5a46-97f2-4e12-b11b-ee33adb94af5");
        emissionEvent.setAmount(UnitWithValue.create(75.2, "kgCO2e"));
        emissionEvent.setEmissionIntensity(UnitWithValue.create(62.1, "gCO2e/tkm"));
        emissionEvent.setPeriodStart(PERIOD_START);
        emissionEvent.setPeriodEnd(PERIOD_END);
        emissionEvent.setCalculationMethod(calculationMethod);
        return emissionEvent;
    }

    private InlineAssociationType<StopAction> buildStop(int sequenceNr, ActionType nestedActionType, String postalCode) {
        // Stop location with the country and postal code required by the kernset
        AdministrativeReference administrativeReference = new AdministrativeReference();
        administrativeReference.setPostalCode(postalCode);
        administrativeReference.setCountry("NL");

        Location location = new Location();
        location.setAdministrativeReference(administrativeReference);

        InlineAssociationType<Location> locationAssociation = new InlineAssociationType<>();
        locationAssociation.setEntity(location);

        // Cargo being loaded/unloaded
        GoodItem goodItem = new GoodItem();
        goodItem.setQuantity(18); // laadeenheid: pallet
        goodItem.setGrossWeight(UnitWithValue.create(12500.0, "kg"));

        InlineAssociationType<GoodItem> goodAssociation = new InlineAssociationType<>();
        goodAssociation.setEntity(goodItem);

        Consignment consignment = new Consignment();
        List<InlineAssociationType<GoodItem>> goods = new ArrayList<>();
        goods.add(goodAssociation);
        consignment.setGoods(goods);

        InlineAssociationType<Consignment> consignmentAssociation = new InlineAssociationType<>();
        consignmentAssociation.setEntity(consignment);

        // Nested load/unload action
        Action nestedAction = new Action();
        nestedAction.setActionType(nestedActionType);
        nestedAction.setLifecycle(Lifecycle.REALIZED);
        nestedAction.setConsignment(consignmentAssociation);

        InlineAssociationType<Action> nestedActionAssociation = new InlineAssociationType<>();
        nestedActionAssociation.setEntity(nestedAction);

        // The stop itself
        StopAction stop = new StopAction();
        stop.setSequenceNr(sequenceNr);
        stop.setLifecycle(Lifecycle.REALIZED);
        stop.setStartTime(Date.from(Instant.parse("2026-06-15T07:30:00Z").plusSeconds(sequenceNr * 3600L)));
        stop.setLocation(locationAssociation);

        List<InlineAssociationType<Action>> nestedActions = new ArrayList<>();
        nestedActions.add(nestedActionAssociation);
        stop.setActions(nestedActions);

        InlineAssociationType<StopAction> stopAssociation = new InlineAssociationType<>();
        stopAssociation.setEntity(stop);
        return stopAssociation;
    }
}
