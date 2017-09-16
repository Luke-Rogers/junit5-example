package example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("regression")
public class TaggingTest {

    @Test
    public void regressionTest() {
        assertEquals(4, 2 + 2);
    }

    /**
     * can tag classes or specific tests to group
     * run mvn:test to see the regression suite only included in the test run
     */
    @Test
    @Tag("integration")
    public void integrationTest() {
        assertEquals(4, 2 + 2);
    }
}
