package singletonPattern;

import java.util.Random;

public class HelpDeskStation {
    private String name;
    private Random random = new Random();

    public HelpDeskStation(String name) {
        this.name = name;
    }

    public void serveNextCustomer() {
        CentralizedQueuingSystem queuingSystem = CentralizedQueuingSystem.getInstance();
        int currentQueueNumber = queuingSystem.getCurrentQueueNumber();
        System.out.println(name + " serving customer with queue number: " + currentQueueNumber);

        queuingSystem.incrementQueueNumber();
    }

    public void resetQueueNumber(int newQueueNumber) {
        CentralizedQueuingSystem queuingSystem = CentralizedQueuingSystem.getInstance();
        queuingSystem.resetQueueNumber(newQueueNumber);

        // Randomly select an issue when resetting the queue numbers
        int randomIssue = random.nextInt(3);
        switch (randomIssue) {
            case 0:
                System.out.println("Queue number reset to: " + newQueueNumber + " for " + name + " due to Technical Issues.");
                break;
            case 1:
                System.out.println("Queue number reset to: " + newQueueNumber + " for " + name + " due to Reorganization of Queue number.");
                break;
            case 2:
                System.out.println("Queue number reset to: " + newQueueNumber + " for " + name + " due to Internet Lost Problem.");
                break;
        }
    }
}
