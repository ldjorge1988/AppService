package co.com.iot.uco.dto;

import lombok.Data;

@Data
public class UserAuthDTO {
    private long id;
    private String fullName;
    private String email;
    private String phoneNumber;

    public UserAuthDTO(UserDTO userDTO){
        setId(userDTO.getId());
        setFullName(userDTO.getFullName());
        setEmail(userDTO.getEmail());
        setPhoneNumber(userDTO.getPhoneNumber());
    }
    
}
