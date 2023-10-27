package org.example;

public class Mammal extends Animal implements AnimalInterface{
    private String name;
    private String sound;
    private String history;

    Mammal(String name,String sound, String history){
        this.name = name;
        this.sound = sound;
        this.history = history;
    }

    @Override
    public void feed() {
        System.out.println(this.name + " " + this.sound +  "(s).");
    }

    @Override
    public void read() {
        System.out.println(this.history);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSound() {
        return sound;
    }

    @Override
    public String getHistory() {
        return history;
    }
}