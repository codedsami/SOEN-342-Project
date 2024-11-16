package Lesson;
import java.sql.ResultSet;
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
        DBController.getInstance().insertAvailability(availability);
        return availability;
    }

    public void populateAvailabilityCatalog(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                boolean isUsed = resultSet.getBoolean("isUsed");
                Location location = LocationCatalog.getInstance().getById(resultSet.getInt("location"));
                Schedule schedule = ScheduleCatalog.getInstance().getById(resultSet.getInt("schedule"));
                Availability availability = new Availability(id, isUsed, location, schedule);
                availabilityList.add(availability);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}