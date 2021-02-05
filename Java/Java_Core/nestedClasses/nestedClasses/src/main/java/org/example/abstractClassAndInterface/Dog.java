package org.example.abstractClassAndInterface;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public class Dog extends Animal implements Info {

    public Dog(int id) {
        super(id);
    }

    @Override
    void makeSound() {
        System.out.println("Гав");
    }

    @Override
    public void showInfo() {
        System.out.println(this.id);
    }
}
