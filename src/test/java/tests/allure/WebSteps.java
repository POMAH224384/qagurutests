package tests.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repositoryName}")
    public void searchForRepository(String repositoryName){
        $(".box-shadow-none").click();
        $("#query-builder-test").setValue(repositoryName).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repositoryName}")
    public void clickOnRepositoryLink(String repositoryName){
        $(linkText(repositoryName)).click();
    }

    @Step("Открываем таб Issue")
    public void openIssueTab(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issueNumber}")
    public void searchForIssueByNumber(int issueNumber){
        $(withText("#" + issueNumber)).should(exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
