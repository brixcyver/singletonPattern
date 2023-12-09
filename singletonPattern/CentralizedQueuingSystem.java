package singletonPattern;

public class CentralizedQueuingSystem {
    private static CentralizedQueuingSystem instance;
    private int currentQueueNumber;

    private CentralizedQueuingSystem() {
        currentQueueNumber = 1;
    }

    public static CentralizedQueuingSystem getInstance() {
        if (instance == null) {
            instance = new CentralizedQueuingSystem();
        }
        return instance;
    }

    public int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    public void incrementQueueNumber() {
        currentQueueNumber++;
    }

    public void resetQueueNumber(int newQueueNumber) {
        currentQueueNumber = newQueueNumber;
    }
}

