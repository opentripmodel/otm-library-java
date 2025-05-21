package otm.model.entities;

//Todo is this used??

public class StopUpdateEvent extends StopAction implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.STOP;
    }
}
