package otm.model.entities;

import java.util.List;

/**
 * Describes how a CO2(e) emission figure was calculated. Corresponds to the generic
 * ("Generiek") elements of the DALTI "Uniforme kernset CO2e" result dataset.
 */
public class EmissionCalculationMethod {

    /**
     * The calculation framework and version that was used, e.g. "GLEC 3.1" or
     * "CO2emissiefactoren.nl".
     */
    private String framework;

    /**
     * Reference to the ISO standard version the calculation complies with, e.g. "ISO 14083:2023".
     */
    private String isoReference;

    /**
     * The method used to allocate emissions over distance: great circle distance (GCD) or
     * shortest feasible distance (SFD).
     */
    private DistanceAllocationMethod distanceAllocationMethod;

    /**
     * The level of detail of the underlying data: day, week, month, quarter or year.
     */
    private EmissionDataGranularity granularity;

    /**
     * Quality classification of the emission figure: bronze, silver, gold or gold+.
     */
    private EmissionDataClassification dataClassification;

    /**
     * The distribution of the underlying data over the data types primary, modelled and
     * default, expressed as fractions that together add up to 1.
     */
    private List<EmissionDataShare> dataTypeDistribution;

    // Getters and setters

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getIsoReference() {
        return isoReference;
    }

    public void setIsoReference(String isoReference) {
        this.isoReference = isoReference;
    }

    public DistanceAllocationMethod getDistanceAllocationMethod() {
        return distanceAllocationMethod;
    }

    public void setDistanceAllocationMethod(DistanceAllocationMethod distanceAllocationMethod) {
        this.distanceAllocationMethod = distanceAllocationMethod;
    }

    public EmissionDataGranularity getGranularity() {
        return granularity;
    }

    public void setGranularity(EmissionDataGranularity granularity) {
        this.granularity = granularity;
    }

    public EmissionDataClassification getDataClassification() {
        return dataClassification;
    }

    public void setDataClassification(EmissionDataClassification dataClassification) {
        this.dataClassification = dataClassification;
    }

    public List<EmissionDataShare> getDataTypeDistribution() {
        return dataTypeDistribution;
    }

    public void setDataTypeDistribution(List<EmissionDataShare> dataTypeDistribution) {
        this.dataTypeDistribution = dataTypeDistribution;
    }

    @Override
    public String toString() {
        return "EmissionCalculationMethod{" +
                "framework='" + framework + '\'' +
                ", isoReference='" + isoReference + '\'' +
                ", distanceAllocationMethod=" + distanceAllocationMethod +
                ", granularity=" + granularity +
                ", dataClassification=" + dataClassification +
                ", dataTypeDistribution=" + dataTypeDistribution +
                '}';
    }
}
