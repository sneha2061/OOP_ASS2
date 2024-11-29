public class AssignmentTwo {
    public static void main(String[] args) {
        // Entry point for the PRVMS
        System.out.println("Welcome to Park Rides Visitor Management System (PRVMS)!!");

            AssignmentTwo assignment = new AssignmentTwo();
            assignment.partThree();
        }
    
        public void partThree() {
            // Create an operator for the ride
            Employee operator = new Employee("Emiliano", 30, "Park Street", "Ride Operator", 45000);
    
            // Create a new Ride object
            Ride ferrisWheel = new Ride("Ferris Wheel", 3, operator);
    
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
        // Code part 4A
    }

    public void partFourB() {
        // Code part 4B
    }

    public void partFive() {
        // Code part five
    }

    public void partSix() {
        // Code part six
    }

    public void partSeven() {
        // Code part seven
    }
}

