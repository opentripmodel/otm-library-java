package otm.model.entities;

public class LocationUpdateEvent extends UpdateEvent {

    @Override
    public EventType getEventType() {
        return EventType.LOCATION_UPDATE_EVENT;
    }

    private InlineAssociationType<Vehicle> vehicle;

    private LatLonPointGeoReference geoReference;

    // Getters and setters

    public InlineAssociationType<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(InlineAssociationType<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public LatLonPointGeoReference getGeoReference() {
        return geoReference;
    }

    public void setGeoReference(LatLonPointGeoReference geoReference) {
        this.geoReference = geoReference;
    }
}