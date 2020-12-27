package org.example.staticBlock;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 05.08.2020
 */

/**
 *
 * */
public class Test {
    public static void main(String[] args) {




        // Вар 1
        /*B b = new B();
        *//* out:
        * static block A
        * static block B
        * Constructor A
        * Constructor B
        * *//*

        System.out.println("***********************************");
        A a = new A();
        *//*
        * Constructor A
        * */


        // Вар 2
        // A a = new A();
        /*
        * static block A
        * Constructor A
        * */

        // Вар 3
        // new C();
        /* out:
        * static block A
        * static block B
        * static block C
        * Constructor A
        * Constructor B
        * Constructor C
        * */

        // Вар 4
        new B(); // A <- B <- C
        System.out.println("***********************************");
        new C();
        /*
        * static block A
        * static block B
        * Constructor A
        * Constructor B
        ***********************************
        * static block C
        * Constructor A
        * Constructor B
        * Constructor C
        * */
    }
}
