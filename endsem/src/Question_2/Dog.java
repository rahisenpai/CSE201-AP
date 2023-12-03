package Question_2;

public class Dog extends Mammal{
    private PetOwner owner;
    Dog(PetOwner p){
        this.owner = p;
    }
    public void takeForWalk(){
        System.out.println("take dog for a walk");
    }

    public PetOwner getOwner() {
        return owner;
    }
    public void setOwner(PetOwner owner) {
        this.owner = owner;
    }
}
