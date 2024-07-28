package tests.restapi.tests;

import tests.restapi.base.LoginTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.restapi.models.responses.LoginResponse;
import tests.restapi.specs.ReqresSpecs;
import utils.PropertiesUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
public class LoginTest extends LoginTestBase {

    @Test
    @DisplayName("Successful Login with password and email")
    void successfulLoginTest(){

        LoginResponse response = ReqresSpecs.request
                .body(setCredit(EMAIL, PASSWORD))
                .when()
                .post("/login")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(LoginResponse.class);

        assertEquals(PropertiesUtil.getProperty("token"), response.getToken());

    }

    @Test
    @DisplayName("Unsuccessful login without email")
    void unsuccessfulLoginTestEmailNull(){

        LoginResponse response =  ReqresSpecs.request
                .body(setCredit(null, PASSWORD))
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

        LoginResponse response =  ReqresSpecs.request
                .body(setCredit(EMAIL, null))
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

        LoginResponse loginResponse = ReqresSpecs.request
                .body(setCredit(null, null))
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing email or username", loginResponse.getError());
    }

    @Test
    @DisplayName("Successful registry test")
    void successfulRegistryTest(){
        LoginResponse loginResponse = ReqresSpecs.request
                .body(setCredit(EMAIL, "pistol"))
                .when()
                .post("/register")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(LoginResponse.class);

        assertEquals(TOKEN, loginResponse.getToken());
    }

    @Test
    @DisplayName("Unsuccessful registry test without email")
    void unsuccessfulRegistryTestEmailNull(){
        LoginResponse loginResponse = ReqresSpecs.request
                .body(setCredit(null, PASSWORD))
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing email or username", loginResponse.getError());
    }

    @Test
    @DisplayName("Unsuccessful registry test without password")
    void unsuccessfulRegistryTestPasswordNull(){
        LoginResponse loginResponse = ReqresSpecs.request
                .body(setCredit(EMAIL, null))
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .extract().as(LoginResponse.class);

        assertEquals("Missing password", loginResponse.getError());
    }
}
