package co.com.iot.uco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeederDTO {

    @JsonProperty("petId")
    private Long id;
    private String serial;
    private String name;
    private PetDTO pet;
    private UserDTO user;
    @JsonProperty("scheduleList")
    private String schedulePet;
}
