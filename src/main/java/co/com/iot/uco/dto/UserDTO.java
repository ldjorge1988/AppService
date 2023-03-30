package co.com.iot.uco.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 4758111801258236935L;

    private Long id;
    private String fullName;
    private String password;
    private String email;
    private String phoneNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FeederDTO> feeders;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PetDTO> pets;
}
