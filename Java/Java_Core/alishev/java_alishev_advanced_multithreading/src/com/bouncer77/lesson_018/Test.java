package com.bouncer77.lesson_018;

import java.util.Scanner;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson 019
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // ждет переноса строки - enter

        myThread.shutdown();
    }
}

class MyThread extends Thread {

    // volatile - значение не кэшируется для каждого потока, а всегда берется из общей памяти
    // Один поток пишет в переменную, а все остальные потоки считывают с переменной
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
