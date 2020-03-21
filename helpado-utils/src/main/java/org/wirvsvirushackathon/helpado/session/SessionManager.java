package org.wirvsvirushackathon.helpado.session;

/**
 * This interface describes the functions of a session manager.
 * A session manager generate user session and offers a checkup function
 * to validate a session token
 *
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public interface SessionManager {

    /**
     * Generates a session token
     * @param userId of the User for which a session token will be generated
     * @return the generated sessiontoken
     */
    String generateSessionToken(String userId);

    /**
     * Validates a session token
     * @param userId of the user for which the session token will be validated
     * @param sessionToken which will be validated
     *
     * @return true if the validation was successful false otherwise
     */
    boolean validateSessionToken(String userId, String sessionToken);

    /**
     * Validates the passed session token and ends the session
     *
     * @param userId of the user who want to end the session
     * @param sessionToken of the current session
     *
     * @return true if successful and false otherwise
     */
    boolean endSession(String userId, String sessionToken);
}
