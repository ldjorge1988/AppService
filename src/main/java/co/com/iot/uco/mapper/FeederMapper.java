package co.com.iot.uco.mapper;

import java.util.List;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.model.Feeder;

public interface FeederMapper {
    Feeder toEntoty(FeederDTO dto);

    FeederDTO toDto(Feeder feeder);

    List<Feeder> toEntoties(List<FeederDTO> dto);

    List<FeederDTO> toDtos(List<Feeder> feeder);
}
    

