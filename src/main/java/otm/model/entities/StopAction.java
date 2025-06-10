package otm.model.entities;

public class StopAction extends Action {
    @Override
    public ActionType getActionType() {
        return ActionType.STOP;
    }
}