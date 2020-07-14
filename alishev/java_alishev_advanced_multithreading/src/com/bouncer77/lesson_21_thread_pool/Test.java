package com.bouncer77.lesson_21_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        // Создать pool потоков
        /// На заводе 2 работника
        ExecutorService executorService
                = Executors.newFixedThreadPool(2);

        /// Передать 2-ум работникам 5 заданий
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
        }

        System.out.println("All tasks submited");
        /// Приказать работникам начать выполнять задания
        executorService.shutdown(); // не останавливает поток main
        // аналог start

        executorService.awaitTermination(1, TimeUnit.DAYS); // ожидание окончания выполнения потоков
        // аналог join
    }
}

class Work implements Runnable {

    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work id = " + id + " was complited");
    }
}
