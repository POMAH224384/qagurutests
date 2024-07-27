package tests.restapi.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    String token;
    String error;
}
