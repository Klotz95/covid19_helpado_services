package org.wirvsvirushackathon.helpado.services;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.order.storage.OrderStorage;
import org.wirvsvirushackathon.helpado.order.storage.OrderStorageMockImpl;
import org.wirvsvirushackathon.helpado.services.order.OrderService;
import org.wirvsvirushackathon.helpado.services.user.UserService;
import org.wirvsvirushackathon.helpado.session.SessionManager;
import org.wirvsvirushackathon.helpado.session.SessionManagerImpl;
import org.wirvsvirushackathon.helpado.user.storage.UserStorage;
import org.wirvsvirushackathon.helpado.user.storage.UserStorageMockImpl;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
        this.configureCors(environment);

        UserStorage userStorage = new UserStorageMockImpl();
        SessionManager sessionManager = new SessionManagerImpl();

        UserService userService = new UserService(userStorage,sessionManager);

        environment.jersey().register(userService);

        OrderStorage orderStorage = new OrderStorageMockImpl();
        OrderService orderService = new OrderService(orderStorage, sessionManager);
        environment.jersey().register(orderService);
    }

    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }
}
