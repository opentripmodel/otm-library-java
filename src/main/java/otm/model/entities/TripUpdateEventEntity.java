package otm.model.entities;

public class TripUpdateEventEntity extends Trip implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.Trip;
    }
}