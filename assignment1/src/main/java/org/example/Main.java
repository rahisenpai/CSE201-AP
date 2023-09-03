package org.example;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian();
        System.out.println("\nLibrary Portal Initialized...");
        int choice, choice1, choice2;

        while (true){
            System.out.println("""
                    ---------------------------------
                    1. Enter as a librarian
                    2. Enter as a member
                    3. Exit
                    ---------------------------------""");
            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input, you are supposed to use numbers!\n");
                scanner.nextLine();
                continue;
            }


            if (choice == 1){
                while (true){
                    System.out.println("""
                    ---------------------------------
                    1. Register a member
                    2. Remove a member
                    3. Add a book
                    4. Remove a book
                    5. View all members along with their books and fines to be paid
                    6. View all books
                    7. Back
                    ---------------------------------""");
                    try{
                        choice1 = scanner.nextInt();
                        scanner.nextLine();
                    }
                    catch(InputMismatchException ex){
                        System.out.println("Invalid input, you are supposed to use numbers!\n");
                        scanner.nextLine();
                        continue;
                    }

                    if (choice1 == 1){
                        System.out.print("---------------------------------\nName: ");
                        String name = scanner.nextLine();
                        int age,phone,id;
                        System.out.print("Age: ");
                        try{
                            age = scanner.nextInt();
                            scanner.nextLine();
                        }
                        catch(InputMismatchException ex){
                            System.out.println("Age can only have numbers, try again!\n");
                            scanner.nextLine();
                            continue;
                        }
                        if (age<1){
                            System.out.println("Age can't be less than 1, try again!\n");
                            continue;
                        }
                        System.out.print("Phone no (don't add any country code or 0): ");
                        try{
                            phone = scanner.nextInt();
                            scanner.nextLine();
                        }
                        catch(InputMismatchException ex){
                            System.out.println("Phone no can only have numbers, try again!\n");
                            scanner.nextLine();
                            continue;
                        }
                        if (phone<1){
                            System.out.println("Phone no can't be less than 1, try again!\n");
                            continue;
                        }
                        id = librarian.addMember(name,age,phone);
                        System.out.println("---------------------------------");
                        if (id == -1){
                            System.out.println("This phone no is already registered, try again with other no!\n");
                        }
                        else{
                            System.out.printf("Member Successfully Registered with id %d!\n\n",id);
                        }
                    }

                    else if (choice1 == 2){
                        boolean memcheck = librarian.checkMembers();
                        if (memcheck){
                            int id;
                            System.out.print("---------------------------------\nEnter member ID to remove:");
                            try{
                                id = scanner.nextInt();
                                scanner.nextLine();
                            }
                            catch(InputMismatchException ex){
                                System.out.println("Enter valid id (i.e. number), try again!\n");
                                scanner.nextLine();
                                continue;
                            }
                            System.out.println("---------------------------------");
                            librarian.removeMember(id);
                        }
                    }

                    else if (choice1 == 3){
                        System.out.print("---------------------------------\nBook title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        int copies;
                        System.out.print("Copies: ");
                        try{
                            copies = scanner.nextInt();
                            scanner.nextLine();
                        }
                        catch(InputMismatchException ex){
                            System.out.println("Copies can only have numbers, try again!\n");
                            scanner.nextLine();
                            continue;
                        }
                        if (copies<1){
                            System.out.println("Copies can't be less than 1, try again!\n");
                            continue;
                        }
                        librarian.addBooks(title,author,copies);
                        System.out.println("---------------------------------\nBook(s) Added Successfully!\n");
                    }

                    else if (choice1 == 4){
                        boolean bookcheck = librarian.checkBooks();
                        if (bookcheck){
                            int id;
                            System.out.print("---------------------------------\nEnter book ID to remove:");
                            try{
                                id = scanner.nextInt();
                                scanner.nextLine();
                            }
                            catch(InputMismatchException ex){
                                System.out.println("Enter valid id (i.e. number), try again!\n");
                                scanner.nextLine();
                                continue;
                            }
                            System.out.println("---------------------------------");
                            librarian.removeBook(id);
                        }
                    }

                    else if (choice1 == 5){
                        System.out.println("---------------------------------");
                        librarian.showMembers();
                        System.out.println("---------------------------------");
                    }
                    else if (choice1 == 6){
                        System.out.println("---------------------------------");
                        librarian.showBooks();
                        System.out.println("---------------------------------");
                    }
                    else if (choice1 == 7){
                        System.out.println("""
                        ---------------------------------
                        Exiting as librarian
                        ---------------------------------""");
                        break;
                    }
                    else{
                        System.out.println("Invalid input, try again with a valid number!\n");
                    }
                }
            }


            else if (choice == 2){
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Phone no: ");
                int phone;
                try{
                    phone = scanner.nextInt();
                    scanner.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("Phone no can only have numbers, try again!\n");
                    scanner.nextLine();
                    continue;
                }
                Member member = librarian.validateMember(name,phone);
                if (member != null){
                    while (true){
                        System.out.println("""
                    ---------------------------------
                    1. List Available Books
                    2. List My Books
                    3. Issue book
                    4. Return book
                    5. Pay Fine
                    6. Back
                    ---------------------------------""");
                        try{
                            choice2 = scanner.nextInt();
                            scanner.nextLine();
                        }
                        catch(InputMismatchException ex){
                            System.out.println("Invalid input, you are supposed to use numbers!\n");
                            scanner.nextLine();
                            continue;
                        }

                        if (choice2 == 1){
                            System.out.println("---------------------------------");
                            librarian.showAvalBooks();
                            System.out.println("---------------------------------");
                        }

                        else if (choice2 == 2){
                            System.out.println("---------------------------------");
                            member.showBooks();
                            System.out.println("---------------------------------");
                        }

                        else if (choice2 == 3){
                            if (member.getBorrow()<2){
                                if (member.getFine()==0){
                                    System.out.print("---------------------------------\nBook ID: ");
                                    int id;
                                    try{
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                    }
                                    catch(InputMismatchException ex){
                                        System.out.println("Invalid input, you are supposed to use numbers!\n");
                                        scanner.nextLine();
                                        continue;
                                    }
                                    boolean issuecheck = librarian.issueBook(member,id);
                                    if (issuecheck){
                                        System.out.println("---------------------------------\nBook Issued Successfully!");
                                    }
                                }
                                else{
                                    System.out.println("You have a fine due, pay it before issuing another.\n");
                                }
                            }
                            else{
                                System.out.println("You are already holding 2 books(maximum allowed).\n");
                            }
                        }

                        else if (choice2 == 4){
                            if (member.getBorrow()>0){
                                int id;
                                System.out.print("---------------------------------\nEnter Book ID: ");
                                try{
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                catch(InputMismatchException ex){
                                    System.out.println("Enter valid id (i.e. number), try again!\n");
                                    scanner.nextLine();
                                    continue;
                                }
                                System.out.println("---------------------------------");
                                librarian.retBook(member,id);
                            }
                            else{
                                System.out.println("You have not issued any book!\n");
                            }
                        }

                        else if (choice2 == 5){
                            System.out.println("---------------------------------");
                            member.retFine();
                            System.out.println("---------------------------------");
                        }

                        else if (choice2 == 6){
                            System.out.println("""
                        ---------------------------------
                        Exiting as member
                        ---------------------------------""");
                            break;
                        }
                        else{
                            System.out.println("Invalid input, try again with a valid number!\n");
                        }
                    }
                }
            }


            else if (choice == 3){
                System.out.println("""
                ---------------------------------
                Thanks for visiting!
                ---------------------------------""");
                break;
            }
            else{
                System.out.println("Invalid input, try again with a valid number!\n");
            }
        }
        scanner.close();
    }
}