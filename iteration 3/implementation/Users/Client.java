package Users;
import Lesson.OfferingCatalog;
import Lesson.Offering;
import Lesson.BookingCatalog;
import Lesson.Booking;

public class Client extends User{

    private int age;

    public Client(String name, int pn, int age){
        super(name,pn);
        this.age = age;
    }

    public void bookOffering(int offeringId){
        if(age<18){
            System.out.println("Can't book offering. You need a legal guardian.");
        }else{
            OfferingCatalog Catalog = OfferingCatalog.getInstance();
            Offering offering = Catalog.getOfferingById(offeringId);
            if (offering != null) {
                BookingCatalog bc = BookingCatalog.getInstance();
                Booking b = bc.addBooking(this,offering);
                System.out.println("Booking with ID " + b.getID() + " created.");
            } else {
                System.out.println("Offering with ID " + offeringId + " not found.");
            }
        }
    }

    public void bookOffering(int offeringId, Client minor){
        if(age<18){
            System.out.println("Can't book offering. You need a legal guardian.");
        }else{
            OfferingCatalog Catalog = OfferingCatalog.getInstance();
            Offering offering = Catalog.getOfferingById(offeringId);
            if (offering != null) {
                BookingCatalog bc = BookingCatalog.getInstance();
                Booking booking = bc.addBooking(minor,offering);
                booking.addLegalGuardian(this);
                System.out.println("Booking with ID " + b.getID() + " created for " + minor.getName()+".");
            } else {
                System.out.println("Offering with ID " + offeringId + " not found.");
            }
        }
    }

    public void cancelBooking(int bookingID){
        BookingCatalog bc = BookingCatalog.getInstance();
        if(bc.removeBooking(bookingID)){
            System.out.println("Booking with ID " + bookingID + "canceled successfully.");
        }else{
            System.out.println("Unable to cancel booking with ID " + bookingID + ".");
        }
    }
}
