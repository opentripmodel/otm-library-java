package otm.model.entities;

/**
 * Whether this trip is a draft, requested, confirmed, in transit, completed or canceled. The values accepted (replaced by confirmed) and modified (replaced the lastModified field on every entity) are deprecated since OTM5.1, but will be supported for the whole OTM5.X line.
 */
public enum TripStatus {
    REQUESTED,
    ACCEPTED,
    MODIFIED,
    CANCELLED,
    DRAFT,
    CONFIRMED,
    IN_TRANSIT,
    COMPLETED
}