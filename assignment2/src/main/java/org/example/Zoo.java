package org.example;
import java.util.ArrayList;

public class Zoo implements ZooFunctionalities {
    private int attId;
    private float revenue;
    private Admin admin;
    private ArrayList<Animal> mammal;
    private ArrayList<Animal> reptile;
    private ArrayList<Animal> amphibian;
    private ArrayList<Attraction> attractions;
    private ArrayList<Visitor> visitors;
    private ArrayList<Discount> discounts;
    private ArrayList<Deal> deals;

    //construcot
    Zoo(String username, String password){
        this.admin = new Admin(username, password, this);
        this.attId = 1;
        this.visitors = new ArrayList<Visitor>();
        this.attractions = new ArrayList<Attraction>();
        this.amphibian = new ArrayList<Animal>();
        this.mammal = new ArrayList<Animal>();
        this.reptile = new ArrayList<Animal>();
        this.discounts = new ArrayList<Discount>();
        this.deals = new ArrayList<Deal>();
    }

    //view a specific attraction
    public void viewAttraction(int id){
        for (Attraction a : this.attractions){
            if (a.getId() == id){
                System.out.println(a.getDescription());
                return;
            }
        }
        System.out.println("Invalid ID.");
    }

    //add or register visitors
    @Override
    public void addVisitor(String name,int age,int phone,int balance,String email,String password){
        if (email.contains("@") && email.contains(".com")) {
            if (this.visitors.stream().noneMatch(n -> (n.getEmail().equalsIgnoreCase(email)))) {
                this.visitors.add(new Visitor(name, age, phone, balance, email, password));
                System.out.println("\nRegistration is successful.");
            } else {
                System.out.println("2 visitors can't have same emails.");
            }
        }
        else{
            System.out.println("\nEmail must have '@' and '.com'");
        }
    }

    //visitor's login
    @Override
    public Visitor visitorLogin(String email, String passwd){
        for (Visitor v : this.visitors){
            if (v.getEmail().equals(email) && v.getPassword().equals(passwd)){
                System.out.println("\nLogin successful.");
                return v;
            }
        }
        System.out.println("Invalid credentials");
        return null;
    }

    //admin's login
    @Override
    public boolean adminLogin(String name, String passwd){
        Admin a = new Admin(name, passwd, this);
        return this.admin.equals(a);
    }

    //view all zoo attractions
    @Override
    public void viewAttractions() {
        System.out.println();
        if (this.attractions.isEmpty()){
            System.out.println("No attractions exist as of now.");
        }
        else {
            System.out.println("Attractions:\nID  Name  Status");
            for (Attraction a : this.attractions) {
                System.out.println(a);
            }
        }
    }

    //view all zoo animals
    @Override
    public void viewAnimals(){
        System.out.println();
        if (this.amphibian.isEmpty() && this.mammal.isEmpty() && this.reptile.isEmpty()){
            System.out.println("No animals in zoo as of now.");
        }
        else {
            System.out.print("Type: Animals\nAmphibians: ");
            for (Animal a : this.amphibian) {
                System.out.print(a.getName()+"  ");
            }
            System.out.print("\nMammals: ");
            for (Animal a : this.mammal) {
                System.out.print(a.getName()+"  ");
            }
            System.out.print("\nReptiles: ");
            for (Animal a : this.reptile) {
                System.out.print(a.getName()+"  ");
            }
            System.out.println();
        }
    }

    //view all discounts
    @Override
    public void viewDiscounts(){
        System.out.println();
        if (this.discounts.isEmpty()){
            System.out.println("No discounts exist as of now.");
        }
        else {
            System.out.println("Special Discounts (Code  Name):");
            for (Discount d : this.discounts) {
                System.out.println(d);
            }
        }
    }

    //view all deals
    @Override
    public void viewDeals(){
        System.out.println();
        if (this.deals.isEmpty()){
            System.out.println("No deals exist as of now.");
        }
        else {
            System.out.println("Special Deals:");
            for (Deal d : this.deals) {
                System.out.println(d);
            }
        }
    }

    public void setAttId(int attId) {
        this.attId = attId;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public float getRevenue() {
        return revenue;
    }

    public Admin getAdmin() {
        return admin;
    }

    public int getAttId() {
        return attId;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public ArrayList<Animal> getMammal() {
        return mammal;
    }

    public ArrayList<Animal> getReptile() {
        return reptile;
    }

    public ArrayList<Animal> getAmphibian() {
            return amphibian;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public ArrayList<Deal> getDeals() {
        return deals;
    }
}