package Lesson;

public class Availability{
    private int id;
    private boolean used;
    private Location location;
    private Schedule schedule;

    public Availability(int id, boolean used, Location location, Schedule schedule){
        this.id = id;
        this.used = used;
        this.location = location;
        this.schedule = schedule;
    }
    public boolean isUsed(){
        return used;
    }

    public void setUsed(boolean used){
        this.used = used;
    }

    @Override
    public String toString(){
        return "Availability{" +
                ", location=" + location +
                ", schedule=" + schedule +
                '}';
                }
}