package com.bouncer77.LinkedLIst_004_005;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 24.05.2020
 * lesson 003
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Add");
        System.out.print("ArrayList: ");
        measureTime(arrayList);
        System.out.print("LinkedList: ");
        measureTime(linkedList);

        // lesson 005
        SuperList superList = new SuperList();
        superList.add(10);
        System.out.println(superList);
        superList.add(20);
        System.out.println(superList);
        superList.add(30);
        System.out.println(superList);
        superList.add(40);
        System.out.println(superList);
        superList.add(50);
        System.out.println(superList);

        System.out.println(superList.get(0));
        System.out.println(superList.get(1));
        System.out.println(superList.get(2));
        System.out.println(superList.get(3));
        System.out.println(superList.get(4));
        // System.out.println(superList.get(5));

        System.out.println("remove 0");
        superList.remove(0);
        System.out.println(superList);
        System.out.println("remove 1");
        superList.remove(1);
        System.out.println(superList);
        System.out.println("remove 2");
        superList.remove(2);
        System.out.println(superList);
        // System.out.println("remove 100");
        // superList.remove(100);
        // System.out.println(superList);
    }

    private static void measureTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1_000; i++) {
            list.add(i);
            // list.add(0, i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

}
