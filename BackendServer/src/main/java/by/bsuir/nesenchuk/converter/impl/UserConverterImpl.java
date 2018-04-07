package by.bsuir.nesenchuk.converter.impl;

import by.bsuir.nesenchuk.converter.UserConverter;
import by.bsuir.nesenchuk.dto.UserDTO;
import by.bsuir.nesenchuk.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    @Override
    public List<UserDTO> convertToDTOList(List<User> userList) {
        List<UserDTO> userDTOs = new ArrayList<>(userList.size());
        userDTOs.addAll(userList.stream().map(this::convertToDTO).collect(Collectors.toList()));
        return userDTOs;
    }
}
