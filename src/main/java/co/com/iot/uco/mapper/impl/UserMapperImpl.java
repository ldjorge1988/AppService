package co.com.iot.uco.mapper.impl;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.FeederMapper;
import co.com.iot.uco.mapper.PetMapper;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.model.User;
import co.com.iot.uco.service.impl.EncodeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final PetMapper petMapper;

    private final FeederMapper feederMapper;

    private final EncodeServiceImpl bcryptEncoder;

    public User toEntoty(UserDTO dto) {
        if (dto == null) {
            return null;
        } else {
            User user = new User();
            user.setId(dto.getId());
            user.setFullName(dto.getFullName());
            user.setEmail(dto.getEmail());
            user.setPassword(bcryptEncoder.encodeData(dto.getPassword()));
            user.setPhoneNumber(dto.getPhoneNumber());

            if (!CollectionUtils.isEmpty(dto.getPets()))
                user.setPets(petMapper.toEntoties(dto.getPets()));

            if (!CollectionUtils.isEmpty(dto.getFeeders()))
                user.setFeeders(feederMapper.toEntoties(dto.getFeeders()));

            return user;
        }
    }

    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFullName(user.getFullName());
            userDTO.setPassword(user.getPassword());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhoneNumber(user.getPhoneNumber());

            if (!CollectionUtils.isEmpty(user.getPets()))
                userDTO.setPets(petMapper.toDtos(user.getPets()));

            if (!CollectionUtils.isEmpty(user.getFeeders()))
                userDTO.setFeeders(feederMapper.toDtos(user.getFeeders()));

            return userDTO;
        }
    }

    public List<User> toEntoties(List<UserDTO> dto) {
        if (dto == null) {
            return null;
        } else {
            List<User> list = new ArrayList<>(dto.size());

            for (UserDTO userDTO : dto) {
                list.add(this.toEntoty(userDTO));
            }

            return list;
        }
    }

    public List<UserDTO> toDtos(List<User> user) {
        if (user == null) {
            return null;
        } else {
            List<UserDTO> list = new ArrayList<>(user.size());

            for (User userIn : user) {
                list.add(this.toDto(userIn));
            }

            return list;
        }
    }
}
