package co.com.iot.uco.mapper.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.iot.uco.dto.PetDTO;
import co.com.iot.uco.mapper.PetMapper;
import co.com.iot.uco.model.Pet;

public class PetMapperImpl implements PetMapper{

    @Override
    public Pet toEntoty(PetDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Pet pet = new Pet();
            return pet;
        }
    }

    @Override
    public PetDTO toDto(Pet pet) {
        if (pet == null) {
            return null;
        } else {
            PetDTO petDTO = new PetDTO();
            petDTO.setId(pet.getId());
            petDTO.setName(pet.getName());
            petDTO.setWeight(pet.getWeight());
            
            
            return petDTO;
        }
    }

    @Override
    public List<Pet> toEntoties(List<PetDTO> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Pet> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while (var3.hasNext()) {
                PetDTO petDTO = (PetDTO) var3.next();
                list.add(this.toEntoty(petDTO));
            }

            return list;
        }
    }

    @Override
    public List<PetDTO> toDtos(List<Pet> pet) {
        if (pet == null) {
            return null;
        } else {
            List<PetDTO> list = new ArrayList(pet.size());
            Iterator var3 = pet.iterator();

            while (var3.hasNext()) {
                Pet pet1 = (Pet) var3.next();
                list.add(this.toDto(pet1));
            }

            return list;
        }
    }
    
}
