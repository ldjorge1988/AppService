package co.com.iot.uco.mapper;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    User toEntoty(UserDTO dto);

    UserDTO toDto(User user);

    List<User> toEntoties(List<UserDTO> dto);

    List<UserDTO> toDtos(List<User> user);
}
