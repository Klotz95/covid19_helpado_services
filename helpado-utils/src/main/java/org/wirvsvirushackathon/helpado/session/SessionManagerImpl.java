package org.wirvsvirushackathon.helpado.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is an implementation of the {@link SessionManager} interface
 * TODO: Add a timeout to a session
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class SessionManagerImpl implements SessionManager {

    private static final Logger logger = LoggerFactory.getLogger(SessionManagerImpl.class);

    private final Map<String, String> userIdsToSessionToken;

    public SessionManagerImpl() {
        this.userIdsToSessionToken = new ConcurrentHashMap<>();
    }

    @Override
    public String generateSessionToken(String userId) {
        logger.debug("Generate session token for user having id {}", userId);
        String sessionToken = UUID.randomUUID().toString();
        this.userIdsToSessionToken.put(userId, sessionToken);

        return sessionToken;
    }

    @Override
    public boolean validateSessionToken(String userId, String sessionToken) {
        logger.trace("Validate session token of user having id {}", userId);
        String savedSessionToken = userIdsToSessionToken.get(userId);

        return savedSessionToken.equals(sessionToken);
    }

    @Override
    public boolean endSession(String userId, String sessionToken) {
        if (validateSessionToken(userId, sessionToken)) {
            logger.debug("End session of user having user id {}", userId);
            userIdsToSessionToken.remove(userId);
            return true;
        }

        return false;
    }
}
