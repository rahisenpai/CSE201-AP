package org.example;

public interface ZooFunctionalities {
    public boolean adminLogin(String name, String passwd);
    public void viewAttractions();
    public void viewAnimals();
    public void viewDiscounts();
    public void viewDeals();
    public void addVisitor(String name,int age,int phone,int balance,String email,String password);
    public Visitor visitorLogin(String email, String passwd);
}