package org.example;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id, choice, choice1, choice11, choice12, choice14, choice15, choice20, choice2, choice21;
        Zoo zoo = new Zoo("admin", "admin123");
        Admin admin = zoo.getAdmin();

        //hard-coding some information to ease evaluation
//        id = zoo.getAttId();
//        admin.addAttraction("Jungle Safari", "A thrilling adventure in the jungle.", id);
//        zoo.setAttId(++id);
//        id = zoo.getAttId();
//        admin.addAttraction("Botanical Garden", "A garden surrounded by amazing plants and trees.", id);
//        zoo.setAttId(++id);
//        admin.scheduleEvent(1,"open",10);
//        admin.scheduleEvent(2,"open",15);
        admin.addAnimal("frog", "a", "croak", "Frogs have protruding eyes, no tail, and strong, webbed hind feet that are adapted for leaping and swimming.");
        admin.addAnimal("salamander", "a", "hiss", "Salamanders are a type of amphibian; they have moist skin and are usually found in damp habitats near or in water.");
        admin.addAnimal("lion", "m", "roar", "Lions have strong, compact bodies and powerful forelegs, teeth and jaws for pulling down and killing prey.");
        admin.addAnimal("tiger", "m", "growl", "Tigers are powerful hunters with sharp teeth, strong jaws and agile bodies.");
        admin.addAnimal("crocodile", "r", "grunt", "Crocodiles are grayish-green and prefer coastal, brackish and salt-water habitats.");
        admin.addAnimal("lizard", "r", "gecko", "Lizards are scaly-skinned reptiles that are usually distinguished from snakes by the possession of legs, movable eyelids, and external ear openings.");
        admin.addDiscount("minors", 10, 0, 18, "MINOR18");
        admin.addDiscount("seniors", 20, 60, 123, "SENIOR60");
        admin.addDeal(2, 15);
        admin.addDeal(3, 30);
