
import Users.Administrator;
import Users.Client;
import Users.Instructor;
import Users.Public;
import java.util.Scanner;

import Lesson.Availability;
import Lesson.Location;
import Lesson.LocationCatalog;
import Lesson.OfferingCatalog;
import Lesson.Schedule;
import Lesson.ScheduleCatalog;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Initialize catalogs and add sample data
        LocationCatalog locationCatalog = LocationCatalog.getInstance();
        ScheduleCatalog scheduleCatalog = ScheduleCatalog.getInstance();
        OfferingCatalog offeringCatalog = OfferingCatalog.getInstance();

        // Sample data for locations, schedules, and offerings
        Location location = locationCatalog.addLocation("City Gym", "123 Fitness St.", "Metro City");
        Schedule schedule = scheduleCatalog.addSchedule("Monday", "9:00 AM - 11:00 AM");
        offeringCatalog.addOffering("Yoga", location, schedule);

        while (!exit) {
            System.out.println("Welcome! Please log in as one of the following user types:");
            System.out.println("1. Administrator");
            System.out.println("2. Instructor");
            System.out.println("3. Client");
            System.out.println("4. Public");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Administrator
                    Administrator adminUser = new Administrator("Admin User");
                    boolean adminExit = false;
                    while (!adminExit) {
                        System.out.println("\nAdministrator Options:");
                        System.out.println("1. Create Offering");
                        System.out.println("2. Update Offering");
                        System.out.println("3. Delete Offering");
                        System.out.println("4. Logout");
                        System.out.print("Choose an option (1-4): ");
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (adminChoice) {
                            case 1:
                                System.out.print("Enter offering type: ");
                                String type = scanner.nextLine();
                                adminUser.createOfferings(type, schedule, location);
                                break;
                            case 2:
                                    System.out.print("Enter offering ID to update: ");
                                    int updateId = scanner.nextInt();
                                    scanner.nextLine();  // Consume newline

                                    System.out.println("Select the type of update:");
                                    System.out.println("1. Update Lesson Type");
                                    System.out.println("2. Update Availability");
                                    System.out.println("3. Update Visibility");
                                    System.out.println("4. Update Instructor");
                                    System.out.print("Choose an option (1-4): ");
                                    int updateChoice = scanner.nextInt();
                                    scanner.nextLine();  // Consume newline

                                    switch (updateChoice) {
                                        case 1:
                                            // Update lesson type
                                            System.out.print("Enter new lesson type: ");
                                            String newLessonType = scanner.nextLine();
                                            adminUser.updateOffering(updateId, newLessonType);
                                            break;

                                        case 2:
                                            // Update availability
                                            System.out.println("Setting new availability:");
                                            Availability newAvailability = new Availability(updateId, adminExit, location, schedule); 
                                            adminUser.updateOffering(updateId, newAvailability);
                                            break;

                                        case 3:
                                            // Update visibility
                                            System.out.print("Set visibility (true for visible, false for hidden): ");
                                            boolean newVisibility = scanner.nextBoolean();
                                            adminUser.updateOffering(updateId, newVisibility);
                                            break;

                                        case 4:
                                            // Update instructor
                                            System.out.print("Enter new instructor name: ");
                                            String instructorName = scanner.nextLine();
                                            System.out.print("Enter new instructor specialization: ");
                                            String instructorSpecialization = scanner.nextLine();
                                            Instructor newInstructor = new Instructor(instructorName, updateId, instructorSpecialization); 
                                            adminUser.updateOffering(updateId, newInstructor);
                                            break;

                                        default:
                                            System.out.println("Invalid update option. Please try again.");
                                    }
                                    break;

                            case 3:
                                System.out.print("Enter offering ID to delete: ");
                                int deleteId = scanner.nextInt();
                                scanner.nextLine();
                                adminUser.deleteOfferings(deleteId);
                                break;
                            case 4:
                                adminExit = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 2:
                    // Instructor
                    Instructor instructorUser = new Instructor("Instructor User", choice, null);
                    boolean instructorExit = false;
                    while (!instructorExit) {
                        System.out.println("\nInstructor Options:");
                        System.out.println("1. Select Offering to Teach");
                        System.out.println("2. Logout");
                        System.out.print("Choose an option (1-2): ");
                        int instructorChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (instructorChoice) {
                            case 1:
                                System.out.print("Enter offering ID to select: ");
                                int offeringId = scanner.nextInt();
                                scanner.nextLine();
                                instructorUser.selectOfferings(offeringCatalog.getOfferingById(offeringId).getOfferingID());
                                System.out.println("Instructor added to offering.");
                                break;
                            case 2:
                                instructorExit = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 3:
                    // Client
                    Client clientUser = new Client("Client User", choice, 20); // for testing purpose 20 is used
                    boolean clientExit = false;
                    while (!clientExit) {
                        System.out.println("\nClient Options:");
                        System.out.println("1. Book Offering");
                        System.out.println("2. Cancel Booking");
                        System.out.println("3. Logout");
                        System.out.print("Choose an option (1-3): ");
                        int clientChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (clientChoice) {
                            case 1:
                                System.out.print("Enter offering ID to book: ");
                                int bookId = scanner.nextInt();
                                scanner.nextLine();
                                clientUser.bookOffering(offeringCatalog.getOfferingById(bookId).getOfferingID());
                                System.out.println("Client booked offering.");
                                break;
                            case 2:
                                System.out.print("Enter booking ID to cancel: ");
                                int cancelId = scanner.nextInt();
                                scanner.nextLine();
                                clientUser.cancelBooking(cancelId);
                                System.out.println("Client cancelled booking.");
                                break;
                            case 3:
                                clientExit = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 4:
                    // Public
                    Public publicUser = new Public("Guest User");
                    System.out.println("\nPublic Options:");
                    System.out.println("Viewing available offerings:");
                    publicUser.viewAvailableOfferings(offeringCatalog);
                    System.out.println("Returning to main menu.\n");
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close();
    }
}
