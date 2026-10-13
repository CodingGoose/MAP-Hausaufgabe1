public class Book {
    private String title;
    private String author;
    private int price;
    private int pageCount;

    public Book(String title, String author, int price, int pageCount){
        this.title = title;
        this.author = author;
        this.price = price;
        this.pageCount = pageCount;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public int getPageCount() {
        return pageCount;
    }
}
