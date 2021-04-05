/**Class Manager.java chứa hàm main() để điều khiển luồng chính của ứng dụng

 Trong hàm main() sẽ chứa đoạn code để hiển thị menu cho người dùng lựa chọn.

 Bạn cần dùng tới vòng lặp để menu này được hiển thị lại sau khi người dùng thao tác các chứ năng.

 Bạn có thể xem lại hình bên cạnh để rõ cách menu này hoạt động.
 */
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        BookList bookList = new BookList();

        System.out.println("Welcome to the online book library");
        runLibrary(bookList, console);
    }

    public static void runLibrary(BookList bookList, Scanner console) {
        while (true) {
            getMenu();

            System.out.print("Your choice: ");
            switch (console.nextInt()) {
                case 1:
                    bookList.add();
                    break;
                case 2:
                    bookList.search();
                    break;
                case 3:
                    bookList.display();
                    break;
                case 4:
                    bookList.borrow();
                    break;
                case 5:
                    bookList.exit();
                    break;
                default:
                    System.out.println("Please choose a number between 1 to 5");
                    break;
            }
        }

    }

    public static void getMenu() {
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("1. Enter a new book");
        System.out.println("2. Search a book by book title");
        System.out.println("3. Display books");
        System.out.println("4. Borrow a book by book id");
        System.out.println("5. Exit");
        System.out.println();
    }
}

