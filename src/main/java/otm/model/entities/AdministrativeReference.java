package otm.model.entities;

/**
 * Address information that is used as an administrative reference. For example, when the actual load location is different from the officially registered location, this holds the latter
 */
public class AdministrativeReference {
    /**
     * Name of the administrative reference address.
     */
    private String name;

    /**
     * Street of the administrative reference address.
     */
    private String street;

    /**
     * House number of the administrative reference address, without any extension.
     */
    private String houseNumber;

    /**
     * Addition or extension of the administrative reference address house number.
     */
    private String houseNumberAddition;

    /**
     * Postal code of the administrative reference address.
     */
    private String postalCode;

    /**
     * The city of the administrative reference address.
     */
    private String city;

    /**
     * ISO 3166-1 alpha-2 country code of the administrative reference address.
     */
    private String country;

    /**
     * Get the name of the administrative reference address
     * @return The name of the administrative reference address
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the administrative reference address
     * @param name The name of the administrative reference address
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the house number of the administrative reference address, without any extension
     * @return The house number of the administrative reference address, without any extension
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the house number of the administrative reference address, without any extension
     * @param street The house number of the administrative reference address, without any extension
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the House number of the administrative reference address, without any extension
     * @return The house number of the administrative reference address, without any extension
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Set the house number of the administrative reference address, without any extension
     * @param houseNumber The house number of the administrative reference address, without any extension
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Get the addition or extension of the administrative reference address house number
     * @return The addition or extension of the administrative reference address house number
     */
    public String getHouseNumberAddition() {
        return houseNumberAddition;
    }

    /**
     * Set the addition or extension of the administrative reference address house number
     * @param houseNumberAddition The addition or extension of the administrative reference address house number
     */
    public void setHouseNumberAddition(String houseNumberAddition) {
        this.houseNumberAddition = houseNumberAddition;
    }

    /**
     * Get the postal code of the administrative reference address
     * @return The postal code of the administrative reference address
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Set the postal code of the administrative reference address
     * @param postalCode The postal code of the administrative reference address
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Get city of the administrative reference address
     * @return The city of administrative reference address
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city of the administrative reference address
     * @param city The city of administrative reference address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the ISO 3166-1 alpha-2 country code of the administrative reference address.
     * @return The country code of the administrative reference address formatted as ISO 3166-1 alpha-2.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the ISO 3166-1 alpha-2 country code of the administrative reference address.
     * @param country The country code of the administrative reference address formatted as ISO 3166-1 alpha-2.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AdministrativeReference{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseNumberAddition='" + houseNumberAddition + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}