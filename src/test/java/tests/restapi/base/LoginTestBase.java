package tests.restapi.base;

import tests.restapi.models.bodies.LoginBody;
import tests.restapi.models.responses.LoginResponse;
import tests.restapi.specs.ReqresSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestBase extends MainTestBase{

    private static final LoginBody loginBody = new LoginBody();

    protected static LoginResponse loginResponse;


    public String getToken(){
        successfulLogin(EMAIL, PASSWORD);
        return loginResponse.getToken();
    }

    public LoginBody setCredit(String emailValue, String passwordValue){
        loginBody.setEmail(emailValue);
        loginBody.setPassword(passwordValue);
        return loginBody;
    }

    public void successfulLogin(String email, String password){

        loginResponse = ReqresSpecs.request
                .body(setCredit(email, password))
                .when()
                .post("/login")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(LoginResponse.class);
    }

    public void unsuccessfulLogin(String email, String password){
        loginResponse = ReqresSpecs.request
                .body(setCredit(email, password))
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);
    }

    public void successfulRegistry(String email, String password){
        loginResponse = ReqresSpecs.request
                .body(setCredit(email, password))
                .when()
                .post("/register")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(LoginResponse.class);
    }

    public void unsuccessfulRegistry(String email, String password){
        loginResponse = ReqresSpecs.request
                .body(setCredit(email, password))
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);
    }


}
