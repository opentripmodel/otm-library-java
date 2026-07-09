package otm.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * The EmissionEvent contains information about how much emission has been produced during a
 * move, on a trip or per consignment, as defined by the OTM 5.7 specification. In the OTM
 * Carbon Footprint profile (CO2 Calculation Result) this event carries the calculated CO2(e)
 * emissions returned by a calculation platform, including the calculation transparency
 * required by the DALTI "Uniforme kernset CO2e" result dataset.
 */
public class EmissionEvent extends Event {

    @Override
    public EventType getEventType() {
        return EventType.EMISSION_EVENT;
    }

    /**
     * The amount of emitted pollutants in this event, expressed in CO2 equivalents,
     * e.g. { value: 123.4, unit: "kgCO2e" }. Required by the OTM specification.
     */
    private UnitWithValue amount;

    /**
     * The method used to determine the amount of emissions, as free text. Especially useful in
     * the projected/planned lifecycle where an estimation is made. For the structured
     * calculation transparency of the Carbon Footprint profile use {@code calculationMethod}.
     */
    private String method;

    /**
     * The emission intensity over the reported period, e.g. { value: 62, unit: "gCO2e/tkm" },
     * based on the carbon performance indicator (CPI) of the transport activity. Carbon
     * Footprint profile extension.
     */
    private UnitWithValue emissionIntensity;

    /**
     * Start of the period the emission result applies to. Carbon Footprint profile extension.
     */
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss.SSS",
            timezone = "UTC"
    )
    private Date periodStart;

    /**
     * End of the period the emission result applies to. Carbon Footprint profile extension.
     */
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss.SSS",
            timezone = "UTC"
    )
    private Date periodEnd;

    /**
     * Describes how the emission was calculated: the framework, ISO reference, allocation
     * method, data quality and granularity. Required by the Carbon Footprint profile for
     * transparency and comparability of emission figures between platforms.
     */
    private EmissionCalculationMethod calculationMethod;

    /**
     * The vehicle that is relevant for this event, used for vehicle-level emission reporting.
     */
    private InlineAssociationType<Vehicle> vehicle;

    /**
     * The consignment that is relevant for this event.
     */
    private InlineAssociationType<Consignment> consignment;

    /**
     * The (hub) location the emission result applies to, used for hub-level (HOC) emission
     * reporting. Carbon Footprint profile extension; should be omitted for trip- or
     * vehicle-level results.
     */
    private InlineAssociationType<Location> location;

    // Getters and setters

    public UnitWithValue getAmount() {
        return amount;
    }

    public void setAmount(UnitWithValue amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public UnitWithValue getEmissionIntensity() {
        return emissionIntensity;
    }

    public void setEmissionIntensity(UnitWithValue emissionIntensity) {
        this.emissionIntensity = emissionIntensity;
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

    public EmissionCalculationMethod getCalculationMethod() {
        return calculationMethod;
    }

    public void setCalculationMethod(EmissionCalculationMethod calculationMethod) {
        this.calculationMethod = calculationMethod;
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
        return "EmissionEvent{" +
                "amount=" + amount +
                ", emissionIntensity=" + emissionIntensity +
                ", periodStart=" + periodStart +
                ", periodEnd=" + periodEnd +
                ", calculationMethod=" + calculationMethod +
                '}';
    }
}
