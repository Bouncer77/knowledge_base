package org.example.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 11.06.2020
 * lesson
 */
public class Test2 {
    /*
    * newInstance() - по умолчанию вызывает пустой конструктор
    * getMethod() - получить метод по его сигнатуре
    * getConstructor() - получить конструктор по сигнатуре конструктора
    *
    * Для объекта класса Method:
    *   invoke()
    * */

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class classString = String.class;
        Method method = classString.getMethod("indexOf", String.class, int.class);
        System.out.println(method);

        Scanner scanner = new Scanner(System.in);
        // Название_класса_1 Название_класса_2 Название_метода
        Class classObject1 = Class.forName(scanner.next());
        Class classObject2 = Class.forName(scanner.next());
        String methodName = scanner.next();

        // На объекта первого класса вызывается метод в который передается объект второго класса
        Method method1 = classObject1.getMethod(methodName, classObject2);
        Object o1 = classObject1.newInstance();

        // получить конструктор со строковым значением
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

        method1.invoke(o1, o2); // вызвать на объекте o1 метод и передав объект o2

        System.out.println(o1);

        // Примеры для тестов
        // org.example.reflection.Person java.lang.String setName
        // java.lang.Thread java.lang.String setName
    }

}
