package tests.restapi.models.responses;

import lombok.Data;

@Data
public class LoginResponse {
    String token;
    String error;
}
