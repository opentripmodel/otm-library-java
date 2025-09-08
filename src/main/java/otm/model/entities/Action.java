package otm.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * Actions are dynamic entities that are able to couple together various static entities at a certain moment in time. For instance, a Load action couples together a Consignment and a Vehicle at the moment the Loading happens.
 * </p>
 * There are various types of Actions:
 * <ul>
 * <li>The Stop that models visiting a certain location at a certain time and potentially doing several other actions at that location.</li>
 * <li>The Load action, that models loading in one or multiple Consignments into a vehicle or some sort of container.</li>
 * <li>The Unload action, that models unloading one or multiple Consignments from a vehicle or some other sort of container.</li>
 * <li>The HandOver that indicates transferring a consignment from one Actor to another.</li>
 * <li>The Move that models moving between two or more locations, potentially with detailed route information on how to move between these locations.</li>
 * <li>The AttachTransportEquipment that allows you to attach some equipment to the associated vehicle. Note that you can both load/unload and attach/detach TransportEquipments. For instance, loading a container on a ship, or attach a trailer to a truck. So choose the one that is most appropriate.</li>
 * <li>The DetachTransportEquipment that allows you to detach some previously attached equipment from the associated vehicle.</li>
 * <li>The Break action that models a mandatory resting period for the driver of the vehicle. During this period, the driver is prohibited from doing any driving activities or other work.</li>
 * <li>The Wait action that models waiting at a particular location during the trip. This can be due to various circumstances such as waiting for the vehicle to be transported by a ferry or train. Or because of waiting at frontiers or docks (e.g., the dock of the loading/unload location is occupied) or traffic prohibitions. The driver is allowed to leave the vehicle during this period. An important aspect distinguishing this from the break action is that waiting times can be shortened because of changing circumstances. For example, if the original waiting time was expected to be 15 minutes because of an occupied dock, but the driver is 10 minutes late, the waiting time can be shortened to 5 minutes until the dock is free.</li>
 * <li>The GenericAction for whenever any of the above actions cannot model the situation appropriately.</li>
 * </ul>
 */
public class Action extends OtmEntity {
    /**
     * The type of action this class is.
     */
    private ActionType actionType;

    /**
     * A lifecycle models when the data in the action is taking place. You can provide the same action in multiple
     * lifecycles to model how it changes over time. For example, the planned and realized time of an action taking
     * place can differ because of unforeseen circumstances (such as traffic jams).
     */
    private Lifecycle lifecycle;

    /**
     * Free text field for adding an on remark on this action.
     */
    private String remark;

    /**
     * The stop that is associated with this action.
     */
    private InlineAssociationType<StopAction> stop;

    /**
     * The consignment that is the subject of this action.
     */
    private InlineAssociationType<Consignment> consignment;

    /**
     * The location at which this action is taking place.
     */
    private InlineAssociationType<Location> location;

    /**
     * The time at which the action starts
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date startTime;

    /**
     * The time at which the action is completed
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date endTime;

    /**
     * Associations actions
     */
    private List<InlineAssociationType<Action>> actions;

    /**
     * The constraints this action abides to, such as start and end time windows.
     */
    private List<InlineAssociationType<Constraint>> constraint;

    /**
     * The result of the action. Can only be present in the actual or realized
     * lifecycles. The result has a required status and optional additional info,
     * like a remark and reason (in the case of failure).
     */
    private List<ActionResult> result;

    /**
     * The sequence number of this action within the entity it is taking place.
     * Can be used to indicate order when no times are present.
     */
    private int sequenceNr;

    /**
     * The format of the time for this action.
     */
    private TimeFormat timeFormat;

    /**
     * The recurrence of the date time. Should only be set when timeFormat is set
     * to recurringDateTime. The recurrence follows the Recurrence Rule specification.
     */
    private String recurrence;

    /**
     * The duration of this action/event. Should only be set when timeFormat is set
     * to duration. The duration follows the ISO 8601 specification.
     */
    private String duration;

    // Getters and setters

