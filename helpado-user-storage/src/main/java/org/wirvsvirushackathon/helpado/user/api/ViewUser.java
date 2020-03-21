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
    private static final String DESCRIPTION_PARAMETER_NAME = "description";
    private static final String BIRTHDAY_PARAMETER_NAME = "birthday";

    @JsonProperty(USER_ID_PARAMETER_NAME)
    private String userId;
    @JsonProperty(USERNAME_PARAMETER_NAME)
    private String username;
    @JsonProperty(DESCRIPTION_PARAMETER_NAME)
    private String description;
    @JsonProperty(BIRTHDAY_PARAMETER_NAME)
    private Date birthday;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
