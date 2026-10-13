import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert Martin", 45, 464));
        library.addBook(new Book("1984", "George Orwell", 18, 328));
        library.addBook(new Book("Animal Farm", "George Orwell", 12, 112));
        library.addBook(new Book("Java Basics", "Max Mueller", 35, 520));
        library.addBook(new Book("The Hobbit", "J. R. R. Tolkien", 28, 310));

        Scanner scanner = new Scanner(System.in);

//        System.out.print("Author: ");
//        String author = scanner.nextLine();
//        library.searchByAuthor(author);

        System.out.println( library.avgPageCount(
            new String[]{
                    "Clean Code",
                    "1984",
                    "Fake Book",
                    "Animal Farm"
            }
        ));

        library.printBookTitles(library.getBooksCheaperThan(30));
        library.findMostExpensive(library.getBooksByTitles(new String[]{"1984","Animal Farm", "The Hobbit"}));

    }
}