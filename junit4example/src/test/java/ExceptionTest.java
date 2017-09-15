import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ExceptionTest {

    String exceptionMessage = "Some Message";

    @Test (expected = RuntimeException.class)
    public void should_assert_exception() {
       someMethod();
    }

    @Test
    public void should_assert_some_exception_message() {
        try {
            someMethod();
        } catch (Exception e) {
            assertThat(e.getMessage(), equalTo(exceptionMessage));
            return;
        }
        fail("Did not throw exception");
    }

    void someMethod() throws RuntimeException {
        throw new RuntimeException(exceptionMessage);
    }

}
