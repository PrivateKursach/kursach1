package by.bsuir.nesenchuk.converter;

import by.bsuir.nesenchuk.dto.UserDTO;
import by.bsuir.nesenchuk.entity.User;

import java.util.List;

public interface UserConverter {
    UserDTO convertToDTO(User user);
    User convertToEntity(UserDTO userDTO);
    List<UserDTO> convertToDTOList(List<User> userList);
}
