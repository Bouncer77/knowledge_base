package com.bouncer77.lesson30;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 29.05.2020
 * lesson 30
 */
public class Test {
    public static void main(String[] args) {
        String a = "1234";
        System.out.println(a.matches("1234"));
        System.out.println(a.matches("12345"));
        System.out.println();

        /*
        * \\d - [0-9]{1} - одна цифра
        * + - 1 или более
        * * - 0 или более
        * ? - 0 или 1 символов до
        * (x|y|z) - множество, | - логическое или
        * [a-zA-Z] - все буквы английского алфавита
        * [^a-c] - символы кроме a, b, c
        * . - любой символ
        *
        * Точное количество символов указывается в фигурных скобках
        * .{2}       2 символа
        * .{2, }     два или более символов
        * .{1, 4}    от двух до 4-х символов
        *
        * \\w = [a-zA-Z] - одна английская буква
        *
        * [abc] = (a|b|c)
        * */

        /*
        * http://regexlib.com/?AspxAutoDetectCookieSupport=1
        * Сайт об регулярных выражениях
        * */

        /*
        * str.matches(String regex) // boolean
        * */
        a = "-1534535";
        System.out.print("a.matches(\"-?\\\\d+\") | " + a + " | ");
        System.out.println(a.matches("-?\\d+"));
        a = "+1534535";
        System.out.print("a.matches(\"(\\\\+|-)?\\\\d+\") | " + a + " | ");
        System.out.println(a.matches("(\\+|-)?\\d+"));

        System.out.println();
        String d = "g1234";
        System.out.println(d.matches("[a-z]\\d+"));
        System.out.println();

        // В строке разрешены все символы, кроме строк,
        // где есть символы a, b, c
        String h1 = "hello";
        String h2 = "thjka";
        System.out.println(h1.matches("[^a-c]*"));
        System.out.println(h2.matches("[^a-c]*"));
        System.out.println();

        String url = "http://www.google.com";
        System.out.println(url.matches("https?://www\\..+\\.(com|ru)"));
        url = "https://www.google.ru";
        System.out.println(url.matches("https?://www\\..+\\.(com|ru)"));
    }
}
