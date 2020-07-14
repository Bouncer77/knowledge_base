package com.bouncer77.lesson_19_synchronized_1;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson 19
 */
public class Test {
    private int counter;
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.doWork();
    }


    private synchronized void increment() {
        counter++;
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
