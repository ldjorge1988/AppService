package co.com.iot.uco.service;

import co.com.iot.uco.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

    void createUser(UserDTO userDTO);

    void deleteUser(String email);

    void updateUser(UserDTO userDTO);

    UserDTO getUserByEmail(String email);
}
