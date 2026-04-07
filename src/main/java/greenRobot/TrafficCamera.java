package greenRobot;

import org.greenrobot.eventbus.EventBus;

public class TrafficCamera {
    private final EventBus eventBus;
    private final String streetName;
    private int trafficLevel;
    private final CameraType cameraType;

    public TrafficCamera(EventBus eventBus, String streetName, int trafficLevel,
                         CameraType cameraType){
        this.eventBus=eventBus;
        this.streetName=streetName;
        this.trafficLevel=trafficLevel;
        this.cameraType=cameraType;
    }

    public void setTrafficLevel(int trafficLevel){
        this.trafficLevel=trafficLevel;

        DetectedCongestionOnRoadsEvent event =
                new DetectedCongestionOnRoadsEvent(streetName,trafficLevel,cameraType);

        eventBus.post(event);
    }
}

