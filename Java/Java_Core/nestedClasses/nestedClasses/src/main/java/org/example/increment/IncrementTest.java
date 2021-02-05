package org.example.increment;

/**
 * Hello world!
 *
 */
public class IncrementTest {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );


        // вариант 1
        int a = 1;
        a = ++a + a++;
        System.out.println(a); // 4

        // вариант 2
        int c = 1;
        c = c++ + c;
        System.out.println(c); // 3

        // вариант 3
        int d = 1;
        d = d + d++;
        System.out.println(d); // 2

        // вариант 4
        int с = 1;
        с = с++ + ++с;
        System.out.println(с); // 4

        // варинт 5
        int m = 1;
        m = m++;
        System.out.println(m); // 1
        m++;
        System.out.println(m); // 2


        System.out.println("*****************");
        int p = 1;
        m = 1;
        p = m++;
        System.out.println(m); // 2
        System.out.println(p); // 1
    }
}
