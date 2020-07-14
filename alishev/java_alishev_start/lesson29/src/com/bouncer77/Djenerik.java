package com.bouncer77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 19.05.2020
 * lesson 34
 */
public class Djenerik {

    public static void main(String[] args) {

        // До Java 5
        List animalList = new ArrayList();
        animalList.add("cat");
        animalList.add("dog");
        animalList.add("frog");

        String animal = (String) animalList.get(0);
        System.out.println(animal);

        // После Java 5
        List<String> animalList2 = new ArrayList<>(animalList);
        System.out.println(animalList2.get(0));
    }
}
