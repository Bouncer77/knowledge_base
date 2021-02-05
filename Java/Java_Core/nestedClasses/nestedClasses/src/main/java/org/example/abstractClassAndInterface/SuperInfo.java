package org.example.abstractClassAndInterface;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public interface SuperInfo {

    default void sayHello() {
        System.out.println("I am super");
    }
}
