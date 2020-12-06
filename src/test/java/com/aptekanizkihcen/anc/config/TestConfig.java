package com.aptekanizkihcen.anc.config;

import com.aptekanizkihcen.anc.repository.UserRepository;
import com.aptekanizkihcen.anc.service.AdminService;
import com.aptekanizkihcen.anc.service.UserService;
import com.aptekanizkihcen.anc.service.impl.AdminServiceImpl;
import com.aptekanizkihcen.anc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@TestConfiguration
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public AdminService adminService() {
        return new AdminServiceImpl(userRepository);
    }
}
