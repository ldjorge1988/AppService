package co.com.iot.uco.controller;

import co.com.iot.uco.dto.UserDTO;
import co.com.iot.uco.service.UserService;
import jakarta.websocket.server.PathParam;
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
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(userService.getUserByEmail(email));
    }

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable("email") String email) {
        userService.deleteUser(email);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return ResponseEntity.accepted().build();
    }

}
