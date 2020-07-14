package com.bouncer77.lesson48;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 23.05.2020
 * lesson
 */
public class EnumOld {

    private static final int DOG = 0;
    private static final int CAT = 1;
    private static final int FROG = 2;

    public static void main(String[] args) {
        int animal = DOG;

        switch (animal) {
            case DOG:
                System.out.println("It is DOG");
                break;
            case CAT:
                System.out.println("It is CAT");
                break;
            case FROG:
                System.out.println("It is FROG");
                break;
            default:
                System.out.println("It is not animal");
        }
    }
}
