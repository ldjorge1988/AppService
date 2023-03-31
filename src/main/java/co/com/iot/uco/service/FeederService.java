package co.com.iot.uco.service;

import java.util.List;

import co.com.iot.uco.dto.FeederDTO;

public interface FeederService {
    List<FeederDTO> getFeeders();

    void createFeeder(FeederDTO FeederDto);

    void deleteFeeder(Long id);

    void updateFeeder(FeederDTO FeederDto);

    FeederDTO getFeederBySerial(String serial);
    
}
