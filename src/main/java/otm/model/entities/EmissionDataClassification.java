package otm.model.entities;

/**
 * Quality classification of a CO2(e) emission figure, based on the origin and level of detail
 * of the underlying data.
 */
public enum EmissionDataClassification {
    BRONZE,
    SILVER,
    GOLD,
    GOLD_PLUS
}
