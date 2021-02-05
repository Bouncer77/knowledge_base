package com.bouncer77.lesson33;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 29.05.2020
 * lesson
 */

interface Executable {
    int execute(int x);
}

class Runner {
    public void run(Executable e) {

        int a = e.execute(5);
        System.out.println(a);
    }
}

class ExecutableImp implements Executable {

    @Override
    public int execute(int x) {
        System.out.println("Hello1");
        return 1 + x;
    }
}

public class Test {
    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.run(new ExecutableImp());
        runner.run(new Executable() {
            @Override
            public int execute(int x) {
                System.out.println("Hello2");
                return 1 + x;
            }
        });

        runner.run((int x) -> {
            System.out.println("Hello3");
            return 1 + x;
        });

        System.out.println();
        runner.run((int x) -> 10 + x);
        runner.run((x) -> 10 + x);
        System.out.println();
        // Java 8
        // Лямбда-выражения - способ передать кусок кода в метод
        /* позволяют обойтись без анонимных классов */
        // Lambda expresson - анонимный метод - метод без названия

        // Любые функциональные интерфейсы (интерфейсы с одним методом)
        // могут быть реализованы с помощю лэмбда выражения

        // new Runnable() - создать новый экземпляр анонимного класса, который
        // реализует интерфейс Runnable с одним методом run()

        // new Thread(...) - конструктор, который ожидает экземпляр класса,
        // который реализует интерфейс Runnable
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });

        Thread thread2 = new Thread(() -> System.out.println("Hello"));

    }
}
