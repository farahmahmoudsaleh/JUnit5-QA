package main.najah.test;

import main.najah.code.Calculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


@Execution(ExecutionMode.CONCURRENT)  // Enable parallel execution for this test class
@DisplayName("Calculator Test Class")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("Before all tests...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests...");
    }

    @BeforeEach
    void setup() {
        calculator = new Calculator();
        System.out.println("Before each test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test...");
    }

    @Test
    @Order(1)
    @DisplayName("Test addition")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    @Order(2)
    @DisplayName("Test division")
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2");
    }

    @Test
    @Order(3)
    @DisplayName("Test factorial")
    void testFactorial() {
        assertEquals(120, calculator.factorial(5), "5! should equal 120");
    }

    @Test
    @Order(4)
    @Disabled("This test is currently failing due to an issue with the divide method")
    @DisplayName("Test divide by zero (intentionally failing)")
    void testDivideByZeroDisabled() {
        // This will fail, and we have disabled it for now
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Division by zero should throw ArithmeticException");
    }
}
