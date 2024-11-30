import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity; // Maximum number of visitors per cycle
    private Employee operator; // Employee assigned to the ride
    private Queue<Visitor> waitingLine; // Queue for visitors waiting to take the ride
    private LinkedList<Visitor> rideHistory; // List for visitors who have taken the ride

    // Default constructor
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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

    // Methods for Queue operations

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.add(visitor);
        System.out.println(visitor.getName() + " has joined the waiting line for " + rideName);
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removedVisitor = waitingLine.poll();
            System.out.println(removedVisitor.getName() + " has been removed from the waiting line for " + rideName);
        } else {
            System.out.println("The waiting line for " + rideName + " is empty.");
        }
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("The waiting line for " + rideName + " is empty.");
        } else {
            System.out.println("Visitors in the waiting line for " + rideName + ":");
            for (Visitor visitor : waitingLine) {
                System.out.println(visitor.getName());
            }
        }
    }

    // Methods for Ride History operations

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history for " + rideName);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = rideHistory.contains(visitor);
        if (exists) {
            System.out.println(visitor.getName() + " is found in the ride history for " + rideName);
        } else {
            System.out.println(visitor.getName() + " is NOT found in the ride history for " + rideName);
        }
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride " + rideName + " yet.");
        } else {
            System.out.println("Visitors who have taken the ride " + rideName + ":");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println("Running one cycle of " + rideName + "...");

        int riders = 0;

        while (!waitingLine.isEmpty() && riders < capacity) {
            Visitor currentVisitor = waitingLine.poll();
            addVisitorToHistory(currentVisitor); // Add visitor to history
            System.out.println(currentVisitor.getName() + " is taking the ride " + rideName);
            riders++;
        }

        if (riders == 0) {
            System.out.println("No visitors were available to ride " + rideName + " this cycle.");
        }
    }
}
