package com.bouncer77.ArrayList_002_003;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 24.05.2020
 * lesson 002
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            arrayList.add(i);
        }

        System.out.println(arrayList);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(99));

        System.out.println("size: " + arrayList.size());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        for (Integer i : arrayList) {
            System.out.println(i);
        }

        System.out.println();

        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrList.add(i);
        }
        System.out.println(arrList);
        arrList.remove(3);
        System.out.println(arrList);


        List<Integer> list = new LinkedList<>(arrList);
        System.out.println("linkList: " + list);
    }
}
