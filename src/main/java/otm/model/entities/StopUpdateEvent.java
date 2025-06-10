package otm.model.entities;

public class StopUpdateEvent extends StopAction implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.STOP;
    }
}
