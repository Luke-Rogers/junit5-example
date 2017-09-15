package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    String exceptionMessage = "Some message";

    @Test
    void assertException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException(exceptionMessage);
        });
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void assertExceptionMethodReference() {
        RuntimeException exception = assertThrows(RuntimeException.class, this::someMethod);
        assertEquals(exceptionMessage, exception.getMessage());
    }

    void someMethod() {
        throw new RuntimeException(exceptionMessage);
    }

}
