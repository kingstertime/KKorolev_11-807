import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc;

    //будет выполнен перед запуском каждого теста
    @Before
    public void setUp() {
        System.out.println("it's before");
        calc = new Calculator();
    }

    @Test
    public void testFactOn5() {
        int expected = 120;
        int actual = calc.fact(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testFactOn1() {
        int expected = 1;
        int actual = calc.fact(1);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactOnNegative() {
        calc.fact(-3);
    }

    @Test
    public void testIsSquareOn4() {
        assertTrue(calc.isSquare(4));
    }

    @Test
    public void testIsSquareOn42() {
        assertFalse(calc.isSquare(42));
    }
}
