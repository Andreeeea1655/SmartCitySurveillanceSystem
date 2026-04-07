package greenRobot;

public class DetectedCongestionOnRoadsEvent {
    private final String streetName;
    private final int trafficLevel;
    private final CameraType cameraType;

    public DetectedCongestionOnRoadsEvent(String streetName, int trafficLevel,
                                          CameraType cameraType){
        this.streetName=streetName;
        this.trafficLevel=trafficLevel;
        this.cameraType=cameraType;
    }

    public String getStreetName() { return streetName; }
    public int getTrafficLevel() {return trafficLevel; }
    public CameraType getCameraType() { return cameraType;}
}
