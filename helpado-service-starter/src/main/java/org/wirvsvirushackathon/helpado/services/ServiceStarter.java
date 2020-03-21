package org.wirvsvirushackathon.helpado.services;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    }
}
