package com.bouncer77;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 19.05.2020
 * lesson 29
 * */

public class Dog extends Pet {

    @Override
    public void whoIs() {
        System.out.println(Dog.class);
    }

    // Позднее связывание
    @Override
    public void sleep() {
        System.out.println("Собака спит");
    }

    public void bark() {
        System.out.println("Лаять");
    }
}
