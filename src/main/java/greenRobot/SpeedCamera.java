package greenRobot;

import org.greenrobot.eventbus.EventBus;


public class SpeedCamera {
    private final EventBus eventBus;
    private final int speedingLimit;
    private int vehicleSpeed;
    private final String licensePlate;
    private final String neighborhood;
    private final CameraType cameraType;

    public SpeedCamera(EventBus eventBus,int speedingLimit, int vehicleSpeed,
                       String licensePlate, String neighborhood, CameraType cameraType){
        this.eventBus=eventBus;
        this.speedingLimit=speedingLimit;
        this.vehicleSpeed=vehicleSpeed;
        this.licensePlate=licensePlate;
        this.neighborhood=neighborhood;
        this.cameraType=cameraType;
    }

    public void setVehicleSpeed(int vehicleSpeed){
        this.vehicleSpeed=vehicleSpeed;

        if (this.vehicleSpeed > this.speedingLimit+10) {
            DetectedSpeedingVehicleEvent event =
                    new DetectedSpeedingVehicleEvent(speedingLimit, vehicleSpeed,
                            licensePlate, neighborhood, cameraType);
            eventBus.post(event);
        }
    }
}
