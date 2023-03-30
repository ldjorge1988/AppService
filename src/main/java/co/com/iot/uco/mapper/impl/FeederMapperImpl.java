package co.com.iot.uco.mapper.impl;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.FeederMapper;
import co.com.iot.uco.mapper.PetMapper;
import co.com.iot.uco.model.Feeder;
import co.com.iot.uco.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FeederMapperImpl implements FeederMapper {

    private final PetMapper petMapper;

    @Override
    public Feeder toEntoty(FeederDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Feeder feeder = new Feeder();
            feeder.setName(dto.getName());
            feeder.setSerial(dto.getSerial());
            feeder.setUser(buildUser(dto.getUser()));
            feeder.setPet(petMapper.toEntoty(dto.getPet()));
            feeder.setSchedulePet(dto.getSchedulePet());
            return feeder;
        }
    }

    private User buildUser(UserDTO user) {
        return User.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
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
            feederDTO.setUser(buildUserDTO(feeder.getUser()));
            feederDTO.setPet(petMapper.toDto(feeder.getPet()));
            feederDTO.setSchedulePet(feeder.getSchedulePet());
            return feederDTO;
        }
    }

    private UserDTO buildUserDTO(User user) {
        return UserDTO.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    @Override
    public List<Feeder> toEntoties(List<FeederDTO> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Feeder> list = new ArrayList<>(dto.size());

            for (FeederDTO feederDto : dto) {
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
            List<FeederDTO> list = new ArrayList<>(feeder.size());

            for (Feeder feederIn : feeder) {
                list.add(this.toDto(feederIn));
            }

            return list;
        }
    }

}
