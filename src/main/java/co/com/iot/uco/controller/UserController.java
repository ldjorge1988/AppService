package co.com.iot.uco.controller;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
