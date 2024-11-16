import Lesson.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBController {
    private static final DBController instance = new DBController();
    private Connection connection;

    private DBController() {
        connect();
    }

    public static DBController getInstance() {
        return instance;
    }

    private void connect() {
        try {
            String url = "jdbc:sqlite:db_name.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAvailability(Availability availability) {
        String sql = "INSERT INTO Availability(AvailabilityId, isUsed, location, schedule) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, availability.getId());
            pstmt.setBoolean(2, availability.isUsed());
            pstmt.setInt(3, availability.getLocation().getId());
            pstmt.setInt(4, availability.getSchedule().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertBooking(Booking booking) {
        String sql = "INSERT INTO Booking(id, client, offering) VALUES(?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, booking.getID());
            pstmt.setInt(2, booking.getClient().getId());
            pstmt.setInt(3, booking.getOffering().getOfferingID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBooking(int bookingID) {
        String sql = "DELETE FROM Booking WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, bookingID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertLocation(Location location) {
        String sql = "INSERT INTO Location(id, name, address, city) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, location.getId());
            pstmt.setString(2, location.getName());
            pstmt.setString(3, location.getAddress());
            pstmt.setString(4, location.getCity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSchedule(Schedule schedule) {
        String sql = "INSERT INTO Schedule(id, day, time) VALUES(?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, schedule.getId());
            pstmt.setString(2, schedule.getDay());
            pstmt.setString(3, schedule.getTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertOffering(Offering newOffering) {
        String sql = "INSERT INTO Offering(id, lessonType, availability, isVisibleToPublic, isInstructorSelected) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, newOffering.getOfferingID());
            pstmt.setString(2, newOffering.getLessonType());
            pstmt.setInt(3, newOffering.getAvailability().getId());
            pstmt.setBoolean(4, newOffering.getVisibility());
            pstmt.setBoolean(5, newOffering.isInstructorSelected());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteOffering(int offeringId) {
        String sql = "DELETE FROM Offering WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, offeringId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateLocationCatalog() {
        String sql = "SELECT * FROM Location";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeQuery();
            // Populate LocationCatalog
            LocationCatalog.getInstance().populateLocationCatalog(pstmt.getResultSet());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void populateScheduleCatalog() {
        String sql = "SELECT * FROM Schedule";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeQuery();
            // Populate ScheduleCatalog
            ScheduleCatalog.getInstance().populateScheduleCatalog(pstmt.getResultSet());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateAvailabilityCatalog() {
        String sql = "SELECT * FROM Availability";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeQuery();
            // Populate AvailabilityCatalog
            AvailabilityCatalog.getInstance().populateAvailabilityCatalog(pstmt.getResultSet());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateOfferingCatalog() {
        String sql = "SELECT * FROM Offering";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeQuery();
            // Populate OfferingCatalog
            OfferingCatalog.getInstance().populateOfferingCatalog(pstmt.getResultSet());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}