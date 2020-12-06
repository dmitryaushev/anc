package com.aptekanizkihcen.anc.service;

import com.aptekanizkihcen.anc.enums.Segment;
import com.aptekanizkihcen.anc.model.User;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    User deleteUserByAdmin(int id);

    List<User> getAllUsers();

    User changeUserSegment(int id, Segment segment);

    Optional<User> getUserById(int id);
}
