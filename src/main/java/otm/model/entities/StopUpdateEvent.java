package otm.model.entities;

public class StopUpdateEvent extends StopAction implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.STOP;
    }

    @Override
    public String toString() {
        // This calls the toString() method from the parent 'StopAction' class
        // and replaces the parent's name with this class's name for accuracy.
        return "StopUpdateEvent" + super.toString().substring(super.toString().indexOf("{"));
    }
}
