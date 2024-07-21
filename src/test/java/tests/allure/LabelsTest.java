package tests.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class LabelsTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("aalayarov@jmart.kz")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Создание Issue для авторизованного пользователя")
    void testStaticLabels() {

    }

    @Test
    void testDynamicLabels(){
        Allure.getLifecycle().updateTestCase(t -> t.setName("Создание Issue для авторизованного пользователя"));
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://github.com/");
    }
}
