package otm.model.entities;

import java.util.List;
import java.util.Optional;

public class ClassificationLine {
    /**
     * The Harmonized System (HS) code is a product classification code used by all members of the
     * World Customs Organization (WCO) to classify goods for customs purposes.
     */
    private String hsCode;

    /**
     * The description of this classification line.
     */
    private String description;

    /**
     * A quantity determines how many of a certain good you have. Note that all other measurements
     * are for a single product, not for the total of products.
     */
    private Optional<Integer> quantity;

    /**
     * The net weight of a 'single' good. The total weight can be calculated by using the quantity
     * and multiplying it with this weight.
     */
    private UnitWithValue weight;

    /**
     * The gross weight of a 'single' good. The total weight can be calculated by using the
     * quantity and multiplying it with this weight.
     */
    private UnitWithValue grossWeight;

    /**
     * The width of a 'single' classified goods part. The total width can be calculated by
     * using the quantity and multiplying it with this width.
     */
    private UnitWithValue width;

    /**
     * The height of a 'single' classified goods part. The total height can be calculated by
     * using the quantity and multiplying it with this height.
     */
    private UnitWithValue height;

    /**
     * The length of a 'single' classified goods part. The total length can be calculated by using
     * the quantity and multiplying it with this length.
     */
    private UnitWithValue length;

    /**
     * Fallback solution as a stopgap for fields not yet in OTM.
     * You can use these, but please file a change request so that they can be properly
     * incorporated into the specification.
     */
    private List<ClassificationField> others;

    /**
     * Gets the Harmonized System (HS) code.
     *
     * @return The HS code as a {@code String}.
     */
    public String getHsCode() {
        return hsCode;
    }

    /**
     * Sets the Harmonized System (HS) code.
     *
     * @param hsCode The HS code to set.
     */
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    /**
     * Gets the description of this classification line.
     *
     * @return The description as a {@code String}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this classification line.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the quantity of this classified good.
     *
     * @return An {@link Optional} containing the quantity as an {@link Integer}, or an empty Optional if not set.
     */
    public Optional<Integer> getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of this classified good.
     *
     * @param quantity An {@link Optional} containing the quantity to set, or an empty Optional.
     */
    public void setQuantity(Optional<Integer> quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the net weight of a single good.
     *
     * @return The {@link UnitWithValue} representing the net weight.
     */
    public UnitWithValue getWeight() {
        return weight;
    }

    /**
     * Sets the net weight of a single good.
     *
     * @param weight The {@link UnitWithValue} to set for the net weight.
     */
    public void setWeight(UnitWithValue weight) {
        this.weight = weight;
    }

    /**
     * Gets the gross weight of a single good.
     *
     * @return The {@link UnitWithValue} representing the gross weight.
     */
    public UnitWithValue getGrossWeight() {
        return grossWeight;
    }

    /**
     * Sets the gross weight of a single good.
     *
     * @param grossWeight The {@link UnitWithValue} to set for the gross weight.
     */
    public void setGrossWeight(UnitWithValue grossWeight) {
        this.grossWeight = grossWeight;
    }

    /**
     * Gets the width of a single classified goods part.
     *
     * @return The {@link UnitWithValue} representing the width.
     */
    public UnitWithValue getWidth() {
        return width;
    }

    /**
     * Sets the width of a single classified goods part.
     *
     * @param width The {@link UnitWithValue} to set for the width.
     */
    public void setWidth(UnitWithValue width) {
        this.width = width;
    }

    /**
     * Gets the height of a single classified goods part.
     *
     * @return The {@link UnitWithValue} representing the height.
     */
    public UnitWithValue getHeight() {
        return height;
    }

    /**
     * Sets the height of a single classified goods part.
     *
     * @param height The {@link UnitWithValue} to set for the height.
     */
    public void setHeight(UnitWithValue height) {
        this.height = height;
    }

    /**
     * Gets the length of a single classified goods part.
     *
     * @return The {@link UnitWithValue} representing the length.
     */
    public UnitWithValue getLength() {
        return length;
    }

    /**
     * Sets the length of a single classified goods part.
     *
     * @param length The {@link UnitWithValue} to set for the length.
     */
    public void setLength(UnitWithValue length) {
        this.length = length;
    }

    /**
     * Gets a list of additional classification fields.
     *
     * @return A {@link List} of {@link ClassificationField} objects for other, non-standard classifications.
     */
    public List<ClassificationField> getOthers() {
        return others;
    }

    /**
     * Sets a list of additional classification fields.
     *
     * @param others A {@link List} of {@link ClassificationField} objects to set.
     */
    public void setOthers(List<ClassificationField> others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "ClassificationLine{" +
                "hsCode='" + hsCode + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", weight=" + weight +
                ", grossWeight=" + grossWeight +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", others=" + others +
                '}';
    }
}
