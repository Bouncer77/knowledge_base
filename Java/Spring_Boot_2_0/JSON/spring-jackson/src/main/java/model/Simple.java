package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Simple {

    private int param1;
    private boolean param2;
    private String param3;

    public Simple() {}

    public Simple(int param1, boolean param2, String param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }
}
