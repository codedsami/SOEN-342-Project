package Lesson;
import java.util.ArrayList;
import java.util.Iterator;

public class BookingCatalog {
    private static BookingCatalog instance = new BookingCatalog();
    private ArrayList<Booking> bookingList;
    private int lastGeneratedID;

    private BookingCatalog() {
        bookingList = new ArrayList<Booking>();
        lastGeneratedID = 0;
    }

    public static BookingCatalog getInstance(){
        return instance;
    }

    private int generateUniqueId() {
        return ++lastGeneratedID;
    }

    public Booking addBooking(Client client, Offering offering){
        Booking booking = new Booking(generateUniqueId(), client, offering);
        BookingList.add(booking);
        return Booking;
    }

    public boolean removeBooking(int bookingID){
        Iterator<Offering> iterator = bookingList.iterator();
        while (iterator.hasNext()) {
            Booking b = iterator.next();
            if (b.getID() == bookingID) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}