import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(" --- Kiểm tra với Adapter --- ");
        int[] nums = {5,2,1,3,4};

        System.out.print("Ban đầu nums có: ");
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.print("\n");

        SorterAdapter sorterAdapter = new SorterAdapter();
        sorterAdapter.sort(nums);

        System.out.print("Sau khi sort, nums có: ");
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.print("\n\n");

        System.out.println(" --- Kiểm tra với Prototype --- ");

        List<ReportTemple> reportTempleList = new ArrayList<>();

        ReportTemple reportTemple1 = new ReportTemple("title1");
        ReportTemple reportTemple2 = reportTemple1.clone();
        ReportTemple reportTemple3 = reportTemple1.clone();

        reportTempleList.add(reportTemple1);
        reportTempleList.add(reportTemple2);
        reportTempleList.add(reportTemple3);

        reportTemple2.setTitle("title2");
        reportTemple3.setTitle("title3");

        for (var reportTemp: reportTempleList) {
            System.out.println(reportTemp.getTitle());
        }
    }
}
