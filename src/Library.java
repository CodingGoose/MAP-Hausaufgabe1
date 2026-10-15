import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        this.books.add(book);
    }

    public ArrayList<Book> getLibraryBooks(){
        return books;
    }
    public ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> found = new ArrayList<>();
        for(Book book : books){
            if(Objects.equals(book.getAuthor(), author)){
                found.add(book);
            }
        }

        if(found.isEmpty()){
            System.out.printf("Keine Buecher von %s gefunden", author);
            return null;
        } else {
            for(Book book : found){
                System.out.println(book.getTitle());
            }
            return found;
        }
    }
    public ArrayList<Book> getBooksByTitles(ArrayList<String> bookTitles){
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

    public float avgPageCount(ArrayList<Book> foundBooks){
        float totalPageCount = 0;

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

    public Book findMostExpensive(ArrayList<Book> books){
        float maxPrice = 0;
        Book mostExpensiveBook = null;
        for(Book book : books){
            if(book.getPrice() > maxPrice){
                maxPrice=book.getPrice();
                mostExpensiveBook=book;
            }
        }
        if(maxPrice==0){
            System.out.println("No books were found.");
            return null;
        }
        System.out.printf("%s (%d Euro)\n", mostExpensiveBook.getTitle(), mostExpensiveBook.getPrice());
        return mostExpensiveBook;
    }

    public ArrayList<Book> getBooksByMinPageCount(int pageCount){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for(Book book : this.books){
            if(book.getPageCount() >= pageCount){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public ArrayList<Book> findBooksInsideBudget(int budget){
        ArrayList<BookPair> affordableBooks = new ArrayList<>();
        // folosim indecsi ca sa evitam duplicate
        for(int i=0; i<books.size()-1; i++ ){
            int remainingMoney = budget - books.get(i).getPrice();
            for(int j=i+1; j<books.size();j++){
                if(remainingMoney - books.get(j).getPrice() >= 0){
                    affordableBooks.add(new BookPair(books.get(i), books.get(j)));
                }

            }
        }

        if(affordableBooks.isEmpty()) {
            System.out.println("Keine Buehcerpaare fuer den gegebenen Budget gefunden");
            return null;
        } else {
            BookPair maxPair= affordableBooks.getFirst();
            int maxPrice=0;
            for(BookPair pair : affordableBooks){
                if(pair.book1.getPrice() + pair.book2.getPrice() > maxPrice){
                    maxPrice=pair.book1.getPrice() + pair.book2.getPrice();
                    maxPair=pair;
                } else if(pair.book1.getPrice() + pair.book2.getPrice() == maxPrice){
                    if(pair.book1.getPageCount() + pair.book2.getPageCount()
                            > maxPair.book1.getPageCount()+maxPair.book2.getPageCount())
                    {
                        maxPrice=pair.book1.getPrice() + pair.book2.getPrice();
                        maxPair=pair;
                    }
                }
            }
            System.out.printf("%s + %s\n", maxPair.book1.getTitle(), maxPair.book2.getTitle());
            System.out.printf("Gesamtpreis: %d\n",maxPair.book1.getPrice() + maxPair.book2.getPrice());

            ArrayList<Book> result = new ArrayList<>();
            result.add(maxPair.book1);
            result.add(maxPair.book2);
            return result;
        }

    }
}
