package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {


    @Test
    void successfulLoginTest(){
        Configuration.holdBrowserOpen = true;

        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("ryolkin90@gmail.com");
        $("[name=password]").setValue("Ryolkin90!");
        $(".btn-success").click();
       
    }
}
