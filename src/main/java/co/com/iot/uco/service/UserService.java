package co.com.iot.uco.service;

import co.com.iot.uco.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
