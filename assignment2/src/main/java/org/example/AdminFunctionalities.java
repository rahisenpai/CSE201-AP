package org.example;

public interface AdminFunctionalities {
    void scheduleEvent(int id,String status,int price);
    void viewFeedback();
    void viewStats();
    void addDeal(int tickets, int discount);
    boolean removeDeal(int tickets, int discount);
    boolean removeDiscount(String code);
    void addDiscount(String category,int discount,int lage,int uage,String code);
    void removeAnimal(String name);
    void updateAnimal(String name, String sound, String history);
    void addAnimal(String name, String type, String sound, String history);
    void addAttraction(String name, String desc, int id);
    boolean removeAttraction(int id);
}