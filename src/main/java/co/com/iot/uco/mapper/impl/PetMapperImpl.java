package co.com.iot.uco.mapper.impl;

import co.com.iot.uco.dto.PetDTO;
import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.PetMapper;
import co.com.iot.uco.model.Pet;
import co.com.iot.uco.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PetMapperImpl implements PetMapper {

    @Override
    public Pet toEntoty(PetDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Pet pet = new Pet();
            pet.setName(dto.getName());
            pet.setWeight(dto.getWeight());
            pet.setUser(buildUser(dto.getUser()));
            pet.setSpecies(dto.getSpecies());
            return pet;
        }
    }

    private User buildUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .fullName(userDTO.getFullName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
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
            petDTO.setUser(buildUserDTO(pet.getUser()));
            petDTO.setSpecies(pet.getSpecies());
            return petDTO;
        }
    }

    private UserDTO buildUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    @Override
    public List<Pet> toEntoties(List<PetDTO> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Pet> list = new ArrayList<>(dto.size());

            for (PetDTO petDTO : dto) {
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
            List<PetDTO> list = new ArrayList<>(pet.size());

            for (Pet pet1 : pet) {
                list.add(this.toDto(pet1));
            }

            return list;
        }
    }

}
