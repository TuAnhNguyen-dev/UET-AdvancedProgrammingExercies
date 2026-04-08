public class ReportService {
    private ReportFormatter formatter;

    public ReportService(ReportFormatter formater) {
        this.formatter = formater;
    }

    public void export(Report data) {
        System.out.println(formatter.format(data));
    }

    public void setFormatter(ReportFormatter formatter) {
        this.formatter = formatter;
    }
}
