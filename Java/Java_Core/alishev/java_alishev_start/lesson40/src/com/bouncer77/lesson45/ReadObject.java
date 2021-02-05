package com.bouncer77.lesson45;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 22.05.2020
 * lesson
 */
public class ReadObject {

    public static void main(String[] args) {

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream("people.bin"))) {
            /*FileInputStream fis =
                    new FileInputStream("people.bin");
            ObjectInputStream ois =
                    new ObjectInputStream(fis);*/

            //Person person1 = (Person) ois.readObject();
            //Person person2 = (Person) ois.readObject();

            int personCount = ois.readInt();
            Person[] people = new Person[personCount];
            for (int i = 0; i < personCount; ++i) {
                people[i] = (Person) ois.readObject();
            }

            System.out.println(Arrays.toString(people));
            // ois.close();

            //System.out.println(person1);
            //System.out.println(person2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
