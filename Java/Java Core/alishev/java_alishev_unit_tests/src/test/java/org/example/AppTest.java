package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }




    // Assume при неверной проверке - тест игнорируется

    /*
    * @BeforeClass - запускается только один раз при запуске теста (static - принадлежит тестовому классу)
    *
    * @Before - запускается перед каждым тестовым методом (принадлежит тестовому методу)
    *
    * @After - запускается после каждого метода
    *
    * @AfterClass - запускается после того, как отработали все тестовые методы (static)
    * */
}
