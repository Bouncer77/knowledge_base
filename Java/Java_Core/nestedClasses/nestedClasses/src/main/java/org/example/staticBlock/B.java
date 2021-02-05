package org.example.staticBlock;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 05.08.2020
 */

public class B extends A {
    static {
        System.out.println("static block B");
    }

    public B() {
        System.out.println("Constructor B");
    }
}
