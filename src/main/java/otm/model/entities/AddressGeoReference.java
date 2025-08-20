package otm.model.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Describes a geographic reference this is the primary way to link a {@code Location} entity to a physical, geographic location.
 */
@JsonTypeName("address")
public class AddressGeoReference extends GeoReference {

    private final GeoReferenceType type = GeoReferenceType.ADDRESS_GEO_REFERENCE;

    @Override
    public GeoReferenceType getType() {
        return type;
    }

    /**
     * Name of the address.
     */
    private String name;

    /**
     * Street of the address.
     */
    private String street;

    /**
     * House number of the address, without any extension.
     */
    private String houseNumber;

    /**
     * Addition or extension of the house number.
     */
    private String houseNumberAddition;

    /**
     * Postal code of the address
     */
    private String postalCode;

    /**
     * The city of the address.
     */
    private String city;

    /**
     * The ISO 3166-1 alpha-2 country code.
     */
    private String country;

    /**
     * Get the name of the address
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the address
     * @param name Name of the address
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the street of the address.
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street of the address.
     * @param street street of the address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the house number of the address, without any extension.
     * @return houseNumber
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Set the house number of the address, without any extension.
     * @param houseNumber house number of the address, without any extension.
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Get the addition or extension of the house number.
     * @return houseNumberAddition
     */
    public String getHouseNumberAddition() {
        return houseNumberAddition;
    }

    /**
     * Set the addition or extension of the house number.
     * @param houseNumberAddition addition or extension of the house number
     */
    public void setHouseNumberAddition(String houseNumberAddition) {
        this.houseNumberAddition = houseNumberAddition;
    }

    /**
     * Get the postal code of the address
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Set the postal code of the address
     * @param postalCode postal code of the address
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Get the city of the address.
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city of the address.
     * @param city city of the address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the country code formatted in ISO 3166-1 alpha-2.
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the country code formatted in ISO 3166-1 alpha-2.
     * @param country country code formatted in ISO 3166-1 alpha-2
     */
    public void setCountry(String country) {
        this.country = country;
    }
}