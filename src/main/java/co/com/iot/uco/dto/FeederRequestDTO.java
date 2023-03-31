package co.com.iot.uco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeederRequestDTO {

    private String serial;

    @JsonProperty("cantidad")
    private String quantity;

    @JsonProperty("horario")
    private String schedule;

}
