package co.com.iot.uco.mapper.impl;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.model.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@NoArgsConstructor
public class UserMapperImpl implements UserMapper {

    public User toEntoty(UserDTO dto) {
        if (dto == null) {
            return null;
        } else {
            User user = new User();
            user.setFullName(dto.getFullName());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setPhoneNumber(dto.getPhoneNumber());
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
            return userDTO;
        }
    }

    public List<User> toEntoties(List<UserDTO> dto) {
        if (dto == null) {
            return null;
        } else {
            List<User> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while (var3.hasNext()) {
                UserDTO userDTO = (UserDTO) var3.next();
                list.add(this.toEntoty(userDTO));
            }

            return list;
        }
    }

    public List<UserDTO> toDtos(List<User> user) {
        if (user == null) {
            return null;
        } else {
            List<UserDTO> list = new ArrayList(user.size());
            Iterator var3 = user.iterator();

            while (var3.hasNext()) {
                User user1 = (User) var3.next();
                list.add(this.toDto(user1));
            }

            return list;
        }
    }
}
