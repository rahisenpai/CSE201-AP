package Question_2;

import java.util.ArrayList;

public class PetOwner {
    String name;
    private ArrayList<Dog> pets;
    PetOwner(String name){
        this.name = name;
        this.pets = new ArrayList<Dog>();
    }

    public void addPet(Dog p){
        this.pets.add(p);
    }

    public ArrayList<Dog> getPets() {
        return pets;
    }
    public void setPets(ArrayList<Dog> pets) {
        this.pets = pets;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
