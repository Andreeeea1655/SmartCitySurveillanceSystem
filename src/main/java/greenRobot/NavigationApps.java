package greenRobot;

import org.greenrobot.eventbus.Subscribe;

import java.util.Set;

public class NavigationApps {
    private final String cameraName;
    private final Set<CameraType> cameraTypes;

    public NavigationApps(String cameraName, Set<CameraType> cameraTypes){
        this.cameraName=cameraName;
        this.cameraTypes=cameraTypes;
    }

    @Subscribe
    public void onDetectedCongestionOnRoadsEvent(DetectedCongestionOnRoadsEvent event){
        if(!cameraTypes.contains(event.getCameraType())){
            return;
        }
        System.out.println(cameraName + " received information: "
                + "congestion on road: " + event.getStreetName()
                + ". The traffic level is:  " + event.getTrafficLevel());
    }
}
