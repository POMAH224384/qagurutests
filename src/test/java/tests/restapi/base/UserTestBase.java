package tests.restapi.base;

import tests.restapi.models.bodies.UserBody;
import tests.restapi.models.responses.UserDataResponse;
import tests.restapi.models.responses.UserResponse;
import tests.restapi.specs.ReqresSpecs;
import utils.PropertiesUtil;

public class UserTestBase extends MainTestBase{

    private static final UserBody USER_BODY = new UserBody();

    protected static UserDataResponse userData;
    protected static UserResponse userResponse;

    public UserBody setUserBody(String name, String job){
        USER_BODY.setName(name);
        USER_BODY.setJob(job);
        return USER_BODY;
    }

    public void getListOfUsers(){
        ReqresSpecs.request
                .when()
                .get("/users?page=2")
                .then()
                .spec(ReqresSpecs.responseSpec);
    }

    public void getUser(){
        userData = ReqresSpecs.request
                .when()
                .get("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .log().body()
                .extract().as(UserDataResponse.class);
    }

    public void userNotFound(){
        ReqresSpecs.request
                .when()
                .get("/users/29")
                .then()
                .statusCode(404);
    }

    public void createUser(String name, String job){
        userResponse = ReqresSpecs.request
                .body(setUserBody(name, job))
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().as(UserResponse.class);
    }

    public void updateUser(String name, String job){
        userResponse = ReqresSpecs.request
                .body(setUserBody(name, job))
                .when()
                .put("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(UserResponse.class);
    }

    public void updateUserPatch(String name, String job){
        userResponse = ReqresSpecs.request
                .body(setUserBody(name, job))
                .when()
                .patch("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .extract().as(UserResponse.class);
    }

    public void deleteUser(){
        ReqresSpecs.request
                .when()
                .delete("/user/2")
                .then()
                .statusCode(204);
    }
}
