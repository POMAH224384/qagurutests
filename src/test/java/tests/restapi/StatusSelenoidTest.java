package tests.restapi;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

@Tag("api")
public class StatusSelenoidTest {

    @Test
    void checkTotal(){
        get("http://185.129.51.98:4444/status")
                .then()
                .body("total", is(5));
    }

    @Test
    void checkWithGivenTotal(){
        given()
        .when()
                .get("http://185.129.51.98:4444/status")
        .then()
                .body("total", is(5));
    }

    @Test
    void checkWithStatusCodeTotal(){
        given()
                .when()
                .get("http://185.129.51.98:4444/status")
                .then()
                .statusCode(200)
                .body("total", is(5));
    }

    @Test
    void checkWithLogAllTotal(){
        given()
                .log().all()
                .when()
                .get("http://185.129.51.98:4444/status")
                .then()
                .log().all()
                .statusCode(200)
                .body("total", is(5));
    }

    @Test
    void checkWithSomeLogsTotal(){
        given()
                .log().uri()
//                .log().body() for POST request
                .log().method()
                .when()
                .get("http://185.129.51.98:4444/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(5));
    }

    @Test
    void checkChromeVersion(){
        given()
                .log().uri()
                .log().method()
                .when()
                .get("http://185.129.51.98:4444/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(5))
                .body("browsers.chrome", hasKey("125.0"));
    }

    @Test
    void checkJsonSchema(){
        given()
                .log().uri()
                .log().method()
                .when()
                .get("http://185.129.51.98:4444/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(5))
                .body("browsers.chrome", hasKey("125.0"))
                .body(matchesJsonSchemaInClasspath("schemes/status-scheme-responce.json"));
    }
}
