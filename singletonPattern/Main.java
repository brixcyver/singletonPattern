package singletonPattern;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            displayWelcomeMessage();

            // Get the number of customers
            int numberOfCustomers = getNumberOfCustomers(scanner);

            if (numberOfCustomers == 0) {
                System.out.println();
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // Create instances of HelpDeskStation with names
            HelpDeskStation helpDeskStation1 = new HelpDeskStation("Help Desk 1");
            HelpDeskStation helpDeskStation2 = new HelpDeskStation("Help Desk 2");
            HelpDeskStation helpDeskStation3 = new HelpDeskStation("Help Desk 3");

            // Distribute customers randomly among the help desk stations
            serveCustomers(random, numberOfCustomers, helpDeskStation1, helpDeskStation2, helpDeskStation3);

            // Add some spacing
            System.out.println();

            // Reset queue numbers for each help desk station with a random issue
            resetQueueNumbers(helpDeskStation1, helpDeskStation2, helpDeskStation3);

            // Notify that the issues are fixed
            displayFixedIssuesMessage();

            // Add more spacing
            System.out.println();
        }

        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println();
        System.out.println("=== Welcome to Pag-Ibig Centralized Queuing System! ===");
    }

    private static int getNumberOfCustomers(Scanner scanner) {
        System.out.print("Enter the number of customers (or enter 0 to exit): ");
        return scanner.nextInt();

    }

    private static void serveCustomers(Random random, int numberOfCustomers, HelpDeskStation... helpDesks) {
        System.out.println();
        System.out.println("All Help Desk will now start serving.");
        for (int i = 0; i < numberOfCustomers; i++) {
            int randomHelpDesk = random.nextInt(helpDesks.length) + 1; // Generate a random number between 1 and the number of help desks

            // Serve the customer at the randomly selected help desk
            helpDesks[randomHelpDesk - 1].serveNextCustomer();
        }
    }

    private static void resetQueueNumbers(HelpDeskStation... helpDesks) {
        for (HelpDeskStation helpDesk : helpDesks) {
            helpDesk.resetQueueNumber(1);
        }
    }

    private static void displayFixedIssuesMessage() {
        System.out.println();
        System.out.println("The issues are all fixed, all Help Desk will now continue serving!");
    }
}
