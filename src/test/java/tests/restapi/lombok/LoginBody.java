package tests.restapi.lombok;

import lombok.Data;

@Data
public class LoginBody {
    String email;
    String password;
}
