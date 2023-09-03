package org.example;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Member {
    private String name;
    private int age;
    private int phone;
    private int id;
    private int fine;
    private int borrowed_books;
    private ArrayList<Book> books = new ArrayList<Book>();

    Member(String name, int age, int phone, int id){
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.id = id;
        this.borrowed_books = 0;
        this.fine = 0;
    }

    public void issueBook(Book book){
        this.books.add(book);
        this.borrowed_books++;
    }

    public void showBooks(){
        if (this.books.isEmpty()){
            System.out.println("There are no books, try adding some!");
        }
        else{
            for (Book book : this.books) {
                int dur = (int) Duration.between(LocalTime.now(),book.getTime()).abs().toSeconds();
                System.out.printf("Book ID- %d\nTitle- %s\nAuthor- %s\nFine- %d\n\n",book.getID(),book.getTitle(),book.getAuthor(),this.fine+this.calFine(dur));
            }
        }
    }

    public int getPhone(){
        return this.phone;
    }
    public int getID(){
        return this.id;
    }

    public void retBook(int id,int fine){
        this.books.removeIf(book->book.getID() == id);
        this.borrowed_books--;
        this.fine += fine;
        System.out.printf("Book ID: %d successfully returned.\n",id);
        if (fine>0){
            System.out.printf("%d Rupees has been charged for a delay of %d days.\n",fine,fine/3);
        }
    }

    public int calFine(int dur){
        if (dur>10){
            return (dur-10)*3;
        }
        else{
            return 0;
        }
    }

    public void retFine(){
        if (this.fine>0){
            System.out.printf("You had a total fine of Rs. %d. It has been paid successfully!\n",this.fine);
            this.fine=0;
        }
        else{
            System.out.println("No fine has been assigned yet!");
        }
    }

    public String getName(){
        return this.name;
    }
    public int getFine(){
        int fine=this.fine;
        for (Book book : this.books) {
            int dur = (int) Duration.between(LocalTime.now(),book.getTime()).abs().toSeconds();
            fine += this.calFine(dur);
        }
        return fine;
    }
    public int getBorrow(){
        return this.borrowed_books;
    }
}