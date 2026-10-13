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
    private ArrayList<Book> getBooksByTitles(String[] bookTitles){
        ArrayList<Book> found = new ArrayList<>();
        for(String title : bookTitles){
            for(Book book : books){
                if(Objects.equals(title, book.getTitle())){
                    found.add(book);
                }
            }
        }
        return found;
    }

    public float avgPageCount(String[] bookTitles){
        float totalPageCount = 0;
        ArrayList<Book> foundBooks = getBooksByTitles(bookTitles);

        for(Book book : foundBooks){
            totalPageCount+=book.getPageCount();
        }

        return totalPageCount /foundBooks.size();
    }

    public void printBookTitles(){
        for(Book book : this.books){
            System.out.printf("%s\n", book.getTitle());
        }
    }
    public void printBookTitles(ArrayList<Book> books){
        for(Book book : books){
            System.out.printf("%s\n", book.getTitle());
        }
    }

    public ArrayList<Book> getBooksCheaperThan(int price){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for(Book book : books){
            if(book.getPrice() <= price){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }



}
