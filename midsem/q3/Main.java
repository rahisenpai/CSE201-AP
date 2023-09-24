package Question_3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean done=false, check = true;
        while(!done){
            check=true;
            try{
                System.out.print("enter pin: ");
                String input = scanner.nextLine();
                try{
                    int pin = Integer.parseInt(input);
                }
                catch (NumberFormatException e){
                    System.out.println("pin can only have numbers.");
                }
                if (input.length() != 6){
                    check = false;
                    throw new IncorrectPincodeException("pin can only has 6 numbers");
                }
                if (input.charAt(0) == '0'){
                    check = false;
                    throw new IncorrectPincodeException("pin's 1st number can't be 0");
                }
                if (check){
                    done = true;
                }
                
            }
            catch (IncorrectPincodeException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("valid pin detected\n");
        scanner.close();
    }
}