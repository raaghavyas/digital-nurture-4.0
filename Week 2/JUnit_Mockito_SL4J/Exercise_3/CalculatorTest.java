package junit;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance cleared.\n");
    }
    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result);
    }
}

/*
OUTPUT
Setup: Calculator instance created.
Teardown: Calculator instance cleared.

Setup: Calculator instance created.
Teardown: Calculator instance cleared.
*/
