package com.bouncer77;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 22.05.2020
 * lesson 41-42
 */
public class Test {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.makeSound();


        // lessson 42
        Cat cat1 = new Cat(1);
        Cat cat2 = new Cat(1);

        System.out.println(cat1.equals(cat2));

        System.out.println();
        String string1 = "hello";
        String string2 = "hello";
        System.out.println(string1 == string2);
        System.out.println(string1.equals(string2));

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));




    }
}
