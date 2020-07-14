package com.bouncer77.HashCode_009_010;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 25.05.2020
 * lesson 009_010_011
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(2, "Nick");
        Person person3 = new Person(2, "Nick");

        Map<Person, String> map = new HashMap<>();
        map.put(person1, "123");
        map.put(person2, "456");
        map.put(person3, "456");

        System.out.println(map);
    }
}
