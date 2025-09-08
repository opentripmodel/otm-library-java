package otm.model.entities;

import java.util.List;

/**
 * A consignment is a description of an identifiable collection of goods items to be transported between the consignor and the consignee. This information may be defined within a transport contract.
 */
public class Consignment extends OtmEntity {
    /**
     * General description of consignment in Free text. e.g 20 europallets fruit.
     */
    private String description;

    /**
     * Whether this consignment is a draft, requested, confirmed, in transit, completed or cancelled. The values accepted (replaced by confirmed) and modified (replaced the lastModified field on every entity) are deprecated since OTM5.1, but will be supported for the whole OTM5.X line.
     */
    private ConsignmentStatus status;

    /**
     * Free text to describe type of consignment. Usually used to indicate the property types of the products being transported (e.g. frozen, fragile, etc.).
     */
    private String type;

    /**
     * The various goods that need to be transported, together they are part of this consignment.
     */
    private List<InlineAssociationType<GoodItem>> goods;

    /**
     * Documents that are relevant for this consignment. Such as an official agreement between consignee and consignor.
     */
    private List<InlineAssociationType<Document>> documents;

    /**
     * Remark concerning the complete consignment, to be printed on the transport document.
     */
    private String remark;

    /**
     * The actors associated with this consignment, for instance the shipper and carrier. One should inline the actors only on the top-level entity (such as the transportOrder or trip)
     */
    private List<InlineAssociationType<Actor>> actors;

    /**
     * General description of actions related to the consignment f.e. loading, unloading, hand over, drop of.
     */
    private List<InlineAssociationType<Action>> actions;

    /**
     * Constraints this consignment has to abide to, such special equipment (tail lift, truck mounted forklift), special vehicle, special instructions related to consignor and consignee. Note that you can put the constraints on the individual goods. However using constraints on the consignment is simpler and therefore recommended when possible.
     */
    private InlineAssociationType<Constraint> constraint;

    /**
     * The transport order this consignment belongs to.
     */
    private InlineAssociationType<TransportOrder> transportOrder;

    /**
     * Consignments that have replaced the current consignment. For various reasons, a
     * consignment can be canceled and replaced by one or more other consignments. An example
     * is when the consignment is too large to be transported as a single 'transportable unit'.
     * You can use the relation field in the association to indicate the type of relationship.
     */
    private List<InlineAssociationType<Consignment>> relatedConsignments;

    // Getters and setters

    /**
     * Gets the general description of the consignment.
     *
     * @return The description of the consignment.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the general description of the consignment.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the status of the consignment.
     *
     * @return The status of the consignment.
     */
    public ConsignmentStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the consignment.
     *
     * @param status The status to set.
     */
    public void setStatus(ConsignmentStatus status) {
        this.status = status;
    }

    /**
     * Gets the type of the consignment.
     *
     * @return The type of the consignment.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the consignment.
     *
     * @param type The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the list of goods associated with the consignment.
     *
     * @return The list of goods.
     */
    public List<InlineAssociationType<GoodItem>> getGoods() {
        return goods;
    }

    /**
     * Sets the list of goods associated with the consignment.
     *
     * @param goods The list of goods to set.
     */
    public void setGoods(List<InlineAssociationType<GoodItem>> goods) {
        this.goods = goods;
    }

    /**
     * Gets the list of documents associated with the consignment.
     *
     * @return The list of documents.
     */
    public List<InlineAssociationType<Document>> getDocuments() {
        return documents;
    }

    /**
     * Sets the list of documents associated with the consignment.
     *
     * @param documents The list of documents to set.
     */
    public void setDocuments(List<InlineAssociationType<Document>> documents) {
        this.documents = documents;
    }

    /**
     * Gets the remark concerning the consignment.
     *
     * @return The remark.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark concerning the consignment.
     *
     * @param remark The remark to set.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets the list of actors associated with the consignment.
     *
     * @return The list of actors.
     */
    public List<InlineAssociationType<Actor>> getActors() {
        return actors;
    }

    /**
     * Sets the list of actors associated with the consignment.
     *
     * @param actors The list of actors to set.
     */
    public void setActors(List<InlineAssociationType<Actor>> actors) {
        this.actors = actors;
    }

    /**
     * Gets the list of actions associated with the consignment.
     *
     * @return The list of actions.
     */
    public List<InlineAssociationType<Action>> getActions() {
        return actions;
    }

    /**
     * Sets the list of actions associated with the consignment.
     *
     * @param actions The list of actions to set.
     */
    public void setActions(List<InlineAssociationType<Action>> actions) {
        this.actions = actions;
    }

    /**
     * Gets the constraint associated with the consignment.
     *
     * @return The constraint.
     */
    public InlineAssociationType<Constraint> getConstraint() {
        return constraint;
    }

    /**
     * Sets the constraint associated with the consignment.
     *
     * @param constraint The constraint to set.
     */
    public void setConstraint(InlineAssociationType<Constraint> constraint) {
        this.constraint = constraint;
    }

    /**
     * Gets the transport order this consignment belongs to.
     *
     * @return An {@link InlineAssociationType} instance representing the transport order.
     */
    public InlineAssociationType<TransportOrder> getTransportOrder() {
        return transportOrder;
    }

    /**
     * Sets the transport order this consignment belongs to.
     *
     * @param transportOrder The {@link InlineAssociationType} instance to set as the transport order.
     */
    public void setTransportOrder(InlineAssociationType<TransportOrder> transportOrder) {
        this.transportOrder = transportOrder;
    }

    /**
     * Gets the list of related consignments that have replaced the current one.
     *
     * @return A {@link List} of {@link InlineAssociationType} instances, each representing a related consignment.
     */
    public List<InlineAssociationType<Consignment>> getRelatedConsignments() {
        return relatedConsignments;
    }

    /**
     * Sets the list of related consignments that have replaced the current one.
     *
     * @param relatedConsignments A {@link List} of {@link InlineAssociationType} instances to set as related consignments.
     */
    public void setRelatedConsignments(List<InlineAssociationType<Consignment>> relatedConsignments) {
        this.relatedConsignments = relatedConsignments;
    }

    @Override
    public String toString() {
        return "Consignment{" +
                "description='" + description + '\'' +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", goods=" + goods +
                ", documents=" + documents +
                ", remark='" + remark + '\'' +
                ", actors=" + actors +
                ", actions=" + actions +
                ", constraint=" + constraint +
                ", transportOrder=" + transportOrder +
                ", relatedConsignments=" + relatedConsignments +
                '}';
    }
}