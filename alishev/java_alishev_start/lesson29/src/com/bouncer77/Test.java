package com.bouncer77;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 19.05.2020
 * lesson 30-32
 */
public class Test {

    float f = 127.1F;
    long num = 123L;

    int x = (int) num;

    public static void main(String[] args) {
        byte aByte = (byte) -256;
        System.out.println(aByte);


        Dog dog = new Dog();

        // Upcast
        Animal animal = dog;
        animal.sleep();

        // Downcast - Нисходящее преобразование - опасно ClassCastException
        Dog dog1 = (Dog) animal;

    }
}
