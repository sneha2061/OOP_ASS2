import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity; // Maximum number of visitors per cycle
    private Employee operator; // Employee assigned to the ride
    private Queue<Visitor> waitingLine; // Queue for visitors waiting to take the ride
    private LinkedList<Visitor> rideHistory; // List for visitors who have taken the ride
    private int maxRider;
    private int numofCycles=0;
    
        // Default constructor
        public Ride() {
            this.waitingLine = new LinkedList<>();
            this.rideHistory = new LinkedList<>();
        }
    
        // Parameterized constructor
        public Ride(String rideName, int capacity, Employee operator, int maxRider) {
            this.rideName = rideName;
            this.capacity = capacity;
            this.operator = operator;
            this.maxRider = maxRider;
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
        public Visitor removeVisitorFromQueue() {
            if (!waitingLine.isEmpty()) {
                Visitor visitor = waitingLine.poll();
                System.out.println(visitor.getName() + " has been removed from the waiting line for " + rideName);
                return visitor;
            } else {
                System.out.println("The waiting line for " + rideName + " is empty.");
                return null;
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
                for (Visitor visitor : rideHistory) {
                    System.out.println(visitor.getName());
                }
            }
        }
    
        @Override
        public void runOneCycle() {
            if (operator == null) {
                System.out.println("Ride cannot be run. No operator assigned.");
                return;
            }
    
            if (waitingLine.isEmpty()) {
                System.out.println("Ride cannot be run. No visitors in the waiting line.");
                return;
            }
    
            System.out.println("Running the ride for one cycle...");
            int riders = 0;
    
            while (riders < maxRider && !waitingLine.isEmpty()) {
                Visitor visitor = removeVisitorFromQueue();
                if(visitor != null){
                addVisitorToHistory(visitor);
                riders++;
                }
            }   
            numofCycles++;
            System.out.println("Ride completed one cycle. Number of cycles: " + numofCycles);
        }
    
        
     // Method to sort the ride history
    
     public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history to sort.");
            return;
        }
    
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history has been sorted.");
    }
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                String visitorData = visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress() + "," + visitor.getTicketType() + "," + visitor.getVisitCount();
                writer.write(visitorData);
                writer.newLine();
            }
    // Iterate through the rideHistory and write to the file
                    System.out.println("Ride history successfully exported to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to extract visitor details
                String[] data = line.split(",");
                if (data.length >= 2) { // Ensure there are enough fields
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String address = data[2];
                    String ticketType = data[3];
                    int visitCount = Integer.parseInt(data[4]);


                    // You can include additional fields if they exist
                    Visitor visitor = new Visitor(name, age , address, ticketType, visitCount); // Create a new Visitor object
                addVisitorToHistory(visitor); // Add to the ride history
            } else {
                System.err.println("Invalid data format: " + line);
            }
        }
        System.out.println("Ride history successfully imported from " + filename);
    } catch (IOException e) {
        System.err.println("Error reading from file: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.err.println("Invalid number format in file: " + e.getMessage());
    }
}
}


