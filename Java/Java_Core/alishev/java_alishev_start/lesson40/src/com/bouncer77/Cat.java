package com.bouncer77;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 22.05.2020
 * lesson
 */
public class Cat extends Animal {

    private int id;

    public Cat(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Cat otherCat = (Cat) obj;
        return this.id == otherCat.id;
    }

    @Override
    public void makeSound() {
        System.out.println("Cat!!!");
    }
}
