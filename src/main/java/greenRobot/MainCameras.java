package greenRobot;

import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class MainCameras {
    public static void main(String[] args) {
        EventBus eventBus = EventBus.getDefault();
        //subscribers
        TrafficPolice tp = new TrafficPolice("cam1", Set.of(CameraType.SPEED),eventBus);
        LocalPolice lp = new LocalPolice("cam2", Set.of(CameraType.SURVEILLANCE),eventBus);
        NavigationApps na = new NavigationApps("cam3", Set.of(CameraType.TRAFFIC));
        CityInformationDashboard cd=new CityInformationDashboard();
        eventBus.register(tp);
        eventBus.register(lp);
        eventBus.register(na);
        eventBus.register(cd);
        //publishers
        //camere
        SpeedCamera spc1 = new SpeedCamera(eventBus, 50, 0,
                "TM12ABC", "Aradului", CameraType.SPEED);
        SpeedCamera spc2 = new SpeedCamera(eventBus, 50, 0,
                "TM89XYZ", "Soarelui", CameraType.SPEED);
        SpeedCamera spc3 = new SpeedCamera(eventBus, 80, 0,
                "TM03NCH", "Torontalului", CameraType.SPEED);
        SpeedCamera spc4 = new SpeedCamera(eventBus, 50, 0,
                "TM27AHD", "Soarelui", CameraType.SPEED);
        TrafficCamera tc1 = new TrafficCamera(eventBus, "Felix",
                0, CameraType.TRAFFIC);
        TrafficCamera tc2 = new TrafficCamera(eventBus, "Belgia",
                0, CameraType.TRAFFIC);
        SurveillanceCamera sc1 = new SurveillanceCamera(eventBus, "Soarelui",
                "", CameraType.SURVEILLANCE);
        SurveillanceCamera sc2 = new SurveillanceCamera(eventBus, "Torontalului",
                "", CameraType.SURVEILLANCE);
        spc1.setVehicleSpeed(70);
        spc2.setVehicleSpeed(55);
        spc3.setVehicleSpeed(102);
        spc4.setVehicleSpeed(75);
        tc1.setTrafficLevel(8);
        tc2.setTrafficLevel(7);
        sc1.setPerson("Andrei");
        sc2.setPerson("Bogdan");
        cd.printMostDangerous();
    }
}
