package Question_2;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int id;
    private Address address;

    Person(String firstName, String lastName, int id, String area, String city, String state, int pincode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        address = new Address(area, city, state, pincode);
    }

    public Address getAddress(){
        return this.address;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    abstract public void goToWork();
}