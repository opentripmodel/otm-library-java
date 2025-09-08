package otm.model.entities;

public class UnitWithValue {

    /**
     * Creates a UnitWithValue object.
     *
     * @param value The value.
     * @param unit  The unit of measurement.
     * @return A UnitWithValue object, or null if the value is null.
     */
    public static UnitWithValue create(Double value, String unit) {
        return value == null ? null : new UnitWithValue(value, unit);
    }

    /**
     * Implicit conversion from double to UnitWithValue.
     *
     * @param value The double value to convert.
     * @return A UnitWithValue object.
     */
    public static UnitWithValue fromDouble(double value) {
        return new UnitWithValue(value, null);
    }

    /**
     * <p>
     *     Measurement unit of this value. OTM5 currently does not enforce any units of measure. So you are free to use any unit necessary. However to ensure parties use OTM5 consistently there are a few rules:
     * </p>
     * <ul>
     *     <li>For <b>currencies</b> use the <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO_4217 standard</a></li>
     *     <li>For <b>mass</b>, <b>volume</b> and <b>length</b> the <a href="https://en.wikipedia.org/wiki/International_System_of_Units">SI system (International System of Units)</a> is recommended. To avoid problems with symbols, square and cubic units of measure are simply communicated using the proper number. Thus a square meter is {@code m2} and a cubic meter is {@code m3}.</li>
     *     <li>For degrees the recommend approach is Celsius, but Fahrenheit and Kelvin are also supported. To again avoid problems with symbols, the degree symbol (° in °C) is left off, thus only the single capital letter remains (C, F, or K).</li>
     *     <li>For velocity use the metric system. The required format would then be / for the metric system, such as km/h (kilometer per hour) or m/s (meter per second).</li>
     * </ul>
     * <p>
     *     Since usage is not enforced you can deviate from these rules, though only do so if strictly necessary. The benefit from using a standard comes from consistent use, so deviating from the recommendations diminishes your benefit.
     * </p>
     * <p>
     *     If the type of unit you need is not supported please create a <a href="https://github.com/opentripmodel/otm5-change-requests">change request</a>
     * </p>
     */
    private String unit;

    /**
     * Value in the given unit.
     */
    private Double value;

    public UnitWithValue(Double value, String unit){
        this.value = value;
        this.unit = unit;
    }

    public UnitWithValue(){
    }

    // Getters and setters

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UnitWithValue{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }

}