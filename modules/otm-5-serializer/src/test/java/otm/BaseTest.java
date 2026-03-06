package otm;

import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import otm.v5.helper.EntityFactory;
import otm.v5.helper.InlineAssociation;
import otm.v5.model.Actor;
import otm.v5.model.ActorCompany;
import otm.v5.model.AddressGeoReference;
import otm.v5.model.AssociatedActorsInline.RolesEnum;
import otm.v5.model.AssociatedLocations;
import otm.v5.model.AverageFuelConsumption;
import otm.v5.model.ContactDetails;
import otm.v5.model.Email;
import otm.v5.model.Email.TypeEnum;
import otm.v5.model.Stop;
import otm.v5.model.Stop.LifecycleEnum;
import otm.v5.model.StopLocation;
import otm.v5.model.Trip;
import otm.v5.model.Trip.StatusEnum;
import otm.v5.model.Trip.TransportModeEnum;
import otm.v5.model.VehicleAssociation;

public class BaseTest {

    protected Trip trip;

    protected static final Instant START_TIME = Instant.now().atZone(ZoneId.systemDefault()).toInstant();
    protected static final Instant END_TIME = START_TIME.plus(10, ChronoUnit.MINUTES);

    @BeforeEach
    void setup() throws ParseException {
        // Build a Trip
        trip = EntityFactory.createTrip();
        trip.setId("baa6e209-2b2b-4f35-86e1-dd229ca839e4");
        trip.setStatus(StatusEnum.COMPLETED);
        trip.setTransportMode(TransportModeEnum.ROAD);
        trip.setName("Trip with errors");

        // Vehicle object creation
        VehicleAssociation vehicle = new VehicleAssociation();
        vehicle.setId("a2a0925f-3ad5-4d01-a00a-4031b0e54e09");
        vehicle.setVehicleType("truck");
        vehicle.setLicensePlate("NL-01-AB");
        vehicle.setAverageFuelConsumption(new AverageFuelConsumption(32.5, "l/100km"));

        trip.setVehicle(InlineAssociation.of(vehicle));

        // Actors list creation and population
        ActorCompany actor = EntityFactory.createActorCompany();
        actor.setId("2f86b0c6-383f-40da-9de0-167b26450303");
        actor.setName("Logistics BV");

        List<ContactDetails> contactDetails = new ArrayList<>();
        Email emailDetail = new Email(TypeEnum.EMAIL,"info@logistics.nl");
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

        actor.setLocations(List.of(
            InlineAssociation.of(location)
        ));

        Actor testActor = EntityFactory.createActor();
        testActor.setId("222837a2-cc39-4fe8-8756-3d19d3db12f0");
        testActor.setName("Test BV");

        trip.setActors(List.of(
            InlineAssociation.of(actor, RolesEnum.CARRIER),
            InlineAssociation.of(testActor, RolesEnum.SUBCONTRACTOR)
        ));

        // Actions list creation and population
        Stop stopAction = EntityFactory.createStop();
        stopAction.setId("ff3251c5-dd40-4a1f-9abd-0fd0205fd2aa");
        stopAction.setLifecycle(LifecycleEnum.ACTUAL);
        stopAction.setStartTime(START_TIME.toString());
        stopAction.setEndTime(END_TIME.toString());

        StopLocation stopLocation = new StopLocation();
        stopLocation.setName("Warehouse Amsterdam");
        stopLocation.setType(StopLocation.TypeEnum.CUSTOMER);

        stopAction.setLocation(InlineAssociation.of(stopLocation));

        trip.setActions(List.of(
            InlineAssociation.of(stopAction)
        ));
    }
}
