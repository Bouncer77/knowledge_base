package org.example.ovverride;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 10.06.2020
 * lesson
 */
public class B extends A {
    /* Возможна ошибка при которой в классе родителя изменили название метода,
     но забыли сменить название этого метода в классах наследниках

     Решение - аннотация Override*/
    @Override
    public void test() {
        System.out.println("Hello from class B");
    }
}
