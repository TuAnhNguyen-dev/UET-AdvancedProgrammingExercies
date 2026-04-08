public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder docs = new Folder("docs");
        FileItem atxt = new FileItem("a.txt", 12);
        FileItem btxt = new FileItem("b.txt", 8);
        FileItem readme = new FileItem("readme.md", 4);
        Shortcut a_shortcut = new Shortcut("a-shortcut", "/root/docs/a.txt");
        Shortcut root_shortcut = new Shortcut("root-shortcut", "/root");

        root.addItem(docs);
        root.addItem(readme);

        docs.addItem(atxt);
        docs.addItem(btxt);
        docs.addItem(a_shortcut);
        docs.addItem(root_shortcut );

        root.print("");

    }
}
