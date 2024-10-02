package test.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testFactorial() {
        // Test cases for the factorial method
        assertEquals(1, Main.factorial(0), "Factorial of 0 should be 1");
        assertEquals(1, Main.factorial(1), "Factorial of 1 should be 1");
        assertEquals(2, Main.factorial(2), "Factorial of 2 should be 2");
        assertEquals(6, Main.factorial(3), "Factorial of 3 should be 6");
        assertEquals(24, Main.factorial(4), "Factorial of 4 should be 24");
        assertEquals(120, Main.factorial(5), "Factorial of 5 should be 120");
    }

    @Test
    public void testFactorialNegative() {
        // Edge case: factorial of a negative number
        // As factorial is not defined for negative numbers, this should ideally be handled in production code
        // Here, we'll assert a specific behavior if needed (could be an exception or a specific return value)
        try {
            Main.factorial(-1);
            assert false : "Factorial of a negative number should throw an exception";
        } catch (IllegalArgumentException e) {
            assertEquals("Factorial is not defined for negative numbers", e.getMessage());
        }
    }
}
