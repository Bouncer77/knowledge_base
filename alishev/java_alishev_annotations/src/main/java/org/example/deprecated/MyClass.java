package org.example.deprecated;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 10.06.2020
 * lesson
 */
public class MyClass {

    public void myNewMethod() {
        System.out.println("Hello from 2020 year!!!");
    }


    /*Аннотация не запрещает использовать метод - а лишь рекомендует найти
    * в документации и использовать другой метод из этой библиотеки */
    @Deprecated
    public void myMethod() {
        System.out.println("Hello from 2000 year!!!");
    }
}
