package otm;

import org.junit.jupiter.api.BeforeEach;
import otm.model.entities.*;

import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BaseTest {

    protected Trip trip;

    protected static final Instant START_TIME = Instant.now().atZone(ZoneId.systemDefault()).toInstant();
    protected static final Instant END_TIME = START_TIME.plus(10, ChronoUnit.MINUTES);

    @BeforeEach
    void setup() throws ParseException {
        // Build a Trip
        trip = new Trip();
        trip.setId("baa6e209-2b2b-4f35-86e1-dd229ca839e4");
        trip.setStatus(TripStatus.COMPLETED);
        trip.setTransportMode(TransportMode.ROAD);
        trip.setEntityType(EntityType.TRIP);
        trip.setName("Trip with errors");

        // Vehicle object creation, but we forget to set the vehicle
        InlineAssociationType<Vehicle> vehicleAssociation = new InlineAssociationType<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setId("a2a0925f-3ad5-4d01-a00a-4031b0e54e09");
        vehicle.setVehicleType("truck");
        vehicle.setLicensePlate("NL-01-AB");
        vehicle.setAverageFuelConsumption(UnitWithValue.create(32.5, "l/100km"));
        vehicleAssociation.setEntity(vehicle);
        trip.setVehicle(vehicleAssociation);

        // Actors list creation and population
        List<InlineAssociationActorType> actors = new ArrayList<>();
        InlineAssociationActorType actorAssociation = new InlineAssociationActorType();

        List<String> roles = new ArrayList<>();
        roles.add("carrier");
        actorAssociation.setRoles(roles);

        Actor actor = new Actor();
        actor.setId("2f86b0c6-383f-40da-9de0-167b26450303");
        actor.setName("Logistics BV");

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
        stopAction.setId("ff3251c5-dd40-4a1f-9abd-0fd0205fd2aa");
        stopAction.setActionType(ActionType.STOP);
        stopAction.setLifecycle(Lifecycle.ACTUAL);
        stopAction.setEndTime(Date.from(END_TIME));

        InlineAssociationType<Location> stopLocationAssociation = new InlineAssociationType<>();
        Location stopLocation = new Location();
        stopLocation.setName("Warehouse Amsterdam");
        stopLocation.setType(LocationType.CUSTOMER);
        stopLocationAssociation.setEntity(stopLocation);
        stopAction.setLocation(stopLocationAssociation);
        stopActionAssociation.setEntity(stopAction);
        stopAction.setStartTime(Date.from(START_TIME));
        actions.add(stopActionAssociation);
        trip.setActions(actions.toArray(new InlineAssociationType[0]));
    }
}
