package co.com.iot.uco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticateDTO {
    private UserAuthDTO user;
    private String token;

    
}
