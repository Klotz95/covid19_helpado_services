package org.wirvsvirushackathon.helpado.services.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wirvsvirushackathon.helpado.user.api.UserAddress;

import java.util.Date;

/**
 * This class defines the structure of the request sending by the frontend
 * to generate a new user profile
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class UserCreateRequest {

    private static final String USERNAME_PARAMETER_NAME = "username";
    private static final String PASSWORD_PARAMETER_NAME = "password";
    private static final String MAIL_ADDRESS_PARAMETER_NAME = "mailAddress";
    private static final String DESCRIPTION_PARAMETER_NAME = "description";
    private static final String BIRTHDAY_PARAMETER_NAME = "birthday";
    private static final String USER_ADDRESS_PARAMETER_NAME = "userAddress";

    @JsonProperty(USERNAME_PARAMETER_NAME)
    private final String username;
    @JsonProperty(PASSWORD_PARAMETER_NAME)
    private final String password;
    @JsonProperty(MAIL_ADDRESS_PARAMETER_NAME)
    private final String mailAddress;
    @JsonProperty(DESCRIPTION_PARAMETER_NAME)
    private final String description;
    @JsonProperty(BIRTHDAY_PARAMETER_NAME)
    private final Date birthday;
    @JsonProperty(USER_ADDRESS_PARAMETER_NAME)
    private final UserAddress userAddress;

    @JsonCreator
    public UserCreateRequest(@JsonProperty(USERNAME_PARAMETER_NAME) String username,
                             @JsonProperty(PASSWORD_PARAMETER_NAME) String password,
                             @JsonProperty(MAIL_ADDRESS_PARAMETER_NAME) String mailAddress,
                             @JsonProperty(DESCRIPTION_PARAMETER_NAME) String description,
                             @JsonProperty(BIRTHDAY_PARAMETER_NAME) Date birthday,
                             @JsonProperty(USER_ADDRESS_PARAMETER_NAME) UserAddress userAddress) {
        this.username = username;
        this.password = password;
        this.mailAddress = mailAddress;
        this.description = description;
        this.birthday = birthday;
        this.userAddress = userAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getDescription() {
        return description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

}
