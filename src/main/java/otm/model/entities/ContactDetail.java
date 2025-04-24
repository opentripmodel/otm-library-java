package otm.model.entities;

/**
 * Contact details
 */
public class ContactDetail {
    /**
     * The type of contact details this object entails
     */
    private ContactDetailType type;

    /**
     * A phone number, note that this means the landline phone number. Mobile phone is a separate type of contact detail
     */
    private String value;

    /**
     * Remark for this phone.
     */
    private String remark;

//    todo missing property language

    // Getters and setters

    /**
     * Gets the type of contact detail.
     *
     * @return The contact detail type.
     */
    public ContactDetailType getType() {
        return type;
    }

    /**
     * Sets the type of contact detail.
     *
     * @param type The contact detail type to set.
     */
    public void setType(ContactDetailType type) {
        this.type = type;
    }

    /**
     * Gets the value of the contact detail (e.g., phone number).
     *
     * @return The contact detail value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the contact detail (e.g., phone number).
     *
     * @param value The contact detail value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the remark for the contact detail.
     *
     * @return The remark.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark for the contact detail.
     *
     * @param remark The remark to set.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}