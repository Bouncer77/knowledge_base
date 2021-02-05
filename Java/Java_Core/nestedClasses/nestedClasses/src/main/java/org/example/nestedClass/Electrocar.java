package org.example.nestedClass;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public class Electrocar {

    private int id;

    // не получаем доступ из вне к этому классу
    // являются часть электромашины и не используется из вне
    // 1. Member inner class (Внутренние классы-члены)
    // Не статический (non-static inner class) вложенный класс
    private class Motor {
        public void startMotor() {
            System.out.println("Мотор " + id + " is starting...");
        }
    }

    // не имеет доступа кне статическим полям электромашины
    // является частью электромашины и используется из вне
    // 2. Static nested classes (Статические вложенные классы)
    // Статический вложенный класс
    public static class Battery {
        public void charge() {
            System.out.println("Battery is charging...");
        }
    }

    public Electrocar(int id) {
        this.id = id;
    }

    public void start() {
        new Motor().startMotor();

        int x = 5;
        // имеет доступ к полям электромашины и полям в методе
        // 2. Local Inner class (Локальный класс)
        // Вложенные классы в методе
        class SomeClass {
            public String someMethod() {
                return "x = " + x + " id = " + id;
            }

            @Override
            public String toString() {
                return "SomeClass{}";
            }
        }

        SomeClass someClass = new SomeClass();
        System.out.println(someClass.someMethod());
        test(someClass);



        System.out.println("Electrocar " + id + " is starting...");
    }

    public void test(Object ob) {
        System.out.println(ob.toString());
    }
}
