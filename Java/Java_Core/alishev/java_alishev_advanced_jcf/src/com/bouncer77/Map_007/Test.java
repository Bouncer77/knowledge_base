package com.bouncer77.Map_007;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 24.05.2020
 * lesson 007
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        testMap(hashMap);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        testMap(linkedHashMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(79, "Nick");
        map.put(102, "Marta");
        map.put(401, "Anton");
        map.put(-70, "Margaret");
        map.put(22, "Bob");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() +
                    " : " +
                    entry.getValue());
        }
        System.out.println();
    }
}
