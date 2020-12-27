package com.bouncer77.Iterable_016;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 25.05.2020
 * lesson 016
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Brfore Java 5
        int idx = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
            if (idx == 1)
                iterator.remove(); // delete element with index 1
            idx++;
        }
        System.out.println();

        // Java 5 // абстракция через итератор
        // итератор указывает на пространство до первого объекта - после вызова метода next указывает на элемент с индексом 0
        for (int x : list) {
            System.out.println(x);
        }


    }
}
