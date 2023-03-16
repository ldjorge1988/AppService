package co.com.iot.uco.service;

import co.com.iot.uco.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

    UserDTO getUserByIdentification(Long identification);

    void createUser(UserDTO userDTO);

    void deleteUser(Long identification);

    void updateUser(UserDTO userDTO);
}
