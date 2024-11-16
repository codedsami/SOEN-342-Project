package Lesson;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OfferingCatalog {

    private static OfferingCatalog instance = new OfferingCatalog();
    private static List<Offering> offerings;
        private int lastGeneratedID;
    
    
        private OfferingCatalog() {
            offerings = new ArrayList<>();
            lastGeneratedID = 0;
        }
    
        public static OfferingCatalog getInstance(){
            return instance;
        }
    
        private int generateUniqueId() {
            return ++lastGeneratedID;
        }
    
    
        public void addOffering(String lessonType, Location location, Schedule schedule) {
            int newId = generateUniqueId(); // Generate a unique ID
            Offering newOffering = new Offering(newId, lessonType, location, schedule);
            offerings.add(newOffering);
            DBController.getInstance().insertOffering(newOffering);
        }
    
        public List<Offering> getOfferings() {
            return offerings;
        }
    
    
        public void displayAvailableOfferings() {
            for (Offering offering : offerings) {
                if (offering.getVisibility()) {
                    System.out.println(offering);
                }
            }
        }
    
    
        public static void displayAllOfferings() {
            for (Offering offering : offerings) {
            System.out.println(offering);
        }
    }

    public boolean removeOffering(int offeringId) {
        Iterator<Offering> iterator = offerings.iterator();

        while (iterator.hasNext()) {
            Offering offering = iterator.next();
            if (offering.getOfferingID() == offeringId) {
                iterator.remove();
                DBController.getInstance().deleteOffering(offeringId);
                return true;
            }
        }
        return false;
    }

    public Offering getOfferingById(int offeringId) {
        for (Offering offering : offerings) {
            if (offering.getOfferingID() == offeringId) {
                return offering;
            }
        }
        return null;
    }


    public Offering getById(int offering) {
        for (Offering o : offerings) {
            if (o.getOfferingID() == offering) {
                return o;
            }
        }
        return null;
    }

    public void populateOfferingCatalog(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String lessonType = resultSet.getString("lessonType");
                Location location = LocationCatalog.getInstance().getById(resultSet.getInt("location"));
                Schedule schedule = ScheduleCatalog.getInstance().getById(resultSet.getInt("schedule"));
                boolean isVisibleToPublic = resultSet.getBoolean("isVisibleToPublic");
                boolean isInstructorSelected = resultSet.getBoolean("isInstructorSelected");
                Offering offering = new Offering(id, lessonType, location, schedule, isVisibleToPublic, isInstructorSelected);
                offerings.add(offering);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
