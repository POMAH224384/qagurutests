package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SkippedTests {

    @Test
    @Disabled
    void test1(){
        assertTrue(true);
    }

    @Test
    @Disabled("Reason")
    void test2(){
        assertTrue(true);
    }

}
