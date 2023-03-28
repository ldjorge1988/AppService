package co.com.iot.uco.service;

import java.util.List;

import co.com.iot.uco.dto.PetDTO;

public interface PetSerivice {
    
    List<PetDTO> getPets();

    void createPet(PetDTO PetDTO);

    void deletePet(Long id);

    void updatePet(PetDTO PetDTO);
}
