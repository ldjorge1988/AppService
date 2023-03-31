package co.com.iot.uco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.iot.uco.dto.LoginDTO;
import co.com.iot.uco.dto.UserAuthDTO;
import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.mapper.UserMapper;
import co.com.iot.uco.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EncodeServiceImpl bcryptEncoder;

    
    
    public UserAuthDTO login(LoginDTO login ){
        UserDTO userDTO= userMapper.toDto(userRepository.findUserByEmail(login.getEmail()));
        if(userDTO != null && userDTO.getPassword().equals(bcryptEncoder.encodeData(login.getPassword()))){
            return new UserAuthDTO(userDTO);
         }
         else {
            return null;
         }


    }



    
}
