package org.example.abstractClassAndInterface;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public class Cat extends Animal {

    public Cat(int id) {
        super(id);
    }

    @Override
    void makeSound() {
        System.out.println("Мяу");
    }
}
