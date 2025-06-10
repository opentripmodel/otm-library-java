package otm.model.entities;

/**
 * Represents the result of an action.
 */
public class ActionResult {

    /**
     * The status of the result, either succeeded, failed, partially succeeded, or canceled.
     */
    private ActionResultStatus status;

    /**
     * The remark of the result, usually only interesting if the result was failed or
     * partially succeeded. Note that this differs from the remark on an action, which is a remark
     * that's relevant before the action's execution. This remark is relevant for
     * the result after execution.
     */
    private String remark;

    /**
     * The reason why the action (partially) failed. Currently, the only supported reasons are
     * 'damage' and 'receiverAbsent'. For example, 'damage' could mean a handOver failed because
     * the goods were too damaged and were rejected. 'receiverAbsent' could mean goods
     * were planned for delivery, but nobody was there to receive them, so they had
     * to be taken back.
     */
    private String reason;

    /**
     * Gets the status of the action result.
     *
     * @return The {@link ActionResultStatus} indicating the status of the result.
     */
    public ActionResultStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the action result.
     *
     * @param status The {@link ActionResultStatus} to set.
     */
    public void setStatus(ActionResultStatus status) {
        this.status = status;
    }

    /**
     * Gets the remark of the action result.
     *
     * @return A string containing the remark, or {@code null} if no remark is present.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark of the action result.
     *
     * @param remark The remark string to set.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets the reason for the action (partial) failure.
     *
     * @return A string detailing the reason for failure (e.g., "damage", "receiverAbsent"), or {@code null} if no reason is specified.
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the reason for the action (partial) failure.
     *
     * @param reason The reason string to set.
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
}
