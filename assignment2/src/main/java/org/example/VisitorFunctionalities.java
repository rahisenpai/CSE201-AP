package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public interface VisitorFunctionalities {
    void visitAttraction(Scanner scanner, Zoo zoo);
    void visitAnimal(String name, int c, Zoo zoo);
    void buyMembership(int c,String code, ArrayList<Discount> discounts);
    void buyTickets(Scanner scanner,Zoo zoo);
}