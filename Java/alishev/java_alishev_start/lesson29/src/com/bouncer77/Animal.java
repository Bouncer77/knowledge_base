package com.bouncer77;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 19.05.2020
 * lesson 29
 * */

public class Animal {

    private int id;

    public Animal() {}

    public Animal(int id) {
        this.id = id;
    }

    public void whoIs() {
        System.out.println(Animal.class);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                '}';
    }

    public void sleep() {
        System.out.println("Животное спит");
    }
}
