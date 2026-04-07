package greenRobot;

import org.greenrobot.eventbus.EventBus;

public class SurveillanceCamera {
    private final EventBus eventBus;
    private final String neighborhood;
    private String person;
    private final CameraType cameraType;

    public SurveillanceCamera(EventBus eventBus,String neighborhood, String person,
                              CameraType cameraType){
        this.eventBus=eventBus;
        this.neighborhood=neighborhood;
        this.person=person;
        this.cameraType=cameraType;
    }

    public void setPerson(String person){
        this.person=person;

        GarbageThrownEvent event =
                new GarbageThrownEvent(neighborhood,person,cameraType);

        eventBus.post(event);
    }
}
