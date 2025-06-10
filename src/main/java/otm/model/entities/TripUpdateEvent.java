package otm.model.entities;

public class TripUpdateEvent extends Trip implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.TRIP;
    }
}
