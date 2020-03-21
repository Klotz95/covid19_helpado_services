package org.wirvsvirushackathon.helpado.services.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This request will be send during a login process of the frontend
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class LoginRequest {

    private static final String MAIL_ADDRESS_PARAMETER_NAME = "mailAddress";
    private static final String PASSWORD_PARAMETER_NAME = "password";

    @JsonProperty(MAIL_ADDRESS_PARAMETER_NAME)
    private final String mailAddress;
    @JsonProperty(PASSWORD_PARAMETER_NAME)
    private final String password;

    @JsonCreator
    public LoginRequest(@JsonProperty(MAIL_ADDRESS_PARAMETER_NAME)String mailAddress,
                        @JsonProperty(PASSWORD_PARAMETER_NAME)String password){
        this.mailAddress = mailAddress;
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getPassword() {
        return password;
    }
}
