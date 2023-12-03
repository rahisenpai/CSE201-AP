package Question_2;

//i have declared extra variables in dog and petowner class to establish association relationship and ensure multiplicities
//this is allowed as per Koteshwar Sir (AP section-B prof)
//an arraylist of Dog in PetOwner allows a petowner to own multiple dogs
//and a variable of PetOwner in Dog allows dog to have a single master

public class Main {
    public static void main(String[] args) {
        PetOwner p = new PetOwner("p1");

        Dog d = new Dog(p); p.addPet(d);
        d.setName("dog");

        Dog d1 = new Dog(p); p.addPet(d1);
        d1.setName("dog1");

        PetOwner p2 = new PetOwner("p2");
        Dog d2 = new Dog(p2); p2.addPet(d2);
        d2.setName("dog2");

        d.feedMe();
        d1.feedMe();
        d2.feedMe();

        System.out.println(d.getOwner().getClass());
        System.out.println(p.getPets().get(0).getClass());
        System.out.println("\npetowner p has "+p.getPets().size()+" pets");
        System.out.println("owner of dog is "+d.getOwner().getName());
        System.out.println("owner of dog1 is "+d1.getOwner().getName());

        System.out.println("\npetowner p2 has "+p2.getPets().size()+" pets");
        System.out.println("owner of dog2 is "+d2.getOwner().getName());
    }
}
