package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuterClass {

    private String param1;
    private String param2;
    private Nested nested;

    public OuterClass() {
    }

    public OuterClass(String param1, String param2, Nested nested) {
        this.param1 = param1;
        this.param2 = param2;
        this.nested = nested;
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", nested=" + nested +
                '}';
    }
}
