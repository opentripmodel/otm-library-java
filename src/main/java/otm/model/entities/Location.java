package otm.model.entities;

import java.util.List;

/**
 * Object describing a geographic location. A location can either be a point or an area.
 */
public class Location extends OtmEntity {
    /**
     * The type of location
     */
    private LocationType type;

    /**
     * Describes a geographic reference, this is the primary way to link a {@link Location} entity to a physical, geographic location.
     */
    private GeoReference geoReference;

    /**
     * the United Nations Code for Trade and Transport Locations, is a geographic coding scheme developed and maintained by United Nations Economic Commission for Europe (UNECE) to uniquely identify locations. See <a href="https://en.wikipedia.org/wiki/UN/LOCODE">this Wikipedia page</a>.
     */
    private String unCode;

    /**
     * The Global Location Number (GLN) is part of the GS1 systems of standards to uniquely identify a location. See also this <a href="https://en.wikipedia.org/wiki/Global_Location_Number">Wikipedia</a> page
     */
    private String gln;

    /**
     * Address information that is used as an administrative reference. For example: when the actual load location is different from the officially registered location, this holds the latter
     */
    private AdministrativeReference administrativeReference;

    /**
     * Contact details for this {@link Location}.
     */
    private List<ContactDetail> contactDetails;

    /**
     * Remark about the location. Please don't misuse this field for external references, use the {@code externalAttributes} field instead
     */
    private String remark;

    /**
     * Locations can be associated with actors in multiple ways, though the most common one is the <i>owner</i> of the location, either a person or a legal entity.
     */
    private List<InlineAssociationType<Actor>> actors;

    /**
     * Multiple actions can be associated with a location, such as a Last-Mile guidance that should be followed to reach that location.
     */
    private List<InlineAssociationType<Action>> actions;

    /**
     * <p>
     * In the context of a {@link Location}, access to the location is only allowed if the given constraint applies.
     * </p>
     * <p>
     * <b>Note</b> that constraints can be nested and combined using the {@link AndConstraint}, {@link OrConstraint} and {@link NotConstraint}.
     * </p>
     */
    private InlineAssociationType<Constraint> constraint;

    /**
     * Sub-locations that can be identified on their own but are also part of this
     * location. For example, a dock at a large distribution area. Sub-locations can also
     * be seen as 'points of interest' on a larger location.
     */
    private List<InlineAssociationType<Location>> subLocations;

    // Getters and setters

    /**
     * Gets the type of the location.
     *
     * @return The location type.
     */
    public LocationType getType() {
        return type;
    }

    /**
     * Sets the type of the location.
     *
     * @param type The location type to set.
     */
    public void setType(LocationType type) {
        this.type = type;
    }

    /**
     * Gets the geographic reference of the location.
     *
     * @return The geographic reference.
     */
    public GeoReference getGeoReference() {
        return geoReference;
    }

    /**
     * Sets the geographic reference of the location.
     *
     * @param geoReference The geographic reference to set.
     */
    public void setGeoReference(GeoReference geoReference) {
        this.geoReference = geoReference;
    }

    /**
     * Gets the UN/LOCODE of the location.
     *
     * @return The UN/LOCODE.
     */
    public String getUnCode() {
        return unCode;
    }

    /**
     * Sets the UN/LOCODE of the location.
     *
     * @param unCode The UN/LOCODE to set.
     */
    public void setUnCode(String unCode) {
        this.unCode = unCode;
    }

    /**
     * Gets the GLN of the location.
     *
     * @return The GLN.
     */
    public String getGln() {
        return gln;
    }

    /**
     * Sets the GLN of the location.
     *
     * @param gln The GLN to set.
     */
    public void setGln(String gln) {
        this.gln = gln;
    }

    /**
     * Gets the administrative reference of the location.
     *
     * @return The administrative reference.
     */
    public AdministrativeReference getAdministrativeReference() {
        return administrativeReference;
    }

    /**
     * Sets the administrative reference of the location.
     *
     * @param administrativeReference The administrative reference to set.
     */
    public void setAdministrativeReference(AdministrativeReference administrativeReference) {
        this.administrativeReference = administrativeReference;
    }

    /**
     * Gets the list of contact details for the location.
     *
     * @return The list of contact details.
     */
    public List<ContactDetail> getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the list of contact details for the location.
     *
     * @param contactDetails The list of contact details to set.
     */
    public void setContactDetails(List<ContactDetail> contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * Gets the remark about the location.
     *
     * @return The remark.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark about the location.
     *
     * @param remark The remark to set.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets the list of actors associated with the location.
     *
     * @return The list of actors.
     */
    public List<InlineAssociationType<Actor>> getActors() {
        return actors;
    }

    /**
     * Sets the list of actors associated with the location.
     *
     * @param actors The list of actors to set.
     */
    public void setActors(List<InlineAssociationType<Actor>> actors) {
        this.actors = actors;
    }

    /**
     * Gets the list of actions associated with the location.
     *
     * @return The list of actions.
     */
    public List<InlineAssociationType<Action>> getActions() {
        return actions;
    }

    /**
     * Sets the list of actions associated with the location.
     *
     * @param actions The list of actions to set.
     */
    public void setActions(List<InlineAssociationType<Action>> actions) {
        this.actions = actions;
    }

    /**
     * Gets the constraint associated with the location.
     *
     * @return The constraint.
     */
    public InlineAssociationType<Constraint> getConstraint() {
        return constraint;
    }

    /**
     * Sets the constraint associated with the location.
     *
     * @param constraint The constraint to set.
     */
    public void setConstraint(InlineAssociationType<Constraint> constraint) {
        this.constraint = constraint;
    }

    /**
     * Gets the list of sub-locations.
     *
     * @return A {@link List} of {@link InlineAssociationType} objects, where each association
     * contains a {@link Location} representing a sub-location.
     */
    public List<InlineAssociationType<Location>> getSubLocations() {
        return subLocations;
    }

    /**
     * Sets the list of sub-locations.
     *
     * @param subLocations A {@link List} of {@link InlineAssociationType} objects to set as sub-locations.
     */
    public void setSubLocations(List<InlineAssociationType<Location>> subLocations) {
        this.subLocations = subLocations;
    }

    @Override
    public String toString() {
        return "Location{" +
                "type=" + type +
                ", geoReference=" + geoReference +
                ", unCode='" + unCode + '\'' +
                ", gln='" + gln + '\'' +
                ", administrativeReference=" + administrativeReference +
                ", contactDetails=" + contactDetails +
                ", remark='" + remark + '\'' +
                ", actors=" + actors +
                ", actions=" + actions +
                ", constraint=" + constraint +
                ", subLocations=" + subLocations +
                '}';
    }
}