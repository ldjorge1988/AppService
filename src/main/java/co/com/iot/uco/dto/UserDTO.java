package co.com.iot.uco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 4758111801258236935L;

    private Long id;
    private Long identification;
    private String name;
    private String userName;
    private String password;
    private String email;
}
