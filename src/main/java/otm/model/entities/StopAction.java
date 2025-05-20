package otm.model.entities;

public class StopAction extends Action {
    @Override
    public ActionType getActionType() {
        return ActionType.STOP;
    }

    /**
     * The sequence number of this action within the entity it is taking place. Can be used to indicate order when no times are present
     */
    private long sequenceNr;

    // Getter and setter
    public long getSequenceNr() {
        return sequenceNr;
    }

    public void setSequenceNr(long sequenceNr) {
        this.sequenceNr = sequenceNr;
    }
}