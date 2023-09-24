package Question_2;

public class Address {
    private String area;
    private String city;
    private String state;
    private int pincode;

    Address(String area, String city, String state, int pincode){
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public int getPincode(){
        return this.pincode;
    }
}