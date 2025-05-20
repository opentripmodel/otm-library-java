package otm.model.entities;

/**
 * The list of types a {@link ContactDetail} can be.
 */
public enum ContactDetailType {
    OTHER,
    IBAN,
    GLN,
    VAT_CODE,
    NAME,
    LAST_NAME,
    MIDDLE_NAME,
    FIRST_NAME,
    EMAIL,
    PHONE,
    MOBILE_PHONE
}
//Todo missing the following types -> eori, phone
//Todo extra type -> MIDDLE_NAME