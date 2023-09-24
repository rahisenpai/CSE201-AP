package Question_1;

public class Helicopter implements RotateAndFly{
    public void rotate(){
        System.out.println("rotate method in helicopter");
    }
    public void fly(){
        System.out.println("fly method in helicopter");
    }
    public void drive(Rotatable r){
        System.out.print("The type of argument is ");
        System.out.println(r.getClass());
    }
}
