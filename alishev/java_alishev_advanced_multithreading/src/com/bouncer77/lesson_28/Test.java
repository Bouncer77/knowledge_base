package com.bouncer77.lesson_28;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 27.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class Runner {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    // избежать DeadLock-ов
    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        // Если может забрать лок, то возврат true
        // Если не может - то false
        // до тех пор пока не заберем два лока
        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                // Успешно забрали два лока сразу
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                // Освобождаем занятый лок для другого потока

                // Для первого лока
                if (firstLockTaken) {
                    lock1.unlock();
                }

                // Для второго потока
                if (secondLockTaken) {
                    lock2.unlock();
                }
            }

            try {
                // дать время другим потокам забрать локи
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    public void firstThread() {
        Random random = new Random();


        for (int i = 0; i < 10_000; i++) {

            // Deadlock
            // lock1.lock();
            //lock2.lock();

            takeLocks(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }

        // высока сложность из-за вложенностей
        /*for (int i = 0; i < 10_000; i++) {
            synchronized (account1) {
                synchronized (account2) {
                    // Когда поток завладеет мониторамии двух аккаунтов
                    Account.transfer(account1, account2, random.nextInt(100));
                }
            }
        }*/

        // Гонка состояний
        /*for (int i = 0; i < 10_000; i++) {
            Account.transfer(account1, account2, random.nextInt(100));
        }*/
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10_000; i++) {


            // Deadlock
            // lock1.lock();
            // lock2.lock();

            takeLocks(lock2, lock1);

            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("A1: " + account1.getBalance() +
                "\nA2: " + account2.getBalance() +
                "\nTotal balance: " +
                (account1.getBalance() + account2.getBalance()) );
    }
}

class Account {
    private int balance = 10_000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account account1, Account account2, int amount) {
        account1.withDraw(amount);
        account2.deposit(amount);
    }
}
