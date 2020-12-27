package com.bouncer77.lesson_24;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson 025
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {

    // не потоко безопасна
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object LOCK = new Object();

    public void producer() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized(LOCK) {

                // Еще одна проверка после возврата монитора объекта и вызова notify() - чтобы не добавить 11 элемент в очередь
                while (queue.size() == LIMIT) {
                    LOCK.wait();
                }

                queue.offer(value++); // +1 число в очередь
                LOCK.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            synchronized (LOCK) {

                // Если использовать if, то не будет дополнительной проверки
                while (queue.size() == 0) {
                    LOCK.wait();
                }

                int value = queue.poll(); // +1 свободное место
                System.out.println(value);
                System.out.println("Queue size is " + queue.size());
                LOCK.notify();
            }

            Thread.sleep(1000);
        }
    }
}
