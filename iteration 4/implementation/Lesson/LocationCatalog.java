package Lesson;
import java.sql.ResultSet;
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
        DBController.getInstance().insertLocation(location);
        return location;
    }

    public void populateLocationCatalog(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                Location location = new Location(name, address, city);
                locationList.add(location);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Location getById(int location) {
        for (Location l : locationList) {
            if (l.getId() == location) {
                return l;
            }
        }
        return null;
    }
}