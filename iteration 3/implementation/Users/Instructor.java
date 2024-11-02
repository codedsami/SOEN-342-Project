package Users;
import Lesson.OfferingCatalog;
import Lesson.Offering;

public class Instructor extends User{

    private String specialization;

    public Instructor(String name, int pn, String specialization){
        super(name,pn);
        this.specialization = specialization;
    }

    public void selectOfferings(int offeringId){
        OfferingCatalog oc = OfferingCatalog.getInstance();
        Offering o = oc.getOfferingById(offeringId);
        if(o == null){
            System.out.println("Offering with ID " + o + " not found.");
        }else{
            if (!(o.isInstructorSelected())){
                o.setInstructor(this);
                o.setVisibility(true);
            }
        }
    }
}
