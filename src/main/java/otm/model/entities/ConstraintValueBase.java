package otm.model.entities;

public abstract class ConstraintValueBase {
    public abstract ConstraintType getType();

    /**
     * A descriptive text for this entity.
     */
    private String description;

    /**
     * Gets the description.
     *
     * @return The description as a {@code String}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description The description string to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}