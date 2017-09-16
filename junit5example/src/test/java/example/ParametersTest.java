package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametersTest {

    private FizzBuzz fizzBuzz;

    static Stream<Arguments> fizzBuzzSource() {
        return Stream.of(
                Arguments.of(1, null),
                Arguments.of(10, "Buzz"),
                Arguments.of(45, "FizzBuzz"),
                Arguments.of(9, "Fizz")
        );
    }

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    /**
     * we can provide the method args using a inline value source
     */
    @ParameterizedTest
    @ValueSource(ints = {15, 45})
    void fizzBuzzers(int number) {
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(number));
    }

    /**
     * we can provide the method args using a inline csv source, its also possible to use
     * csv file
     */
    @ParameterizedTest
    @CsvSource({"1, ", "10, Buzz", "45, FizzBuzz", "9, Fizz"})
    @DisplayName("example.FizzBuzz Tester")
    void fizzBuzzTestCsv(int number, String testResult) {
        assertEquals(testResult, fizzBuzz.fizzBuzz(number));
    }

    /**
     * we can provide the method args using a method source
     */
    @ParameterizedTest
    @MethodSource("fizzBuzzSource")
    @DisplayName("FizzBuzz Tester")
    void fizzBuzzTest(int number, String testResult) {
        assertEquals(testResult, fizzBuzz.fizzBuzz(number));
    }

    /**
     * we can provide the method args using an arguments source class
     */
    @ParameterizedTest
    @ArgumentsSource(FizzBuzzArgumentsSource.class)
    @DisplayName("FizzBuzz Tester")
    void fizzBuzzArgSourceTest(int number, String testResult) {
        assertEquals(testResult, fizzBuzz.fizzBuzz(number));
    }

    static class FizzBuzzArgumentsSource implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return fizzBuzzSource();
        }
    }

}
