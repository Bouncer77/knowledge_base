package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Arr {

    private int[] array;

    public Arr() {}

    public Arr(int[] array) {
        this.array = array;
    }
}
