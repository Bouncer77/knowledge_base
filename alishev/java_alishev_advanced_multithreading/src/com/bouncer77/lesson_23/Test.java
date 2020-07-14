package com.bouncer77.lesson_23;

import java.util.Scanner;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson 23
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
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

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Produser thread started");
            // вызов методов привязывается к контексту, у нестатических методов на объекте this
            // для другого объекта пиши: lock.wait() !!!
            wait(); // вызывается только в пределах synchronized блока
            // wait(1000); // столько будет ждать notify от другого потока
            // 1 - отдать intrinsic lock (монитор объекта) => другие потоки могут забрать lock объекта
            // 2 - в текущем потоке ждем пока будет вызван notify на этом объекте
            System.out.println("Producer thread resumed..."); // возобновлен
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000); // чтобы produced запустился первым

        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            notify(); // разбудить поток
            // notifyAll(); // разбудить все потоки

            // не освобождает монитор!!!
        }
    }
}
