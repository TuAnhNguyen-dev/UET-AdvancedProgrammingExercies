public class Shortcut extends FileSystemItem {
    private String targetPath;

    public Shortcut(String name, String targetPath) {
        super(name);
        this.targetPath = targetPath;
    }

    @Override
    public void print(String ident) {
        System.out.printf("%sShortcut: %s -> %s\n", ident, name, targetPath);
    }
}
