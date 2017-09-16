package example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTests {

    /**
     * we can repeat tests by simply using the @RepeatedTest annotation with the
     * required number of repetitions
     */
    @RepeatedTest(10)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
        assertTrue(repetitionInfo.getCurrentRepetition() <= 10);
    }

}
