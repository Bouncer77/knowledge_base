package org.example.initBlocks;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 05.08.2020
 */

/**
 * Виды блоков инициализации
 * Существует всего два типа блоков:
 *
 * нестатический (динамический) (instance initializer) - инициализирует статические и нестатические переменные
 * статический (class initializer) - инициализирует только статические переменные, вызывается один раз при создании первого экземпляра класса
 *
 * нужно производить какие-нибудь вычисления перед инициализацией переменных.
 * Блок инициализации выполняется так же, как если бы он был расположен в верхней части тела любого конструктора.
 *
 * Сначала вызываются все статические блоки от первого предка до последнего наследника.
 * Потом попарно вызываются динамический блок инициализации и конструктор в той же последовательности (от предка до последнего потомка).
 *
 * Если блоков инициализации несколько, они выполняются в порядке следования в тексте класса.
 * (Например два динамических или два статических блока инициализации)
 * */
public class Test {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Дейзи", "Питбуль", 3);
        System.out.println(dog1);
        /*
        * Это Cтатический блок!
        * Это Нестатический блок!
        * Dog{name='Дейзи', poroda='Питбуль', age=3, static count = 10}
        * */

        Dog dog2 = new Dog();
        System.out.println(dog2);
        /*
        * Это Нестатический блок!
        * Dog{name='Шарик', poroda='Овчарка', age=2, static count = 10}
        * */
    }
}

class Dog {
    private String name;
    private String poroda;
    private int age;

    static int dogCount;

    // статический (class initializer)
    // Используется для инициализации статических переменных
    static {
        System.out.println("Это Cтатический блок!");
        dogCount = 10;
    }

    // нестатический (instance initializer)
    // Используется для инициализации всех переменных
    {
        System.out.println("Это Нестатический блок!");
        name = "Шарик";
        poroda = "Овчарка";
        age = 2;
        dogCount += 20;
    }

    public Dog() {
        System.out.println("Конструктор: Dog()");
    }

    public Dog(String name, String poroda, int age) {
        System.out.println("Конструктор: Dog(String name, String poroda, int age)");
        this.name = name;
        this.poroda = poroda;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", poroda='" + poroda + '\'' +
                ", age=" + age +
                ", static count = " + dogCount +
                '}';
    }
}
