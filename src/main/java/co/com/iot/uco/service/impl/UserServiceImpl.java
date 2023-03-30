package co.com.iot.uco.service.impl;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.model.User;
import co.com.iot.uco.repository.UserRepository;
import co.com.iot.uco.service.UserService;
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
public class UserServiceImpl implements UserService, UserDetailsService  {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    //private PasswordEncoder bcryptEncoder;

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapper.toDto(userRepository.findUserByEmail(email));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        //userDTO.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        userRepository.save(userMapper.toEntoty(userDTO));
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findUserById(id);
        if(Objects.nonNull(user)){
            userRepository.delete(user);
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userRepository.findUserById(userDTO.getId());
        if(Objects.nonNull(user)){
            user = userMapper.toEntoty(userDTO);
            userRepository.save(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return null;
    }


    }

    
