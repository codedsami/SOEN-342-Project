package Lesson;
import java.util.ArrayList;
import java.util.Iterator;

import Users.Client;

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
        bookingList.add(booking);
        return booking;
    }

    public boolean removeBooking(int bookingID){
        Iterator<Booking> iterator = bookingList.iterator();
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