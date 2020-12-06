package com.aptekanizkihcen.anc.controller;

import com.aptekanizkihcen.anc.dto.UserDTO;
import com.aptekanizkihcen.anc.model.User;
import com.aptekanizkihcen.anc.service.UserService;
import com.aptekanizkihcen.anc.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registration")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.registerUser(UserMapper.userDTOtoUser(userDTO));
        userDTO = UserMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.updateUser(UserMapper.userDTOtoUser(userDTO));
        userDTO = UserMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping
    public ResponseEntity<UserDTO> deleteUser(@RequestBody UserDTO userDTO) {
        User user = userService.deleteUser(UserMapper.userDTOtoUser(userDTO));
        userDTO = UserMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }
}
