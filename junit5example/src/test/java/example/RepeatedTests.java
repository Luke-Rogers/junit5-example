package example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTests {

    @RepeatedTest(10)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
        assertTrue(repetitionInfo.getCurrentRepetition() <= 10);
    }

}
