public class AssignmentTwo {
    public static void main(String[] args) {
        // Entry point for the PRVMS
        System.out.println("Welcome to Park Rides Visitor Management System (PRVMS)!!");

            AssignmentTwo assignment = new AssignmentTwo();
            assignment.partThree();
            assignment.partFourA();
            assignment.partFourB();
            assignment.partFive();
            assignment.partSix();
        }
    
        public void partThree() {
            // Create an operator for the ride
            Employee operator = new Employee("Emiliano", 30, "Park Street", "Ride Operator", 45000);
    
            // Create a new Ride object
            Ride ferrisWheel = new Ride("Ferris Wheel", 3, operator, 3);
    
            // Create Visitor objects
            Visitor visitor1 = new Visitor("Alicia", 25, "Chinatown", "Regular", 1);
            Visitor visitor2 = new Visitor("Barbara", 28, "Under street", "VIP", 2);
            Visitor visitor3 = new Visitor("Charles", 22, "City Center", "Regular", 3);
            Visitor visitor4 = new Visitor("David", 30, "Subrine street", "Regular", 4);
            Visitor visitor5 = new Visitor("Evelyn", 27, "Downtown", "VIP", 5);
    
            // Add Visitors to the Queue
            ferrisWheel.addVisitorToQueue(visitor1);
            ferrisWheel.addVisitorToQueue(visitor2);
            ferrisWheel.addVisitorToQueue(visitor3);
            ferrisWheel.addVisitorToQueue(visitor4);
            ferrisWheel.addVisitorToQueue(visitor5);
    
            // Remove a Visitor from the Queue
            ferrisWheel.removeVisitorFromQueue();
    
            // Print all Visitors in the Queue
            ferrisWheel.printQueue();
        }

    public void partFourA() {
        // Create an operator
        Employee operator = new Employee("Jason", 42, "Parkwood", "Ride Operator", 40000);

        // Create a new Ride object
        Ride rollerCoaster = new Ride("Roller Coaster", 4, operator, 4);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Anjana", 25, "Damak", "Regular", 101);
        Visitor visitor2 = new Visitor("Bandana", 30, "Udayapur", "VIP", 102);
        Visitor visitor3 = new Visitor("Charishma", 22, "City road", "Regular", 103);
        Visitor visitor4 = new Visitor("Dina", 28, "Sunsari", "VIP", 104);
        Visitor visitor5 = new Visitor("Eva", 26, "Morang", "Regular", 105);

        // Add Visitors to the Ride History collection
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // Check if a specific Visitor is in the collection
        Visitor visitorToCheck = new Visitor("Binod", 30, "Udayapur", "VIP", 102);
        rollerCoaster.checkVisitorFromHistory(visitorToCheck);

        // Print the number of Visitors in the collection
        System.out.println("Number of visitors who have taken the ride: " + rollerCoaster.numberOfVisitors());

        // Print all Visitors in the collection
        rollerCoaster.printRideHistory();
    } 
    

    public void partFourB() {
       // Create an operator
       Employee operator = new Employee("Sam", 35, "Limly Lane", "Ride Operator", 45000);

       // Create a new Ride object
       Ride Slingshot = new Ride("Slingshot", 16, operator,6);

       // Add Visitors to the ride history
       Slingshot.addVisitorToHistory(new Visitor("Zaira", 23, "Kathmandu", "Regular", 201));
       Slingshot.addVisitorToHistory(new Visitor("Amy", 27, "Milan Chowk", "VIP", 202));
       Slingshot.addVisitorToHistory(new Visitor("Doreen", 19, "Upper mustang", "Regular", 203));
       Slingshot.addVisitorToHistory(new Visitor("Zaira", 25, "Suncity", "Regular", 204)); 
       Slingshot.addVisitorToHistory(new Visitor("Babar", 30, "sunshine coast", "VIP", 205));

       // Print ride history before sorting
       System.out.println("Ride history before sorting:");
       Slingshot.printRideHistory();

       // Sort the ride history
       Slingshot.sortRideHistory();

       // Print ride history after sorting
       System.out.println("Ride history after sorting:");
       Slingshot.printRideHistory();
   } 

    public void partFive() {
     // Create a new Ride object
     Employee operator = new Employee("Tam", 30, "Lolly Lane", "Ride Operator", 46000); 
     Ride monsterDragon = new Ride("Monster Dragon", 20, operator, 5); // Max 5 riders per cycle
 
     // Add 10 Visitors to the Queue
     monsterDragon.addVisitorToQueue(new Visitor("Aarshi", 20, "ferny avenue", "Regular", 101));
     monsterDragon.addVisitorToQueue(new Visitor("Priyanka", 21, "gothatar", "Regular", 102));
     monsterDragon.addVisitorToQueue(new Visitor("Atithi", 22, "trickett st", "VIP", 103));
     monsterDragon.addVisitorToQueue(new Visitor("Anjana", 28, "rocher avenue", "Regular", 104));
     monsterDragon.addVisitorToQueue(new Visitor("Pritha", 25, "rosy avenue", "VIP", 105));
     monsterDragon.addVisitorToQueue(new Visitor("Ayesha", 26, "kitchener avenue", "Regular", 106));
     monsterDragon.addVisitorToQueue(new Visitor("Simana", 22, "boil avenue", "Regular", 107));
     monsterDragon.addVisitorToQueue(new Visitor("Samridhi", 21, "ferma avenue", "VIP", 108));
     monsterDragon.addVisitorToQueue(new Visitor("Ankit", 25, "fishy avenue", "Regular", 109));
     monsterDragon.addVisitorToQueue(new Visitor());
 
     // Print all Visitors in the queue
     System.out.println("\n--- Visitors in the Queue ---");
     monsterDragon.printQueue();
 
     // Run one cycle
     System.out.println("\n--- Running One Cycle ---");
     monsterDragon.runOneCycle();
 
     // Print all Visitors in the queue after one cycle is run
     System.out.println("\n--- Visitors in the Queue After One Cycle ---");
     monsterDragon.printQueue();
 
     // Print all Visitors in the collection (ride history)
     System.out.println("\n--- Visitors in the Ride History ---");
     monsterDragon.printRideHistory();
 }    


    public void partSix() {
     // Create a new Ride object
     Employee operator = new Employee("Sagar", 23, "Ferny ave", "Ride Operator", 40000); 
     Ride bumperCars = new Ride("Bumper Cars", 10, operator, 6);

     // Add a minimum of 5 Visitors to the Ride's history
     bumperCars.addVisitorToHistory(new Visitor("Saran", 23, "fern st", "Regular", 101));
     bumperCars.addVisitorToHistory(new Visitor("Sneha", 20, "kitchener avenue", "Regular", 102));
     bumperCars.addVisitorToHistory(new Visitor("Manita", 23, "paradise avenue", "VIP", 103));
     bumperCars.addVisitorToHistory(new Visitor("Sadiksha", 22, "angella avenue", "Regular", 104));
     bumperCars.addVisitorToHistory(new Visitor("Aarshi", 21, "guttsy avenue", "Regular", 105));
 
     // Export the ride history to a file
     System.out.println("\n--- Exporting Ride History to File ---");
     bumperCars.exportRideHistory("bumper_cars_history.csv");
 }  

    public void partSeven() {
        // Code part seven
    }
}

