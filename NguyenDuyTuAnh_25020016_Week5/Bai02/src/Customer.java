public class Customer {
    private String id;
    private String name;
    private Ticket ticket;

    public Customer(String id, String name, Ticket ticket) {
        this.id = id;
        this.name = name;
        this.ticket = ticket;
    }

    public String getName() { return name; }
    public Ticket getTicket() { return ticket; }
}