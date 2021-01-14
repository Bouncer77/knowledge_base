import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Arr;
import model.Nested;
import model.OuterClass;
import model.Simple;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Simple simple = new Simple(100, true, "BoostBrain");

        Arr arr = new Arr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        OuterClass outerClass = new OuterClass("par1", "par2",
                new Nested("par_1_1", 100, new int[]{1, 2, 3}));

        String result = null;

        // Библиотека Jackson
        // POJO Java Class -> JSON
        try {
            // Simple
            result = objectMapper.writeValueAsString(simple);
            System.out.println(result);

            // Arr
            result = objectMapper.writeValueAsString(arr);
            System.out.println(result);

            // Nested
            result = objectMapper.writeValueAsString(outerClass);
            System.out.println(result);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // JSON -> POJO Java Class
        try {
            OuterClass outerClass1 = objectMapper.readValue(result, OuterClass.class);
            System.out.println(outerClass1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
