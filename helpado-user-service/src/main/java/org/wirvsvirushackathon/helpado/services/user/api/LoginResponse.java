package org.wirvsvirushackathon.helpado.services.user.api;

import org.wirvsvirushackathon.helpado.user.api.User;
import org.wirvsvirushackathon.helpado.user.api.ViewUser;

/**
 * This answer will be send to the frontend after a successful login
 * procedure
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class LoginResponse extends ViewUser {

    private final String sessionToken;

    public LoginResponse(String sessionToken, User user) {
        super(user);
        this.sessionToken = sessionToken;
    }

    public String getSessionToken() {
        return sessionToken;
    }
}
