package com.bouncer77.lesson45;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 22.05.2020
 * lesson
 */
public class WriteObj {

    public static void main(String[] args) {
        Person person1 = new Person(1, "Ivan");
        Person person2 = new Person(2, "Nick");
        Person person3 = new Person(3, "Masha");


        Person[] people = {person1, person2, person3};


        try {
            FileOutputStream fos =
                new FileOutputStream("people.bin");
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);

            //oos.writeObject(person1);
            //oos.writeObject(person2);

            oos.writeInt(people.length);
            for (Person p : people) {
                oos.writeObject(p);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