    /**
     * Gets the type of action this {@link Action} represents.
     * <p>
     * The {@code ActionType} enum defines the possible categories of actions
     * that can be performed within the system.
     *
     * @return the {@link ActionType} associated with this {@link Action}.  Will never be {@code null}.
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * Sets the type of action for this {@link Action}.
     * <p>
     * This method allows you to specify the {@link ActionType} that this {@link Action} represents.
     *
     * @param actionType The new {@link ActionType} to set for this {@link Action}.
     *                   Must not be {@code null}.
     * @throws NullPointerException if the provided {@code actionType} is {@code null}.
     */
    public void setActionType(ActionType actionType) {
        this.actionType = Objects.requireNonNull(actionType, "Action type cannot be null");
    }

    /**
     * Get the lifecycle for this {@link Action}.
     * <p>
     *     The {@code Lifecycle} enum defines the possible lifecycle status the {@link Action} can contain.
     * </p>
     * @return the {@link Lifecycle} associated with this object. Will never be {@code null}.
     */
    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    /**
     * Sets the lifecycle for this {@link Action}.
     * <p>
     *     This method allows you to specify the {@link Lifecycle} of this object.
     * </p>
     * @param lifecycle The current {@link Lifecycle} to set for this object. Must not be {@code null}
     */
    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = Objects.requireNonNull(lifecycle, "Lifecycle cannot be null");
    }

    /**
     * Get the remark for this {@link Action}.
     * <p>
     *     The {@code remark} is a free text field for adding an on remark on this action.
     * </p>
     * @return the remark.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark for this {@link Action}.
     * <p>
     *     This method allows you to set the remark for this {@link Action}.
     * </p>
     * @param remark The remark to set for this {@link Action}.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Get the {@link StopAction} wrapped in a {@link InlineAssociationType} for this {@link Action}
     * <p>
     *     The {@code stopAction} contains the information regarding a planned stop for this {@link Action}.
     * </p>
     * @return The {@link StopAction} wrapped in a {@link InlineAssociationType} object.
     */
    public InlineAssociationType<StopAction> getStop() {
        return stop;
    }

    /**
     * Sets the {@link StopAction} wrapped in a {@link InlineAssociationType} for this {@link Action}
     * <p>
     *     The {@code stopAction} contains the information regarding a planned stop for this {@link Action}.
     * </p>
     * @param stop The {@link StopAction} wrapped in a {@link InlineAssociationType} object.
     */
    public void setStop(InlineAssociationType<StopAction> stop) {
        this.stop = stop;
    }

    /**
     * Get the {@link Consignment} wrapped in a {@link InlineAssociationType} for this {@link Action}
     * <p>
     *     The {@code Consignment} contains the information regarding the to be transported goods for this {@link Action}.
     * </p>
     * @return The {@link Consignment} wrapped in a {@link InlineAssociationType} object.
     */
    public InlineAssociationType<Consignment> getConsignment() {
        return consignment;
    }

    /**
     * Sets the {@link Consignment} wrapped in a {@link InlineAssociationType} for this {@link Action}
     * <p>
     *     The {@code Consignment} contains the information regarding the to be transported goods for this {@link Action}.
     * </p>
     * @param consignment The {@link Consignment} wrapped in a {@link InlineAssociationType} object.
     */
    public void setConsignment(InlineAssociationType<Consignment> consignment) {
        this.consignment = consignment;
    }

    /**
     * Get the {@link Location} wrapped in a {@link InlineAssociationType} for this {@link Action}
     * <p>
     *     The {@code Consignment} contains the information regarding the location at which this {@link Action} takes place.
     * </p>
     * @return The {@link Location} wrapped in a {@link InlineAssociationType} object.
     */
    public InlineAssociationType<Location> getLocation() {
        return location;
    }

    /**
     * sets the {@link Location} wrapped in a {@link InlineAssociationType} for this {@link Action}
     * <p>
     *     The {@code Consignment} contains the information regarding the location at which this {@link Action} takes place.
     * </p>
     * @param location The {@link Location} wrapped in a {@link InlineAssociationType} object.
     */
    public void setLocation(InlineAssociationType<Location> location) {
        this.location = location;
    }

    /**
     * Gets the startTime ({@link Date}) for this {@link Action}
     * <p>
     *     The {@code startTime} contains the information regarding the time at which this {@link Action} starts.
     * </p>
     * @return The {@code startTime} for this {@link Action}.
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Sets the startTime ({@link Date}) for this {@link Action}
     * <p>
     *     The {@code startTime} contains the information regarding the time at which this {@link Action} starts.
     * </p>
     * @param startTime The {@code startTime} for this {@link Action} formatted as a {@link Date}.
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the endTime ({@link Date}) for this {@link Action}
     * <p>
     *     The {@code endTime} contains the information regarding the time at which this {@link Action} is completed.
     * </p>
     * @return The {@code endTime} for this {@link Action}.
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Sets the endTime ({@link Date}) for this {@link Action}
     * <p>
     *     The {@code endTime} contains the information regarding the time at which this {@link Action} is completed.
     * </p>
     * @param endTime The {@code endTime} for this {@link Action} formatted as a {@link Date}.
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets The {@link List} of {@link Action} wrapped in {@link InlineAssociationType} for this {@link Action}
     * <p>
     *
     * </p>
     * @return The {@link List} of {@code Actions} this {@link Action} contains
     */
    public List<InlineAssociationType<Action>> getActions() {
        return actions;
    }

    /**
     * Set the {@link List} of {@link Action} for this {@link Action}
     * <p>
     *
     * </p>
     * @param actions A {@link List} of {@link Action} wrapped in {@link InlineAssociationType} to be set for the {@link Action}
     */
    public void setActions(List<InlineAssociationType<Action>> actions) {
        this.actions = actions;
    }

    /**
     * Gets the list of constraints associated with this {@link Action}.
     * <p>
     * The returned list contains {@link Constraint} objects that are applied to this {@link Action}
     * </p>
     * @return A {@link List} of {@link Constraint} objects, wrapped in {@link InlineAssociationType}.
     */
    public List<InlineAssociationType<Constraint>> getConstraint() {
        return constraint;
    }

    /**
     * Sets the list of constraints associated with this {@link Action}.
     * <p>
     * This method allows you to define or replace the set of {@link Constraint} that apply to this object.
     * </p>
     *
     * @param constraint A {@link List} of {@link Constraint} objects, wrapped in {@link InlineAssociationType}.
     */
    public void setConstraint(List<InlineAssociationType<Constraint>> constraint) {
        this.constraint = constraint;
    }

    /**
     * Gets the result of the action.
     *
     * @return A list of {@link ActionResult} objects representing the result of the action.
     */
    public List<ActionResult> getResult() {
        return result;
    }

    /**
     * Sets the result of the action.
     *
     * @param result A list of {@link ActionResult} objects to set as the result of the action.
     */
    public void setResult(List<ActionResult> result) {
        this.result = result;
    }

    /**
     * Gets the sequence number of this action.
     *
     * @return the sequence number
     */
    public int getSequenceNr() {
        return sequenceNr;
    }

    /**
     * Sets the sequence number of this action.
     *
     * @param sequenceNr int the sequence number to set.
     */
    public void setSequenceNr(int sequenceNr) {
        this.sequenceNr = sequenceNr;
    }

    /**
     * Gets the time format for this action.
     *
     * @return The {@link TimeFormat} enum value.
     */
    public TimeFormat getTimeFormat() {
        return timeFormat;
    }

    /**
     * Sets the time format for this action.
     *
     * @param timeFormat The {@link TimeFormat} enum value to set.
     */
    public void setTimeFormat(TimeFormat timeFormat) {
        this.timeFormat = timeFormat;
    }

    /**
     * Gets the recurrence of the date time.
     *
     * @return The recurrence string following the Recurrence Rule specification.
     */
    public String getRecurrence() {
        return recurrence;
    }

    /**
     * Sets the recurrence of the date time.
     *
     * @param recurrence The recurrence string to set.
     */
    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    /**
     * Gets the duration of this action/event.
     *
     * @return The duration string following the ISO 8601 specification.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of this action/event.
     *
     * @param duration The duration string to set.
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionType=" + actionType +
                ", lifecycle=" + lifecycle +
                ", remark='" + remark + '\'' +
                ", stop=" + stop +
                ", consignment=" + consignment +
                ", location=" + location +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", actions=" + actions +
                ", constraint=" + constraint +
                ", result=" + result +
                ", sequenceNr=" + sequenceNr +
                ", timeFormat=" + timeFormat +
                ", recurrence='" + recurrence + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}