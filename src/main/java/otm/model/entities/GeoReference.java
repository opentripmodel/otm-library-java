package otm.model.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AddressGeoReference.class, name = "ADDRESS_GEO_REFERENCE"),
        @JsonSubTypes.Type(value = LatLonPointGeoReference.class, name = "LAT_LON_POINT_GEO_REFERENCE"),
        @JsonSubTypes.Type(value = LatLonArrayGeoReference.class, name = "LAT_LON_ARRAY_GEO_REFERENCE")
})
public abstract class GeoReference {
    public abstract GeoReferenceType getType();
}