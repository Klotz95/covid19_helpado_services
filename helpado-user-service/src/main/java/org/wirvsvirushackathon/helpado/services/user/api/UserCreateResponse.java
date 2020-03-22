package org.wirvsvirushackathon.helpado.services.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateResponse {

    private static final String USER_ID_PARAMETER_NAME = "userId";

    @JsonProperty(USER_ID_PARAMETER_NAME)
    private final String userId;

    @JsonCreator
    public UserCreateResponse(@JsonProperty(USER_ID_PARAMETER_NAME)String userId){
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
