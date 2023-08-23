package ra.run;

import ra.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookImp {
    static ArrayList<Book> bookArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        managerBook(scanner);
    }

    public static void menu() {
        System.out.println(" *************************MENU************************");
        System.out.println("1. Nhập thông tin các sách");
        System.out.println(" 2. In thông tin các sách ra file demo.txt");
        System.out.println(" 3. Đọc file demo.txt và in ra các sách có giá trong khoảng 10000 đến 20000");
        System.out.println(" 4. Thoát");
    }

    public static void managerBook(Scanner scanner) {

        boolean isExit = true;
        do {
            menu();
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputBook(scanner);
                    break;
                case 2:
                    writeData(bookArrayList);
                    break;
                case 3:
                    ArrayList<Book> bookArrayList1 = new ArrayList<>();
                    bookArrayList1 = readData();
                    System.out.println("List Danh sach Book");
                    for (Book book : bookArrayList1) {
                        book.output();
                    }
                    System.out.println("*************************");
                    System.out.println("List Danh sach Book co gia tien 10k-20k");
                    outputPrice(bookArrayList1);
                    break;
                case 4:
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui long chon lai");
                    break;
            }
        } while (isExit);
    }

    public static void inputBook(Scanner scanner) {
        Book newBook = new Book();
        newBook.input(scanner);
        bookArrayList.add(newBook);
    }

    public static void writeData(ArrayList<Book> bookArrayList) {
        //1 Khoi tao doi tuong file
        File file = new File("book.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(bookArrayList);
            oos.flush();
        } catch (FileNotFoundException ex1) {
            System.err.println("Loi ghi du lieu vao  file");
        } catch (IOException ex2) {
            System.err.println("Loi khong ton tai file");
        } catch (Exception e) {
            System.err.println("Loi xay ra trong qua trinh ghi du lieu");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex1) {
                System.err.println("Loi dong cac stream");
            } catch (Exception e) {
                System.err.println("Loi say ra trong qua trinh dong Stream");
            }
        }
    }

    public static ArrayList<Book> readData() {
        File file = new File("book.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Book> bookArrayList1 = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            bookArrayList1 = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.out.println("Loi khong ton tai file khi doc");
        } catch (IOException ex2) {
            System.out.println("Loi khi doc file");
        } catch (Exception ex3) {
            System.out.println("Loi trong qua tring doc file");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
                System.out.println("Loi xay ra khi dong strem");
            } catch (Exception ex) {
                System.out.println("Loi xay ra trong qua trinh dong cac Stream");
            }
            return bookArrayList1;
        }
    }

    public static void outputPrice(ArrayList<Book> bookArrayList) {
        for (Book book : bookArrayList) {
            if (book.getPrice() >= 10000 & book.getPrice() <= 20000) {
                book.output();
            }
        }
    }
}
