package com.bouncer77.lesson44;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 22.05.2020
 * lesson
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("testFile");
        PrintWriter pw = new PrintWriter(file);

        pw.println("row 1");
        pw.println("row 2");
        pw.close();
    }
}
