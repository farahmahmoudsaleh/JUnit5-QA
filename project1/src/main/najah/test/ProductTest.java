package main.najah.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import main.najah.code.Product;
import java.time.Duration;

@DisplayName("Product Test Class")
class ProductTest {

    private Product product;
    
    @BeforeAll
    static void setupAll() {
        System.out.println("Before all tests...");
    }

    @BeforeEach
    void setup() {
    	System.out.println("Before each test...");
        product = new Product("Laptop", 1000);
    }

    @Test
    @DisplayName("Test valid discount application")
    void testValidDiscount() {
        product.applyDiscount(10);
        assertEquals(900, product.getFinalPrice(), "Discounted price should be correct");
    }

    @Test
    @DisplayName("Test invalid discount")
    void testInvalidDiscount() {
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(60), "Discount should not be more than 50%");
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.0, 20.0, 30.0})
    @DisplayName("Test parameterized discount")
    void testParameterizedDiscount(double discount) {
        product.applyDiscount(discount);
        assertTrue(product.getFinalPrice() < 1000, "Final price should be less than original price");
    }

    @Test
    @DisplayName("Test price cannot be negative")
    void testNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Phone", -500), "Price must be non-negative");
    }

    @Test
    @DisplayName("Test timeout for final price calculation")
    void testTimeout() {
        assertTimeout(Duration.ofMillis(500), () -> product.getFinalPrice());
    }
    
    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests...");
    }
}
