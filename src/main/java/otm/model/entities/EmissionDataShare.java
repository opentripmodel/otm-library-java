package otm.model.entities;

/**
 * The share of one data type (primary, modelled or default) within the data used for a
 * CO2(e) emission calculation.
 */
public class EmissionDataShare {

    /**
     * The type of data this share applies to.
     */
    private EmissionDataType dataType;

    /**
     * The fraction (0..1) of the underlying data that is of this data type.
     */
    private Double share;

    public EmissionDataShare() {
    }

    public EmissionDataShare(EmissionDataType dataType, Double share) {
        this.dataType = dataType;
        this.share = share;
    }

    // Getters and setters

    public EmissionDataType getDataType() {
        return dataType;
    }

    public void setDataType(EmissionDataType dataType) {
        this.dataType = dataType;
    }

    public Double getShare() {
        return share;
    }

    public void setShare(Double share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "EmissionDataShare{" +
                "dataType=" + dataType +
                ", share=" + share +
                '}';
    }
}
