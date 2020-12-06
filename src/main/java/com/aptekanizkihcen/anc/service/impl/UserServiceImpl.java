package com.aptekanizkihcen.anc.service.impl;

import com.aptekanizkihcen.anc.enums.Role;
import com.aptekanizkihcen.anc.enums.Segment;
import com.aptekanizkihcen.anc.enums.Status;
import com.aptekanizkihcen.anc.exception.UserAlreadyExistsException;
import com.aptekanizkihcen.anc.model.Family;
import com.aptekanizkihcen.anc.model.User;
import com.aptekanizkihcen.anc.repository.UserRepository;
import com.aptekanizkihcen.anc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        if (userExist(user.getUsername())) {
            throw new UserAlreadyExistsException(
                    String.format("User with username %s already exist", user.getUsername()));
        }
        user.setFamily(new Family());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setSegment(Segment.GENERAL);
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
        user.setStatus(Status.DELETED);
        return userRepository.save(user);
    }

    private boolean userExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
