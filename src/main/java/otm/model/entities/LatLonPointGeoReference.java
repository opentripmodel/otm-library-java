package otm.model.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("latLonPoint")
public class LatLonPointGeoReference extends GeoReference {

    @Override
    public GeoReferenceType getType() {
        return GeoReferenceType.LAT_LON_POINT_GEO_REFERENCE;
    }

    /**
     * The latitude of a point location.
     */
    private double lat;

    /**
     * The longitude of a point location.
     */
    private double lon;

    /**
     * The speed of a moving vehicle.
     */
    private UnitWithValue speed;

    /**
     * The heading of a vehicle, that is: the direction the "nose" of the vehicle is pointing to.
     */
    private UnitWithValue heading;

    /**
     * The bearing of a vehicle, that is: the angle between the vehicle and its destination.
     * Either measured relative or absolute. See <a href="https://en.wikipedia.org/wiki/Bearing_(navigation)">Wikipedia</a> for an explanation.
     */
    private UnitWithValue bearing;

    /**
     * Denotes how the bearing is measured. See <a href="https://en.wikipedia.org/wiki/Bearing_(navigation)">Wikipedia</a> for an explanation.
     */
    private BearingType bearingType;

    // Getters and setters

    /**
     * Gets the latitude of the point location.
     *
     * @return The latitude.
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the latitude of the point location.
     *
     * @param lat The latitude to set.
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Gets the longitude of the point location.
     *
     * @return The longitude.
     */
    public double getLon() {
        return lon;
    }

    /**
     * Sets the longitude of the point location.
     *
     * @param lon The longitude to set.
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * Gets the speed of the moving vehicle.
     *
     * @return The speed.
     */
    public UnitWithValue getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the moving vehicle.
     *
     * @param speed The speed to set.
     */
    public void setSpeed(UnitWithValue speed) {
        this.speed = speed;
    }

    /**
     * Gets the heading of the vehicle.
     *
     * @return The heading.
     */
    public UnitWithValue getHeading() {
        return heading;
    }

    /**
     * Sets the heading of the vehicle.
     *
     * @param heading The heading to set.
     */
    public void setHeading(UnitWithValue heading) {
        this.heading = heading;
    }

    /**
     * Gets the bearing of the vehicle.
     *
     * @return The bearing.
     */
    public UnitWithValue getBearing() {
        return bearing;
    }

    /**
     * Sets the bearing of the vehicle.
     *
     * @param bearing The bearing to set.
     */
    public void setBearing(UnitWithValue bearing) {
        this.bearing = bearing;
    }

    /**
     * Gets the bearing type.
     *
     * @return The bearing type.
     */
    public BearingType getBearingType() {
        return bearingType;
    }

    /**
     * Sets the bearing type.
     *
     * @param bearingType The bearing type to set.
     */
    public void setBearingType(BearingType bearingType) {
        this.bearingType = bearingType;
    }
}