public class AssignmentTwo {
    public static void main(String[] args) {
        // Entry point for the PRVMS
        System.out.println("Welcome to Park Rides Visitor Management System (PRVMS)");
        Employee operator = new Employee("Pratik", 30, "Redondo Street", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", 5, operator);

        Visitor visitor1 = new Visitor("Janice", 35, "Down street", "Regular", 1);
        Visitor visitor2 = new Visitor("Patricia", 22, "Uptown", "Regular", 2);

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);

        rollerCoaster.printQueue();
        rollerCoaster.runOneCycle();

        rollerCoaster.printRideHistory();
    }
    public void partThree() {
        // Code part three 
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

