package tests.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Tag("remote")
public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 80;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "104.0";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://selenoid:4444/wd/hub";

//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("browserVersion", "104.0");
//        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            /* How to add test badge */
//            put("name", "Test badge...");
//
//            /* How to set session timeout */
//            put("sessionTimeout", "15m");
//
//            /* How to set timezone */
//            put("env", new ArrayList<String>() {{
//                add("TZ=UTC");
//            }});
//
//            /* How to add "trash" button */
//            put("labels", new HashMap<String, Object>() {{
//                put("manual", "true");
//            }});
//
//            /* How to enable video recording */
//            put("enableVideo", true);
//        }});
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"), options);
//        Configuration.browserCapabilities = options;
    }

    @Test
    void testLambdaTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> open("https://github.com/"));

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".box-shadow-none").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> $(linkText(REPOSITORY)).click());

        step("Открываем таб Issue", () -> $("#issues-tab").click());

        step("Проверяем наличие Issue с номером " + ISSUE_NUMBER, () -> {

            $(withText("#" + ISSUE_NUMBER)).should(exist);
        });
    }

    @Test
    void testAnnotationSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps step = new WebSteps();

        step.openMainPage();
        step.searchForRepository(REPOSITORY);
        step.clickOnRepositoryLink(REPOSITORY);
        step.openIssueTab();
        step.searchForIssueByNumber(ISSUE_NUMBER);
    }
}
