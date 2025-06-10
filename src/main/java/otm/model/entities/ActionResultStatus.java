package otm.model.entities;

public enum ActionResultStatus {
    /**
     * Indicates that the action completed successfully.
     */
    SUCCEEDED,
    /**
     * Indicates that the action failed to complete.
     */
    FAILED,
    /**
     * Indicates that the action completed, but only partially.
     * This might mean some aspects of the action succeeded while others failed.
     */
    PARTIALLY_SUCCEEDED,
    /**
     * Indicates that the action was canceled before completion.
     */
    CANCELLED
}
