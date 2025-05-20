package otm.model.entities;

public class ConsignmentUpdateEventEntity extends Consignment implements IUpdateEvent {

    @Override
    public EntityType getEntityType() {
        return EntityType.Consignment;
    }
}