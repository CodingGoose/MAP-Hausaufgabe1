import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert Martin", 45, 464));
        library.addBook(new Book("1984", "George Orwell", 18, 328));
        library.addBook(new Book("Animal Farm", "George Orwell", 12, 112));
        library.addBook(new Book("Java Basics", "Max Mueller", 35, 520));
        library.addBook(new Book("The Hobbit", "J. R. R. Tolkien", 28, 310));
        library.addBook(new Book("The Bible (Gold Edition)", "'God'", 18, 1200));

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome To The Library!");
            System.out.println("What do you wanna do?");
            System.out.println("1. Search Books By Author");
            System.out.println("2. Calculate Avg Page Count of Books");
            System.out.println("3. Find Books Under a Certain Price Limit");
            System.out.println("4. Find Books With More THan X Pages");
            System.out.println("5. Find A Book Pair Within A Certain Budget");
            System.out.println("0. EXIT");

            int input;
            while(true){
                try{
                    System.out.print("Your Choice: ");
                    input = scanner.nextInt();

                } catch (Exception e) {
                    scanner.nextLine(); // ca si cin.get() ala din cpp din liceu
                    continue;
                }
                break;
            }
            scanner.nextLine(); // input buffer cleanup

            switch(input){
                case 1:
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    library.searchByAuthor(author);
                case 2:
                    ArrayList<String> book_titles = new ArrayList<>();
                    System.out.print("How many books: ");
                    input= scanner.nextInt();
                    scanner.nextLine(); // input buffer cleanup
                    for(int i=0; i<input; i++) {
                        String title = scanner.nextLine();
                        book_titles.add(title);
                        System.out.println(
                                library.avgPageCount(book_titles)
                        );
                    }
                case 3:
//                    alalala

            }


            //        System.out.print("Maximalpreis: ");
            //        int price = scanner.nextInt();
            //        library.printBookTitles(library.getBooksCheaperThan(price));

            //        library.findMostExpensive(library.getBooksByTitles(new String[]{"1984","Animal Farm", "The Hobbit"}));

            //        System.out.print("Mindestseitenanzahl: ");
            //        int minPageCount = scanner.nextInt();
            //        library.printBookTitles(library.getBooksByMinPageCount(minPageCount));

            System.out.print("Budget: ");
            int budget = scanner.nextInt();
            library.findBooksInsideBudget(budget);

        }
    }
}