public class Visitor extends Person{
    private String ticketType;
    private int visitCount;

    // Default constructor
    public Visitor() {
    }

    // Parameterized constructor
    public Visitor(String name, int age, String address, String ticketType, int visitCount) {
        super(name, age, address);
        this.ticketType = ticketType;
        this.visitCount = visitCount;
    }

    // Getters and Setters
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
}
