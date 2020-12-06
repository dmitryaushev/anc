package com.aptekanizkihcen.anc.config;

import com.aptekanizkihcen.anc.enums.Role;
import com.aptekanizkihcen.anc.enums.Segment;
import com.aptekanizkihcen.anc.enums.Status;
import com.aptekanizkihcen.anc.model.User;

import java.time.LocalDate;
import java.util.List;

public class Users {

    public static final String FIRST_USER_USERNAME = "user1@mail.com";
    public static final String FIRST_USER_PASSWORD = "Password1";
    public static final String FIRST_USER_FIRST_NAME = "firstName1";
    public static final String FIRST_USER_MIDDLE_NAME = "middleName1";
    public static final String FIRST_USER_LAST_NAME = "lastName1";
    public static final LocalDate FIRST_USER_BIRTHDAY = LocalDate.of(2020, 10, 10);
    public static final String FIRST_USER_ITN = "1234567890";
    public static final String INCORRECT_EMAIL = "test@mail.com";

    public static User createUser(String username, String password, String firstName, String middleName, String lastName,
    LocalDate birthday, String itn) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        user.setItn(itn);
        user.setSegment(Segment.GENERAL);
        user.setRole(Role.ROLE_USER);
        user.setStatus(Status.ACTIVE);
        return user;
    }

    public static User prepareUser() {
        return Users.createUser(FIRST_USER_USERNAME, FIRST_USER_PASSWORD, FIRST_USER_FIRST_NAME, FIRST_USER_MIDDLE_NAME,
        FIRST_USER_LAST_NAME, FIRST_USER_BIRTHDAY, FIRST_USER_ITN);
    }

}
