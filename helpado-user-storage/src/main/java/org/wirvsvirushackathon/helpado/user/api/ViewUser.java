package org.wirvsvirushackathon.helpado.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * This class represents the structure of the objects represented at the frontend
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class ViewUser {

    private static final String USER_ID_PARAMETER_NAME = "userId";
    private static final String USERNAME_PARAMETER_NAME = "username";
    private static final String FIRSTNAME_PARAMETER_NAME = "firstName";
    private static final String LASTNAME_PARAMETER_NAME = "lastName";

    @JsonProperty(USER_ID_PARAMETER_NAME)
    private String userId;
    @JsonProperty(USERNAME_PARAMETER_NAME)
    private String username;
    @JsonProperty(FIRSTNAME_PARAMETER_NAME)
    private String firstName;
    @JsonProperty(LASTNAME_PARAMETER_NAME)
    private String lastName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
