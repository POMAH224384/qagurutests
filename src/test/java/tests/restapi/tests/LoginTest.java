package tests.restapi.tests;

import io.qameta.allure.Owner;
import tests.restapi.base.LoginTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
public class LoginTest extends LoginTestBase {

    @Test
    @Owner("Z")
    @DisplayName("Successful Login with password and email")
    void successfulLoginTest(){
        step("Send a request to login with email and password",
                () -> successfulLogin(EMAIL, PASSWORD));

        assertEquals(TOKEN, loginResponse.getToken());
    }

    @Test
    @Owner("Z")
    @DisplayName("Unsuccessful login without email")
    void unsuccessfulLoginTestEmailNull(){
        step("Send a request to login without email",
                () -> unsuccessfulLogin(null, PASSWORD));

        assertEquals("Missing email or username", loginResponse.getError());
    }

    @Test
    @Owner("Z")
    @DisplayName("Unsuccessful login without password")
    void unsuccessfulLoginTestPasswordNull(){
        step("Send a request to login without password",
                () -> unsuccessfulLogin(EMAIL, null));

        assertEquals("Missing password", loginResponse.getError());
    }

    @Test
    @Owner("Z")
    @DisplayName("Unsuccessful login without email and password")
    void unsuccessfulLoginTestBodyNull(){
        step("Send a request to login without email and password",
                () -> unsuccessfulLogin(null, null));

        assertEquals("Missing email or username", loginResponse.getError());
    }

    @Test
    @Owner("Z")
    @DisplayName("Successful registry test")
    void successfulRegistryTest(){
        step("Send a request to registry with email and password",
                () -> successfulRegistry(EMAIL, "pistol"));

        assertEquals(TOKEN, loginResponse.getToken());
    }

    @Test
    @Owner("Z")
    @DisplayName("Unsuccessful registry test without email")
    void unsuccessfulRegistryTestEmailNull(){
        step("Send a request to registry without email",
                () -> unsuccessfulRegistry(null, PASSWORD));

        assertEquals("Missing email or username", loginResponse.getError());
    }

    @Test
    @Owner("Z")
    @DisplayName("Unsuccessful registry test without password")
    void unsuccessfulRegistryTestPasswordNull(){
        step("Send a request to registry without password",
                () -> unsuccessfulRegistry(EMAIL, null));

        assertEquals("Missing password", loginResponse.getError());
    }
}
