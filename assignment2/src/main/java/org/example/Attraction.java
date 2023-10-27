package org.example;

public class Attraction {
    private String name;
    private String description;
    private int id;
    private int price;
    private int tickets;
    private String status;

    Attraction(String name, String desc, int id){
        this.name=name;
        this.description = desc;
        this.id = id;
        this.tickets = 0;
        this.status = "closed";
    }

    @Override
    public String toString() {
        return this.id+"  "+this.name+" "+this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public int getTickets() {
        return tickets;
    }

    public int getPrice() {
        return price;
    }
}