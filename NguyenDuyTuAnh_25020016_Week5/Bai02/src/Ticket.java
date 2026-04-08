public class Ticket {
    private String id;
    private String content;

    public Ticket(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "TicketID: " + id + " (Vấn đề: " + content + ")";
    }
}