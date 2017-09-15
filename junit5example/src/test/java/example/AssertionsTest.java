package example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    @DisplayName("Simple addition test")
    public void mathAddTest() {
        assertEquals(3, 1 + 2, "Assertion message");
    }

    @Test
    @DisplayName("Grouped assertions")
    void groupedAssertions() {
        Car bmw = Car.newCar("BMW", "M3", "M3 Competition Pack", null);
        assertAll("example.Car Assertions",
                () -> assertEquals("AUDI", bmw.getMake()),
                () -> assertEquals("M3", bmw.getModel()),
                () -> assertEquals("M3 Standard", bmw.getVariant())
        );
    }

    @Test
    @DisplayName("Dependent assertions")
    void dependentAssertions() {
        Car bmw = Car.newCar("BMW", "M3", "M3 Competition Pack", new Price(80000, 100000));
        // Both inner assertion groups are at the same level so not dependent
        assertAll("example.Car Assertions", () -> {
            assertEquals("BMW", bmw.getMake());
            assertEquals("M3", bmw.getModel());
            assertEquals("M3", bmw.getVariant());
        }, () -> {
            assertNotNull(bmw.getPrice());

            // nested so dependent on not null
            assertAll("example.Car example.Price Assertions", () -> {
                assertEquals(80000, bmw.getPrice().getNet());
                assertEquals(100000, bmw.getPrice().getNet());
            });

        });
    }

}
