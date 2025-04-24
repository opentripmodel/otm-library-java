package otm.model.entities;

import java.util.List;

/**
 * A {@link Vehicle} is a means to transport consignments from one location to potentially multiple other locations. There are various types of vehicles, each with their own unique properties like size, dimensions, fuel type and means of tranport (by air, on land, over sea).
 */
public class Vehicle extends OtmEntity {

    // todo missing attribute -> contextEvents, otherFuelType, averageFuelConsumption, emissionStandard, sensors, actions

    /**
     * The type of vehicle
     */
    private String vehicleType;

    /**
     * The type of fuel the vehicle runs on. For vehicle without an engine of their own, such as a trailer, you may choose {@code not-applicable}. For trailers with cooling capabilities, choose the fuel type of the cooling engine.
     */
    private String fuel; //todo spec makes this a ENUM not string

    /**
     * Maximum number of links to other {@link Vehicle}s. Typical values are 0, 1 or 2
     */
    private Integer maxLinks;

    /**
     * <p>
     * The load capacities of the Vehicle. This can be an array of values, for several reasons:
     * </p>
     * <ul>
     * <li><The {@code Vehicle} might be split up in multiple compartments./li>
     * <li>You might want to express the load capacities in different quantities. E.g. in square meters or litres as well as in number of pallets.</li>
     * </ul>
     */
    private List<UnitWithValue> loadCapacities;

    /**
     * The length of the Vehicle
     */
    private UnitWithValue length;

    /**
     * The height of the Vehicle
     */
    private UnitWithValue height;

    /**
     * The width of the Vehicle
     */
    private UnitWithValue width;

    /**
     * The license plate of the vehicle.
     */
    private String licencePlate;

    /**
     * The weight of the Vehicle when empty.
     */
    private UnitWithValue emptyWeight;

    /**
     * There are multiple roles in which actors can be associated with a vehicle, such as the owner
     * or the driver of the vehicle.
     */
    private List<InlineAssociationType<Actor>> actors;

    // Getters and setters

    /**
     * Gets the type of the vehicle.
     *
     * @return The vehicle type.
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets the type of the vehicle.
     *
     * @param vehicleType The vehicle type to set.
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Gets the fuel type of the vehicle.
     *
     * @return The fuel type.
     */
    public String getFuel() {
        return fuel;
    }

    /**
     * Sets the fuel type of the vehicle.
     *
     * @param fuel The fuel type to set.
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    /**
     * Gets the maximum number of links to other vehicles.
     *
     * @return The maximum number of links.
     */
    public Integer getMaxLinks() {
        return maxLinks;
    }

    /**
     * Sets the maximum number of links to other vehicles.
     *
     * @param maxLinks The maximum number of links to set.
     */
    public void setMaxLinks(Integer maxLinks) {
        this.maxLinks = maxLinks;
    }

    /**
     * Gets the list of load capacities of the vehicle.
     *
     * @return The list of load capacities.
     */
    public List<UnitWithValue> getLoadCapacities() {
        return loadCapacities;
    }

    /**
     * Sets the list of load capacities of the vehicle.
     *
     * @param loadCapacities The list of load capacities to set.
     */
    public void setLoadCapacities(List<UnitWithValue> loadCapacities) {
        this.loadCapacities = loadCapacities;
    }

    /**
     * Gets the length of the vehicle.
     *
     * @return The length.
     */
    public UnitWithValue getLength() {
        return length;
    }

    /**
     * Sets the length of the vehicle.
     *
     * @param length The length to set.
     */
    public void setLength(UnitWithValue length) {
        this.length = length;
    }

    /**
     * Gets the height of the vehicle.
     *
     * @return The height.
     */
    public UnitWithValue getHeight() {
        return height;
    }

    /**
     * Sets the height of the vehicle.
     *
     * @param height The height to set.
     */
    public void setHeight(UnitWithValue height) {
        this.height = height;
    }

    /**
     * Gets the width of the vehicle.
     *
     * @return The width.
     */
    public UnitWithValue getWidth() {
        return width;
    }

    /**
     * Sets the width of the vehicle.
     *
     * @param width The width to set.
     */
    public void setWidth(UnitWithValue width) {
        this.width = width;
    }

    /**
     * Gets the license plate of the vehicle.
     *
     * @return The license plate.
     */
    public String getLicencePlate() {
        return licencePlate;
    }

    /**
     * Sets the license plate of the vehicle.
     *
     * @param licencePlate The license plate to set.
     */
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    /**
     * Gets the empty weight of the vehicle.
     *
     * @return The empty weight.
     */
    public UnitWithValue getEmptyWeight() {
        return emptyWeight;
    }

    /**
     * Sets the empty weight of the vehicle.
     *
     * @param emptyWeight The empty weight to set.
     */
    public void setEmptyWeight(UnitWithValue emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    /**
     * Gets the list of actors associated with the vehicle.
     *
     * @return The list of actors.
     */
    public List<InlineAssociationType<Actor>> getActors() {
        return actors;
    }

    /**
     * Sets the list of actors associated with the vehicle.
     *
     * @param actors The list of actors to set.
     */
    public void setActors(List<InlineAssociationType<Actor>> actors) {
        this.actors = actors;
    }
}