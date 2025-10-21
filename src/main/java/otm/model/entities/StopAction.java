package otm.model.entities;

public class StopAction extends Action {
    @Override
    public ActionType getActionType() {
        return ActionType.STOP;
    }

    @Override
    public String toString() {
        // This calls the toString() method from the parent 'Action' class
        // and replaces the parent's name with this class's name for accuracy.
        return "StopAction" + super.toString().substring(super.toString().indexOf("{"));
    }
}