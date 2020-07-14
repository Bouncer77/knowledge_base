package com.bouncer77.knowledge.base;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 4 способа чтения файла
    // от новых способов к старым
    public static void main(String[] args) throws IOException {

        // 4 - Java 8 - лямбда выражения и декларативное программирование
        readFile4();

        // 3 - Files.readAllLines
        readFile3();

        // 2 - Scanner
        readFile2();

        // 1 - чтение блоками байтов в буфер  (с ошибками)
        readFile1();
    }

    // Java 8 - лямбда выражения и декларативное программирование
    public static void readFile4() throws IOException {
        Files.lines(Paths.get("input.txt")).forEach(System.out::println);
    }

    // Files.readAllLines
    public static void readFile3() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("input.txt"));

        for (String str : list) {
            System.out.println(str);
        }
    }

    // Scanner
    public static void readFile2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    // чтение блоками байтов в буфер
    public static void readFile1() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("input.txt"));
        byte[] buffer = new byte[512];
        while (dis.available() != 0) { // есть доступные байты в потоке
            int count = dis.read(buffer); // количество реально считанных байт

            if (count > 0) {
                System.out.println(new String(buffer));
            }
        }
    }
}
