package com.bouncer77.lesson48;

public enum Animal {
    DOG("Собака"), // new DOG("Собака");
    CAT("Кошка"),
    FROG("Лягушка");

    private String translation;

    Animal(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }


    @Override
    public String toString() {
        return super.toString() +
                " - Перевод на русский язык: " +
                translation;
    }
}
