package Users;

import Lesson.OfferingCatalogue;

public class Public {

    public Public() {}

    public void displayAvailableOfferings(OfferingCatalogue catalogue) {
        System.out.println("Offerings visible to the public:");
        catalogue.displayAvailableOfferings();
    }

}
