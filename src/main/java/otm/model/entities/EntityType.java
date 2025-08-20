package otm.model.entities;

import com.fasterxml.jackson.annotation.JsonValue;
//import com.google.common.base.CaseFormat;


public enum EntityType {
    GENERIC_ACTION,
    WAIT,
    BREAK,
    REFUEL,
    DETACH_TRANSPORT_EQUIPMENT,
    ATTACH_TRANSPORT_EQUIPMENT,
    HAND_OVER,
    MOVE,
    STOP,
    UNLOAD,
    LOAD,
    DOCUMENT,
    VEHICLE,
    CONSIGNMENT,
    GOODS,
    TRANSPORT_ORDER,
    CONSTRAINT,
    ACTOR,
    LOCATION,
    ROUTE,
    SENSOR,
    TRIP;

    @JsonValue
    public String toCamelCase() {
        System.out.println("test");
//        return "test";
//        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, this.name());
        return com.google.common.base.CaseFormat.UPPER_UNDERSCORE.to(com.google.common.base.CaseFormat.LOWER_CAMEL, this.name());
    }
}
