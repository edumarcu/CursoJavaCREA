package curso.demo16;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class CalculadoraTest {

    @Before
    public void before() {
        System.out.println("BEFORE");
    }

    @Test
    public void test_add() {

        Calculadora calc = new Calculadora();

        calc.setA(3);
        calc.setB(5);
        calc.add();

        assertEquals(calc.getRes(), 8);
    }

    @Test
    public void test_sub() {

        Calculadora calc = new Calculadora();

        calc.setA(3);
        calc.setB(5);
        calc.sub();

        assertEquals(calc.getRes(), -2);
    }

    @Test
    public void test_prod() {

        Calculadora calc = new Calculadora();

        calc.setA(3);
        calc.setB(5);
        calc.prod();

        assertEquals(calc.getRes(), 15);
    }

    @Test
    public void test_div() {

        Calculadora calc = new Calculadora();

        calc.setA(3);
        calc.setB(5);
        calc.div();

        assertEquals(calc.getRes(), 0);
    }

    @Test
    public void getA() {

        Calculadora calc = new Calculadora();

        calc.setA(3);

        assertEquals(calc.getA(), 3);
    }

    @Test
    public void getB() {

        Calculadora calc = new Calculadora();

        calc.setB(5);

        assertEquals(calc.getB(), 5);
    }

    @Test(expected=ArithmeticException.class)
    public void test_divByZero() {

        Calculadora calc = new Calculadora();

        calc.setA(3);
        calc.setB(0);
        calc.div();

        assertEquals(calc.getRes(), 0);
    }
}
