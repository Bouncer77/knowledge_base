package org.example.reflection;

import org.example.myAnnotations.MethodInfo;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 11.06.2020
 * lesson
 */
@MethodInfo(purpose = "личность")
public class Person {

    private String name;
    private int age;
    public int publicInt;

    public Person() {
        name = "Ivan";
        age = 22;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person: " + name + " " + age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }
}
