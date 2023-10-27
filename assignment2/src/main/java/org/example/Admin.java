package org.example;
import java.util.Comparator;

public class Admin implements AdminFunctionalities {
    private String username;
    private String password;
    private Zoo zoo;

    //constructor
    Admin(String username, String password, Zoo zoo){
        this.username = username;
        this.password = password;
        this.zoo = zoo;
    }

    //compare 2 admin objects
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && getClass()==obj.getClass()) {
            Admin a = (Admin) obj;
            return (this.username.equals(a.getUsername()) && this.password.equals(a.getPassword()));
        }
        return false;
    }

    //schedule an attraction
    @Override
    public void scheduleEvent(int id,String status,int price){
        for (Attraction a : this.zoo.getAttractions()){
            if (a.getId() == id){
                a.setPrice(price);
                a.setStatus(status);
                return;
            }
        }
        System.out.println("Attraction ID doesn't exist.\n");
    }

    //read visitor's feedback
    @Override
    public void viewFeedback(){
        for (Visitor v : this.zoo.getVisitors()){
            if (v.getFeedback()!=null){
                System.out.println(v.getName()+"'s feedback:\n"+v.getFeedback()+"\n");
            }
        }
        System.out.println();
    }

    //view zoo statistics
    @Override
    public void viewStats(){
        System.out.print("\nVisitor Statistics:\n- Total Visitors: "+this.zoo.getVisitors().size()+"\n- Total Revenue: "+this.zoo.getRevenue()+"\n- Most Popular Attraction: ");
        this.zoo.getAttractions().sort(Comparator.comparing(Attraction::getTickets));
        if (!this.zoo.getAttractions().isEmpty()) {
            System.out.print(this.zoo.getAttractions().get(this.zoo.getAttractions().size() - 1).getName());
        }
        System.out.println("\n");
    }

    //add a special deal
    @Override
    public void addDeal(int tickets, int discount){
        if (tickets>0 && discount>0 && discount<=100) {
            this.zoo.getDeals().add(new Deal(tickets, discount));
            this.zoo.getDeals().sort(Comparator.comparing(Deal::getTickets));
            System.out.println("Deal added successfully.");
        }
        else{
            System.out.println("Invalid details");
        }
    }

    //remove a special deal
    @Override
    public boolean removeDeal(int tickets, int discount){
        return this.zoo.getDeals().removeIf(a -> a.getTickets()==tickets && a.getDiscount()==discount);
    }

    //remove a discount
    @Override
    public boolean removeDiscount(String code){
        return this.zoo.getDiscounts().removeIf(a -> a.getCode().equalsIgnoreCase(code));
    }

    //add a discount
    @Override
    public void addDiscount(String category,int discount,int lage,int uage,String code){
        if (this.zoo.getDiscounts().stream().noneMatch(n -> (n.getCode().equalsIgnoreCase(code)))) {
            if (discount<1 || discount>100) {
                System.out.println("Invalid discount percentage");
                return;
            }
            if (lage < 0 || uage < 1 || lage > uage) {
                System.out.println("Invalid age parameters");
                return;
            }
            this.zoo.getDiscounts().add(new Discount(category, discount, lage, uage, code));
            System.out.println("Discount added successfully.");
        }
        else{
            System.out.println("2 discounts cannot have same codes.");
        }
    }

    //remove a animal from zoo
    @Override
    public void removeAnimal(String name){
        if (this.zoo.getAmphibian().size()>2){
            if (this.zoo.getAmphibian().removeIf(a -> a.getName().equalsIgnoreCase(name))){
                System.out.println("Animal removed successfully.");
            }
        }
        else if (this.zoo.getMammal().size()>2){
            if (this.zoo.getMammal().removeIf(a -> a.getName().equalsIgnoreCase(name))){
                System.out.println("Animal removed successfully.");
            }
        }
        else if (this.zoo.getReptile().size()>2){
            if (this.zoo.getReptile().removeIf(a -> a.getName().equalsIgnoreCase(name))){
                System.out.println("Animal removed successfully.");
            }
        }
        else{
            System.out.println("Animal not removed.\nEither name is invalid or only 2 animals of its type are there in zoo.");
        }
    }

    //update animal details
    @Override
    public void updateAnimal(String name, String sound, String history){
        if (this.zoo.getAmphibian().removeIf(a -> a.getName().equalsIgnoreCase(name))){
            Animal a = new Amphibian(name,sound,history);
            this.zoo.getAmphibian().add(a);
            System.out.println("Animal updated successfully.");
        }
        else if (this.zoo.getMammal().removeIf(a -> a.getName().equalsIgnoreCase(name))){
            Animal a = new Mammal(name,sound,history);
            this.zoo.getMammal().add(a);
            System.out.println("Animal updated successfully.");
        }
        else if (this.zoo.getReptile().removeIf(a -> a.getName().equalsIgnoreCase(name))){
            Animal a = new Reptile(name,sound,history);
            this.zoo.getReptile().add(a);
            System.out.println("Animal updated successfully.");
        }
        else{
            System.out.println("Invalid animal name.");
        }
    }

    //add animals to zoo
    @Override
    public void addAnimal(String name, String type, String sound, String history){
        if (type.equalsIgnoreCase("a") || type.equalsIgnoreCase("amphibian") || type.equalsIgnoreCase("amphibians")){
            Animal a = new Amphibian(name,sound,history);
            this.zoo.getAmphibian().add(a);
            System.out.println("Animal added to Zoo.");
        }
        else if (type.equalsIgnoreCase("m") || type.equalsIgnoreCase("mammal") || type.equalsIgnoreCase("mammals")){
            Animal a = new Mammal(name,sound,history);
            this.zoo.getMammal().add(a);
            System.out.println("Animal added to Zoo.");
        }
        else if (type.equalsIgnoreCase("r") || type.equalsIgnoreCase("reptile") || type.equalsIgnoreCase("reptiles")){
            Animal a = new Reptile(name,sound,history);
            this.zoo.getReptile().add(a);
            System.out.println("Animal added to Zoo.");
        }
        else{
            System.out.println("The type can only be amphibian(a), mammal(m) or reptile(r).");
        }
    }

    //add attraction to zoo
    @Override
    public void addAttraction(String name, String desc, int id){
        this.zoo.getAttractions().add(new Attraction(name, desc, id));
    }

    //remove attractions from zoo
    @Override
    public boolean removeAttraction(int id){
        return this.zoo.getAttractions().removeIf(a -> a.getId() == id);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}