package com.bouncer77.lesson31;

import java.util.Arrays;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 29.05.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) {
        // разбить строку на подстроки
        String a = "hello there hey";
        String[] arrStr1 = a.split(" ");
        System.out.println(Arrays.toString(arrStr1));
        a = "hello.there.hey";
        String[] arrStr2 = a.split("\\.");
        System.out.println(Arrays.toString(arrStr2));
        a = "hello123there456hey";
        String[] arrStr3 = a.split("\\d+");
        System.out.println(Arrays.toString(arrStr3));
        System.out.println();
        a = "hello.there.hey";
        a = a.replace(".", " ");
        System.out.println(a);
        // для регулярных выражений
        a = "hello123there456hey";
        a = a.replaceAll("\\d+", " ");
        System.out.println(a);
        // замена первого вхождения
        a = "hello123there456hey";
        a = a.replaceFirst("\\d+", " ");
        System.out.println(a);


    }
}
