package otm.model.entities;

public class ConsignmentUpdateEventEntity extends Consignment implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.CONSIGNMENT;
    }

    @Override
    public String toString() {
        // This calls the toString() method from the parent 'Consignment' class
        // and replaces the parent's name with this class's name for accuracy.
        return "ConsignmentUpdateEventEntity" + super.toString().substring(super.toString().indexOf("{"));
    }
}