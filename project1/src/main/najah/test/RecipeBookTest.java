package main.najah.test;

import org.junit.jupiter.api.*;
import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

@DisplayName("RecipeBook Test Class")
class RecipeBookTest {

    private RecipeBook recipeBook;

    @BeforeAll
    static void setupAll() {
        System.out.println("Before all tests...");
    }
    
    @BeforeEach
    void setup() {
    	System.out.println("Before each test...");
        recipeBook = new RecipeBook();
    }

    @Test
    @DisplayName("Test add recipe successfully")
    void testAddRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");
        assertTrue(recipeBook.addRecipe(recipe), "Recipe should be added successfully");
    }

    @Test
    @DisplayName("Test add duplicate recipe")
    void testAddDuplicateRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");

        // Add the recipe once
        recipeBook.addRecipe(recipe);

        // Try to add the same recipe again
        assertFalse(recipeBook.addRecipe(recipe), "Duplicate recipe should not be added");
    }

    @Test
    @DisplayName("Test delete recipe")
    void testDeleteRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");

        // Add recipe before trying to delete
        recipeBook.addRecipe(recipe);
        
        // Delete the recipe at index 0
        assertEquals("Coffee", recipeBook.deleteRecipe(0), "Recipe name should be 'Coffee'");
    }

    @Test
    @DisplayName("Test edit recipe")
    void testEditRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");
        Recipe recipe2 = new Recipe();
        recipe2.setName("Tea");

        // Add the original recipe
        recipeBook.addRecipe(recipe);
        
        // Edit the recipe
        assertEquals("Coffee", recipeBook.editRecipe(0, recipe2), "Recipe name should be 'Coffee'");
    }

    @Test
    @DisplayName("Test timeout for adding recipe")
    void testTimeout() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");

        // Test the addRecipe method does not exceed 500ms
        assertTimeout(Duration.ofMillis(500), () -> recipeBook.addRecipe(recipe));
    }
    
    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests...");
    }
}
