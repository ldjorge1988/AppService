package co.com.iot.uco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private long id;
    private String name;
    private double weight;
    private UserDTO user;
    private FeederDTO feeder;
}
