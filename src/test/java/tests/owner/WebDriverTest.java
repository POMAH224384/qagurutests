package tests.owner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("selenium")
public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testGithub(){
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }

    @AfterEach
    void stopDriver(){
        driver.quit();
    }
}
