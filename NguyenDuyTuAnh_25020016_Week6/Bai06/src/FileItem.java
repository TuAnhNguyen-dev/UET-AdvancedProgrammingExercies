public class FileItem extends FileSystemItem {
    private int size;

    public FileItem(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void print(String ident) {
        System.out.printf("%sFile: %s (%dKB)\n", ident, name, size);
    }
}
