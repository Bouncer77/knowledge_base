package org.example.reflection;

import org.example.myAnnotations.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 11.06.2020
 * lesson
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        // 1
        Class c1 = MyClass.class;

        // 2
        MyClass myClass = new MyClass();
        Class c2 = myClass.getClass();

        // 3
        Class c3 = Class.forName("org.example.reflection.MyClass");

        Class personClass = Person.class;
        Method[] methods = personClass.getMethods();
        int i = 1;
        for (Method method : methods) {
            System.out.println("Method number: " + i++);
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println();
        }

        System.out.println("-----------------------------------------");
        // только public поля
        Field[] fields = personClass.getFields();
        i = 1;
        for (Field field : fields) {
            System.out.println("Field number: " + i++);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println();
        }

        System.out.println("-----------------------------------------");
        // все поля
        fields = personClass.getDeclaredFields();
        i = 1;
        for (Field field : fields) {
            System.out.println("Field number: " + i++);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println();
        }

        System.out.println("-----------------------------------------");
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MethodInfo) {
                System.out.println("Annotation with name MethodInfo is DETECTED in class " + personClass.getName());
            }
        }
    }
}
