package otm.model.entities;

/**
 * Whether this consignment is a draft, requested, confirmed, in transit, completed or cancelled. The values accepted (replaced by confirmed) and modified (replaced the lastModified field on every entity) are deprecated since OTM5.1, but will be supported for the whole OTM5.X line.
 */
public enum ConsignmentStatus {
    DRAFT,
    REQUESTED,
    IN_TRANSIT,
    COMPLETED,
    CANCELLED,
    ACCEPTED,
    MODIFIED,
}
