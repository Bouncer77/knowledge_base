package com.bouncer77.lesson_26;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(task.getCounter());
    }
}

class Task {
    private int counter;
    // Предотвращает DeadLock
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10_000; i++) {
            counter++;
        }
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public int getCounter() {
        return counter;
    }
}
