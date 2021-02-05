package com.bouncer77.lesson_30;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 27.05.2020
 * lesson
 */
public class Test {

    private static int result;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread finished");
                result++;
            }
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(result);


        ExecutorService executorService2 = Executors.newFixedThreadPool(1);
        // интерфейс Callable
        Future<Integer> future2 = executorService2.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int randomValue = random.nextInt(10);
                if (randomValue < 5) {
                    throw new Exception("Exception: val < 5");
                }
                return randomValue;
            }
        });
        executorService2.shutdown();

        try {
            // дожидается окончания выполнения потока
            int result = future2.get();
            // пробрасывает искл из потока
            System.out.println("Res: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // ловим исключения возникшее во время выполнения потока
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
            // e.printStackTrace();
        }


    }

    public static int calculate() {
        return 5 + 4;
    }
}
