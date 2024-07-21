package tests.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 80;

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
