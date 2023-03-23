package co.com.iot.uco.service;

import co.com.iot.uco.dto.PetDTO;

public interface PetService {
    void createPet(PetDTO PetDTO);

    void deletePet(PetDTO identification);

    void updatePet(PetDTO PetDTO);
    
}
