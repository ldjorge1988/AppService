package co.com.iot.uco.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.iot.uco.dto.PetDTO;
import co.com.iot.uco.mapper.PetMapper;
import co.com.iot.uco.model.Pet;
import co.com.iot.uco.repository.PetRepository;
import co.com.iot.uco.service.PetSerivice;

@Service
public class PetServiceImpl implements PetSerivice{
    @Autowired
    PetRepository petRepository;
    
    PetMapper petMapper;

    @Override
    public List<PetDTO> getPets() {
        return petMapper.toDtos(petRepository.findAll());
    }

    @Override
    public void createPet(PetDTO PetDTO) {
        petRepository.save(petMapper.toEntoty(PetDTO));
    }

    @Override
    public void deletePet(Long id) {
        Pet pet = petRepository.findPetById(id);
        if(Objects.nonNull(pet)){
            petRepository.delete(pet);
        }
    }

    @Override
    public void updatePet(PetDTO petDTO) {
        Pet pet = petRepository.findPetById(petDTO.getId());
        if(Objects.nonNull(pet)){
            pet = petMapper.toEntoty(petDTO);
            petRepository.save(pet);
        }
    }

   

    
    
}
