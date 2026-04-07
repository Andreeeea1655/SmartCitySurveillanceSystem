package greenRobot;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Set;
import java.util.Random;

public class LocalPolice {
    private final String cameraName;
    private final Set<CameraType> cameraTypes;
    private final EventBus eventBus;
    private final Random random=new Random();

    public LocalPolice(String cameraName, Set<CameraType> cameraTypes, EventBus eventBus){
        this.cameraName=cameraName;
        this.cameraTypes=cameraTypes;
        this.eventBus=eventBus;
    }

    public void giveFine(CameraType cameraTypes,String person,String neighborhood){
        IssuedBadBehaviourFineEvent event = new IssuedBadBehaviourFineEvent(cameraTypes,person,neighborhood);
        eventBus.post(event);
    }

    @Subscribe
    public void onGarbageThrownEvent(GarbageThrownEvent event){
        boolean receiveFine =random.nextBoolean();
        if(!cameraTypes.contains(event.getCameraType())){
            return ;
        }
        System.out.println(cameraName + " received information: detected bad behaviour for "
                + event.getPerson()
                + " at " + event.getNeighborhood());
        if(receiveFine){
            giveFine(event.getCameraType(),event.getPerson(),event.getNeighborhood());}
    }
}
