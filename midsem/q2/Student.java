package Question_2;

public class Student extends Person{
    private double CGPA;
    private int startYear;
    private String residentialStatus;

    private int distance;
    private double hostel;

    public void calcDist(int pin){
        this.distance = (pin>this.getAddress().getPincode()) ? pin-this.getAddress().getPincode() : this.getAddress().getPincode()-pin;
        hostel = this.distance - 6*this.CGPA;
    }

    Student(String firstName, String lastName, int id, String area, String city, String state, int pincode, double cg, int start, String status){
        super(firstName, lastName, id, area, city, state, pincode);
        this.CGPA = cg;
        this.startYear = start;
        this.residentialStatus = status;
    }

    public String toString(){
        return this.getName();
    }

    public double getCGPA(){
        return this.CGPA;
    }

    public String getStatus(){
        return this.residentialStatus;
    }

    public double getHostel(){
        return this.hostel;
    }

    public double getDist(){
        return this.distance;
    }

    public void setStatus(String status){
        this.residentialStatus = status;
    }

    public void goToWork(){
        if (this.residentialStatus.equals("onCampus")){
            System.out.println("walk");
        }
        else{
            System.out.println("vehicle");
        }
    }
}
