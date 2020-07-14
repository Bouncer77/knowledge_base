package com.bouncer77.lesson43;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 22.05.2020
 * lesson
 */
public class ElectroCar {

    private int id;

    // вложеный нестатический класс
        // имеет доступ к внутреним полям класса
    private class Motor {
        public void startMotor() {
            System.out.println("Motor is starting. car id = " + id);
        }
    }

    // вложенные статические классы
        // не имеет доступа к нестатическим внутреним полям класса
    public static class Battery {
        public void charge() {
            System.out.println("Battary is charging...");
        }
    }


    public ElectroCar(int id) {
        this.id = id;
    }

    public void start() {

        Motor motor = new Motor();
        motor.startMotor();

        final int x = 10;
        int y = 5;
        // имеет доступ только к константам в методе
        class SomeClass {
            public void someMethod() {
                System.out.println(id);
                System.out.println(x);
                System.out.println(y);
            }
        }

        SomeClass someClass = new SomeClass();
        someClass.someMethod();


        System.out.println(id + " is starting!");
    }
}
