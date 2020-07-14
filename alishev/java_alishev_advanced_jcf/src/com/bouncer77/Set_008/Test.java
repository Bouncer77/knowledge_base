package com.bouncer77.Set_008;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 24.05.2020
 * lesson 008
 */
public class Test {
    public static void main(String[] args) {
        // Множества - не могут хранить одинаковые элементы
        Set<String> hashSet = new HashSet<>();
        testSet(hashSet);
        Set<String> linkHashSet = new LinkedHashSet<>();
        testSet(linkHashSet);
        Set<String> treeSet = new TreeSet<>();
        testSet(treeSet);

        System.out.println(hashSet.contains("Tom")); // false
        System.out.println(hashSet.contains("Ivan")); // true

        System.out.println("isEmpty: " + hashSet.isEmpty());

        // Операции
        // union - объединение
        Set<Integer> intSet1 = new HashSet<>();
        intSet1.add(1);
        intSet1.add(2);
        intSet1.add(3);
        intSet1.add(4);
        intSet1.add(5);

        Set<Integer> intSet2 = new HashSet<>();
        intSet2.add(3);
        intSet2.add(4);
        intSet2.add(5);
        intSet2.add(6);
        intSet2.add(7);

        System.out.println(intSet1);
        System.out.println(intSet2);

        // union - объединение
        Set<Integer> union = new HashSet<>(intSet1);
        union.addAll(intSet2);
        System.out.println(union + " - union");

        // intersection - пересечение
        Set<Integer> intersection = new HashSet<>(intSet1);
        intersection.retainAll(intSet2);
        System.out.println(intersection + " - intersection");

        // difference - Разность
        Set<Integer> difference = new HashSet<>(intSet1);
        difference.removeAll(intSet2);
        System.out.println(difference + " - difference");

        // symmetricDiff - симметричная разность
        Set<Integer> tmp1 = new HashSet<>(intSet1);
        Set<Integer> tmp2 = new HashSet<>(intSet2);

        Set<Integer> tmp3 = new HashSet<>(intSet1);
        tmp1.removeAll(tmp2); // s1 - s2 = d1
        tmp2.removeAll(tmp3); // s2 - s1 = d2
        tmp1.addAll(tmp2); // d1 + d2
        System.out.println(tmp1 + " - symmetricDiff");

        tmp1 = new HashSet<>(intSet1);
        tmp2 = new HashSet<>(intSet2);
        tmp3 = new HashSet<>(intSet1);
        tmp3.addAll(tmp2); // s1 + s2
        Set<Integer> tmp4 = new HashSet<>(intSet1);
        tmp4.retainAll(tmp2); // s1 пересечение с s2
        tmp3.removeAll(tmp4); // (s1 + s2) - (s1 пересечение с s2)
        System.out.println(tmp3 + " - symmetricDiff");







    }

    public static void testSet(Set<String> set) {
        set.add("Bob");
        set.add("Amanda");
        set.add("Margaret");
        set.add("Ivan");
        set.add("Zen");
        set.add("Nick");

        System.out.println(set);
    }
}
