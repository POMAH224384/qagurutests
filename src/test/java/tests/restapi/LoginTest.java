package tests.restapi;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.restapi.lombok.LoginBody;
import tests.restapi.lombok.LoginResponse;
import tests.restapi.specs.ReqresSpecs;

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

        LoginResponse response = ReqresSpecs.request
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
        String body = "{ \"email\": \"eve.holt@reqres.in\" }";

        given()
                .log().uri()
                .log().method()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));

    }

    @Test
    void unsuccessfulLoginTestBodyNull(){
        String body = "";

        given()
                .log().uri()
                .log().method()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));

    }
}
