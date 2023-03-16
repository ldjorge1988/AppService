package co.com.iot.uco.service;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.model.User;
import co.com.iot.uco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    public UserDTO getUserByIdentification(Long identification) {
        return userMapper.toDto(userRepository.findUserByIdentification(identification));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepository.save(userMapper.toEntoty(userDTO));
    }

    @Override
    public void deleteUser(Long identification) {
        User user = userRepository.findUserByIdentification(identification);
        if(Objects.nonNull(user)){
            userRepository.delete(user);
        }
    }

}
