package org.example.abstractClassAndInterface;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public class Human implements Info, SuperInfo {

    private String name;

    {
        name = "Пельмень";
    }

    public Human() {}

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void showInfo() {
        System.out.println(this.name);
    }

    @Override
    public void sayHello() {
        // use super keyword to call the show
        // method of Info interface
        Info.super.sayHello();

        // use super keyword to call the show
        // method of SuperInfo interface
        SuperInfo.super.sayHello();

        this.showInfo();
    }
}
