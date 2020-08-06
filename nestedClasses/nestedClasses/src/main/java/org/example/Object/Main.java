package org.example.Object;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Integer val1 = 5;

        // public final native Class getClass()
        // – возвращает в рантайме класс данного объекта.
        System.out.println(val1.getClass());
        /// class java.lang.String

        // public native int hashCode()
        // – возвращает хеш-код (реализация зависит от JVM)
        System.out.println(val1.hashCode());
        /// 2337

        // public boolean equals(Object obj)
        // – сравнивает объекты.
        System.out.println(val1.equals(10));
        // false

        // protected native Object clone() throws CloneNotSupportedException
        // – клонирование объекта
        Man man = new Man();
        System.out.println(man.getName() + " " + man.hashCode());
        Man man2 = man.clone();
        System.out.println(man2.getName() + " " + man2.hashCode());

        // public String toString()
        // – возвращает строковое представление объекта.
        Object obj1 = new Object();
        System.out.println(obj1.toString());
        // java.lang.Object@34ce8af7
        System.out.println(obj1.getClass().getName() +
                "@" + Integer.toHexString(obj1.hashCode()));






    }

    static class Man {

        private String name;

        {
            name = "Nick";
        }

        public Man() {
        }

        public Man(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Man clone() throws CloneNotSupportedException {
            return new Man(this.name);
        }

        @Override
        public String toString() {
            return "Man{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
