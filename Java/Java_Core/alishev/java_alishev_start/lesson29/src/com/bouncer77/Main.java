package com.bouncer77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 19.05.2020
 * lesson 29
 */

public class Main {

    public static void main(String[] args) {
        // write your code here
        Animal animal = new Dog();
        animal.sleep();
        Dog dog;
        dog = (Dog) animal;
        dog.bark();

        Animal animal1 = new Animal();
        animal1.sleep();

        System.out.println();
        animalSleep(animal);
        animalSleep(dog);

        List<Pet> pets = new LinkedList<>();
        pets.add(new Pet());
        pets.add(new Pet());

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());


        List<Cat> cats = new LinkedList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        List<Dog> dogs = new LinkedList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        whoIsAll(cats);
        whoIsAll(dogs);

        whoIsAllSuperCat(cats);
        //whoIsAllSuperCat(dogs);

        System.out.println("Animal");
        whoIsAll(animals);
        System.out.println("Pets");
        whoIsAll(pets);

        System.out.println();
        Animal animal2 = new Animal() {
            @Override
            public void whoIs() {
                System.out.println("Other Animal");
            }
        };
        animal2.whoIs();
    }

    public static void animalSleep(Animal animal) {
        animal.sleep();
    }

    public static void whoIsAll(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.whoIs();
        }
    }

    public static void whoIsAllSuperCat(List<? super Cat> animals) {
        for (Object cat : animals) {

        }
    }
}
