public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);               // Add visitor to queue
    void removeVisitorFromQueue();                         // Remove visitor from queue
    void printQueue();                                     // Print the list of waiting visitors
    void runOneCycle();                                    // Run one ride cycle
    void addVisitorToHistory(Visitor visitor);             // Add visitor to ride history
    boolean checkVisitorFromHistory(Visitor visitor);      // Check if visitor is in ride history
    int numberOfVisitors();                                // Get the number of visitors in ride history
    void printRideHistory();                               // Print all visitors in ride history
}  

