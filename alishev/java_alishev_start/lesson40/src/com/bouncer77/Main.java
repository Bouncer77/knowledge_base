package com.bouncer77;

public class Main {

    public static void main(String[] args) {

        // Uncheck exception (Runtime exception)
        // Появляется в ходе выполнения программы

        // Эти исключения являются ошибками в программе и требуют исправления в коде,
        // поэтому они не обрабатываются

        // java.lang.ArithmeticException: / by zero
        // int a = 1 / 0;

        // java.lang.NullPointerException NPE
        String str = null;
        // str.length();

        // java.lang.ArrayIndexOutOfBoundsException: 2
        int[] arr = new int[2];
        // System.out.println(arr[2]);


    }
}
