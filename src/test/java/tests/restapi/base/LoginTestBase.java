package tests.restapi.base;

import tests.restapi.models.bodies.LoginBody;
import utils.PropertiesUtil;

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
}
