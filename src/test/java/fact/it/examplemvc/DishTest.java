package fact.it.examplemvc;

import fact.it.examplemvc.model.Dish;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DishTest {

    @Test
    void testDishConstructor() {
        // Arrange
        String name = "Veggie Burger";
        int calories = 350;
        boolean vegetarian = true;

        // Act
        Dish dish = new Dish(name, calories, vegetarian);

        // Assert
        assertEquals(name, dish.getName());
        assertEquals(calories, dish.getCalories());
        assertTrue(dish.isVegetarian());
    }
}

