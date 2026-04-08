public class Main {
    public static void main(String[] args) {
        // 1. Tạo dữ liệu báo cáo
        Report myReport = new Report("Báo Cáo Doanh Thu Q1", "Lợi nhuận tăng trưởng 20% so với cùng kỳ.");

        // 2. Kịch bản 1: Hệ thống yêu cầu xuất JSON
        ReportFormatter jsonStrategy = new JsonFormatter();
        ReportService service = new ReportService(jsonStrategy);
        System.out.println("-> Khách hàng yêu cầu JSON:");
        service.export(myReport);

        // 3. Kịch bản 2: Khách hàng đổi ý, muốn xuất XML
        // Không cần tạo lại ReportService mới, chỉ cần đổi "chiến lược" bên trong nó!
        ReportFormatter xmlStrategy = new XmlFormatter();
        service.setFormatter(xmlStrategy);
        System.out.println("-> Khách hàng đổi ý sang XML:");
        service.export(myReport);    }
}
