package tests.restapi.models.bodies;

import lombok.Data;

@Data
public class LoginBody {

    private String email,
            password;
}
