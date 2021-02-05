package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 10.06.2020
 * lesson
 */
public class Vector2DTest {

    private final double EPS = 1e-9;
    private static Vector2D v1;
    // private Vector2D v1;


    @BeforeClass
    public static void createNewVector() {
        v1 = new Vector2D();
    }

    /*@Before
    public void createNewVector() {
        v1 = new Vector2D();
    }*/

    @Test
    public void newVectorShouldHaveZeroLength() {
        Assert.assertEquals(0, v1.length(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Assert.assertEquals(0, v1.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Assert.assertEquals(0, v1.getY(), EPS);
    }


    /* Все же хорошей практикой является создание для каждого тестирумого метода собственный тестовый метод*/
    @Test
    public void newVectorShouldHaveZeroXAndY() {
        Assert.assertEquals(0, v1.getX(), EPS);
        Assert.assertEquals(0, v1.getY(), EPS);
    }
}
