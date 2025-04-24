package otm.model.entities;

public class InlineAssociationType<T> {

    /**
     * Type of association
     */
    public AssociationType getAssociationType() {
        return AssociationType.INLINE;
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
}