package org.example.myAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* Аннотация для библиотеки
* */
// ограничение использования аннотации только к методам; классам, интерфейсам и перечислениям
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // аннотация видна в ходе выполнения программы
public @interface MethodInfo {
    String autor() default "User";
    int dateOfCreation() default 2020;
    String purpose(); // цель метода пользователя библиотеки
}
