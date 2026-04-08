public abstract class FileSystemItem {
    public String name;

    public FileSystemItem(String name) {
        this.name = name;
    }

    public abstract void print(String ident);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
