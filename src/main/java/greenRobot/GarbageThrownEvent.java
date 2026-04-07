package greenRobot;

public class GarbageThrownEvent {
    private final String neighborhood;
    private final String person;
    private final CameraType cameraType;

    public GarbageThrownEvent(String neighborhood, String person, CameraType cameraType){
        this.neighborhood=neighborhood;
        this.person=person;
        this.cameraType=cameraType;
    }

    public String getNeighborhood() { return neighborhood; }
    public String getPerson() { return person; }
    public CameraType getCameraType() { return cameraType; }
}
