package com.bouncer77.Queue_014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 25.05.2020
 * lesson 014
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        // FIFO - first in ferst out
        Queue<Person> people = new ArrayBlockingQueue<>(10); // Максимальный размер очереди
        // add - remove
        people.add(person3);
        people.add(person2);
        people.add(person1);
        System.out.println(people.peek()); // посмотреть, но не удалять
        //System.out.println("Delete: " + people.remove());

        for (Person p : people) {
            System.out.println(p);
        }


        // add - remove - element | Throws exception
        // offer - pull - peek | Return special value (true/false)
    }
}

class Person {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person: id = " + id;
    }
}
