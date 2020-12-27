package org.example.nestedClass.anonymousInnerClass;

import java.util.LinkedList;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 05.08.2020
 */

public class Nested {

    final String human = "Человек";
    final static String hu = "Человек";

    public String getHuman() {
        return human;
    }

    /**
     * Анонимные классы
     * Применяйте анонимные классы, если вам нужен локальный класс для одноразового использования
     * видны только внутри того метода, в котором определены.
     * анонимный класс не может содержать статические переменные и методы
     * https://javarush.ru/groups/posts/2193-anonimnihe-klassih
     *
     * Задача:
     * Один модуль будет отслеживать общие показатели работы и вести лог, второй — фиксировать и регистрировать
     * ошибки в журнале ошибок, третий — отслеживать подозрительную активность: например,
     * попытки несанкционированного доступа и прочие связанные с безопасностью вещи.
     *
     * Подход без аннонимных классов:
     * Создать три класса по одному для каждого типа модуля для мониторинга и реализовать там интерфейс с методом для
     * запуска мониторинга
     *
     * С анонимными внутренними классами:
     * */
    public static void main(String[] args) {

        System.out.println("Создает три анонимных класса (модули системы мониторинга)," +
                " каждый из которых переопределяет метод из интерфейса и вызывает этот метод:");
        LinkedList<MonitoringSystem> monitoringSystemList = new LinkedList<>();

        // Создается анонимный внутренний класс, который реализует интерфейс MonitoringSystem
        MonitoringSystem generalModule = new MonitoringSystem() {

            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг общих показателей стартовал!");
                someSpecificMethod();
            }

            private void someSpecificMethod() {
                System.out.println("\tСпецифический private метод только для модуля мониторинга общих показателей");
            }

        };
        monitoringSystemList.add(generalModule);

        MonitoringSystem errorModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг отслеживания ошибок стартовал!");
            }
        };
        monitoringSystemList.add(errorModule);

        MonitoringSystem securityModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг безопасности стартовал!");
            }
        };
        monitoringSystemList.add(securityModule);

        // вызвать метод мониторинга у всех модулей
        monitoringSystemList.forEach(MonitoringSystem::startMonitoring);
        System.out.println("\nСоздает один анонимный вложенный класс, который наследуется от класса Animal и " +
                "переопределяет его метод eat():");


        /**
         *Так же можно создавать анонимные вложенные классы, которые наследуются от класса и переопределяют методы в нем
         * */
        Animal fox = new Animal() {
            @Override
            public void eat() {
                System.out.println("Лиса ест " + Nested.hu);
            }
        };
        fox.eat();

        AbleToEat cat = () -> System.out.println("Кот ест");
        cat.eat();
    }
}

class Animal implements AbleToEat {

    @Override
    public void eat() {
        System.out.println("Животное ест");
    }
}
