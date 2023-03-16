package co.com.iot.uco.controller;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{identification}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long identification){
        return ResponseEntity.ok().body(userService.getUserByIdentification(identification));
    }

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(UserDTO userDTO){
        userService.createUser(userDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/user/{identification}")
    public ResponseEntity<Void> deleteUser(Long identification){
        userService.deleteUser(identification);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(UserDTO userDTO){
        userService.updateUser(userDTO);
        return ResponseEntity.accepted().build();
    }
}
