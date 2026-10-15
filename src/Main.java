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
        boolean running = true;

        while (running) {
            printMenu();
            int input = readInt(scanner, "Your Choice: ");

            switch (input) {
                case 0:
                    running = false;
                    continue;
                case 1:
                    handleSearchByAuthor(library, scanner);
                    break;
                case 2:
                    handleAvgPageCount(library, scanner);
                    break;
                case 3:
                    handleBooksUnderPrice(library, scanner);
                    break;
                case 4:
                    handleMostExpensiveBook(library, scanner);
                    break;
                case 5:
                    handleMinPageCount(library, scanner);
                    break;
                case 6:
                    handleBudgetSearch(library, scanner);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

            waitForEnter(scanner);
            clearScreen();
        }
    }

    private static void printMenu() {
        System.out.println("Welcome To The Library!");
        System.out.println("What do you wanna do?");
        System.out.println("1. Search Books By Author");
        System.out.println("2. Calculate Avg Page Count of Books");
        System.out.println("3. Find Books Under a Certain Price Limit");
        System.out.println("4. Find Most Expensive Book");
        System.out.println("5. Find Books With More Than X Pages");
        System.out.println("6. Find A Book Pair Within A Certain Budget");
        System.out.println("0. EXIT");
    }

    private static void handleSearchByAuthor(Library library, Scanner scanner) {
        System.out.print("Author: ");
        String author = scanner.nextLine();
        library.searchByAuthor(author);
    }

    private static void handleAvgPageCount(Library library, Scanner scanner) {
        ArrayList<String> bookTitles = readBookTitles(scanner);
        System.out.println(library.avgPageCount(library.getBooksByTitles(bookTitles)));
    }

    private static void handleBooksUnderPrice(Library library, Scanner scanner) {
        int price = readInt(scanner, "Maximalpreis: ");
        library.printBookTitles(library.getBooksCheaperThan(price));
    }

    private static void handleMostExpensiveBook(Library library, Scanner scanner) {
        ArrayList<String> bookTitles = readBookTitles(scanner);
        library.findMostExpensive(library.getBooksByTitles(bookTitles));
    }

    private static void handleMinPageCount(Library library, Scanner scanner) {
        int minPageCount = readInt(scanner, "Mindestseitenanzahl: ");
        library.printBookTitles(library.getBooksByMinPageCount(minPageCount));
    }

    private static void handleBudgetSearch(Library library, Scanner scanner) {
        int budget = readInt(scanner, "Budget: ");
        library.findBooksInsideBudget(budget);
    }

    // helpers

    private static ArrayList<String> readBookTitles(Scanner scanner) {
        int count = readInt(scanner, "How many books: ");
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Book title: ");
            titles.add(scanner.nextLine());
        }
        return titles;
    }

    private static int readInt(Scanner scanner, String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                scanner.nextLine(); // input buffer cleanup applied automatically
                return input;
            } catch (Exception e) {
                scanner.nextLine(); // clear invalid string from buffer
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void waitForEnter(Scanner scanner) {
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();
    }

    private static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}