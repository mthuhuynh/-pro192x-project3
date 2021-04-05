/**Các trường thông tin cơ bản cần có của một cuốn sách là: mã sách, tên sách, tác giả, và trạng thái
 * (được mượn, chưa mượn). Tham khảo code trong hình dưới đây để biết cách tạo các class kèm theo các
 * thuộc tính và constructor.
 *
 *Để thông tin về sách được hiển thị một cách đẹp đẽ thì ta nên ghi đè thêm phương thức toString()
 *để quy định quy cách các trường thông tin sẽ được hiển thị.
 */

public class Book {
    //Thông tin cơ bản cần có của một cuốn sách là: mã sách, tên sách, tác giả, và trạng thái
    private String id;
    private String title;
    private String author;
    private Boolean isBorrowed;

    //Constructor
    public Book(String id, String title, String author, Boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String id) {
        this.author = author;
    }

    public Boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20b", id, title, author, isBorrowed);
    }
}
