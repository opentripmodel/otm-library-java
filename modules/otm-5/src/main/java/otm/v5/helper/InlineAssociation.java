package otm.v5.helper;

import java.util.List;
import otm.v5.model.Actions;
import otm.v5.model.ActionsInline;
import otm.v5.model.Actor;
import otm.v5.model.ActorsReference;
import otm.v5.model.AssociatedActorsInline;
import otm.v5.model.AssociatedActorsInline.RolesEnum;
import otm.v5.model.AssociatedLocations;
import otm.v5.model.AssociatedLocationsInline;
import otm.v5.model.AssociationsActions;
import otm.v5.model.LocationsReference;
import otm.v5.model.StopInEventsLocation;
import otm.v5.model.StopLocation;
import otm.v5.model.StopLocationInline;
import otm.v5.model.VehicleAssociation;
import otm.v5.model.VehicleAssociationInline;
import otm.v5.model.VehicleAssociationInline.AssociationTypeEnum;
import otm.v5.model.VehiclesReference;

/**
 * This is a helper class to enable easier use of inline associations
 */
public class InlineAssociation {

    private InlineAssociation () {
        // static helper class
    }

    public static VehiclesReference of (VehicleAssociation vehicle) {
        return VehicleAssociationInline.builder()
            .associationType(AssociationTypeEnum.INLINE)
            .entity(vehicle)
            .build();
    }

    public static LocationsReference of (AssociatedLocations location) {
        return AssociatedLocationsInline.builder()
            .associationType(AssociatedLocationsInline.AssociationTypeEnum.INLINE)
            .entity(location)
            .build();
    }

    public static ActorsReference of (Actor actor, List<RolesEnum> roles) {
        return AssociatedActorsInline.builder()
            .associationType(AssociatedActorsInline.AssociationTypeEnum.INLINE)
            .roles(roles)
            .entity(actor)
            .build();
    }

    public static ActorsReference of (Actor actor, RolesEnum singleRole) {
        return AssociatedActorsInline.builder()
            .associationType(AssociatedActorsInline.AssociationTypeEnum.INLINE)
            .roles(List.of(singleRole))
            .entity(actor)
            .build();
    }

    public static StopInEventsLocation of (StopLocation stopLocation) {
        return StopLocationInline.builder()
            .associationType(StopLocationInline.AssociationTypeEnum.INLINE)
            .entity(stopLocation)
            .build();
    }

    public static AssociationsActions of (Actions action) {
        return ActionsInline.builder()
            .associationType(ActionsInline.AssociationTypeEnum.INLINE)
            .entity(action)
            .build();
    }

    // TODO: create more methods to help create inline associations

}
