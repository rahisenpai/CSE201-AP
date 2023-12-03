package Question_1;

import java.util.Scanner;

//I have used singleton design pattern for admin instance
//to ensure that only one admin exists to store usernames and passwords
//this further ensures that unique username exists all over the database
//and here database is stored in admin instance

public class Main {
    public static void main(String[] args) {
        Admin admin = Admin.getInstance();
        Scanner sc = new Scanner(System.in);
        admin.addUser("a","1");
        admin.addUser("ab","12");
        admin.addUser("abc","123");
        admin.addUser("abcd","1234");

        System.out.println("welcome");
        while(true){
            try{
                String u,p;
                System.out.print("\nenter username: ");
                u = sc.nextLine();
                //System.out.println(u.equals(null));
                if (u.equals("")){
                    throw new UsernameUnavailableException("username can't be empty");
                }
                if (admin.getUsers().containsKey(u)){
                    throw new UsernameUnavailableException("username already exists");
                }
                System.out.print("enter password: ");
                p = sc.nextLine();
                admin.addUser(u,p);
                System.out.println("\nuser signup successful");
                break;
            }
            catch (UsernameUnavailableException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
