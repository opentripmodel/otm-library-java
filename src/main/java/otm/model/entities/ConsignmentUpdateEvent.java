package otm.model.entities;

public class ConsignmentUpdateEvent extends Consignment implements IUpdateEvent {
    @Override
    public EntityType getEntityType() {
        return EntityType.CONSIGNMENT;
    }
}