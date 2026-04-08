import java.util.ArrayList;
import java.util.List;

public class ReportTemple {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemple(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    public ReportTemple(String title) {
        this.title = title;
        this.footer = null;
        this.sections = null;
    }

    public ReportTemple(ReportTemple other) {
        this.title = other.title;
        this.footer = other.footer;
        this.sections = new ArrayList<>(other.sections);
    }

    public ReportTemple clone() {
        return new ReportTemple(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
