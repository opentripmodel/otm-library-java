package otm.model.entities;

import java.util.List;

public class InlineAssociationActorType extends InlineAssociationType<Actor> {
    /**
     * <p>
     *     The roles this actor can have, one or multiple of:
     * </p>
     * <ul>
     *     <li><b>Carrier</b>: the actor which is responsible for physically delivering the goods from one place to another. Note that the actual transport can be delegated to another party (subcontractor), but the carrier remains responsible.</li>
     *     <li><b>Shipper</b>: the actor that engages in shipping goods and is the main contractor, ensuring the shipment takes place.</li>
     *     <li><b>Consignee</b>: the actor that is the buyer of the goods.</li>
     *     <li><b>Consignor</b>: the actor that sells the goods.</li>
     *     <li><b>Receiver</b>: the actor that receives the goods.</li>
     *     <li><b>Driver</b>: the actor that drives the vehicle containing the goods.</li>
     *     <li><b>Subcontractor</b>: The actor actually carrying out the physical delivery of the goods.</li>
     *     <li><b>Owner</b>: The actor owning the associated entity, e.g., the owner of a location or vehicle.</li>
     *     <li></li>
     * </ul>
     * <p>
     *     <b>How these are related</b> The consignee requires goods from the consignor. The shipper is the party responsible for ensuring this shipment takes place. The carrier is the one responsible for transporting the goods and ensures they are delivered to the receiver. If required/desired, the carrier can delegate the actual delivery to another party, the subcontractor. A driver is an actual person driving the vehicle. Note that a single actor can have multiple roles, for instance, an actor can be the shipper and consignor at the same time. Also note that there might be an actor that does not fit any of these roles. Then the roles may be left empty. However, if the role of the actor fits any of the above, it must be present.
     * </p>
     */
    private List<String> roles;

    // Getter and setter

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "InlineAssociationActorType{" +
                "roles=" + roles +
                '}';
    }
}
