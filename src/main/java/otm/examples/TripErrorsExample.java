package otm.examples;

import otm.model.entities.*;
import otm.profile.profiles.cbs.CbsProfileValidator;
import otm.profile.validation.ValidationResult;
import otm.serializer.IOtmSerializer;
import otm.serializer.OtmSerializer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * Example of how to use the OTM validator.
 */
public class TripErrorsExample {
    public static void main(String[] args) throws IOException {

        // Build a Trip
        Trip trip = new Trip();
        trip.setId(UUID.randomUUID().toString());
        trip.setStatus(TripStatus.COMPLETED);
        trip.setTransportMode(TransportMode.ROAD);
        trip.setEntityType(EntityType.TRIP);
        trip.setName("Trip with errors");

        // Vehicle object creation, but we forget to set the vehicle
        InlineAssociationType<Vehicle> vehicleAssociation = new InlineAssociationType<>();
        // Vehicle vehicle = new Vehicle();
        // vehicle.setId(UUID.randomUUID());
        // vehicle.setVehicleType("truck");
        // vehicle.setAverageFuelConsumption(UnitWithValue.create(32.5, "l/100km"));
        // vehicleAssociation.setEntity(vehicle);
        trip.setVehicle(vehicleAssociation);

        // Actors list creation and population
        List<InlineAssociationActorType> actors = new ArrayList<>();
        InlineAssociationActorType actorAssociation = new InlineAssociationActorType();

        List<String> roles = new ArrayList<>();
        roles.add("carrier");
        actorAssociation.setRoles(roles);

        Actor actor = new Actor();
        actor.setId(UUID.randomUUID().toString());

        List<ContactDetail> contactDetails = new ArrayList<>();
        ContactDetail emailDetail = new ContactDetail();
        emailDetail.setType(ContactDetailType.EMAIL);
        emailDetail.setValue("info@logistics.nl");
        contactDetails.add(emailDetail);
        actor.setContactDetails(contactDetails);

        List<InlineAssociationType<Location>> locations = new ArrayList<>();
        InlineAssociationType<Location> locationAssociation = new InlineAssociationType<>();
        Location location = new Location();
        AddressGeoReference addressGeoReference = new AddressGeoReference();
        addressGeoReference.setStreet("Prinsengracht");
        addressGeoReference.setHouseNumber("263");
        addressGeoReference.setPostalCode("1016 XP");
        addressGeoReference.setCity("Amsterdam");
        addressGeoReference.setCountry("NL");
        location.setGeoReference(addressGeoReference);
        locationAssociation.setEntity(location);
        locations.add(locationAssociation);
        actor.setLocations(locations);
        actorAssociation.setEntity(actor);
        actors.add(actorAssociation);
        trip.setActors(actors.toArray(new InlineAssociationActorType[0]));

        // Actions list creation and population
        List<InlineAssociationType<StopAction>> actions = new ArrayList<>();
        InlineAssociationType<StopAction> stopActionAssociation = new InlineAssociationType<>();
        StopAction stopAction = new StopAction();
        stopAction.setId(UUID.randomUUID().toString());
        stopAction.setActionType(ActionType.ATTACH_TRANSPORT_EQUIPMENT);
        stopAction.setLifecycle(Lifecycle.ACTUAL);
        stopAction.setEndTime(Date.from(Instant.now().plusSeconds(900)));

        InlineAssociationType<Location> stopLocationAssociation = new InlineAssociationType<>();
        Location stopLocation = new Location();
        stopLocation.setName("Warehouse Amsterdam");
        stopLocation.setType(LocationType.CUSTOMER);
        stopLocationAssociation.setEntity(stopLocation);
        stopAction.setLocation(stopLocationAssociation);
        stopActionAssociation.setEntity(stopAction);
        actions.add(stopActionAssociation);
        trip.setActions(actions.toArray(new InlineAssociationType[0]));


        // Optional: serialize trip
        IOtmSerializer serializer = new OtmSerializer();
        String json = serializer.serialize(trip);
        System.out.println("Serialized JSON:\n" + json);
        // Optional: deserialize trip
        Trip tripFromString = serializer.deserialize(json, Trip.class);
        System.out.println("\nDeserialized from string: Trip ID = " + tripFromString.getId());

        // Optional: Stream-based serialization
        String path = "trip.json";
        try (FileOutputStream fos = new FileOutputStream(path)) {
             serializer.serializeToStream(trip, fos);
        }
        // Optional: Stream-based deserialization
        try (FileInputStream fis = new FileInputStream(path)) {
             var tripFromStream = serializer.deserializeFromStream(fis, Trip.class);
             System.out.println("\nDeserializing from file: " + path);
             System.out.println("Deserialized from stream: Trip Name = " + tripFromStream.getName() + "\n");
        }

        // Validate Trip
        CbsProfileValidator cbsProfileValidator = new CbsProfileValidator();
        ValidationResult validationResult = cbsProfileValidator.validate(trip);

        // Pretty-print validation errors
        System.out.println(validationResult.toString());

        // Check if we are valid
        if(validationResult.isValid()){
            System.out.println("Validation succeeded (0 errors)");
            return;
        }

        System.out.println("Fixing errors...");

        // Fix Vehicle error
        Vehicle newVehicle = new Vehicle();
        newVehicle.setId(String.valueOf(UUID.randomUUID()));
        newVehicle.setVehicleType("truck");
        newVehicle.setAverageFuelConsumption(UnitWithValue.create(32.5, "l/100km"));
        trip.getVehicle().setEntity(newVehicle);

        // Fix Actor errors
        trip.getActors()[0].getEntity().setName("Logistics BV");
        trip.getActions()[0].getEntity().setStartTime(Date.from(Instant.now().plus(5, ChronoUnit.MINUTES)));

        trip.setName("");

        System.out.println("Revalidating...");

        // Revalidate the trip
        validationResult = cbsProfileValidator.validate(trip);

        System.out.println(validationResult.toString());

        System.out.println("Still forgot to fix all errors");

        // Still forgot to resolve some parts of the error
        trip.getVehicle().getEntity().setLicensePlate("NL-01-AB");

        // Revalidate the trip
        validationResult = cbsProfileValidator.validate(trip);

        System.out.println(validationResult.toString());
    }
}
