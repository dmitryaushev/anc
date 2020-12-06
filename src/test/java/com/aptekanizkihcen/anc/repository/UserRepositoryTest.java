package com.aptekanizkihcen.anc.repository;

import com.aptekanizkihcen.anc.config.Users;
import com.aptekanizkihcen.anc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource({"classpath:application-test.properties"})
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserBeEmailShouldReturnUser() {
        prepareData();
        User user = userRepository.findByUsername(Users.FIRST_USER_USERNAME).get();
        assertThat(user.getFirstName()).isEqualTo(Users.FIRST_USER_FIRST_NAME);
        assertThat(user.getLastName()).isEqualTo(Users.FIRST_USER_LAST_NAME);
    }

    @Test(expected = NoSuchElementException.class)
    public void testFindUserByEmailShouldReturnException() {
        prepareData();
        User user = userRepository.findByUsername(Users.INCORRECT_EMAIL).get();
    }


    private void prepareData() {
        testEntityManager.persist(Users.prepareUser());
        testEntityManager.flush();
    }

}
