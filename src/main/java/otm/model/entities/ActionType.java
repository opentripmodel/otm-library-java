package otm.model.entities;

/**
 * <p>
 * Actions are {@code dynamic} entities that are able to couple together various {@code static} entities at a certain moment in time. For instance a Load action couples together a Consignment and a Vehicle at the moment the Loading happens.
 * </p>
 * <p>
 * There are various types of Actions:
 *</p>
 * <ul>
 * <li>The <strong>Stop</strong> that models visiting a certain location at a certain time and potentially doing several other actions at that location.</li>
 * <li>The <strong>Load</strong> action, that models loading in one or multiple Consignments into a vehicle or some sort of container.</li>
 * <li>The <strong>Unload</strong> action, that models unloading one or multiple Consignments from a vehicle or some other sort of container.</li>
 * <li>The <strong>HandOver</strong> that indicates transferring a consignment from one Actor to another.</li>
 * <li>The <strong>Move</strong> that models moving between two or more locations, potentially with detailed route information on how to move between these locations.</li>
 * <li>The <strong>AttachTransportEquipment</strong> that allows you to attach some equipment to the associated vehicle. Note that you can both load/unload and attach/detach TransportEquipments. For instance loading a container on a ship, or attach a trailer to a truck. So choose the one that is most appropriate.</li>
 * <li>The <strong>DetachTransportEquipment</strong> that allows you to detach some previously attached equipment from the associated vehicle.</li>
 * <li>The <strong>Break</strong> action that models a mandatory resting period for the driver of the vehicle. During this period the driver is prohibited from doing any driving activities or other work.</li>
 * <li>The <strong>Wait</strong> action that models waiting at a particular location during the trip. This can be due to various circumstances such as waiting for the vehicle to be transported by a ferry or train. Or because of waiting at frontiers or docks (e.g. the dock of the loading/unload location is occupied) or traffic prohibitions. The driver is allowed to leave the vehicle during this period. An important aspect distinguishing this from the break action is that waiting times can be shortened because of changing circumstances. For example, if the original waiting time was expected to be 15 minutes because of an occupied dock, but the driver is 10 minutes late, the waiting time can be shortened to 5 minutes until the dock is free.</li>
 * <li>The <strong>GenericAction</strong> for whenever any of the above actions cannot model the situation appropriately.</li>
 * </ul>
 */
public enum ActionType {
    GENERIC_ACTION,
    DETACH_TRANSPORT_EQUIPMENT,
    ATTACH_TRANSPORT_EQUIPMENT,
    MOVE,
    STOP,
    HAND_OVER,
    UNLOAD,
    LOAD
}
