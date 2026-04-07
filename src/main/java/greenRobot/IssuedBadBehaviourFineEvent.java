package greenRobot;

public class IssuedBadBehaviourFineEvent {
    private final CameraType cameraType;
    private final String person;
    private final String neighborhood;

    public IssuedBadBehaviourFineEvent(CameraType cameraType, String person, String neighborhood){
        this.cameraType=cameraType;
        this.person=person;
        this.neighborhood=neighborhood;
    }
    public CameraType getCameraType(){ return cameraType; }
    public String getPerson() { return person; }
    public String getNeighborhood(){ return neighborhood; }
}