package curso.demo16_junit;

import curso.demo16.Calculator;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {


    Calculator calc;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BEFORE");
    }

    @Before
    public void before() {
        calc = new Calculator();
        calc.setA(3);
        calc.setB(5);
    }


    @Test
    public void test_add() {
        calc.add();
        assertEquals(8, calc.getRes());
    }

    @Test
    public void test_del() {
        calc.del();

        assertEquals(-2, calc.getRes());
    }

    @Test
    public void test_mul() {
        calc.mul();

        assertEquals(15, calc.getRes());
    }

    @Test
    public void test_div() {
        calc.div();

        assertEquals(0, calc.getRes());
    }

    @Test(expected=ArithmeticException.class)
    public void test_div_divisionByZero_throwsException() {
        calc.setB(0);
        calc.div();
    }

    @Test
    public void test_getA() {
        assertEquals(3, calc.getA());
    }

    @Test
    public void test_getB() {
        assertEquals(5, calc.getB());
    }
}
