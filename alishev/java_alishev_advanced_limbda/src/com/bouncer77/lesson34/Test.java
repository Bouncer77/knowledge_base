package com.bouncer77.lesson34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 01.06.2020
 * lesson 34
 */
public class Test {
    public static void main(String[] args) {

        int[] arr = fillArr();
        List<Integer> list = fillList();

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("list = " + list);

        /*
        * Умножить на два каждый элемент массива и листа
        * */

        // Без лямбда-выражений
        /*for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
            list.set(i, list.get(i) * 2);
        }
        System.out.println();
        System.out.println("arrX2 = " + Arrays.toString(arr));
        System.out.println("listX2 = " + list);
        System.out.println();*/

        // С лямбда выражениями
        // возвращает поток . изменить каждый элемент из набора данных

        // map - отображение из теории множест - каждому элементу из
        // старого множества задаем отображение в новом множестве
        arr = Arrays.stream(arr).map(a -> a * 2).toArray(); // a - элемент из набора данных
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());
        System.out.println();
        System.out.println("arrX2 = " + Arrays.toString(arr));
        System.out.println("listX2 = " + list);


        // filter - фильтрует данные
         // true - соответствует критерию
        System.out.println();
        arr = fillArr();
        list = fillList();
        arr = Arrays.stream(arr).filter(a -> a % 2 == 0).toArray();
        list = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println("arr%2==0 = " + Arrays.toString(arr));
        System.out.println("list%2==0 = " + list);

        // for-each
        Arrays.stream(arr).forEach(System.out::println);
        list.forEach(System.out::println);

        // reduce - уменьшение до одного элемента
        arr = fillArr();
        list = fillList();
            // посчитать сумму элеентов
                // аккумулятор, текущий элемент
        // по умолчанию аккумулятор - первый элемент в массиве, а итерация со второго элемента
        int sum1 = Arrays.stream(arr).reduce((acc, b) -> acc + b).getAsInt();
        int sum1_ = Arrays.stream(arr).reduce(0, (acc, b) -> acc + b);
        int sum1__ = Arrays.stream(arr).reduce(0, Integer::sum);
        int sum1___ = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        int sum2 = list.stream().reduce((acc, b) -> acc + b).get();
        // проверка isPresent нужнаб когда может вернуться ничего из reduce
        System.out.println(sum1 + " | "+ sum2);

        // несколько преобразований
        arr = fillArr();
        list = fillList();
        // каждое нечетное число умножить на 2

        arr = Arrays.stream(arr).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        list = list.stream().filter(a -> a % 2 != 0).map(a -> a * 2).collect(Collectors.toList());
        System.out.println(Arrays.toString(arr));
        System.out.println(list);

    }

    private static List<Integer> fillList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    private static int[] fillArr() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
