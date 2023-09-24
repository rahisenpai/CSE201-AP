package Question_1;

public class Main {
    public static void main(String[] args){
        //polymorhism
        Rotatable rotator = new Rotator();
        Rotatable flyer = new Flyer();
        Rotatable helicopter1 = new Helicopter();
        Helicopter helicopter = new Helicopter();
        helicopter.drive(rotator);
        helicopter.drive(flyer);
        helicopter.drive(helicopter1);
    }
}