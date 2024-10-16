package Users;

import Lesson.Offering;
import Lesson.OfferingCatalogue;

public class Instructor {

    private String name;
    private int phoneNumber;
    private String specialization;

    public Instructor(String name, int pn, String specialization){
        this.name = name;
        this.phoneNumber = pn;
        this.specialization = specialization;
    }

    public void selectOfferings(Offering offering){
        if (!(offering.isInstructorSelected())){
            offering.setInstructor(this);
            offering.setVisibility(true);
        }
    }

    public void viewOfferings(OfferingCatalogue catalogue){
        catalogue.displayAllOfferings();
    }




}
