package otm.model.entities;

import java.util.List;

public class GoodItem extends OtmEntity {



    private GoodItemType type;

    /**
     * A free text description of these goods.
     */
    private String description;

    /**
     * Remark belonging to the goods that need to be transported. For example, a delivery note.
     */
    private String remark;

    /**
     * A barcode present on the (packaging of the) goods that uniquely identifies these goods.
     */
    private String barCode;

    /**
     * A quantity determines how many of a certain good you have. Note that all other measurements are measured for a <b>single</b> product, not for the total of products.
     */
    private double quantity;

    /**
     * The gross weight of a 'single' good. The total weight can be calculated
     * by using the quantity and multiplying it with this weight.
     */
    private UnitWithValue grossWeight;

    /**
     * The net weight of a 'single' good, the total weight can be calculated by using the quantity and multiplying it with this weight.
     */
    private UnitWithValue weight;

    /**
     * The width of a 'single' good, the total width can be calculated by using the quantity and multiplying it with this width.
     */
    private UnitWithValue width;

    /**
     * The height of a 'single' good, the total height can be calculated by using the quantity and multiplying it with this height.
     */
    private UnitWithValue height;

    /**
     * The length of a 'single' good, the total length can be calculated by using the quantity and multiplying it with this length.
     */
    private UnitWithValue length;

    /**
     * Information about the potentially dangerous properties of these goods.
     */
    private Adr adr;

    /**
     * The product type of goods, for instance, bananas.
     */
    private String productType;

    /**
     * Description of the package type. Use as described by the <a href="https://www.gs1.nl/sites/default/files/so_gs1das_guideline_for_choosing_the_right_packaging_type.pdf">GS1 standard</a>.
     */
    private String packagingMaterial;

    /**
     * Product classification information often required at customs. A single product
     * can contain multiple classification lines. For example, whenever the product
     * consists of multiple components, that can each be classified. The most important
     * information in the classification lines is often the HS code.
     */
    private List<ClassificationLine> classificationLines;

    /**
     * All parties associated with these goods, for example, the consignor and consignee.
     */
    private List<InlineAssociationActorType> actors;

    /**
     * Association actions
     */
    private List<InlineAssociationType<Action>> actions;

    /**
     * The constraints this action abides to, such as start and end time windows.
     */
    private InlineAssociationType<Constraint> constraint;

    // Getters and setters

    /**
     * Gets the type of the good item.
     *
     * @return The good item type.
     */
    public GoodItemType getType() {
        return type;
    }

    /**
     * Sets the type of the good item.
     *
     * @param type The good item type to set.
     */
    public void setType(GoodItemType type) {
        this.type = type;
    }

    /**
     * Gets the free text description of the goods.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the free text description of the goods.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the remark belonging to the goods.
     *
     * @return The remark.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark belonging to the goods.
     *
     * @param remark The remark to set.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets the barcode of the goods.
     *
     * @return The barcode.
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * Sets the barcode of the goods.
     *
     * @param barCode The barcode to set.
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * Gets the quantity of the goods.
     *
     * @return The quantity.
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the goods.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
     * Gets the net weight of a single good.
     *
     * @return The weight.
     */
    public UnitWithValue getWeight() {
        return weight;
    }

    /**
     * Sets the net weight of a single good.
     *
     * @param weight The weight to set.
     */
    public void setWeight(UnitWithValue weight) {
        this.weight = weight;
    }

    /**
     * Gets the width of a single good.
     *
     * @return The width.
     */
    public UnitWithValue getWidth() {
        return width;
    }

    /**
     * Sets the width of a single good.
     *
     * @param width The width to set.
     */
    public void setWidth(UnitWithValue width) {
        this.width = width;
    }

    /**
     * Gets the height of a single good.
     *
     * @return The height.
     */
    public UnitWithValue getHeight() {
        return height;
    }

    /**
     * Sets the height of a single good.
     *
     * @param height The height to set.
     */
    public void setHeight(UnitWithValue height) {
        this.height = height;
    }

    /**
     * Gets the length of a single good.
     *
     * @return The length.
     */
    public UnitWithValue getLength() {
        return length;
    }

    /**
     * Sets the length of a single good.
     *
     * @param length The length to set.
     */
    public void setLength(UnitWithValue length) {
        this.length = length;
    }

    /**
     * Gets the ADR information of the goods.
     *
     * @return The ADR information.
     */
    public Adr getAdr() {
        return adr;
    }

    /**
     * Sets the ADR information of the goods.
     *
     * @param adr The ADR information to set.
     */
    public void setAdr(Adr adr) {
        this.adr = adr;
    }

    /**
     * Gets the product type of the goods.
     *
     * @return The product type.
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the product type of the goods.
     *
     * @param productType The product type to set.
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * Gets the packaging material of the goods.
     *
     * @return The packaging material.
     */
    public String getPackagingMaterial() {
        return packagingMaterial;
    }

    /**
     * Sets the packaging material of the goods.
     *
     * @param packagingMaterial The packaging material to set.
     */
    public void setPackagingMaterial(String packagingMaterial) {
        this.packagingMaterial = packagingMaterial;
    }

    /**
     * Gets the list of product classification lines.
     *
     * @return A {@link List} of {@link ClassificationLine} objects, providing details
     * for customs and product classification.
     */
    public List<ClassificationLine> getClassificationLines() {
        return classificationLines;
    }

    /**
     * Sets the list of product classification lines.
     *
     * @param classificationLines A {@link List} of {@link ClassificationLine} objects
     * to set for product classification.
     */
    public void setClassificationLines(List<ClassificationLine> classificationLines) {
        this.classificationLines = classificationLines;
    }

    /**
     * Gets the list of actors associated with the goods.
     *
     * @return The list of actors.
     */
    public List<InlineAssociationActorType> getActors() {
        return actors;
    }

    /**
     * Sets the list of actors associated with the goods.
     *
     * @param actors The list of actors to set.
     */
    public void setActors(List<InlineAssociationActorType> actors) {
        this.actors = actors;
    }

    /**
     * Gets the list of actions associated with the goods.
     *
     * @return The list of actions.
     */
    public List<InlineAssociationType<Action>> getActions() {
        return actions;
    }

    /**
     * Sets the list of actions associated with the goods.
     *
     * @param actions The list of actions to set.
     */
    public void setActions(List<InlineAssociationType<Action>> actions) {
        this.actions = actions;
    }

    public InlineAssociationType<Constraint> getConstraint() {
        return constraint;
    }

    public void setConstraint(InlineAssociationType<Constraint> constraint) {
        this.constraint = constraint;
    }

    @Override
    public String toString() {
        return "GoodItem{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", remark='" + remark + '\'' +
                ", barCode='" + barCode + '\'' +
                ", quantity=" + quantity +
                ", grossWeight=" + grossWeight +
                ", weight=" + weight +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", adr=" + adr +
                ", productType='" + productType + '\'' +
                ", packagingMaterial='" + packagingMaterial + '\'' +
                ", classificationLines=" + classificationLines +
                ", actors=" + actors +
                ", actions=" + actions +
                ", constraint=" + constraint +
                '}';
    }
}