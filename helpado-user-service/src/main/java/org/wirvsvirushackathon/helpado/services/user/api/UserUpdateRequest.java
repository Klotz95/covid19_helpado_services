package org.wirvsvirushackathon.helpado.services.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.wirvsvirushackathon.helpado.user.api.UserAddress;

/**
 * This class describes the structure of a update request to change user information
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class UserUpdateRequest {

    private static final String PASSWORD_PARAMETER_NAME = "password";
    private static final String DESCRIPTION_PARAMETER_NAME = "description";
    private static final String ADDRESS_PARAMETER_NAME = "address";
    private static final String SESSION_TOKEN_PARAMETER_NAME = "sessionToken";

    @JsonProperty(PASSWORD_PARAMETER_NAME)
    private final String password;
    @JsonProperty(DESCRIPTION_PARAMETER_NAME)
    private final String description;
    @JsonProperty(ADDRESS_PARAMETER_NAME)
    private final UserAddress userAddress;
    @JsonProperty(SESSION_TOKEN_PARAMETER_NAME)
    private final String sessionToken;

    public UserUpdateRequest(@JsonProperty(PASSWORD_PARAMETER_NAME)String password,
                             @JsonProperty(DESCRIPTION_PARAMETER_NAME)String description,
                             @JsonProperty(ADDRESS_PARAMETER_NAME)UserAddress userAddress,
                             @JsonProperty(SESSION_TOKEN_PARAMETER_NAME)String sessionToken){
        this.password = password;
        this.description = description;
        this.userAddress = userAddress;
        this.sessionToken = sessionToken;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public String getSessionToken() {
        return sessionToken;
    }

}
