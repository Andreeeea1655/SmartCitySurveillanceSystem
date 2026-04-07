package greenRobot;

public class IssuedSpeedingFineEvent {
    private final CameraType cameraType;
    private final String licencePlate;
    private final String neighborhood;

    public IssuedSpeedingFineEvent(CameraType cameraType, String licencePlate, String neighborhood){
        this.cameraType=cameraType;
        this.licencePlate=licencePlate;
        this.neighborhood=neighborhood;
    }
    public CameraType getCameraType(){ return cameraType; }
    public String getLicencePlate() { return licencePlate; }
    public String getNeighborhood(){ return neighborhood; }
}
