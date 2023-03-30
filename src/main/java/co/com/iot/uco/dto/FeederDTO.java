package co.com.iot.uco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeederDTO {
    private Long id;
    private String serial;
    private String name;
    private PetDTO pet;
    private UserDTO user;
}
