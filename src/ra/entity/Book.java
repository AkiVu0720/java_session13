package ra.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private String BookId;
    private  String Bookname;
    private float Price;

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public Book() {
    }

    public Book(String bookId, String bookname, float price) {
        BookId = bookId;
        Bookname = bookname;
        Price = price;
    }
    public void input (Scanner scanner){
        System.out.println("Ma sach: ");
        this.BookId = scanner.nextLine();
        System.out.println("Ten Sach: ");
        this.Bookname = scanner.nextLine();
        System.out.println("Gia Sach: ");
        this.Price = Float.parseFloat(scanner.nextLine());
    }
    public void output (){
        System.out.printf("MaSach: %3s - Ten Sach: %3s - Gia: %3.2f \n", this.BookId, this.Bookname, this.Price);
    }

}
