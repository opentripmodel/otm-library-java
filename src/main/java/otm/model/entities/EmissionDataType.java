package otm.model.entities;

/**
 * The origin of the data used in a CO2(e) emission calculation.
 */
public enum EmissionDataType {
    /**
     * Measured data from the actual transport operation, e.g. real fuel consumption.
     */
    PRIMARY,

    /**
     * Data derived from a model of the transport operation.
     */
    MODELLED,

    /**
     * Default (industry average) values.
     */
    DEFAULT
}
