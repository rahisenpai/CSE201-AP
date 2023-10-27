package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Visitor implements VisitorFunctionalities {
    private String name;
    private int age;
    private int phone;
    private float balance;
    private String email;
    private String password;
    private String membership;
    private String feedback;
    private ArrayList<Integer> tickets = new ArrayList<Integer>();

    //constructor
    public Visitor(String name,int age,int phone,int balance,String email,String password){
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membership = null;
        this.feedback = null;
    }

    //compare 2 visitor objects
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && getClass()==obj.getClass()) {
            Visitor a = (Visitor) obj;
            return (this.email.equals(a.getEmail()) && this.password.equals(a.getPassword()));
        }
        return false;
    }

    //visit an attraction
    @Override
    public void visitAttraction(Scanner scanner,Zoo zoo){
        if (!zoo.getAttractions().isEmpty()) {
            System.out.print("\nEnter Attraction ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (zoo.getAttractions().stream().anyMatch(a -> (a.getId() == id && a.getStatus().equalsIgnoreCase("open")))) {
                if (this.membership.equalsIgnoreCase("basic")) {
                    if (this.tickets.contains(id)) {
                        this.tickets.remove((Object) id);
                        System.out.println("1 Ticket Used. Thank you for visiting. Hope you enjoyed the attraction.");
                    } else {
                        System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                    }
                } else {
                    for (Attraction a : zoo.getAttractions()) {
                        if (a.getId() == id && a.getStatus().equalsIgnoreCase("open")) {
                            a.setTickets(a.getTickets() + 1);
                        }
                        break;
                    }
                    System.out.println("Thank you for visiting. Hope you enjoyed the attraction.");
                }
            }
            else{
                System.out.println("Invalid ID");
            }
        }
    }

    //buy tickets for an attraction
    @Override
    public void buyTickets(Scanner scanner,Zoo zoo){
        System.out.print("\nBuy Tickets:\nEnter the number of tickets: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Apply Discount code: ");
        String code = scanner.nextLine();
        float cost, discount = 0;
        if ((!code.equalsIgnoreCase("none")) && (!code.equalsIgnoreCase(""))) {
            for (Discount d : zoo.getDiscounts()) {
                if (d.getCode().equalsIgnoreCase(code)) {
                    if (this.age > d.getLower_age() && d.getUpper_age() > this.age) {
                        discount += d.getDiscount();
                    } else {
                        System.out.println("You are not eligible for the discount code.");
                    }
                    break;
                }
            }
            if (discount == 0) {
                System.out.println("Discount not applied.");
            }
        }

        for (int i=zoo.getDeals().size()-1; i>=0; i--){
            if (zoo.getDeals().get(i).getTickets()<num){
                discount += zoo.getDeals().get(i).getDiscount();
                break;
            }
        }
        System.out.println("you are eligible for a total discount of "+discount+"%.");
        System.out.print("\nBuy Tickets:\nSelect an Attraction to Buy a Ticket:");
        System.out.println("\nID  Name (Price)");
        for (Attraction a : zoo.getAttractions()){
            if (a.getStatus().equalsIgnoreCase("open")){
                System.out.println(a.getId()+"  "+a.getName()+" ("+a.getPrice()+")");
            }
        }
        for (int i=0; i<num; i++){
            System.out.print("\nEnter Attraction ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (zoo.getAttractions().stream().anyMatch(n -> (n.getId() == id))) {
                for (Attraction a : zoo.getAttractions()) {
                    if (a.getId() == id && a.getStatus().equalsIgnoreCase("open")) {
                        cost = a.getPrice() * (1 - (discount / 100));
                        if (this.balance < cost) {
                            System.out.println("\nNot enough balance");
                        } else {
                            this.balance -= cost;
                            zoo.setRevenue((zoo.getRevenue() + cost));
                            this.tickets.add(id);
                            a.setTickets(a.getTickets() + 1);
                            System.out.println("The ticket for " + a.getName() + " was purchased successfully. Your balance is now " + this.balance);
                        }
                        break;
                    }
                }
            }
            else{
                System.out.println("Invalid credentials");
            }
        }
    }

    //visit an animal in zoo
    @Override
    public void visitAnimal(String name, int c, Zoo zoo){
        if (c!=1 && c!=2){
            System.out.println("Invalid choice");
            return;
        }
        for (Animal a : zoo.getAmphibian()){
            if (a.getName().equalsIgnoreCase(name)){
                if (c==1){
                    a.feed();
                } else {
                    a.read();
                }
                return;
            }
        }
        for (Animal a : zoo.getMammal()){
            if (a.getName().equalsIgnoreCase(name)){
                if (c==1){
                    a.feed();
                } else {
                    a.read();
                }
                return;
            }
        }
        for (Animal a : zoo.getReptile()){
            if (a.getName().equalsIgnoreCase(name)){
                if (c==1){
                    a.feed();
                } else {
                    a.read();
                }
                return;
            }
        }
        System.out.println("Invalid Animal name.");
    }

    //buy zoo membership
    @Override
    public void buyMembership(int c,String code, ArrayList<Discount> discounts){
        if (this.membership!=null && this.membership.equalsIgnoreCase("premium")){
            System.out.println("\nYou already have premium membership");
        }
        else {
            float cost, discount = 0;
            if ((!code.equalsIgnoreCase("none")) && (!code.equalsIgnoreCase(""))) {
                for (Discount d : discounts) {
                    if (d.getCode().equalsIgnoreCase(code)) {
                        if (this.age > d.getLower_age() && d.getUpper_age() > this.age) {
                            discount += d.getDiscount();
                        } else {
                            System.out.println("You are not eligible for the discount code.");
                        }
                        break;
                    }
                }
                if (discount == 0) {
                    System.out.println("Discount not applied.");
                }
            }
            if (c == 1) {
                if (this.membership!=null && this.membership.equalsIgnoreCase("basic")){
                    System.out.println("\nYou already have basic membership");
                }
                else {
                    cost = 20 * (1 - (discount / 100));
                    if (this.balance < cost) {
                        System.out.println("\nNot enough balance");
                    } else {
                        this.membership = "basic";
                        this.balance -= cost;
                        System.out.println("\nBasic Membership purchased successfully. Your balance is now " + this.balance);
                    }
                }
            } else if (c == 2) {
                cost = 50 * (1 - (discount / 100));
                if (this.balance < cost) {
                    System.out.println("\nNot enough balance");
                } else {
                    this.membership = "premium";
                    this.balance -= cost;
                    System.out.println("\nPremium Membership purchased successfully. Your balance is now " + this.balance);
                }
            } else {
                System.out.println("\nInvalid input, try again.");
            }
        }
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getMembership() {
        return membership;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public float getBalance() {
        return balance;
    }
}