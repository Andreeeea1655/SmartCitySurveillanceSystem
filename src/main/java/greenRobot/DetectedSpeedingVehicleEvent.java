package greenRobot;

public class DetectedSpeedingVehicleEvent {
    private final int speedingLimit;
    private final int speed;
    private final String licensePlate;
    private final String neighborhood;
    private final CameraType cameraType;

    public DetectedSpeedingVehicleEvent(int speedingLimit,
                                        int speed, String licensePlate,
                                        String neighborhood, CameraType cameraType){
        this.speedingLimit=speedingLimit;
        this.speed=speed;
        this.licensePlate=licensePlate;
        this.neighborhood=neighborhood;
        this.cameraType=cameraType;
    }

    public int getSpeedingLimit() { return speedingLimit; }
    public int getSpeeding() { return speed; }
    public String getLicensePlate() { return licensePlate; }
    public String getNeighborhood() { return neighborhood; }
    public CameraType getCameraType() { return cameraType; }
}
