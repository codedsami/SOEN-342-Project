package Lesson;
import java.util.ArrayList;

public class LocationCatalog {
    private static LocationCatalog instance = new LocationCatalog();
    private ArrayList<Location> locationList;

    private LocationCatalog() {
        locationList = new ArrayList<Location>();
    }

    public static LocationCatalog getInstance(){
        return instance;
    }

    public Location addLocation(String name, String address, String city){
        Location location = new Location(name, address, city);
        locationList.add(location);
        return location;
    }

}