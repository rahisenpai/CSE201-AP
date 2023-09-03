package org.example;
import java.time.LocalTime;

public class Book {
    private String title;
    private String author;
    private boolean availability;
    private int id;
    private LocalTime issueTime;

    Book(String title, String author, int id){
        this.title = title;
        this.author = author;
        this.availability = true;
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public int getID(){
        return this.id;
    }
    public String getAvailability(){
        if(this.availability){
            return "Available";
        }
        else{
            return "Issued";
        }
    }
    public LocalTime getTime(){
        return this.issueTime;
    }

    public void setAvailability(boolean x){
        this.availability = x;
    }

    public void setTime(){
        issueTime = LocalTime.now();
    }
}