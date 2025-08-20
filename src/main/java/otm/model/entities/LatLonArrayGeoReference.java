package otm.model.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("latLonArray")
public class LatLonArrayGeoReference extends GeoReference {

    @Override
    public GeoReferenceType getType() {
        return GeoReferenceType.LAT_LON_ARRAY_GEO_REFERENCE;
    }

    /**
     * An array of lat/lon points.
     */
    private List<LatLonPointGeoReference> points;

    // Getter and setter

    /**
     * Get the Array of lot/lon points
     * @return Array of lot/lon points
     */
    public List<LatLonPointGeoReference> getPoints() {
        return points;
    }

    /**
     * Set the lat/lon points
     * @param points The list of lat/lon points to set
     */
    public void setPoints(List<LatLonPointGeoReference> points) {
        this.points = points;
    }
}