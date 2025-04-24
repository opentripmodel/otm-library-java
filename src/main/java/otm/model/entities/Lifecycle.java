package otm.model.entities;

/**
 * A lifecycle models <i>when</i> the data in the action is taking place. You can provide the same action in multiple lifecycles to model how it changes over time. For example the planned and realized time of an action taking place can differ because of unforseen circumstances (such as traffic jams).
 */
public enum Lifecycle {
    REQUESTED,
    PLANNED,
    PROJECTED,
    ACTUAL,
    REALIZED
}
