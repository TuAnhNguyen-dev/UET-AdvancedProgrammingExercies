public class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "<report>\n" +
                "  <title>" + data.getTitle() + "</title>\n" +
                "  <content>" + data.getContent() + "</content>\n" +
                "</report>";
    }
}
