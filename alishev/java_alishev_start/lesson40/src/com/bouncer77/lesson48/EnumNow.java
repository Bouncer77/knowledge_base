package com.bouncer77.lesson48;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 23.05.2020
 * lesson
 */
public class EnumNow {

    public static void main(String[] args) {
        Animal animal = Animal.CAT;

        switch (animal) {
            case CAT:
                System.out.println("It is CAT");
                break;
            case DOG:
                System.out.println("It is Dog");
                break;
            case FROG:
                System.out.println("It is Frog");
                break;
        }

        // true, true, true
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Enum);
        System.out.println(animal instanceof Object);

        System.out.println(animal.getClass());
        System.out.println(animal.getDeclaringClass());

        System.out.println(animal.getTranslation());
        System.out.println(animal);

        Season season = Season.WINTER;
        System.out.println(season.getAvgTemperature());

        System.out.println();
        System.out.println(season.name()); // вернуть название Enum, как задекларировано

        Animal animal1 = Animal.valueOf("FROG");
        System.out.println(animal1.getTranslation());

        System.out.println(season.ordinal()); // Позиция Enum в перечисление

        for (Animal a : Animal.values()) {
            System.out.println(a.ordinal() + " : " + a.name() + " - " + a.getTranslation());
        }
    }
}
