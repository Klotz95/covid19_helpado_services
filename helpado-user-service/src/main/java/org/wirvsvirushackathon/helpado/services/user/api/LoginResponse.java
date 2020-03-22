package org.wirvsvirushackathon.helpado.services.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This answer will be send to the frontend after a successful login
 * procedure
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class LoginResponse {

    private static final String SESSION_TOKEN_PARAMETER_NAME = "sessionToken";
    private static final String USER_ID_PARAMETER_NAME = "userId";

    @JsonProperty(SESSION_TOKEN_PARAMETER_NAME)
    private final String sessionToken;
    @JsonProperty(USER_ID_PARAMETER_NAME)
    private final String userId;

    @JsonCreator
    public LoginResponse(@JsonProperty(SESSION_TOKEN_PARAMETER_NAME)String sessionToken,
                         @JsonProperty(USER_ID_PARAMETER_NAME)String userId){
        this.sessionToken = sessionToken;
        this.userId = userId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getUserId() {
        return userId;
    }
}
