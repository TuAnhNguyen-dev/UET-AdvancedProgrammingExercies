public abstract class MediaItem {
    protected String id;
    protected String name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String getDetails();
}