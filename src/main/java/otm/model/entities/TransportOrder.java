package otm.model.entities;

import java.util.List;

/**
 * The TransportOrder is the top-level entity to model a group of related consignments that might be transported separately, but need to be administered together. For consistency, even if there is only one consignment, it is still required to use a transport order.
 */
public class TransportOrder extends OtmEntity {


    /**
     * A free text description of this transport order
     */
    private String description;

    /**
     * All consignments belonging to this transport order.
     */
    private List<InlineAssociationType<Consignment>> consignments;

    /**
     * The actors associated with this transport order, for instance the consignor, consignee.
     */
    private List<InlineAssociationActorType> actors;

    /**
     * Constraints this transport order has to abide to, such as the expected delivery time windows.
     */
    private List<InlineAssociationType<Constraint>> constraints;

    // Getters and setters

    /**
     * Gets the free text description of the transport order.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the free text description of the transport order.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the list of consignments belonging to the transport order.
     *
     * @return The list of consignments.
     */
    public List<InlineAssociationType<Consignment>> getConsignments() {
        return consignments;
    }

    /**
     * Sets the list of consignments belonging to the transport order.
     *
     * @param consignments The list of consignments to set.
     */
    public void setConsignments(List<InlineAssociationType<Consignment>> consignments) {
        this.consignments = consignments;
    }

    /**
     * Gets the list of actors associated with the transport order.
     *
     * @return The list of actors.
     */
    public List<InlineAssociationActorType> getActors() {
        return actors;
    }

    /**
     * Sets the list of actors associated with the transport order.
     *
     * @param actors The list of actors to set.
     */
    public void setActors(List<InlineAssociationActorType> actors) {
        this.actors = actors;
    }

    /**
     * Gets the list of constraints for the transport order.
     *
     * @return The list of constraints.
     */
    public List<InlineAssociationType<Constraint>> getConstraints() {
        return constraints;
    }

    /**
     * Sets the list of constraints for the transport order.
     *
     * @param constraints The list of constraints to set.
     */
    public void setConstraints(List<InlineAssociationType<Constraint>> constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        return "TransportOrder{" +
                "description='" + description + '\'' +
                ", consignments=" + consignments +
                ", actors=" + actors +
                ", constraints=" + constraints +
                '}';
    }
}
