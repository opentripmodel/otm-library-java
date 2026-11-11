package otm.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * The FuelConsumedEvent contains information about how much fuel (or other energy, such as
 * electricity) was consumed during a move, on a trip or per consignment, as defined by the
 * OTM 5.7 specification. In the OTM Carbon Footprint profile (CO2 Calculation Input) this
 * event supplies the energy data needed to calculate CO2 emissions, as defined by the DALTI
 * "Uniforme kernset CO2e": the consumption of a vehicle, towed unit, auxiliary equipment or
 * hub location over a given period.
 */
public class FuelConsumedEvent extends Event {

    @Override
    public EventType getEventType() {
        return EventType.FUEL_CONSUMED_EVENT;
    }

    /**
     * The type of fuel (energy) consumed in this event, e.g. diesel, electricity or hydrogen.
     * Use {@link Fuel#OTHER} in combination with {@code otherFuelType} for energy sources not
     * covered by the enumeration.
     */
    private Fuel fuel;

    /**
     * Type of fuel, only to be used when the fuel field is set to other.
     */
    private String otherFuelType;

    /**
     * The amount of fuel (energy) consumed in this event, e.g. liters of diesel or kWh of
     * electricity. Required by the OTM specification.
     */
    private UnitWithValue amount;

    /**
     * The standard ("normering") the consumption figures adhere to and against which emission
     * factors should be applied, e.g. "GLEC" or "CO2emissiefactoren.nl". Carbon Footprint
     * profile extension.
     */
    private String emissionFactorStandard;

    /**
     * Start of the period over which the consumption is reported. Carbon Footprint profile
     * extension.
     */
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss.SSS",
            timezone = "UTC"
    )
    private Date periodStart;

    /**
     * End of the period over which the consumption is reported. Carbon Footprint profile
     * extension.
     */
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss.SSS",
            timezone = "UTC"
    )
    private Date periodEnd;

    /**
     * The vehicle (or towed unit / auxiliary equipment) that is relevant for this event.
     * Optional when the event is provided as context of a trip with a single vehicle.
     */
    private InlineAssociationType<Vehicle> vehicle;

    /**
     * The consignment that is relevant for this event.
     */
    private InlineAssociationType<Consignment> consignment;

    /**
     * The (hub) location the consumption applies to, used to report hub energy data (HOC).
     * Carbon Footprint profile extension; should be omitted for vehicle-related consumption.
     */
    private InlineAssociationType<Location> location;

    // Getters and setters

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public String getOtherFuelType() {
        return otherFuelType;
    }

    public void setOtherFuelType(String otherFuelType) {
        this.otherFuelType = otherFuelType;
    }

    public UnitWithValue getAmount() {
        return amount;
    }

    public void setAmount(UnitWithValue amount) {
        this.amount = amount;
    }

    public String getEmissionFactorStandard() {
        return emissionFactorStandard;
    }

    public void setEmissionFactorStandard(String emissionFactorStandard) {
        this.emissionFactorStandard = emissionFactorStandard;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public InlineAssociationType<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(InlineAssociationType<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public InlineAssociationType<Consignment> getConsignment() {
        return consignment;
    }

    public void setConsignment(InlineAssociationType<Consignment> consignment) {
        this.consignment = consignment;
    }

    public InlineAssociationType<Location> getLocation() {
        return location;
    }

    public void setLocation(InlineAssociationType<Location> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "FuelConsumedEvent{" +
                "fuel=" + fuel +
                ", amount=" + amount +
                ", emissionFactorStandard='" + emissionFactorStandard + '\'' +
                ", periodStart=" + periodStart +
                ", periodEnd=" + periodEnd +
                '}';
    }
}
