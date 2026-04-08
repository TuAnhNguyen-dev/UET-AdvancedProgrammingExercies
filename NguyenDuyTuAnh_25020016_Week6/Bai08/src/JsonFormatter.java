public class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "{\n" +
                "  \"title\": \"" + data.getTitle() + "\",\n" +
                "  \"content\": \"" + data.getContent() + "\"\n" +
                "}";
    }
}
