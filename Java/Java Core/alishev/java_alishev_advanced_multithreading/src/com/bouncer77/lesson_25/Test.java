package com.bouncer77.lesson_25;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 26.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // Защелка обратного отсчета
        // Количество итераций, которое надо отсчитать перед тем, как защелка отопрется
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Processor(i, countDownLatch));
        }

        executorService.shutdown();
        // три потока будут декрементировать переменную
        countDownLatch.await(); // ожидает когда защелка будет равна нулю
        System.out.println("Защелка открыта и главный поток продолжает свою работу");
    }
}

class Processor implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;

    public Processor(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processor " + id);
        countDownLatch.countDown();
    }
}
