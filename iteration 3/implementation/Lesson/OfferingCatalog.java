package Lesson;
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
        }
    
        public List<Offering> getOfferings() {
            return offerings;
        }
    
    
        public void displayAvailableOfferings() {
            for (Offering offering : offerings) {
                if (offering.getVisibility()) {
                    System.out.println(offering.getLessonType());
                    System.out.println(offering.getAvailability());
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



    

}
