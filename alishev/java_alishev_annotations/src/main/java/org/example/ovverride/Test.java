package org.example.ovverride;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 10.06.2020
 * lesson
 */
public class Test {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello from main Thread");
    }


}

class MyThread extends Thread {
    /*
    * Если добавыить параметер в run метод - то он станет не переопределенный а перегруженны - сигнатура
    * метода будет отличаться от сигнатуры метода в Thread - это ошибка
    *
    * public void run(int x) !!!
    * */
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello from MyThread");
    }
}
