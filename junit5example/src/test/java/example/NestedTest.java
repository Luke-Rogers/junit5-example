package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * BDD style tests
 */
public class NestedTest {

    private Car car;
    private CarValidator carValidator;

    @BeforeEach
    public void setUp() {
        carValidator = new CarValidator();
    }

    @Nested
    @DisplayName("When I pick an new car")
    public class NewCarTestClass {

        @BeforeEach
        public void setUp() {
            car = Car.newCar("BMW", "M3", "M3", new Price(8000.00, 10000.00));
        }

        @Test
        @DisplayName("should not have a regplate set")
        public void newCarValidationTest() {
            assertTrue(carValidator.valid(car));
        }

    }

    @Nested
    @DisplayName("When I pick a used car")
    public class UsedCarTestClass {

        @BeforeEach
        public void setUp() {
            car = Car.usedCar("BMW", "M3", "M3", new Price(8000.00, 10000.00), "YK67ZHO");
        }

        @Test
        @DisplayName("should have a regplate set")
        public void usedCarValidationTest() {
            assertTrue(carValidator.valid(car));
        }


    }

}
