package org.wirvsvirushackathon.helpado.services.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.session.SessionManager;
import org.wirvsvirushackathon.helpado.user.api.ViewUser;
import org.wirvsvirushackathon.helpado.user.storage.UserStorage;

import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * This class contains the test against the {@link UserService}
 * The used {@link org.wirvsvirushackathon.helpado.user.storage.UserStorage}
 * as well as the used {@link org.wirvsvirushackathon.helpado.session.SessionManager}
 * are mocked
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 22.03.2020
 */
public class UserServiceTest {

    static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    static private UserStorage userStorage;
    static private SessionManager sessionManager;
    static private UserService userService;


    @BeforeAll
    static void init(){
        logger.info("Init UserService test by mocking UserStorage and SessionManager");
        userStorage = mock(UserStorage.class);
        sessionManager = mock(SessionManager.class);

        userService = new UserService(userStorage, sessionManager);
    }

    @Test
    static void getUserInformationShouldReturnUserInformation(){
        logger.info("Testing getUserInformation method with an existing user");

        ViewUser testUser = new ViewUser();
        testUser.setUserId("test");
        when(userStorage.getViewUser(anyString())).thenReturn(Optional.of(testUser));


        Assertions.assertEquals("test", userService.getUserInformation("test", "token"));
    }
}
