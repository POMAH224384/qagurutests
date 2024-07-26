package tests.restapi;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.restapi.lombok.LoginBody;
import tests.restapi.lombok.LoginResponse;
import tests.restapi.specs.ReqresSpecs;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
public class LoginTest {

    @Test
    @DisplayName("Successful Login with password and email")
    void successfulLoginTest(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");

        LoginResponse response = ReqresSpecs.request
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(LoginResponse.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

    }

    @Test
    @DisplayName("Unsuccessful login without email")
    void unsuccessfulLoginTestEmailNull(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(null);
        loginBody.setPassword("cityslicka");

        LoginResponse response =  ReqresSpecs.request
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing email or username", response.getError());

    }

    @Test
    @DisplayName("Unsuccessful login without password")
    void unsuccessfulLoginTestPasswordNull(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword(null);

        LoginResponse response =  ReqresSpecs.request
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing password", response.getError());
    }

    @Test
    @DisplayName("Unsuccessful login without email and password")
    void unsuccessfulLoginTestBodyNull(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(null);
        loginBody.setPassword(null);

        LoginResponse loginResponse = ReqresSpecs.request
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing email or username", loginResponse.getError());
    }
}
