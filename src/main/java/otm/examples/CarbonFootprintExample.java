package otm.examples;

import otm.model.entities.*;
import otm.profile.profiles.carbonfootprint.CarbonFootprintInputProfileValidator;
import otm.profile.profiles.carbonfootprint.CarbonFootprintResultProfileValidator;
import otm.profile.validation.ValidationResult;
import otm.serializer.IOtmSerializer;
import otm.serializer.OtmSerializer;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Shows the two message flows of the OTM Carbon Footprint profile:
 * <ol>
 *     <li><b>CO2 Calculation Input</b> - a TMS builds an OTM trip with a load and unload stop,
 *     cargo details and the fuel consumed by the vehicle, and validates it before sending it
 *     to a CO2 calculation platform.</li>
 *     <li><b>CO2 Calculation Result</b> - the calculation platform returns the calculated
 *     emissions as an emission context event on the trip, including full transparency on the
 *     calculation method.</li>
 * </ol>
 */
public class CarbonFootprintExample {

    public static void main(String[] args) throws IOException {
        IOtmSerializer serializer = new OtmSerializer();

        // === CO2 Calculation Input: TMS -> calculation platform ===
        Trip inputTrip = buildInputTrip();

        System.out.println("CO2 Calculation Input message:");
        System.out.println(serializer.serialize(inputTrip));

        ValidationResult inputValidation = new CarbonFootprintInputProfileValidator().validate(inputTrip);
        System.out.println(inputValidation);

        // === CO2 Calculation Result: calculation platform -> carrier ===
        Trip resultTrip = buildResultTrip();

        System.out.println("\nCO2 Calculation Result message:");
        System.out.println(serializer.serialize(resultTrip));

        ValidationResult resultValidation = new CarbonFootprintResultProfileValidator().validate(resultTrip);
        System.out.println(resultValidation);
    }

    @SuppressWarnings("unchecked")
    private static Trip buildInputTrip() {
        Trip trip = new Trip();
        trip.setId(UUID.randomUUID().toString());
        trip.setName("Rit 2026-045123");
        trip.setEntityType(EntityType.TRIP);
        trip.setStatus(TripStatus.COMPLETED);
        trip.setTransportMode(TransportMode.ROAD);

        // The vehicle that drove the trip
        Vehicle vehicle = new Vehicle();
        vehicle.setId(UUID.randomUUID().toString());
        vehicle.setVehicleType("truck");
        vehicle.setLicensePlate("12-ABC-3");
        vehicle.setFuel(Fuel.DIESEL);
        vehicle.setEmissionStandard(EmissionStandard.EURO_6);

        InlineAssociationType<Vehicle> vehicleAssociation = new InlineAssociationType<>();
        vehicleAssociation.setEntity(vehicle);
        trip.setVehicle(vehicleAssociation);

        // The client (opdrachtgever)
        Actor client = new Actor();
        client.setId(UUID.randomUUID().toString());
        client.setName("Retailer B.V.");

        InlineAssociationActorType clientAssociation = new InlineAssociationActorType();
        clientAssociation.setEntity(client);
        trip.setActors(new InlineAssociationActorType[]{clientAssociation});

        // Load stop in Utrecht, unload stop in Amersfoort
        trip.setActions(new InlineAssociationType[]{
                buildStop(1, ActionType.LOAD, "DC Utrecht", "3542 AB", "Utrecht"),
                buildStop(2, ActionType.UNLOAD, "Winkel Amersfoort", "3818 LE", "Amersfoort")
        });

        // The fuel consumed on the trip (energy data for the CO2 calculation)
        FuelConsumedEvent fuelConsumedEvent = new FuelConsumedEvent();
        fuelConsumedEvent.setId(UUID.randomUUID().toString());
        fuelConsumedEvent.setFuel(Fuel.DIESEL);
        fuelConsumedEvent.setAmount(UnitWithValue.create(23.4, "l"));
        fuelConsumedEvent.setEmissionFactorStandard("CO2emissiefactoren.nl");
        fuelConsumedEvent.setPeriodStart(Date.from(Instant.parse("2026-06-15T07:30:00Z")));
        fuelConsumedEvent.setPeriodEnd(Date.from(Instant.parse("2026-06-15T09:45:00Z")));

        List<Event> contextEvents = new ArrayList<>();
        contextEvents.add(fuelConsumedEvent);
        trip.setEvents(contextEvents);

        return trip;
    }

    private static Trip buildResultTrip() {
        Trip trip = new Trip();
        trip.setId(UUID.randomUUID().toString());
        trip.setName("Rit 2026-045123");
        trip.setEntityType(EntityType.TRIP);
        trip.setTransportMode(TransportMode.ROAD);

        // Transparency on how the emission was calculated
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

        // The calculated emission for the trip
        EmissionEvent emissionEvent = new EmissionEvent();
        emissionEvent.setId(UUID.randomUUID().toString());
        emissionEvent.setAmount(UnitWithValue.create(75.2, "kgCO2e"));
        emissionEvent.setEmissionIntensity(UnitWithValue.create(62.1, "gCO2e/tkm"));
        emissionEvent.setPeriodStart(Date.from(Instant.parse("2026-06-15T07:30:00Z")));
        emissionEvent.setPeriodEnd(Date.from(Instant.parse("2026-06-15T09:45:00Z")));
        emissionEvent.setCalculationMethod(calculationMethod);

        List<Event> contextEvents = new ArrayList<>();
        contextEvents.add(emissionEvent);
        trip.setEvents(contextEvents);

        return trip;
    }

    private static InlineAssociationType<StopAction> buildStop(
            int sequenceNr, ActionType nestedActionType, String name, String postalCode, String city) {

        AdministrativeReference administrativeReference = new AdministrativeReference();
        administrativeReference.setPostalCode(postalCode);
        administrativeReference.setCity(city);
        administrativeReference.setCountry("NL");

        Location location = new Location();
        location.setName(name);
        location.setAdministrativeReference(administrativeReference);

        InlineAssociationType<Location> locationAssociation = new InlineAssociationType<>();
        locationAssociation.setEntity(location);

        GoodItem goodItem = new GoodItem();
        goodItem.setDescription("Pallets retail goederen");
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

        Action nestedAction = new Action();
        nestedAction.setActionType(nestedActionType);
        nestedAction.setLifecycle(Lifecycle.REALIZED);
        nestedAction.setConsignment(consignmentAssociation);

        InlineAssociationType<Action> nestedActionAssociation = new InlineAssociationType<>();
        nestedActionAssociation.setEntity(nestedAction);

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
