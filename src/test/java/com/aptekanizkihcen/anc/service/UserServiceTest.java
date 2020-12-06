package com.aptekanizkihcen.anc.service;

import com.aptekanizkihcen.anc.config.TestConfig;
import com.aptekanizkihcen.anc.config.Users;
import com.aptekanizkihcen.anc.enums.Status;
import com.aptekanizkihcen.anc.exception.UserAlreadyExistsException;
import com.aptekanizkihcen.anc.model.User;
import com.aptekanizkihcen.anc.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUserShouldReturnUser() {
        User user = Users.createUser(Users.FIRST_USER_USERNAME, Users.FIRST_USER_PASSWORD, Users.FIRST_USER_FIRST_NAME,
                Users.FIRST_USER_MIDDLE_NAME, Users.FIRST_USER_LAST_NAME, Users.FIRST_USER_BIRTHDAY,
                Users.FIRST_USER_ITN);
        this.userService.registerUser(user);
        assertThat(user.getPassword()).isNotEqualTo(Users.FIRST_USER_PASSWORD);
        assertThat(user.getStatus()).isEqualTo(Status.ACTIVE);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void testRegisterUserShouldReturnException() {
        User user = Users.createUser(Users.FIRST_USER_USERNAME, Users.FIRST_USER_PASSWORD, Users.FIRST_USER_FIRST_NAME,
                Users.FIRST_USER_MIDDLE_NAME, Users.FIRST_USER_LAST_NAME, Users.FIRST_USER_BIRTHDAY,
                Users.FIRST_USER_ITN);
        when(userRepository.findByUsername(Users.FIRST_USER_USERNAME)).thenReturn(Optional.of(user));
        this.userService.registerUser(user);
    }

}
