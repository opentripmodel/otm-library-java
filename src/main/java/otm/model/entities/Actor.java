package otm.model.entities;

import java.util.List;

/**
 * An {@code Actor} models a legal entity. A legal entity is an individual, company, or organization that has legal rights and obligations. The use of {@code Actors} is optional, and is not necessary to use OpenTripModel. Actors can be used, e.g., to group all locations that belong to an organization, or to address an OpenTripModel message to a specific person or organization.
 */
public class Actor extends OtmEntity {

    /**
     * Contact details for this Actor.
     */
    private List<ContactDetail> contactDetails;

    /**
     * Locations for this Actor.
     */
    private List<InlineAssociationType<Location>> locations;

    /**
     * Get contact details for this Actor.
     * @return ContactDetail
     */
    public List<ContactDetail> getContactDetails() {
        return contactDetails;
    }

    /**
     * Set contact details for this Actor.
     * @param contactDetails The contact details for this Actor.
     */
    public void setContactDetails(List<ContactDetail> contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * Get the locations for this Actor
     * @return locations
     */
    public List<InlineAssociationType<Location>> getLocations() {
        return locations;
    }

    /**
     * Set the locations for this Actor
      * @param locations The locations for this Actor
     */
    public void setLocations(List<InlineAssociationType<Location>> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "contactDetails=" + contactDetails +
                ", locations=" + locations +
                '}';
    }
}