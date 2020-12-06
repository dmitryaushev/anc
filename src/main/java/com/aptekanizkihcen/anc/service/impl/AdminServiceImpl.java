package com.aptekanizkihcen.anc.service.impl;

import com.aptekanizkihcen.anc.enums.Segment;
import com.aptekanizkihcen.anc.enums.Status;
import com.aptekanizkihcen.anc.model.User;
import com.aptekanizkihcen.anc.repository.UserRepository;
import com.aptekanizkihcen.anc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private UserRepository userRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUserByAdmin(int id) {
        userRepository.changeUserStatus(id, Status.DELETED.getStatus());
        return userRepository.findById(id).get();
    }

    @Override
    public User changeUserSegment(int id, Segment segment) {
        userRepository.changeUserSegment(id, segment.getSegment());
        return userRepository.findById(id).get();
    }
}
