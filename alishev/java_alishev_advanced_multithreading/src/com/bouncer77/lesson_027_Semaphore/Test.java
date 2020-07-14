package com.bouncer77.lesson_027_Semaphore;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // количество разрешений для потоков
        // сколько потоков одновременно могут отправлять данные на сервер?
        Semaphore semaphore = new Semaphore(3); // разрешения
        /*
        * Когда поток отвзаимодействовал с ресурсом
        *   - поток возвращает разрешение
        * */
        // semaphore.release(); // отдать одно из разрешение

        // semaphore.acquire(); // при начале взаимодействия с ресурсом
        // semaphore.availablePermits(); // вернуть количество свободных разрешений
        System.out.println("availablePermits: " + semaphore.availablePermits());

        ExecutorService executorService = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

// singelton - один объект класса
class Connection {

    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);

    private Connection () {

    }

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork(); // если  будет искл => ресурс должен быть освобожден
        } finally {
            semaphore.release(); // должно вызываться в последнем блоке
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println("Connection counts: " + connectionsCount);
        }
        Thread.sleep(5000);

        synchronized (this) {
            connectionsCount--;
        }
    }
}
