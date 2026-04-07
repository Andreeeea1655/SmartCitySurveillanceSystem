package greenRobot;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Set;

public class TrafficPolice {
    private final String cameraName;
    private final Set<CameraType> cameraTypes;
    private final EventBus eventBus;

    public TrafficPolice(String cameraName, Set<CameraType> cameraTypes, EventBus eventBus){
        this.cameraName=cameraName;
        this.cameraTypes=cameraTypes;
        this.eventBus=eventBus;
    }

    public void giveFine(CameraType cameraTypes,String licencePlate, String neighborhood){
        IssuedSpeedingFineEvent event = new IssuedSpeedingFineEvent(cameraTypes,licencePlate,neighborhood);
        eventBus.post(event);
    }

    @Subscribe
    public void onDetectedSpeedingVehicleEvent(DetectedSpeedingVehicleEvent event){
        if(!cameraTypes.contains(event.getCameraType())){
            return;
        }
        System.out.println(cameraName + " received information: Car "
                + event.getLicensePlate()
                + " was going " + event.getSpeeding()
                + " in an area of " + event.getSpeedingLimit()
                + " at " + event.getNeighborhood());
        giveFine(event.getCameraType(),event.getLicensePlate(), event.getNeighborhood());
    }
}
