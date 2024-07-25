package tests.restapi;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.restapi.lombok.UserDataLombok;
import tests.restapi.specs.ReqresSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
public class UserTest {

    @Test
    void singleUser(){
        ReqresSpecs.request
                .when()
                .get("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .log().body();
    }

//    @Test
//    void singleUserWithUserData(){
//        UserData data = ReqresSpecs.request
//                .when()
//                .get("/users/2")
//                .then()
//                .spec(ReqresSpecs.responseSpec)
//                .log().body()
//                .extract().as(UserData.class);
//
//        assertEquals(2, data.getData().getId());
//    }

    @Test
    void listOfUsers(){
        ReqresSpecs.request
                .when()
                .get("/users?page=2")
                .then()
                .log().body();
    }

    @Test
    void singleUserWithLombok(){
        UserDataLombok data = ReqresSpecs.request
                .when()
                .get("/users/2")
                .then()
                .spec(ReqresSpecs.responseSpec)
                .log().body()
                .extract().as(UserDataLombok.class);

        assertEquals(2, data.getUserLombok().getId());
    }
}
