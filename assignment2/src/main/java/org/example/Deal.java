package org.example;

public class Deal {
    private int tickets;
    private int discount;

    Deal(int tickets, int discount){
        this.tickets = tickets;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Buy more than "+this.tickets+" attraction ticket(s) and get a special discount of "+this.discount+"% on the total amount";
    }

    public int getDiscount() {
        return discount;
    }

    public int getTickets() {
        return tickets;
    }
}