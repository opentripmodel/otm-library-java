package otm.model.entities;

public class StopAction extends Action {

//    note below: These are not present in this object, either though {@link Action} or any other deep link
//    todo missing attribute -> contextEvents, result, trip, TimeFormat, recurrence, duration

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