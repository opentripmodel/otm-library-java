package otm.model.entities;

import java.util.List;

/**
 * A {@link Vehicle} is a means to transport consignments from one location to potentially multiple other locations. There are various types of vehicles, each with their own unique properties like size, dimensions, fuel type and means of transport (by air, on land, over sea).
 */
public class Vehicle extends OtmEntity {
    /**
     * The type of vehicle
     */
    private String vehicleType;

    /**
     * The type of fuel the vehicle runs on. For vehicle without an engine of their own, such as a trailer, you may choose {@code not-applicable}. For trailers with cooling capabilities, choose the fuel type of the cooling engine.
     */
    private Fuel fuel;

    /**
     * Type of fuel, only to be used when the fuel field is set to 'Other'.
     */
    private String otherFuelType;

    /**
     * Average fuel consumption of the vehicle.
     */
    private UnitWithValue averageFuelConsumption;

    /**
     * European emission standards are vehicle emission standards for exhaust emissions of new vehicles sold in
     * the European Union and EEA member states. The standards are defined in a series of European Union directives
     * staging the progressive introduction of increasingly stringent standards.
     */
    private EmissionStandard emissionStandard;

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
     * <li>You might want to express the load capacities in different quantities. E.g., in square meters or liters as well as in the number of pallets.</li>
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
    private String licensePlate;

    /**
     * The weight of the Vehicle when empty.
     */
    private UnitWithValue emptyWeight;

    /**
     * There are multiple roles in which actors can be associated with a vehicle, such as the owner
     * or the driver of the vehicle.
     */
    private List<InlineAssociationType<Actor>> actors;

    /**
     * Vehicles might have some sensors that are permanently attached; these can be described using the sensor field.
     * If one works with detachable sensors, the recommended approach is to use associationCreated and associationRemoved
     * events instead.
     */
    private List<InlineAssociationType<Sensor>> sensors;

    /**
     * The actions that are involved for the vehicle (for a particular time window).
     */
    private List<InlineAssociationType<Action>> actions;

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
    public Fuel getFuel() {
        return fuel;
    }

    /**
     * Sets the fuel type of the vehicle.
     *
     * @param fuel The fuel type to set.
     */
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    /**
     * Gets the type of fuel when the primary fuel field is set to 'Other'.
     *
     * @return The specific type of fuel if the primary fuel is 'Other'.
     */
    public String getOtherFuelType() {
        return otherFuelType;
    }

    /**
     * Sets the type of fuel when the primary fuel field is set to 'Other'.
     *
     * @param otherFuelType The specific type of fuel if the primary fuel is 'Other'.
     */
    public void setOtherFuelType(String otherFuelType) {
        this.otherFuelType = otherFuelType;
    }

    /**
     * Gets the average fuel consumption of the vehicle.
     *
     * @return The average fuel consumption as a {@link UnitWithValue} object.
     */
    public UnitWithValue getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    /**
     * Sets the average fuel consumption of the vehicle.
     *
     * @param averageFuelConsumption The average fuel consumption as a {@link UnitWithValue} object.
     */
    public void setAverageFuelConsumption(UnitWithValue averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    /**
     * Gets the European emission standard of the vehicle.
     *
     * @return The {@link EmissionStandard} of the vehicle.
     */
    public EmissionStandard getEmissionStandard() {
        return emissionStandard;
    }

    /**
     * Sets the European emission standard of the vehicle.
     *
     * @param emissionStandard The {@link EmissionStandard} of the vehicle.
     */
    public void setEmissionStandard(EmissionStandard emissionStandard) {
        this.emissionStandard = emissionStandard;
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
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets the license plate of the vehicle.
     *
     * @param licensePlate The license plate to set.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    /**
     * Gets the list of sensors permanently attached to the vehicle.
     *
     * @return A list of {@link InlineAssociationType} of {@link Sensor}s.
     */
    public List<InlineAssociationType<Sensor>> getSensors() {
        return sensors;
    }

    /**
     * Sets the list of sensors permanently attached to the vehicle.
     *
     * @param sensors A list of {@link InlineAssociationType} of {@link Sensor}s to set.
     */
    public void setSensors(List<InlineAssociationType<Sensor>> sensors) {
        this.sensors = sensors;
    }

    /**
     * Gets the list of actions associated with the vehicle.
     *
     * @return A list of {@link InlineAssociationType} of {@link Action}s.
     */
    public List<InlineAssociationType<Action>> getActions() {
        return actions;
    }

    /**
     * Sets the list of actions associated with the vehicle.
     *
     * @param actions A list of {@link InlineAssociationType} of {@link Action}s to set.
     */
    public void setActions(List<InlineAssociationType<Action>> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType='" + vehicleType + '\'' +
                ", fuel=" + fuel +
                ", otherFuelType='" + otherFuelType + '\'' +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", emissionStandard=" + emissionStandard +
                ", maxLinks=" + maxLinks +
                ", loadCapacities=" + loadCapacities +
                ", length=" + length +
                ", height=" + height +
                ", width=" + width +
                ", licensePlate='" + licensePlate + '\'' +
                ", emptyWeight=" + emptyWeight +
                ", actors=" + actors +
                ", sensors=" + sensors +
                ", actions=" + actions +
                '}';
    }
}