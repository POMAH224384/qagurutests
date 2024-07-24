package tests.restapi;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Tag("api")
public class ReqresInTest {

    @Test
    void successfulLoginTest(){
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

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
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));

    }

    @Test
    void unsuccessfulLoginTestEmailNull(){
        String body = "{ \"password\": \"cityslicka\" }";

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
