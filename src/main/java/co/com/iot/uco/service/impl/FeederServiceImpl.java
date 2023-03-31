package co.com.iot.uco.service.impl;

import java.util.List;
import java.util.Objects;

import co.com.iot.uco.client.BackendClient;
import co.com.iot.uco.dto.FeederRequestDTO;
import org.springframework.stereotype.Service;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.mapper.FeederMapper;
import co.com.iot.uco.model.Feeder;
import co.com.iot.uco.repository.FeederRepository;
import co.com.iot.uco.service.FeederService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeederServiceImpl implements FeederService {

    private final FeederRepository feederRepository;

    private final FeederMapper feederMapper;

    private final BackendClient backendClient;

    @Override
    public List<FeederDTO> getFeeders() {
        return feederMapper.toDtos(feederRepository.findAll());
    }

    @Override
    public void createFeeder(FeederDTO FeederDto) {
        feederRepository.save(feederMapper.toEntoty(FeederDto));
        FeederRequestDTO feederRequestDTO = FeederRequestDTO.builder()
                .quantity("4")
                .schedule("test")
                .serial("eqwe32")
                .build();
        backendClient.sendDataFeeder(feederRequestDTO);
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

    @Override
    public FeederDTO getFeederBySerial(String serial) {
        Feeder feeder = feederRepository.findFeederBySerial(serial);
        FeederDTO feederDTO = null;
        if (Objects.nonNull(feeder)){
             feederDTO = feederMapper.toDto(feeder);
        }
        return feederDTO;
    }

}
