package Users;

import Lesson.OfferingCatalog;

public class Public extends User {

    public Public(String string) {super("Pblic");}

    public void viewAvailableOfferings(OfferingCatalog catalogue) {
        System.out.println("Offerings visible to the public:");
        catalogue.displayAvailableOfferings();
    }

}
