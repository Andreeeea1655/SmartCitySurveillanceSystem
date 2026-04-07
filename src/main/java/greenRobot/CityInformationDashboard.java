package greenRobot;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class CityInformationDashboard {
    private final List<Neighborhood> neighborhoods= new ArrayList<>();
    public CityInformationDashboard(){
    }

    public Neighborhood AddNeighborhood(String name){
        for(Neighborhood n: neighborhoods){
            if(n.name.equals(name)){
                return n;
            }
        }
        Neighborhood newN=new Neighborhood(name);
        neighborhoods.add(newN);
        return newN;
    }

    @Subscribe
    public void onIssuedSpeedingFineEvent(IssuedSpeedingFineEvent event){
        System.out.println("Traffic police issued a fine for " + event.getLicencePlate());
        Neighborhood n=AddNeighborhood(event.getNeighborhood());
        n.speedingTickets++;
    }
    @Subscribe
    public void onIssuedBadBehaviourFineEvent(IssuedBadBehaviourFineEvent event){
        System.out.println("Local police issued a fine for " + event.getPerson());
        Neighborhood n=AddNeighborhood(event.getNeighborhood());
        n.garbageTickets++;
    }

    public void printMostDangerous() {
        Neighborhood mostDangerous = null;
        for(Neighborhood n: neighborhoods){
            if(mostDangerous==null || n.getTotal() > mostDangerous.getTotal()){
               mostDangerous=n;
            }
        }
        if(mostDangerous!= null) {
            System.out.println("Most dangerous neighborhood: " + mostDangerous.name + " with "
                    + mostDangerous.getTotal() + " fines.");
            System.out.println("Speed fines: " + mostDangerous.speedingTickets);
            System.out.println("Bad behaviour fines: " + mostDangerous.garbageTickets);
        }
    }
}