//        zoo.addVisitor("alice", 32, 1234, 100, "alice@email.com", "pass123");

        System.out.println("\n\nWelcome to ZOOtopia!");
        while (true) {
            try {
                System.out.println("""
                                            
                        1. Enter as Admin
                        2. Enter as a Visitor
                        3. View Special Deals
                        4. Exit
                        """);
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                //admin login and functionalities
                if (choice == 1) {
                    System.out.print("\nEnter Admin Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String password = scanner.nextLine();
                    if (zoo.adminLogin(username, password)) {
                        System.out.println("\nLogged in as Admin.\n");
                        while (true) {
                            System.out.println("""
                                    Admin Menu:
                                    1. Manage Attractions
                                    2. Manage Animals
                                    3. Schedule Events
                                    4. Set Discounts
                                    5. Set Special Deal
                                    6. View Visitor Stats
                                    7. View Feedback
                                    8. Exit
                                    """);
                            System.out.print("Enter your choice: ");
                            choice1 = scanner.nextInt();
                            scanner.nextLine();

                            //attractions menu
                            if (choice1 == 1) {
                                while (true) {
                                    System.out.println("""
                                                                                    
                                            Manage Attractions:
                                            1. Add Attraction
                                            2. View Attractions
                                            3. Modify Attraction
                                            4. Remove Attraction
                                            5. Exit
                                            """);
                                    System.out.print("Enter your choice: ");
                                    choice11 = scanner.nextInt();
                                    scanner.nextLine();

                                    if (choice11 == 1) {
                                        System.out.print("\nEnter Attraction Name: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter Attraction Description: ");
                                        String desc = scanner.nextLine();
                                        id = zoo.getAttId();
                                        admin.addAttraction(name, desc, id);
                                        zoo.setAttId(++id);
                                        System.out.println("Attraction added successfully.");
                                    } else if (choice11 == 2) {
                                        zoo.viewAttractions();
                                    } else if (choice11 == 3) {
                                        if (!zoo.getAttractions().isEmpty()) {
                                            System.out.print("\nEnter Attraction ID to be updated: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            if (admin.removeAttraction(id)) {
                                                System.out.print("Enter new Attraction name: ");
                                                String name = scanner.nextLine();
                                                System.out.print("Enter new Attraction description: ");
                                                String desc = scanner.nextLine();
                                                admin.addAttraction(name, desc, id);
                                                System.out.println("Attraction updated successfully.");
                                            } else {
                                                System.out.println("Attraction ID doesn't exist.");
                                            }
                                        } else {
                                            System.out.println("No Attractions exist as of now.");
                                        }
                                    } else if (choice11 == 4) {
                                        if (!zoo.getAttractions().isEmpty()) {
                                            System.out.print("\nEnter Attraction ID to be removed: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            if (admin.removeAttraction(id)) {
                                                System.out.println("Attraction removed successfully.");
                                            } else {
                                                System.out.println("Attraction ID doesn't exist.");
                                            }
                                        } else {
                                            System.out.println("No Attractions exist as of now.");
                                        }
                                    } else if (choice11 == 5) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input, try again with a valid number!");
                                    }
                                }
                            }

                            //animals menu
                            else if (choice1 == 2) {
                                while (true) {
                                    System.out.println("""
                                                                                    
                                            Manage Animals:
                                            1. Add Animal
                                            2. View Animals
                                            3. Update Animal Details
                                            4. Remove Animal
                                            5. Exit
                                            """);
                                    System.out.print("Enter your choice: ");
                                    choice12 = scanner.nextInt();
                                    scanner.nextLine();

                                    if (choice12 == 1) {
                                        System.out.print("\nEnter Animal Name: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter Animal Type: ");
                                        String type = scanner.nextLine();
                                        System.out.print("Enter Animal Sound: ");
                                        String sound = scanner.nextLine();
                                        System.out.print("Enter Animal's history: ");
                                        String history = scanner.nextLine();
                                        admin.addAnimal(name, type, sound, history);
                                    } else if (choice12 == 2) {
                                        zoo.viewAnimals();
                                    } else if (choice12 == 3) {
                                        System.out.print("\nEnter Animal Name to be updated: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter new Animal Sound: ");
                                        String sound = scanner.nextLine();
                                        System.out.print("Enter new Animal's history: ");
                                        String history = scanner.nextLine();
                                        admin.updateAnimal(name, sound, history);
                                    } else if (choice12 == 4) {
                                        System.out.print("\nEnter Animal Name to be removed: ");
                                        String name = scanner.nextLine();
                                        admin.removeAnimal(name);
                                    } else if (choice12 == 5) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input, try again with a valid number!");
                                    }
                                }
                            }

                            //schedule events
                            else if (choice1 == 3) {
                                zoo.viewAttractions();
                                if (!zoo.getAttractions().isEmpty()) {
                                    System.out.print("\nEnter Attraction ID to be scheduled: ");
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Enter Status (open/closed): ");
                                    String status = scanner.nextLine();
                                    System.out.print("Enter price for ticket: ");
                                    int price = scanner.nextInt();
                                    scanner.nextLine();
                                    admin.scheduleEvent(id, status, price);
                                }
                                System.out.println();
                            }

                            //discount menu
                            else if (choice1 == 4) {
                                while (true) {
                                    System.out.println("""
                                                                                    
                                            Set Discounts:
                                            1. Add Discount
                                            2. View Discounts
                                            3. Modify Discount
                                            4. Remove Discount
                                            5. Exit
                                            """);
                                    System.out.print("Enter your choice: ");
                                    choice14 = scanner.nextInt();
                                    scanner.nextLine();

                                    if (choice14 == 1) {
                                        System.out.print("\nEnter Discount Category: ");
                                        String category = scanner.nextLine();
                                        System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                        int discount = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter min age: ");
                                        int lage = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter max age: ");
                                        int uage = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("\nEnter Discount code: ");
                                        String code = scanner.nextLine();
                                        admin.addDiscount(category, discount, lage, uage, code);
                                    } else if (choice14 == 2) {
                                        zoo.viewDiscounts();
                                    } else if (choice14 == 3) {
                                        if (!zoo.getDiscounts().isEmpty()) {
                                            System.out.print("\nEnter discount code to be updated: ");
                                            String code = scanner.nextLine();
                                            if (admin.removeDiscount(code)) {
                                                System.out.print("\nEnter new Discount Category: ");
                                                String category = scanner.nextLine();
                                                System.out.print("Enter new Discount Percentage (e.g., 20 for 20%): ");
                                                int discount = scanner.nextInt();
                                                scanner.nextLine();
                                                System.out.print("Enter new min age: ");
                                                int lage = scanner.nextInt();
                                                scanner.nextLine();
                                                System.out.print("Enter new max age: ");
                                                int uage = scanner.nextInt();
                                                scanner.nextLine();
                                                admin.addDiscount(category, discount, lage, uage, code);
                                            } else {
                                                System.out.println("Discount code doesn't exist.");
                                            }
                                        } else {
                                            System.out.println("No discount as of now.");
                                        }
                                    } else if (choice14 == 4) {
                                        if (!zoo.getDiscounts().isEmpty()) {
                                            System.out.print("\nEnter discount code to be removed: ");
                                            String code = scanner.nextLine();
                                            if (admin.removeDiscount(code)) {
                                                System.out.println("Discount removed successfully.");
                                            } else {
                                                System.out.println("Discount code doesn't exist.");
                                            }
                                        } else {
                                            System.out.println("No discount as of now.");
                                        }
                                    } else if (choice14 == 5) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input, try again with a valid number!");
                                    }
                                }
                            }

                            //deal menu
                            else if (choice1 == 5) {
                                while (true) {
                                    System.out.println("""
                                                                                    
                                            Set Special Deal:
                                            1. Add Deal
                                            2. View Deals
                                            3. Remove Deal
                                            4. Exit
                                            """);
                                    System.out.print("Enter your choice: ");
                                    choice15 = scanner.nextInt();
                                    scanner.nextLine();

                                    if (choice15 == 1) {
                                        System.out.print("\nEnter min number of tickets: ");
                                        int tickets = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                        int discount = scanner.nextInt();
                                        scanner.nextLine();
                                        admin.addDeal(tickets, discount);
                                    } else if (choice15 == 2) {
                                        zoo.viewDeals();
                                    } else if (choice15 == 3) {
                                        if (!zoo.getDeals().isEmpty()) {
                                            System.out.print("\nEnter min number of tickets: ");
                                            int tickets = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                            int discount = scanner.nextInt();
                                            scanner.nextLine();
                                            if (admin.removeDeal(tickets, discount)) {
                                                System.out.println("Deal removed successfully.");
                                            } else {
                                                System.out.println("Invalid deal credentials.");
                                            }
                                        } else {
                                            System.out.println("No deal as of now.");
                                        }
                                    } else if (choice15 == 4) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input, try again with a valid number!");
                                    }
                                }
                            }

                            //view stats
                            else if (choice1 == 6) {
                                admin.viewStats();
                            }

                            //read feedback
                            else if (choice1 == 7) {
                                admin.viewFeedback();
                            } else if (choice1 == 8) {
                                System.out.println("\nLogged out.\n");
                                break;
                            } else {
                                System.out.println("Invalid input, try again with a valid number!\n");
                            }
                        }
                    } else {
                        System.out.println("\nIncorrect credentials. Login failed.");
                    }
                }

                //visitor login/signup and functionalities
                else if (choice == 2) {
                    while (true) {
                        System.out.print("\n1. Register\n2. Login\n3. Exit\n\nEnter your choice: ");
                        choice20 = scanner.nextInt();
                        scanner.nextLine();

                        //register menu
                        if (choice20 == 1) {
                            System.out.print("\nEnter Visitor Name:");
                            String name = scanner.nextLine();
                            System.out.print("Enter Visitor Age:");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Visitor Phone Number:");
                            int phone = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Visitor Balance:");
                            int balance = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Visitor Email:");
                            String email = scanner.nextLine();
                            System.out.print("Enter Visitor Password:");
                            String password = scanner.nextLine();
                            zoo.addVisitor(name, age, phone, balance, email, password);
                        }

                        //login menu
                        else if (choice20 == 2) {
                            System.out.print("\nEnter Visitor Email:");
                            String email = scanner.nextLine();
                            System.out.print("Enter Visitor Password:");
                            String password = scanner.nextLine();
                            Visitor visitor = zoo.visitorLogin(email, password);
                            if (visitor != null) {
                                float prev_bal, curr_bal;
                                while (true) {
                                    System.out.println("""
                                                                                    
                                            Visitor Menu:
                                            1. Explore the Zoo
                                            2. Buy Membership
                                            3. Buy Tickets
                                            4. View Discounts
                                            5. View Special Deals
                                            6. Visit Animals
                                            7. Visit Attractions
                                            8. Leave Feedback
                                            9. Log Out
                                            """);
                                    System.out.print("Enter your choice: ");
                                    choice2 = scanner.nextInt();
                                    scanner.nextLine();

                                    //explore zoo
                                    if (choice2 == 1) {
                                        while (true) {
                                            System.out.println("""
                                                                                            
                                                    Visitor Menu:
                                                    1. View Attractions
                                                    2. View Animals
                                                    3. Exit
                                                    """);
                                            System.out.print("Enter your choice: ");
                                            choice21 = scanner.nextInt();
                                            scanner.nextLine();

                                            if (choice21 == 1) {
                                                zoo.viewAttractions();
                                                System.out.print("\nEnter Attraction ID: ");
                                                id = scanner.nextInt();
                                                scanner.nextLine();
                                                zoo.viewAttraction(id);
                                            } else if (choice21 == 2) {
                                                zoo.viewAnimals();
                                            } else if (choice21 == 3) {
                                                break;
                                            }
                                        }
                                    }

                                    //buy membership
                                    else if (choice2 == 2) {
                                        System.out.print("\nBuy Membership:\n1. Basic Membership (20)\n2. Premium Membership (50)\nEnter your choice: ");
                                        int c = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Apply Discount code: ");
                                        String code = scanner.nextLine();
                                        prev_bal = visitor.getBalance();
                                        visitor.buyMembership(c, code, zoo.getDiscounts());
                                        curr_bal = visitor.getBalance();
                                        zoo.setRevenue((zoo.getRevenue() + prev_bal - curr_bal));
                                    }

                                    //buy tickets
                                    else if (choice2 == 3) {
                                        if (!zoo.getAttractions().isEmpty()) {
                                            if (visitor.getMembership() != null) {
                                                if (visitor.getMembership().equalsIgnoreCase("premium")) {
                                                    System.out.println("Premium members don't need to buy tickets.");
                                                } else {
                                                    visitor.buyTickets(scanner, zoo);
                                                }
                                            } else {
                                                System.out.println("You need a membership to visit animals.");
                                            }
                                        }
                                        else{
                                            System.out.println("No attractions exist as of now.");
                                        }
                                    }

                                    //view discounts
                                    else if (choice2 == 4) {
                                        zoo.viewDiscounts();
                                    }

                                    //view deals
                                    else if (choice2 == 5) {
                                        zoo.viewDeals();
                                    }

                                    //visit animals
                                    else if (choice2 == 6) {
                                        zoo.viewAnimals();
                                        if (visitor.getMembership() != null) {
                                            System.out.print("\nEnter Animal name: ");
                                            String name = scanner.nextLine();
                                            System.out.println("1. Feed\n2. Read");
                                            System.out.print("Enter your choice: ");
                                            int c = scanner.nextInt();
                                            scanner.nextLine();
                                            visitor.visitAnimal(name, c, zoo);
                                        } else {
                                            System.out.println("You need a membership to visit animals.");
                                        }
                                    }

                                    //visit attractions
                                    else if (choice2 == 7) {
                                        if (visitor.getMembership() != null) {
                                            System.out.print("\nVisit Attractions:");
                                            zoo.viewAttractions();
                                            visitor.visitAttraction(scanner,zoo);
                                        } else {
                                            System.out.println("You need a membership to visit animals.");
                                        }
                                    }

                                    //give feedback
                                    else if (choice2 == 8) {
                                        System.out.print("\nLeave Feedback:\nEnter your feedback(max 200 characters): ");
                                        String feedback = scanner.nextLine();
                                        if (feedback.length() > 200) {
                                            System.out.println("Your feedback isn't accepted because it has more than 200 characters");
                                        } else {
                                            visitor.setFeedback(feedback);
                                            System.out.println("Thank you for your feedback.");
                                        }
                                    } else if (choice2 == 9) {
                                        System.out.println("\nLogged out.\n");
                                        break;
                                    } else {
                                        System.out.println("Invalid input, try again with a valid number!\n");
                                    }
                                }
                            }
                        } else if (choice20 == 3) {
                            System.out.println("\nExiting.\n");
                            break;
                        } else {
                            System.out.println("Invalid input, try again with a valid number!");
                        }
                    }
                }

                //view special deals
                else if (choice == 3) {
                    zoo.viewDeals();
                } else if (choice == 4) {
                    System.out.println("\nThanks for visiting!");
                    break;
                } else {
                    System.out.println("Invalid input, try again with a valid number!");
                }
            }
            catch (InputMismatchException ex){
                System.out.println("You entered string in a place where integer was expected :((\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}