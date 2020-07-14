package org.example;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 10.06.2020
 * lesson
 */
public class Vector2D {

    private double x;
    private double y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }
}
