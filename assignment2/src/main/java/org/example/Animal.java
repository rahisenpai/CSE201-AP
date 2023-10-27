package org.example;

public abstract class Animal implements AnimalInterface{
    @Override
    abstract public void feed();
    @Override
    abstract public void read();

    abstract public String getName();
    abstract public String getSound();
    abstract public String getHistory();
}