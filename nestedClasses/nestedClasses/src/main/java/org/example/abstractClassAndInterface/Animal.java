package org.example.abstractClassAndInterface;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

// то чем класс Cat и Dog являются
    // А интерфейс то что класс умеет делать
public abstract class Animal {
    protected int id;

    public Animal(int id) {
        this.id = id;
    }

    abstract void makeSound();
}
