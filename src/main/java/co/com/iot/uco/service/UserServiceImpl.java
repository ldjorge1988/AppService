package co.com.iot.uco.service;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.model.User;
import co.com.iot.uco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private PasswordEncoder bcryptEncoder;

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    public UserDTO getUserByIdentification(Long identification) {
        return userMapper.toDto(userRepository.findUserByIdentification(identification));
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        return userMapper.toDto(userRepository.findUserByUserName(userName));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userDTO.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        userRepository.save(userMapper.toEntoty(userDTO));
    }

    @Override
    public void deleteUser(Long identification) {
        User user = userRepository.findUserByIdentification(identification);
        if(Objects.nonNull(user)){
            userRepository.delete(user);
        }
    }

    /*@Override
    public void updateUser(UserDTO userDTO) {
        User user = userRepository.findUserByIdentification(userDTO.getIdentification());
        if(Objects.nonNull(user)){
            user = userMapper.toEntoty(userDTO);
            userRepository.save(user);
        }
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
}
