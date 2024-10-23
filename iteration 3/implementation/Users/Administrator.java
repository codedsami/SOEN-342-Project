package Users;
import Lesson.Offering;
import Lesson.OfferingCatalog;
import Lesson.Schedule;
import Lesson.Location;
import Lesson.Availability;

public class Administrator {

    public Administrator(String name){
        super(name);
    }

    public void createOfferings(String lessonType, Schedule schedule, Location location) {
        OfferingCatalog Catalog = OfferingCatalog.getInstance();
        AvailabilityCatalog ac = AvailabilityCatalog.getInstance();
        Availability availability = ac.addAvailability(schedule, location);
        Catalog.addOffering(lessonType, availability);
        availability.setUsed(true);
        System.out.println("Offering created for: " + lessonType + " and added to the Catalog.");
    }

    public void updateOffering(int offeringId, String newLessonType) {
        OfferingCatalog Catalog = OfferingCatalog.getInstance();
        Offering offeringToUpdate = Catalog.getOfferingById(offeringId);
        if (offeringToUpdate != null) {
            offeringToUpdate.setLessonType(newLessonType);
            System.out.println("Offering with ID " + offeringId + " has been updated.");
        } else {
            System.out.println("Offering with ID " + offeringId + " not found.");
        }
    }

    public void updateOffering(int offeringId, Availability newAvailability) {
        OfferingCatalog Catalog = OfferingCatalog.getInstance();
        Offering offeringToUpdate = Catalog.getOfferingById(offeringId);
        if (offeringToUpdate != null) {
            offeringToUpdate.getAvailability().setUsed(false);
            offeringToUpdate.setAvailability(newAvailability);
            newAvailability.setUsed(true);
            System.out.println("Offering with ID " + offeringId + " has been updated.");
        } else {
            System.out.println("Offering with ID " + offeringId + " not found.");
        }
    }
    public void updateOffering(int offeringId, boolean newVisibility) {
        OfferingCatalog Catalog = OfferingCatalog.getInstance();
        Offering offeringToUpdate = Catalog.getOfferingById(offeringId);
        if (offeringToUpdate != null) {
            offeringToUpdate.setVisibility(newVisibility);
            System.out.println("Offering with ID " + offeringId + " has been updated.");
        } else {
            System.out.println("Offering with ID " + offeringId + " not found.");
        }
    }
    public void updateOffering(int offeringId, Instructor newInstructor) {
        OfferingCatalog Catalog = OfferingCatalog.getInstance();
        Offering offeringToUpdate = Catalog.getOfferingById(offeringId);
        if (offeringToUpdate != null) {
            offeringToUpdate.setInstructor(newInstructor);
            System.out.println("Offering with ID " + offeringId + " has been updated.");
        } else {
            System.out.println("Offering with ID " + offeringId + " not found.");
        }
    }

    public void deleteOfferings(int offeringId) {
        OfferingCatalog Catalog = OfferingCatalog.getInstance();
        boolean isDeleted = Catalog.removeOffering(offeringId);
        if (isDeleted) {
            System.out.println("Offering with ID " + offeringId + " has been deleted.");
        } else {
            System.out.println("Offering with ID " + offeringId + " not found.");
        }
    }

}
