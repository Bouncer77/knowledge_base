package com.bouncer77.lesson32;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 29.05.2020
 * lesson 32
 */
public class Test {
    public static void main(String[] args) {
        // найти в тексте все адреса электронной почты
        String text = "Hello, Gues! I send you my email joe@gmail.com so we can\n" +
                "keep in touch. Thanks, Joe! That's coll. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay it touch...";
        Pattern email = Pattern.compile("(\\w+)@\\w+\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        // найти строку в соответствии с регул выраж
        while (matcher.find()) {
            // вернуть то что было найдено в find()
            // получить всю подстраку - получить id группы (в фйигурных скобках) из патерна
            // нумерация слева направо начиная с единицы
            // при вложенностях 1(2()3()) | 1(2()) 3()
            System.out.println(matcher.group() + " - " + matcher.group(1));
        }
    }
}
