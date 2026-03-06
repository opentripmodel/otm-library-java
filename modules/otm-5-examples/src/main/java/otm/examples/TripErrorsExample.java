package otm.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import otm.profile.profiles.cbs.CbsProfileValidator;
import otm.profile.validation.ValidationResult;
import otm.serializer.IOtmSerializer;
import otm.serializer.OtmSerializer;
import otm.v5.model.ActionsInline;
import otm.v5.model.Actor;
import otm.v5.model.Actor.EntityTypeEnum;
import otm.v5.model.ActorCompany;
import otm.v5.model.ActorsReference;
import otm.v5.model.AddressGeoReference;
import otm.v5.model.AssociatedActorsInline;
import otm.v5.model.AssociatedActorsInline.RolesEnum;
import otm.v5.model.AssociatedLocations;
import otm.v5.model.AssociatedLocationsInline;
import otm.v5.model.AssociationsActions;
import otm.v5.model.AverageFuelConsumption;
import otm.v5.model.ContactDetails;
import otm.v5.model.Email;
import otm.v5.model.Email.TypeEnum;
import otm.v5.model.LocationsReference;
import otm.v5.model.Stop;
import otm.v5.model.Stop.ActionTypeEnum;
import otm.v5.model.Stop.LifecycleEnum;
import otm.v5.model.StopInEventsLocation;
import otm.v5.model.StopLocation;
import otm.v5.model.StopLocationInline;
import otm.v5.model.Trip;
import otm.v5.model.Trip.StatusEnum;
import otm.v5.model.Trip.TransportModeEnum;
import otm.v5.model.VehicleAssociation;
import otm.v5.model.VehicleAssociationInline;
import otm.v5.model.VehicleAssociationInline.AssociationTypeEnum;


/**
 * Example of how to use the OTM validator.
 */
public class TripErrorsExample {
    public static void main(String[] args) throws IOException {

        // Build a Trip
        Trip trip = new Trip();
        trip.setId(UUID.randomUUID().toString());
        trip.setStatus(StatusEnum.COMPLETED);
        trip.setTransportMode(TransportModeEnum.ROAD);
        trip.setName("Trip with errors");

        // Vehicle object creation, but we forget to set the vehicle
        VehicleAssociation vehicle = new VehicleAssociation();
        vehicle.setId("a2a0925f-3ad5-4d01-a00a-4031b0e54e09");
        vehicle.setVehicleType("truck");
        vehicle.setLicensePlate("NL-01-AB");
        vehicle.setAverageFuelConsumption(new AverageFuelConsumption(32.5, "l/100km"));

        VehicleAssociationInline vehicleAssociationInline = VehicleAssociationInline.builder()
            .associationType(AssociationTypeEnum.INLINE)
            //.entity(vehicle) // forget to set entity on purpose
            .build();

        trip.setVehicle(vehicleAssociationInline);

        // Actors list creation and population
        ActorCompany actor = new ActorCompany();
        actor.setId("2f86b0c6-383f-40da-9de0-167b26450303");
        actor.setName("Logistics BV");
        actor.setType(Actor.TypeEnum.COMPANY);
        actor.setEntityType(EntityTypeEnum.ACTOR);

        List<ContactDetails> contactDetails = new ArrayList<>();
        Email emailDetail = new Email();
        emailDetail.setType(TypeEnum.EMAIL);
        emailDetail.setValue("info@logistics.nl");
        contactDetails.add(emailDetail);
        actor.setContactDetails(contactDetails);

        AssociatedLocations location = new AssociatedLocations();
        AddressGeoReference addressGeoReference = new AddressGeoReference();
        addressGeoReference.setStreet("Prinsengracht");
        addressGeoReference.setHouseNumber("263");
        addressGeoReference.setPostalCode("1016 XP");
        addressGeoReference.setCity("Amsterdam");
        addressGeoReference.setCountry("NL");
        addressGeoReference.setType(AddressGeoReference.TypeEnum.ADDRESS_GEO_REFERENCE);
        location.setGeoReference(addressGeoReference);

        LocationsReference locationsRef = AssociatedLocationsInline.builder()
            .associationType(AssociatedLocationsInline.AssociationTypeEnum.INLINE)
            .entity(location)
            .build();
        actor.setLocations(List.of(locationsRef));

        AssociatedActorsInline inlineActor = AssociatedActorsInline.builder()
            .associationType(AssociatedActorsInline.AssociationTypeEnum.INLINE)
            .roles(List.of(RolesEnum.CARRIER))
            .entity(actor)
            .build();

        List<ActorsReference> actorsReferences = new ArrayList<>();
        actorsReferences.add(inlineActor);
        trip.setActors(actorsReferences);

        // Actions list creation and population
        Stop stopAction = new Stop();
        stopAction.setId("ff3251c5-dd40-4a1f-9abd-0fd0205fd2aa");
        stopAction.setActionType(ActionTypeEnum.STOP);
        stopAction.setLifecycle(LifecycleEnum.ACTUAL);
        stopAction.setEndTime(Instant.now().plusSeconds(900).toString());

        StopLocation stopLocation = new StopLocation();
        stopLocation.setName("Warehouse Amsterdam");
        stopLocation.setType(StopLocation.TypeEnum.CUSTOMER);

        StopInEventsLocation stopLocationAssociation = StopLocationInline.builder()
            .associationType(StopLocationInline.AssociationTypeEnum.INLINE)
            .entity(stopLocation)
            .build();
        stopAction.setLocation(stopLocationAssociation);

        ActionsInline inlineAction = ActionsInline.builder()
            .associationType(ActionsInline.AssociationTypeEnum.INLINE)
            .entity(stopAction)
            .build();

        List<AssociationsActions> actions = new ArrayList<>();
        actions.add(inlineAction);
        trip.setActions(actions);

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
        VehicleAssociation newVehicle = new VehicleAssociation();
        newVehicle.setId(String.valueOf(UUID.randomUUID()));
        newVehicle.setVehicleType("truck");
        newVehicle.setAverageFuelConsumption(new AverageFuelConsumption(32.5, "l/100km"));
        ((VehicleAssociationInline)trip.getVehicle()).setEntity(newVehicle);

        // Fix Actor errors
        ((AssociatedActorsInline)trip.getActors().getFirst()).getEntity().setName("Logistics BV");
        ((Stop)((ActionsInline)trip.getActions().getFirst()).getEntity()).setStartTime(Instant.now().plus(5, ChronoUnit.MINUTES).toString());

        trip.setName("");

        System.out.println("Revalidating...");

        // Revalidate the trip
        validationResult = cbsProfileValidator.validate(trip);

        System.out.println(validationResult.toString());

        System.out.println("Still forgot to fix all errors");
        System.out.println("Fixing errors last errors ...");
        // Still forgot to resolve some parts of the error
        ((VehicleAssociationInline)trip.getVehicle()).getEntity().setLicensePlate("NL-01-AB");

        // Revalidate the trip
        validationResult = cbsProfileValidator.validate(trip);

        System.out.println(validationResult.toString());
    }
}
