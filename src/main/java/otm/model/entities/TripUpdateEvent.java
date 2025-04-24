package otm.model.entities;

//todo is this used??

public class TripUpdateEvent extends Trip implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.TRIP;
    }
}
