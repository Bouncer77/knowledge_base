package com.bouncer77.lesson33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 01.06.2020
 * lesson
 */
public class Compar {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("threeeee");
        list.add("twooo");
        list.add("t");
        System.out.println(list);

/*        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;
                else return 0;
            }
        });*/

        // 2
        /*list.sort((s1, s2) -> {
            if (s1.length() > s2.length())
                return 1;
            else if (s1.length() < s2.length())
                return -1;
            else return 0;
        });*/

        // 3
        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            else if (s1.length() < s2.length()) return -1;
            else return 0;
        };
        list.sort(comparator);

        System.out.println(list);

    }
}
