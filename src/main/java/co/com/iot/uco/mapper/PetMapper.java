package co.com.iot.uco.mapper;

import java.util.List;

import co.com.iot.uco.dto.PetDTO;
import co.com.iot.uco.model.Pet;

public interface PetMapper {
    Pet toEntoty(PetDTO dto);

    PetDTO toDto(Pet pet);

    List<Pet> toEntoties(List<PetDTO> dto);

    List<PetDTO> toDtos(List<Pet> pet);

}
