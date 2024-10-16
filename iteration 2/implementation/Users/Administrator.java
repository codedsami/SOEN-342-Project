package Users;
import Lesson.Offering;
import Lesson.OfferingCatalogue;
import Lesson.Schedule;
import Lesson.Location;

public class Administrator {
    private String name;

    public Administrator(String name){
        this.name = name;
    }

    public void viewOfferings(OfferingCatalogue catalogue){
        catalogue.displayAllOfferings();
    }

    public void createOfferings(OfferingCatalogue catalogue, String lessonType, Location location, Schedule schedule) {
        catalogue.addOffering(lessonType, location, schedule);
        System.out.println("Offering created for: " + lessonType + " and added to the catalogue.");
    }

    public void updateOfferings(OfferingCatalogue catalogue, int offeringId, String newLessonType, Location newLocation, Schedule newSchedule) {
        Offering offeringToUpdate = catalogue.getOfferingById(offeringId);
        if (offeringToUpdate != null) {
            offeringToUpdate.setLessonType(newLessonType);
            offeringToUpdate.setLocation(newLocation);
            offeringToUpdate.setSchedule(newSchedule);
            System.out.println("Offering with ID " + offeringId + " has been updated.");
        } else {
            System.out.println("Offering with ID " + offeringId + " not found.");
        }
    }

    public void deleteOfferings(OfferingCatalogue catalogue, int offeringId) {
        boolean isDeleted = catalogue.removeOffering(offeringId);
        if (isDeleted) {
            System.out.println("Offering with ID " + offeringId + " has been deleted.");
        } else {
            System.out.println("Offering with ID " + offeringId + " not found.");
        }
    }

}
