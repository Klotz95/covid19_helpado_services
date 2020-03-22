package org.wirvsvirushackathon.helpado.services.order.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDeleteRequest {
    private static final String USER_ID_PARAMETER_NAME = "userId";
    private static final String SESSION_TOKEN_PARAMETER_NAME = "sessionToken";

    @JsonProperty(SESSION_TOKEN_PARAMETER_NAME)
    private final String sessionToken;
    @JsonProperty(USER_ID_PARAMETER_NAME)
    private final String userId;

    @JsonCreator
    public OrderDeleteRequest(
            @JsonProperty(SESSION_TOKEN_PARAMETER_NAME) String sessionToken,
            @JsonProperty(USER_ID_PARAMETER_NAME) String userId) {
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
