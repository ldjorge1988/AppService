package co.com.iot.uco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.iot.uco.dto.AuthenticateDTO;
import co.com.iot.uco.dto.LoginDTO;
import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.service.impl.AuthenticationServiceImpl;
import co.com.iot.uco.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticateController {

    private final AuthenticationServiceImpl authenticationServiceImpl;
    @PostMapping("/login")
    public ResponseEntity<AuthenticateDTO> createpet(@RequestBody LoginDTO login){

       

        authenticationServiceImpl.login(login);
        ResponseEntity.accepted().build();
    }


    
}
