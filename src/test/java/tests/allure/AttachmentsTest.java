package tests.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Tag("remote")
public class AttachmentsTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "104.0";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://selenoid:4444/wd/hub";
    }

    @Test
    void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    void testAnnotationAttachments(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps step = new WebSteps();

        step.openMainPage();
        step.takeScreenshot();
    }
}
