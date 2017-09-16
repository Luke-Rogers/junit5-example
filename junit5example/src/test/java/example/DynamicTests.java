package example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicTests {

    /**
     * we can now create tests at runtime be annotating method with @TestFactory
     * and returning some dynamic tests
     */
    @TestFactory
    public Stream<DynamicTest> dynamicTests() {
        // Generates tests for the first 10 even integers.
        return IntStream.iterate(0, n -> n + 2).limit(10)
                .mapToObj(n -> DynamicTest.dynamicTest("Dynamic test" + n, () -> assertTrue(n % 2 == 0)));
    }

}
