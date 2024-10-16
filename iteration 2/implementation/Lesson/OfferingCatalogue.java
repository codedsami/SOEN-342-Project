package Lesson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OfferingCatalogue {

    private List<Offering> offerings;
    private int lastGeneratedID;


    public OfferingCatalogue() {
        offerings = new ArrayList<>();
        lastGeneratedID = 0;
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
                System.out.println(offering);
            }
        }
    }


    public void displayAllOfferings() {
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
