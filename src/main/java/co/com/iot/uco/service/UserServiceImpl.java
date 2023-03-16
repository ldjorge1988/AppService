package co.com.iot.uco.service;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }
}
