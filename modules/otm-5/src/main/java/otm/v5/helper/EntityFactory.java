package otm.v5.helper;

import otm.v5.model.Actor;
import otm.v5.model.Actor.EntityTypeEnum;
import otm.v5.model.Actor.TypeEnum;
import otm.v5.model.ActorCompany;
import otm.v5.model.ActorPerson;
import otm.v5.model.AttachInEvents;
import otm.v5.model.BreakInEvents;
import otm.v5.model.Consignment;
import otm.v5.model.Constraint;
import otm.v5.model.DetachInEvents;
import otm.v5.model.Document;
import otm.v5.model.GenericInEvents;
import otm.v5.model.HandoverInEvents;
import otm.v5.model.Items;
import otm.v5.model.LoadInEvents;
import otm.v5.model.Location;
import otm.v5.model.MoveInEvents;
import otm.v5.model.RefuelInEvents;
import otm.v5.model.Route;
import otm.v5.model.Sensor;
import otm.v5.model.Stop;
import otm.v5.model.Stop.ActionTypeEnum;
import otm.v5.model.StopInEvents;
import otm.v5.model.TransportEquipment;
import otm.v5.model.TransportOrder;
import otm.v5.model.Trip;
import otm.v5.model.UnloadInEvents;
import otm.v5.model.Vehicle;
import otm.v5.model.WaitInEvents;

/**
 * Helper class used create new OTM entities
 */
public class EntityFactory {

    private EntityFactory () {
        // static helper class
    }

    public static ActorCompany createActorCompany() {
        return ActorCompany.builder()
            .type(Actor.TypeEnum.COMPANY)
            .entityType(EntityTypeEnum.ACTOR)
            .build();
    }

    public static ActorPerson createActorPerson() {
        return ActorPerson.builder()
            .type(TypeEnum.PERSON)
            .entityType(EntityTypeEnum.ACTOR)
            .build();
    }

    public static Actor createActor() {
        return Actor.builder()
            .entityType(EntityTypeEnum.ACTOR)
            .build();
    }

    public static Trip createTrip() {
        return Trip.builder()
            .entityType(Trip.EntityTypeEnum.TRIP)
            .build();
    }

    public static Stop createStop() {
        return Stop.builder()
            .actionType(ActionTypeEnum.STOP)
            .build();
    }

    public static Sensor createSensor() {
        return Sensor.builder()
            .entityType(Sensor.EntityTypeEnum.SENSOR)
            .build();
    }

    public static Route createRoute() {
        return Route.builder()
            .entityType(Route.EntityTypeEnum.ROUTE)
            .build();
    }

    public static Location createLocation() {
        return Location.builder()
            .entityType(Location.EntityTypeEnum.LOCATION)
            .build();
    }

    public static Constraint createConstraint() {
        return Constraint.builder()
            .entityType(Constraint.EntityTypeEnum.CONSTRAINT)
            .build();
    }

    public static TransportOrder createTransportOrder() {
        return TransportOrder.builder()
            .entityType(TransportOrder.EntityTypeEnum.TRANSPORT_ORDER)
            .build();
    }

    public static Items createItems() {
        return Items.builder()
            .entityType(Items.EntityTypeEnum.GOODS)
            .type(Items.TypeEnum.ITEMS)
            .build();
    }

    public static TransportEquipment createTransportEquipment() {
        return TransportEquipment.builder()
            .entityType(TransportEquipment.EntityTypeEnum.GOODS)
            .type(TransportEquipment.TypeEnum.TRANSPORT_EQUIPMENT)
            .build();
    }

    public static Consignment createConsignment() {
        return Consignment.builder()
            .entityType(Consignment.EntityTypeEnum.CONSIGNMENT)
            .build();
    }

    public static Vehicle createVehicle() {
        return Vehicle.builder()
            .entityType(Vehicle.EntityTypeEnum.VEHICLE)
            .build();
    }

    public static Document createDocument() {
        return Document.builder()
            .entityType(Document.EntityTypeEnum.DOCUMENT)
            .build();
    }

    public static LoadInEvents createLoadInEvents() {
        return LoadInEvents.builder()
            .entityType(LoadInEvents.EntityTypeEnum.LOAD)
            .build();
    }

    public static UnloadInEvents createUnloadInEvents() {
        return UnloadInEvents.builder()
            .entityType(UnloadInEvents.EntityTypeEnum.UNLOAD)
            .build();
    }

    public static StopInEvents createStopInEvents() {
        return StopInEvents.builder()
            .entityType(StopInEvents.EntityTypeEnum.STOP)
            .build();
    }

    public static MoveInEvents createMoveInEvents() {
        return MoveInEvents.builder()
            .entityType(MoveInEvents.EntityTypeEnum.MOVE)
            .build();
    }

    public static HandoverInEvents createHandoverInEvents() {
        return HandoverInEvents.builder()
            .entityType(HandoverInEvents.EntityTypeEnum.HAND_OVER)
            .build();
    }

    public static AttachInEvents createAttachInEvents() {
        return AttachInEvents.builder()
            .entityType(AttachInEvents.EntityTypeEnum.ATTACH_TRANSPORT_EQUIPMENT)
            .build();
    }

    public static DetachInEvents createDetachInEvents() {
        return DetachInEvents.builder()
            .entityType(DetachInEvents.EntityTypeEnum.DETACH_TRANSPORT_EQUIPMENT)
            .build();
    }

    public static RefuelInEvents createRefuelInEvents() {
        return RefuelInEvents.builder()
            .entityType(RefuelInEvents.EntityTypeEnum.REFUEL)
            .build();
    }

    public static BreakInEvents createBreakInEvents() {
        return BreakInEvents.builder()
            .entityType(BreakInEvents.EntityTypeEnum.BREAK)
            .build();
    }

    public static WaitInEvents createWaitInEvents() {
        return WaitInEvents.builder()
            .entityType(WaitInEvents.EntityTypeEnum.WAIT)
            .build();
    }

    public static GenericInEvents createGenericInEvents() {
        return GenericInEvents.builder()
            .entityType(GenericInEvents.EntityTypeEnum.GENERIC_ACTION)
            .build();
    }


}
