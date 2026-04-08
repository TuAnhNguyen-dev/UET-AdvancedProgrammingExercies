interface IExport {
    void exportFile();
}

class PdfExport implements IExport {
    @Override
    public void exportFile() {
        System.out.println("Khởi tạo với PDF.");
    }
}

class ExcelExport implements IExport {
    @Override
    public void exportFile() {
        System.out.println("Khởi tạo với EXCEL.");
    }
}

abstract class ExportFactory {
    abstract IExport createExport();
}

class PdfFactory extends ExportFactory {
    @Override
    public IExport createExport() {
        return new PdfExport();
    }
}

class ExcelFactory extends ExportFactory {
    @Override
    public IExport createExport() {
        return new ExcelExport();
    }
}

public class FactoryMethod {
    public static void test() {
        System.out.println("--- KIỂM TRA FACTORY METHOD ---");

        ExportFactory pdfFactory = new PdfFactory();

        IExport pdf = pdfFactory.createExport();
        pdf.exportFile();

        ExportFactory excelFactory = new ExcelFactory();

        IExport excel = excelFactory.createExport();
        excel.exportFile();

        System.out.println();
    }
}
