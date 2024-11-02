package Lesson;
import java.util.ArrayList;

public class AvailabilityCatalog {
    private static AvailabilityCatalog instance = new AvailabilityCatalog();
    private ArrayList<Availability> availabilityList;
    private int lastGeneratedID;

    private AvailabilityCatalog() {
        availabilityList = new ArrayList<Availability>();
        lastGeneratedID = 0;
    }

    public static AvailabilityCatalog getInstance(){
        return instance;
    }

    private int generateUniqueId() {
        return ++lastGeneratedID;
    }

    public Availability addAvailability(Schedule schedule, Location location){
        Availability availability = new Availability(generateUniqueId(), false, location, schedule);
        availabilityList.add(availability);
        return availability;
    }

}