package com.aptekanizkihcen.anc.service.mapper;

import com.aptekanizkihcen.anc.dto.UserDTO;
import com.aptekanizkihcen.anc.model.User;

public class UserMapper {

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setMiddleName(user.getMiddleName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setItn(user.getItn());
        userDTO.setFamilyStatus(user.getFamilyStatus());
        userDTO.setEducation(user.getEducation());
        userDTO.setSegment(user.getSegment());
        userDTO.setStatus(user.getStatus());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public static User userDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setBirthday(userDTO.getBirthday());
        user.setItn(userDTO.getItn());
        user.setFamilyStatus(userDTO.getFamilyStatus());
        user.setEducation(userDTO.getEducation());
        user.setSegment(userDTO.getSegment());
        user.setStatus(userDTO.getStatus());
        user.setRole(userDTO.getRole());
        return user;
    }
}
