
/**Class BookList.java: chứa danh sách các cuốn sách, và các phương thức xử lý liên quan.

 1. Add() nhập thông tin mới về sách
 Bạn cần nhập các thông tin cơ bản như: mã sách, tên sách, tác giả, trạng thái (1 - yes - đã mượn, 0 - no - chưa mượn).

 2. Search() tìm kiếm sách
 Bạn có thể cho phép người dùng tìm thông tin về sách theo một trong các tiêu chí sau (mã sách, tên sách).
 Ví dụ trong hình là người dùng đang tìm kiếm thông tin về sách theo tên sách.
 Bạn nhập tiêu đề cuốn sách (tên sách) rồi sau đó nhấn Enter. Nếu có sách phù hợp với thông tin tìm kiếm thì về sách sẽ
 hiện ra theo định dạng như hình trên (thông tin hiển thị dạng bảng).
 Nếu không tìm thấy sách thì bạn cần hiển thị thông báo để người dùng biết. Ví dụ sẽ thông báo là: “Cuốn sách bạn cần tìm
 hiện không có trong thư viện. Bạn có thể quay lại tìm kiếm vào lúc khác”.

 3. Display() hiển thị danh sách
 Thông tin hiển thị bao gồm: mã sách, tên sách, tên tác giả, trạng thái mượn sách.
 Để người dùng dễ quan sát thì ta cần tạo các thông tin hiển thị dưới dạng bảng.
 Hãy dùng vòng lặp để hiển thị nội dung của các cuốn sách theo dạng bảng.
 Lưu ý phần tiêu đề của bảng cần phải đưa ra ngoài vòng lặp (ID, Title, Author, Is borrowed).

 4. Borrow() thực hiện cho mượn sách (chuyển trạng thái của 1 trường thông tin trong book)
 Bạn nhập thông tin cuốn sách muốn mượn. Ví dụ bạn nhập mã sách hoặc tên sách.
 Sau khi người dùng nhập mã sách xong, hệ thống cần tìm kiếm trong dữ liệu hiện có (danh sách sách) xem có sách này không,
 và sách đã được cho mượn chưa.
 Nếu sách không có, hoặc có mà đã cho mượn thì cần thông báo cho người dùng.
 Nếu không có sách thì hệ thống cần hiển thị thông báo là: “Thư viện hiện không có sách này”.
 Nếu có sách nhưng đã cho mượn thì cần thông báo là: “ Thư viện có sách này nhưng hiện đã cho người khác mượn. Bạn có thể mượn vào lúc khác”.
 Nếu sách có và đang ở trạng thái là chưa ai mượn thì thông báo “Bạn đã mượn thành công cuốn sách xxxx” (xxxx là Tên cuốn sách họ mượn).

 5. Exit() kết thúc chương trình

 Lưu ý: trên đây là gợi ý tên  phương thức và chức năng đi kèm, học viên có thể tuỳ ý thay đổi tên phương thức cũng như input output,
 miễn là đảm bảo chức năng
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {
    List<Book> myBooks = new ArrayList<>();

    public void add() {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter information for the new book: ");
        String id = getString(console, "ID: ");
        String title = getString(console, "Title: ");
        String author = getString(console, "Author: ");
        Boolean isBorrowed = false;
        String choice;
        do {
            choice = getString(console, "Is borrowed (1 = yes, 0 = no): ");

            switch (choice) {
                case "1":
                    isBorrowed = true;
                    break;
                case "0":
                    isBorrowed = false;
                    break;
                default:
                    System.out.println("Please input a valid value");
                    break;
            }
        } while (!choice.equals("1") && !choice.equals("2"));

        addToList(id.toUpperCase(), title, author, isBorrowed);

        System.out.println("A new book has been added");
        //console.close();
    }

    public void addToList(String id, String title, String author, Boolean isBorrowed) {
        Book book = new Book(id, title, author, isBorrowed);
        myBooks.add(book);

    }

    public void search() {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter book title to search:");
        String searchKey = getString(console, "Book title: ");

        List<Book> booksFound = new ArrayList<>();
        for (Book book : myBooks) {
            if (book.getTitle().contains(searchKey)) {
                booksFound.add(book);
            }
        }

        if (booksFound.isEmpty()) {
            System.out.println("No book is found");
        } else {
            System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
            for (Book book : booksFound) {
                System.out.println(book.toString());
            }
        }

        //console.close();
    }
    
    public void display() {
        System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
        for (Book book : myBooks) {
            System.out.println(book.toString());
        }
    }

    public void borrow() {
        Scanner console = new Scanner(System.in);
        Boolean isAvailable = false;

        System.out.println("Enter book ID to borrow:");
        String searchKey = getString(console, "Book ID: ");

        for (Book book : myBooks) {
            if (book.getId().equalsIgnoreCase(searchKey)) {
                isAvailable = true;
                if (!book.getIsBorrowed()) {
                    System.out.println("You have successfully borrow the book: " + book.getTitle());
                    book.setIsBorrowed(true);
                } else {
                    System.out.println(book.getTitle() + " is borrowed already. Please try again next time.");
                }
            }
        }

        if (!isAvailable) {
            System.out.println("No book ís found");
        }

        //console.close();
    }

    public static String getString(Scanner console, String promt) {
        System.out.print(promt);
        return console.nextLine();
    }

    public void exit() {
        System.exit(0);
    }


}
