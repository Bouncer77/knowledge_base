package org.example.myAnnotations;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 10.06.2020
 * lesson
 */
public class Test {

    @MethodInfo(autor = "Ivan", purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello, World!");
    }
}
