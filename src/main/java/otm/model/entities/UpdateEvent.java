package otm.model.entities;

import java.util.List;

public abstract class UpdateEvent extends OtmEntity {

    public EventType getEventType() {
        return EventType.UPDATE_EVENT;
    }

    /**
     * A lifecycle models when the data in the action is taking place. You can provide the same action in multiple
     * lifecycles to model how it changes over time. For example, the planned and realized time of an action taking
     * place can differ because of unforeseen circumstances (such as traffic jams).
     */
    private Lifecycle lifecycle;

    /**
     * The actors associated with this transport order, for instance, the consignor, consignee.
     */
    private List<InlineAssociationActorType> actors;

    // Getters and setters

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public List<InlineAssociationActorType> getActors() {
        return actors;
    }

    public void setActors(List<InlineAssociationActorType> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "UpdateEvent{" +
                "lifecycle=" + lifecycle +
                ", actors=" + actors +
                '}';
    }
}