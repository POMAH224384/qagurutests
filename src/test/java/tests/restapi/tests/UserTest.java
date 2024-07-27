package tests.restapi.tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.restapi.base.UserTestBase;
import tests.restapi.models.responses.UserDataResponse;
import tests.restapi.models.responses.UserResponse;
import tests.restapi.specs.ReqresSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("api")
public class UserTest extends UserTestBase {

    @Test
    @DisplayName("Get a list of users")
    void testListOfUsers(){
        ReqresSpecs.request
                .when()
                .get("/users?page=2")
                .then()
                .spec(ReqresSpecs.responseSpec);
    }

    @Test
    @DisplayName("Get a single user")
    @Story("Get a user with id = 2")
    void testSingleUser(){
        UserDataResponse data = ReqresSpecs.request
                .when()
                .get("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .log().body()
                .extract().as(UserDataResponse.class);

        assertEquals(2, data.getUserLombok().getId());
    }

    @Test
    @DisplayName("Single user not found")
    void testSingleUserNotFound(){
        ReqresSpecs.request
                .when()
                .get("/users/29")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("Create user")
    void testCreateUser(){
        UserResponse user = ReqresSpecs.request
                .body(setUserBody(NAME, JOB))
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().as(UserResponse.class);

        assertTrue(user.getName().equals(NAME) && user.getJob().equals(JOB));
    }

    @Test
    @DisplayName("Update user's name and job")
    @Story("Updating user's name and job. User with an id = 2")
    void testUpdateUserName(){
        UserResponse user = ReqresSpecs.request
                .body(setUserBody(NAME, JOB))
                .when()
                .put("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(UserResponse.class);

        assertTrue(user.getName().equals(NAME) && user.getJob().equals(JOB));
    }

    @Test
    @DisplayName("Update user's name with null values")
    void testUpdateUserWithNull(){
        UserResponse user = ReqresSpecs.request
                .body(setUserBody(null, null))
                .log().all()
                .when()
                .put("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .log().all()
                .extract().as(UserResponse.class);

        assertTrue(user.getName() == null && user.getJob() == null);
    }

    @Test
    @DisplayName("Update user's name and job using PATCH")
    void testUpdateUserWithPatch(){
        UserResponse user = ReqresSpecs.request
                .body(setUserBody(NAME, JOB))
                .when()
                .patch("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(UserResponse.class);

        assertTrue(user.getName().equals(NAME) && user.getJob().equals(JOB));
    }

    @Test
    @DisplayName("Delete user")
    void testDeleteUser(){
        ReqresSpecs.request
                .when()
                .delete("/user/2")
                .then()
                .statusCode(204);
    }

}
