class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;       // cùng object
        if (obj == null) return false;      // null
        if (getClass() != obj.getClass()) return false;

        Book other = (Book) obj;

        return title.equals(other.title)
                && author.equals(other.author)
                && price == other.price;
    }
}