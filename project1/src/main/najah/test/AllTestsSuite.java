package main.najah.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class,
    ProductTest.class,
    UserServiceTest.class,
    RecipeBookTest.class
})
public class AllTestsSuite {
    // This class will automatically run all tests from the selected classes
}
