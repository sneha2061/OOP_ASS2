import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator; // Employee assigned to this ride
 private Queue<Visitor> visitorQueue;                   // Queue for waiting visitors
    private List<Visitor> rideHistory;                     // List to store ride history

    // Default constructor
    public Ride() {
     this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();   
    }

    // Parameterized constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    // Implementing RideInterface methods

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println(visitor.getName() + " has been added to the queue for " + rideName);
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!visitorQueue.isEmpty()) {
            Visitor visitor = visitorQueue.poll();
            System.out.println(visitor.getName() + " has been removed from the queue for " + rideName);
        } else {
            System.out.println("The queue is empty!");
        }
    }

    @Override
    public void printQueue() {
        if (!visitorQueue.isEmpty()) {
            System.out.println("Visitors in the queue for " + rideName + ":");
            for (Visitor visitor : visitorQueue) {
                System.out.println(visitor.getName());
            }
        } else {
            System.out.println("No visitors in the queue for " + rideName);
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println("Running one cycle of " + rideName + "...");
        int riders = 0;

        while (!visitorQueue.isEmpty() && riders < capacity) {
            Visitor visitor = visitorQueue.poll();
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " is riding " + rideName);
            riders++;
        }

        if (riders == 0) {
            System.out.println("No visitors to ride the " + rideName);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history for " + rideName);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (!rideHistory.isEmpty()) {
            System.out.println("Visitors who have ridden " + rideName + ":");
            for (Visitor visitor : rideHistory) {
                System.out.println(visitor.getName());
            }
        } else {
            System.out.println("No visitors have ridden " + rideName + " yet.");
        }
    }
}
