package otm.model.entities;

public class InlineAssociationType<T> {

    public InlineAssociationType(T actorLocation) {
        this.entity = actorLocation;
    }
    public InlineAssociationType() {

    }

    private final AssociationType associationType = AssociationType.INLINE;

    /**
     * Type of association
     */
    public AssociationType getAssociationType() {
        return associationType;
    }

    /**
     * Associated entity
     */
    private T entity;

    /**
     * A free text description of the relationship to the associated entity.
     */
    private String description;

    // Getters and setters

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "InlineAssociationType{" +
                "associationType=" + associationType +
                ", entity=" + entity +
                ", description='" + description + '\'' +
                '}';
    }
}