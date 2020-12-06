package com.aptekanizkihcen.anc.controller;

import com.aptekanizkihcen.anc.dto.UserDTO;
import com.aptekanizkihcen.anc.enums.Segment;
import com.aptekanizkihcen.anc.model.User;
import com.aptekanizkihcen.anc.service.AdminService;
import com.aptekanizkihcen.anc.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("get-user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") int id) {
        Optional<User> userOptional = adminService.getUserById(id);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserDTO userDTO = UserMapper.userToUserDTO(userOptional.get());
        return ResponseEntity.ok(userDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("get-all-users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> usersDTO = getUsersDTO(adminService.getAllUsers());
        return ResponseEntity.ok(usersDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<UserDTO> deleteUserByAdmin(@PathVariable("id") int id) {
        User user = adminService.deleteUserByAdmin(id);
        UserDTO userDTO = UserMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("change-user-segment/{id}")
    public ResponseEntity<UserDTO> changeUserSegment(@PathVariable("id") int id, @RequestParam Segment segment) {
        User user = adminService.changeUserSegment(id, segment);
        UserDTO userDTO = UserMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    private List<UserDTO> getUsersDTO(List<User> users) {
        return users
                .stream()
                .map(UserMapper::userToUserDTO)
                .collect(Collectors.toList());
    }
}
