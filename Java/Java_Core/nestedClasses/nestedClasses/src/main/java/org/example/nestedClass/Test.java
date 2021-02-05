package org.example.nestedClass;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 06.08.2020
 */

public class Test {

    public static void main(String[] args) {
        Electrocar electrocar = new Electrocar(1);
        electrocar.start();

        Electrocar.Battery battery = new Electrocar.Battery();
        System.out.println();

        // 3. Anonymous Inner Class
        Electrocar turboElectrocar = new Electrocar(3) {
            @Override
            public void start() {
                System.out.println("Спорткар");
                super.start();
            }
        };
        turboElectrocar.start();
    }
}
