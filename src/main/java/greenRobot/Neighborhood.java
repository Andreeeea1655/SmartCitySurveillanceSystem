package greenRobot;

public class Neighborhood {
    public String name;
    public int speedingTickets=0;
    public int garbageTickets=0;
    public Neighborhood(String name){
        this.name=name;
    }
    public int getTotal(){
        return speedingTickets + garbageTickets;
    }
}