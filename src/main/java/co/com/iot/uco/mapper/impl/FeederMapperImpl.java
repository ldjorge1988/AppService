package co.com.iot.uco.mapper.impl;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.mapper.FeederMapper;
import co.com.iot.uco.mapper.PetMapper;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.model.Feeder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FeederMapperImpl implements FeederMapper {

    private final UserMapper userMapper;

    private final PetMapper petMapper;

    @Override
    public Feeder toEntoty(FeederDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Feeder feeder = new Feeder();
            feeder.setName(dto.getName());
            feeder.setSerial(dto.getSerial());
            feeder.setUser(userMapper.toEntoty(dto.getUser()));
            feeder.setPet(petMapper.toEntoty(dto.getPet()));
            return feeder;
        }
    }

    @Override
    public FeederDTO toDto(Feeder feeder) {
        if (feeder == null) {
            return null;
        } else {
            FeederDTO feederDTO = new FeederDTO();
            feederDTO.setId(feeder.getId());
            feederDTO.setName(feeder.getName());
            feederDTO.setSerial(feeder.getSerial());
            feederDTO.setUser(userMapper.toDto(feeder.getUser()));
            feederDTO.setPet(petMapper.toDto(feeder.getPet()));
            return feederDTO;
        }
    }

    @Override
    public List<Feeder> toEntoties(List<FeederDTO> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Feeder> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while (var3.hasNext()) {
                FeederDTO feederDto = (FeederDTO) var3.next();
                list.add(this.toEntoty(feederDto));
            }

            return list;
        }
    }

    @Override
    public List<FeederDTO> toDtos(List<Feeder> feeder) {
        if (feeder == null) {
            return null;
        } else {
            List<FeederDTO> list = new ArrayList(feeder.size());
            Iterator var3 = feeder.iterator();

            while (var3.hasNext()) {
                Feeder feeder1 = (Feeder) var3.next();
                list.add(this.toDto(feeder1));
            }

            return list;
        }
    }

}
