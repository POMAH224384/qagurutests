package tests.restapi;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
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
    void successfulLoginTest(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");

        LoginResponse response = ReqresSpecs.request
                .filter(new AllureRestAssured())
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(LoginResponse.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

    }

    @Test
    void unsuccessfulLoginTestEmailNull(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(null);
        loginBody.setPassword("cityslicka");

        LoginResponse response =  ReqresSpecs.request
                .filter(new AllureRestAssured())
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing email or username", response.getError());

    }

    @Test
    void unsuccessfulLoginTestPasswordNull(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword(null);

        LoginResponse response =  ReqresSpecs.request
                .filter(new AllureRestAssured())
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing password", response.getError());
    }

    @Test
    void unsuccessfulLoginTestBodyNull(){
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(null);
        loginBody.setPassword(null);

        LoginResponse loginResponse = ReqresSpecs.request
                .filter(new AllureRestAssured())
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing email or username", loginResponse.getError());
    }
}
