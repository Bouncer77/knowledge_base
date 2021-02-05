package org.example.introdactionInAnnotations;

import org.example.introdactionInAnnotations.MyAnnotation;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 10.06.2020
 * lesson
 */
// Аннотация для класса
@MyAnnotation
public class Test {

    // Аннотация для поля
    @MyAnnotation
    private String name;

    // Аннотация для конструктора
    @MyAnnotation
    public Test() {}

    @MyAnnotation
    public void tst(@MyAnnotation int value) { // Аннотация для параметра
        @MyAnnotation String localVar = "Hello"; // Для локальной переменной
    }

    @MyAnnotation // К статическому методу
    public static void main(@MyAnnotation String[] args) { // к параметру статического метода

    }
}
