package org.example.abstractClassAndInterface;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://javastudy.ru/interview/java-oop3/
 * 54. Чем отличается абстрактный класс от интерфейса, в каких случаях что вы будете использовать?
 * Абстрактные классы используются только тогда, когда есть “is a” тип отношений;
 * интерфейсы могут быть реализованы классами которые не связаны друг с другом.
 *
 * Абстрактный класс может реализовывать методы; интерфейс может реализовывать статические методы начиная с 8й версии.
 *
 * Интерфейс может описывать константы и методы. Все методы интерфейса по умолчанию являются публичными (public)
 * и абстрактными (abstract), а поля – public static final. С java 8 в интерфейсах можно реализовывать default и статические методы.
 *
 * В Java класс может наследоваться (реализовывать) от многих интерфейсов, но только от одного абстрактного класса.
 *
 * С абстрактными классами вы теряете индивидуальность класса, наследующего его; с интерфейсами вы просто расширяете
 * функциональность каждого класса.
 * */
public class Main {
    public static void main(String[] args) {
        Human human = new Human("Иван");
        Dog dog = new Dog(1);

        human.showInfo();
        dog.showInfo();

        System.out.println();

        Info info1 = new Human("Николай");
        Info info2 = new Dog(2);

        info1.showInfo();
        info2.showInfo();

        System.out.println();

        List.of(human, dog, info1, info2).forEach(Main::outputInfo);
        System.out.println();
        List.of(human, dog, info1, info2).forEach(Info::showInfo);


        System.out.println("**************");
        human.sayHello();
        System.out.println("**************");

        Dog dog1 = new Dog(3);
        Cat cat1 = new Cat(4);
        Animal[] animals = {dog1, cat1};
        Arrays.stream(animals).forEach(Animal::makeSound);


    }

    public static void outputInfo(Info info) {
        info.showInfo();
    }

}
