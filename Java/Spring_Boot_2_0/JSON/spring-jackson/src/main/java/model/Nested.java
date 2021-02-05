package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Nested {

    private String param1;
    private int param2;
    private int[] arr;

    public Nested() {
    }

    public Nested(String param1, int param2, int[] arr) {
        this.param1 = param1;
        this.param2 = param2;
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "Nested{" +
                "param1='" + param1 + '\'' +
                ", param2=" + param2 +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}

/*
   "Вложенный объект":{
		"Вложенный Параметр 1":"Значение",
		"Вложенный параметр 2":100,
		"Вложенный массив":[1, 2, 3]
	}
* */
