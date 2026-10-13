import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        this.books.add(book);
    }

    public void searchByAuthor(String author){
        ArrayList<Book> found = new ArrayList<>();
        for(Book book : books){
            if(Objects.equals(book.getAuthor(), author)){
                found.add(book);
            }
        }

        if(found.isEmpty()){
            System.out.printf("Keine Buecher von %s gefunden", author);
        } else {
            for(Book book : found){
                System.out.println(book.getTitle());
            }
        }
    }
}
