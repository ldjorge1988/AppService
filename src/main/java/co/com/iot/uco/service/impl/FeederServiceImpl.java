package co.com.iot.uco.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.mapper.FeederMapper;
import co.com.iot.uco.model.Feeder;
import co.com.iot.uco.repository.FeederRepository;
import co.com.iot.uco.service.FeederService;

@Service
public class FeederServiceImpl implements FeederService {

    FeederRepository feederRepository;

    FeederMapper feederMapper;

    @Override
    public List<FeederDTO> getFeeders() {
        return feederMapper.toDtos(feederRepository.findAll());
    }

    @Override
    public void createFeeder(FeederDTO FeederDto) {
        feederRepository.save(feederMapper.toEntoty(FeederDto));
    }

    @Override
    public void deleteFeeder(Long id) {
        Feeder feeder = feederRepository.findFeederById(id);
        if(Objects.nonNull(feeder)){
            feederRepository.delete(feeder);
        }
        
        
    }

    @Override
    public void updateFeeder(FeederDTO feederDto) {
        Feeder feeder = feederRepository.findFeederById(feederDto.getId());
        if(Objects.nonNull(feeder)){
            feeder = feederMapper.toEntoty(feederDto);
            feederRepository.save(feeder);
        }
    }
    
}
