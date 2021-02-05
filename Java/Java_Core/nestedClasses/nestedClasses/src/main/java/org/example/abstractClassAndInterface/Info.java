package org.example.abstractClassAndInterface;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public interface Info {

    int a = 5;

    void showInfo();

    default void sayHello() {
        System.out.println("Hello from Info = " + a);
    }
}
