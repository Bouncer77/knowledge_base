package org.example.staticBlock;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 05.08.2020
 */

public class C extends B {
    static {
        System.out.println("static block C");
    }

    public C() {
        System.out.println("Constructor C");
    }
}
