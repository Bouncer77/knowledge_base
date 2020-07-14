package com.bouncer77.lesson_017;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson 018
 */
public class MyThread extends Thread {

    // Тут описывается код - который должен быть выполнен в своем потоке
    @Override
    public void run() {
        for (int i = 0; i < 1_000; i++) {
            System.out.println("Hello, from MyThread " + i);
        }
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1_000; i++) {
            System.out.println("Hello, from MyThread " + i);
        }
    }
}
