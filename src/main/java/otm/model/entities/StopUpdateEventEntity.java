package otm.model.entities;

public class StopUpdateEventEntity extends StopAction implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.Stop;
    }
}