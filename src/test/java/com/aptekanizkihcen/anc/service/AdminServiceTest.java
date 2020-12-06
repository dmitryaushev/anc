package com.aptekanizkihcen.anc.service;

import com.aptekanizkihcen.anc.config.TestConfig;
import com.aptekanizkihcen.anc.model.User;
import com.aptekanizkihcen.anc.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class AdminServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private AdminService adminService;

    @Test
    public void testGetAllUsersShouldReturnEmptyList() {
        when(userRepository.findAll()).thenReturn(List.of());
        List<User> users = this.adminService.getAllUsers();
        assertThat(users.size()).isEqualTo(0);
    }
}
