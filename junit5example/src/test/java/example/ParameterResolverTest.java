package example;

import example.resolvers.NewCarParameterResolver;
import example.resolvers.UsedCarParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterResolverTest {

    @Test
    @DisplayName("should be new car")
    @ExtendWith(NewCarParameterResolver.class)
    void shouldResolveNewCar(Car car) {
        assertEquals("BMW", car.getMake());
        assertTrue(car.isNew());
    }

    @Test
    @DisplayName("should be used car")
    @ExtendWith(UsedCarParameterResolver.class)
    void shouldResolveUsedCar(Car car) {
        assertTrue(car.isUsed());
    }

}
