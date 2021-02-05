package com.bouncer77.lesson_29;

import java.util.Random;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 27.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    // вернет true, если было вызвано interrupt();
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread was interrypted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });

        System.out.println("Starting Thread");
        thread1.start();
        Thread.sleep(1000);
        thread1.interrupt();
        thread1.join();

        System.out.println("Thread is finish");
    }
}
