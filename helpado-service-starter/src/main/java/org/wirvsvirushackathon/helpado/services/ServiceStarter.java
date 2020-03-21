package org.wirvsvirushackathon.helpado.services;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.services.user.UserService;
import org.wirvsvirushackathon.helpado.session.SessionManager;
import org.wirvsvirushackathon.helpado.session.SessionManagerImpl;
import org.wirvsvirushackathon.helpado.user.storage.UserStorage;
import org.wirvsvirushackathon.helpado.user.storage.UserStorageMockImpl;

/**
 * This class will startup the following specified services:
 *
 * - User Service
 *
 * The service will startup at default at port 3000
 *
 * @author NKO (NicoKotlenga@live.de
 * @since 21.03.2020
 */
public class ServiceStarter extends Application<ServiceConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(ServiceStarter.class);


    public static void main(String[] args) throws Exception {
        new ServiceStarter().run(args);
    }

    public void run(ServiceConfiguration serviceConfiguration, Environment environment) throws Exception {
        UserStorage userStorage = new UserStorageMockImpl();
        SessionManager sessionManager = new SessionManagerImpl();

        UserService userService = new UserService(userStorage,sessionManager);

        environment.jersey().register(userService);
    }
}
