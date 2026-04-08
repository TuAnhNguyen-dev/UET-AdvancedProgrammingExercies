import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {
    private List<FileSystemItem> itemList;

    public Folder(String name) {
        super(name);
        itemList = new ArrayList<>();
    }

    @Override
    public void print(String ident) {
        System.out.printf("%sFolder: %s\n", ident, name);

        ident += '\t';
        for (FileSystemItem item: itemList) {
            item.print(ident);
        }
    }

    public void addItem(FileSystemItem item) {
        itemList.add(item);
    }
}
