package tests.restapi.lombok;

import lombok.Data;

@Data
public class LoginResponse {
    String token;
    String error;
}
