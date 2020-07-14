package com.bouncer77.lesson_20_synchronized_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson 20
 */
public class Test {
    private int counter;
    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }


    // Неявный synchronized на объекте this
    /*private synchronized void increment() {
        counter++;
    }*/

    // явный synchronized часть 2
    private void increment() {
        // synchronized блок
        // Может исполняться только одним потоком
        synchronized (this) {
            counter++;
        }
    }


    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    increment();
                    // counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    increment();
                    // counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        // ожидание выполнения потока в текущем потоке
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class Worker {

    Random random = new Random();

    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    // this == new Worker
    public synchronized void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("Programm took: " + (end - before));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }
}

