package example;

import example.resolvers.NewCarParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertTrue;

@ExtendWith({SpringExtension.class, NewCarParameterResolver.class})
@SpringBootTest(classes = Application.class)
public class SpringParameterResolutionTest {

    /**
     * parameter resolution also east with spring using the spring extension
     * also note you can extend with multiple classes to provide different config
     * and parameter resolution
     */
    @Test
    @DisplayName("Should validate new car")
    public void validateNewCarTest(@Autowired CarValidator carValidator, Car car) {
        assertTrue(carValidator.valid(car));
    }

}
