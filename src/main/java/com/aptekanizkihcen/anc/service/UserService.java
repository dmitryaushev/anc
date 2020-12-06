package com.aptekanizkihcen.anc.service;

import com.aptekanizkihcen.anc.model.User;

public interface UserService {
    User registerUser(User user);

    User updateUser(User user);

    User deleteUser(User user);
}
