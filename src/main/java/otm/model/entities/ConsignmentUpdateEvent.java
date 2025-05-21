package otm.model.entities;

//todo unused class?
public class ConsignmentUpdateEvent extends Consignment implements IUpdateEvent {
    @Override
    public EntityType getEntityType() {
        return EntityType.Consignment;
    }
}