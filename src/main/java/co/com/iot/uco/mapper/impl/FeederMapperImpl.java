package co.com.iot.uco.mapper.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.mapper.FeederMapper;
import co.com.iot.uco.model.Feeder;

public class FeederMapperImpl implements FeederMapper{

    @Override
    public Feeder toEntoty(FeederDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Feeder feeder = new Feeder();
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
