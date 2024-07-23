package tests.simple;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PositiveTests {

    @BeforeAll
    static void setUpBeforeClass() {
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:8080/wd/hub";
    }

    @Test
    void test1(){
        assertTrue(true);
    }

    @Test
    void test2(){
        assertTrue(true);
    }

    @Test
    void test3(){
        assertTrue(true);
    }

    @Test
    void test4(){
        assertTrue(true);
    }

    @Test
    void test5(){
        assertTrue(true);
    }

    @Test
    void test6(){
        assertTrue(true);
    }

    @Test
    void test7(){
        assertTrue(true);
    }

    @Test
    void test8(){
        assertTrue(true);
    }

    @Test
    void test9(){
        assertTrue(true);
    }
}
