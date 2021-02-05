package com.bouncer77.HashMap_006;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 24.05.2020
 * lesson 006
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        System.out.println(map);

        // Старое значение перезаписывается
        map.put(3, "Другое значение");
        System.out.println(map);

        String str1 = map.get(1);
        System.out.println(str1);

        System.out.println(map.get(10));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " +
                    entry.getValue());
        }
    }
}
