package com.bouncer77.lesson49;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 23.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) {
        counter(10);
        System.out.println(factorial(4));
    }

    // 4! = 4 * 3 * 2 * 1 = 24
    // 4 * factorial(3)
    // 3 * factorial(2)
    // 2 * factorial(1)
    // 1 (base-case - условие выхода)
    // 2 * factorial(1) = 2 * 1 = 2
    // 3 * factorial(2) = 3 * 2 = 6
    // 4 * factorial(3) = 4 * 6 = 24
    private static long factorial(int n) {

        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    private static void counter(int n) {

        if (n == 0) {
            return;
        }

        System.out.println(n);
        counter(n - 1);
    }
}
