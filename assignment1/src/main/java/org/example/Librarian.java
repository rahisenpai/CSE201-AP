package org.example;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;

public class Librarian {
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Integer> bookID = new ArrayList<Integer>();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Integer> memberID = new ArrayList<Integer>();

    public int addMember(String name, int age, int phone){
        for (Member mem : this.members) {
            if (mem.getPhone() == phone) {
                return -1;
            }
        }
        int id;
        if (this.memberID.isEmpty()){
            id = this.members.size()+1;
        }
        else{
            id = this.memberID.get(0);
            this.memberID.remove(0);
        }
        Member mem = new Member(name, age, phone, id);
        this.members.add(mem);
        return id;
    }

    public void showMembers(){
        if (this.members.isEmpty()){
            System.out.println("There are no members, try adding some!");
        }
        else{
            System.out.println("List of members in below format:\nMemberId  Name  Phone  BorrowedBooks  Fine");
            for (Member mem : this.members){
                System.out.printf("%d  %s  %d  %d  %d\n", mem.getID(),mem.getName(),mem.getPhone(),mem.getBorrow(),mem.getFine());
            }
        }
    }

    public boolean checkMembers(){
        if (this.members.isEmpty()){
            System.out.println("There are no members, try adding some!\n");
            return false;
        }
        else{
            return true;
        }
    }

    public Member validateMember(String name,int phone){
        for (Member mem : this.members) {
            if ((mem.getName().equalsIgnoreCase(name)) && mem.getPhone() == phone) {
                System.out.printf("\nWelcome %s. Member ID:%d\n",name,mem.getID());
                return mem;
            }
        }
        System.out.printf("Member with Name: %s and Phone No: %d doesn't exist.\n",name,phone);
        return null;
    }

    public void removeMember(int id){
        boolean status = this.members.removeIf(mem->mem.getID() == id && mem.getBorrow() == 0);
        if (!status){
            System.out.println("Member not removed, either ID is invalid or member holds any book!\n");
        }
        else{
            this.memberID.add(id);
            System.out.printf("Member Successfully Removed with ID %d!\n\n",id);
        }
    }

    public void addBooks(String title, String author, int copies){
        for (int i=0; i<copies; i++){
            int id;
            if (this.bookID.isEmpty()){
                id = this.books.size()+1;
            }
            else{
                id = this.bookID.get(0);
                this.bookID.remove(0);
            }
            Book book = new Book(title, author, id);
            this.books.add(book);
        }
    }

    public void showBooks(){
        if (this.books.isEmpty()){
            System.out.println("There are no books, try adding some!");
        }
        else{
            for (Book book : this.books) {
                System.out.printf("Book ID- %d (%s)\nTitle- %s\nAuthor- %s\n\n",book.getID(),book.getAvailability(),book.getTitle(),book.getAuthor());
            }
        }
    }

    public void showAvalBooks(){
        if (this.books.isEmpty()){
            System.out.println("There are no books in library!");
        }
        else{
            System.out.println("List of available books in below format:\nBookId  Title  Author");
            for (Book book : this.books) {
                if (book.getAvailability().equals("Available")){
                    System.out.printf("%d  %s  %s\n",book.getID(),book.getTitle(),book.getAuthor());
                }
            }
        }
    }

    public boolean checkBooks(){
        if (this.books.isEmpty()){
            System.out.println("There are no books, try adding some!\n");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean issueBook(Member mem,int id){
        for (Book book : this.books) {
            if (book.getAvailability().equals("Available") && book.getID() == id){
                book.setAvailability(false);
                book.setTime();
                mem.issueBook(book);
                return true;
            }
        }
        System.out.println("Enter valid credentials!\n");
        return false;
    }

    public void retBook(Member mem,int id){
        for (Book book : this.books) {
            if (book.getID() == id && book.getAvailability().equals("Issued")){
                book.setAvailability(true);
                int dur = (int)Duration.between(LocalTime.now(),book.getTime()).abs().toSeconds();
                int fine = mem.calFine(dur);
                mem.retBook(id,fine);
                return;
            }
        }
        System.out.println("Invalid ID, try again!");
    }

    public void removeBook(int id){
        boolean status = this.books.removeIf(book->book.getID() == id && book.getAvailability().equals("Available"));
        if (!status){
            System.out.println("Book not removed, either ID is invalid or book is issued to any member!\n");
        }
        else{
            this.bookID.add(id);
            System.out.printf("Book Successfully Removed with ID %d!\n\n",id);
        }
    }
}