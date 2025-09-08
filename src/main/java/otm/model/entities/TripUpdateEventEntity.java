package otm.model.entities;

public class TripUpdateEventEntity extends Trip implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.TRIP;
    }

    @Override
    public String toString() {
        // This calls the toString() method from the parent 'Trip' class
        // and replaces the parent's name with this class's name for accuracy.
        return "TripUpdateEventEntity" + super.toString().substring(super.toString().indexOf("{"));
    }
}