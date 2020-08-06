package org.example.staticBlock;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 05.08.2020
 */

public class A {
    static {
        System.out.println("static block A");
    }

    public A() {
        System.out.println("Constructor A");
    }
}
