package com.bouncer77.Comparator_012_013;

import java.util.*;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 25.05.2020
 * lesson 012_013
 */
public class Test {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Frog");
        animals.add("Bird");
        System.out.println(animals);
        Collections.sort(animals);
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);


        animals.add("Bi");
        animals.add("B");
        Collections.sort(animals, new StringLengthComparator());
        System.out.println(animals);

        Collections.sort(numbers, new BackwardsIntegerComparator());
        System.out.println(numbers);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else if (o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });

        System.out.println(numbers);


        Person person1 = new Person(1, "Nick");
        Person person3 = new Person(3, "Ivan");
        Person person2 = new Person(2, "Mike");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person3);
        personList.add(person2);
        System.out.println(personList);

        Collections.sort(personList, (o1, o2) -> {
            if (o1.getId() > o2.getId())
                return 1;
            else if (o1.getId() < o2.getId())
                return -1;
            else return 0;
        });

        /*Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId())
                    return 1;
                else if (o1.getId() < o2.getId())
                    return -1;
                else return 0;
            }
        });*/

        System.out.println(personList);

        // lesson 013
        System.out.println();
        Set<Person> personSet = new TreeSet<>();

        addElements(personSet);
        addElements(personList);
        System.out.println(personSet);
        System.out.println(personList);

    }

    private static void addElements(Collection collection) {
        Person person1 = new Person(1, "Nick");
        Person person3 = new Person(3, "Ivan");
        Person person2 = new Person(2, "Mike");
        collection.add(person2);
        collection.add(person3);
        collection.add(person1);
    }
}

class Person implements Comparable<Person> {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person with name = " + name +
                ", id = " + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Person o) {
        if (this.id > o.getId())
            return 1;
        else if (this.id < o.getId())
            return -1;
        else return 0;
    }
}

class BackwardsIntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2)
            return -1;
        else if (o1 < o2)
            return 1;
        else
            return 0;
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        /*
        * o1 > o2  =>  1
        * o1 < o2  => -1
        * o1 == o2 =>  0
        * */
        if (o1.length() > o2.length())
            return 1;
        else if (o1.length() < o2.length())
            return -1;
        else
            return 0;
    }
}
