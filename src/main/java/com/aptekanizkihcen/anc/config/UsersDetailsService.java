package com.aptekanizkihcen.anc.config;

import com.aptekanizkihcen.anc.model.User;
import com.aptekanizkihcen.anc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UsersDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new RuntimeException(String.format("User with email %s not exist", username)));
        return new UserPrincipal(user);
    }
}
