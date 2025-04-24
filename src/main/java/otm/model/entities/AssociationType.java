package otm.model.entities;

/**
 * <p>
 *     There are 3 types of AssociationType,
 *     <ul>
 *         <li>INLINE (Child object stored directly as an inline child)</li>
 *         <li>REFERENCE (Child object is only referenced by unique identifier )</li>
 *         <li>ATTRIBUTE_RESTRICTION</li>
 *     </ul>
 * </p>
 */
public enum AssociationType {
    INLINE,
    REFERENCE,
    ATTRIBUTE_RESTRICTION,
}
