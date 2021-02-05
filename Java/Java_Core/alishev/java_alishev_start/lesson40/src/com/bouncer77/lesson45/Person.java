package com.bouncer77.lesson45;

import java.io.Serializable;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 22.05.2020
 * lesson
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -6633974588877204954L;
    private int id;
    // transient - не хотим сериализовывать это поле
    // private  transient String name;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + id;
    }
}
