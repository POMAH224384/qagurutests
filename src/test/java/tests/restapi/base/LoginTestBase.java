package tests.restapi.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import tests.restapi.models.bodies.LoginBody;
import utils.PropertiesUtil;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTestBase {

    private static final LoginBody loginBody = new LoginBody();

    protected static final String EMAIL = PropertiesUtil.getProperty("email");
    protected static final String PASSWORD = PropertiesUtil.getProperty("password");
    protected static final String TOKEN = PropertiesUtil.getProperty("token");


    public LoginBody setCredit(String emailValue, String passwordValue){
        loginBody.setEmail(emailValue);
        loginBody.setPassword(passwordValue);
        return loginBody;
    }

    @BeforeEach
    void setUp(){
        RestAssured.filters(new AllureRestAssured());
    }

}
