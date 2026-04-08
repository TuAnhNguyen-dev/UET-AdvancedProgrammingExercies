import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Hàng đợi khách hàng (FIFO)
        Queue<Customer> customerQueue = new LinkedList<>();

        // 2. Lịch sử tin nhắn đang soạn thảo (LIFO - dành cho Undo)
        Stack<Message> chatSession = new Stack<>();

        // GIẢ LẬP: Khách A và B đến
        System.out.println("--- TIẾP NHẬN KHÁCH HÀNG ---");
        Customer custA = new Customer("C01", "NguyenVanA", new Ticket("T01", "Lỗi đơn hàng"));
        Customer custB = new Customer("C02", "TranThiB", new Ticket("T02", "Tư vấn sản phẩm"));

        customerQueue.offer(custA);
        customerQueue.offer(custB);
        System.out.println("Đã thêm A và B vào hàng đợi.");

        // GIẢ LẬP: Xử lý khách A
        System.out.println("\n--- ĐANG XỬ LÝ KHÁCH: " + customerQueue.peek().getName() + " ---");
        Customer processing = customerQueue.poll();
        System.out.println("Nội dung yêu cầu: " + processing.getTicket());

        // Nhân viên gõ 3 dòng tin nhắn
        chatSession.push(new Message("Chào bạn, tôi là tổng đài viên Shopee."));
        chatSession.push(new Message("Tôi đã nhận được yêu cầu " + processing.getTicket().toString()));
        chatSession.push(new Message("Bạn chờ 10 phút nhé, tôi đang kiểm tra... (GÕ NHẦM)"));

        System.out.println("Tin nhắn vừa gõ (Peek): " + chatSession.peek());

        // Tính năng Undo: Xóa dòng cuối do gõ nhầm
        System.out.println("Thực hiện lệnh UNDO...");
        chatSession.pop();

        System.out.println("Lịch sử chat còn lại:");
        for(Message m : chatSession) System.out.println("- " + m);

        // GIẢ LẬP: Xử lý khách tiếp theo
        System.out.println("\n--- ĐANG XỬ LÝ KHÁCH TIẾP THEO ---");
        if (customerQueue.isEmpty()) {
            System.out.println("Không còn khách đợi.");
        } else {
            Customer next = customerQueue.poll();
            System.out.println("Đang hỗ trợ: " + next.getName());
        }
    }
}