package tests.restapi.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.restapi.base.UserTestBase;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("api")
public class UserTest extends UserTestBase {

    @Test
    @DisplayName("GET /users?page=2")
    @Owner("Nigger")
    void testListOfUsers(){
        step("Get a list of users", this::getListOfUsers);
    }

    @Test
    @DisplayName("GET /users/2")
    @Story("Get a user with id = 2")
    @Owner("Nigger")
    void testSingleUser(){
        step("Send a request to get a user by id", this::getUser);

        assertEquals(2, userData.getUserLombok().getId());
    }

    @Test
    @DisplayName("GET /users/29")
    @Owner("Nigger")
    void testSingleUserNotFound(){
        step("Send a request to a non-existent user", this::userNotFound);

    }

    @Test
    @DisplayName("POST /users")
    @Owner("Nigger")
    void testCreateUser(){
        step("Send a request to create a user",
                () -> createUser(NAME, JOB));

        assertTrue(userResponse.getName().equals(NAME)
                && userResponse.getJob().equals(JOB));
    }

    @Test
    @DisplayName("PUT /users/2")
    @Owner("Nigger")
    @Story("Updating user's name and job. User with an id = 2")
    void testUpdateUserName(){
        step("Send a request to update user by id",
                () -> updateUser(NAME, JOB));

        assertTrue(userResponse.getName().equals(NAME)
                && userResponse.getJob().equals(JOB));
    }

    @Test
    @DisplayName("PUT /users/2")
    @Owner("Nigger")
    void testUpdateUserWithNull(){
        step("Send a request to update user with null values",
                () -> updateUser(null, null));

        assertTrue(userResponse.getName() == null
                && userResponse.getJob() == null);
    }

    @Test
    @DisplayName("PATCH /users/2")
    @Owner("Nigger")
    void testUpdateUserWithPatch(){
        step("Send a request to update user by id",
                () -> updateUserPatch(NAME, JOB));

        assertTrue(userResponse.getName().equals(NAME)
                && userResponse.getJob().equals(JOB));
    }

    @Test
    @DisplayName("DELETE /user/2")
    @Owner("Nigger")
    void testDeleteUser(){
        step("Send a request to delete user", this::deleteUser);
    }

}
