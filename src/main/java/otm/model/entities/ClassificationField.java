package otm.model.entities;

public class ClassificationField {
    /**
     * The key of this classification field. This uniquely identifies the type
     * of classification data.
     */
    private String key;

    /**
     * The value that belongs to the key of this classification field.
     * This holds the actual data for the classification.
     */
    private String value;

    /**
     * Gets the key of this classification field.
     *
     * @return The key as a {@code String}.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key of this classification field.
     *
     * @param key The key to set as a {@code String}.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the value that belongs to the key of this classification field.
     *
     * @return The value as a {@code String}.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value that belongs to the key of this classification field.
     *
     * @param value The value to set as a {@code String}.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
