package org.wirvsvirushackathon.helpado.services.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.wirvsvirushackathon.helpado.user.api.Address;

/**
 * This class describes the structure of a update request to change user information
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class UserUpdateRequest {

    private static final String PASSWORD_PARAMETER_NAME = "password";
    private static final String FIRSTNAME_PARAMETER_NAME = "firstName";
    private static final String LASTNAME_PARAMETER_NAME = "lastName";
    private static final String ADDRESS_PARAMETER_NAME = "address";
    private static final String SESSION_TOKEN_PARAMETER_NAME = "sessionToken";

    @JsonProperty(PASSWORD_PARAMETER_NAME)
    private final String password;
    @JsonProperty(FIRSTNAME_PARAMETER_NAME)
    private final String firstName;
    @JsonProperty(LASTNAME_PARAMETER_NAME)
    private final String lastName;
    @JsonProperty(ADDRESS_PARAMETER_NAME)
    private final Address address;
    @JsonProperty(SESSION_TOKEN_PARAMETER_NAME)
    private final String sessionToken;

    public UserUpdateRequest(@JsonProperty(PASSWORD_PARAMETER_NAME) String password,
                             @JsonProperty(FIRSTNAME_PARAMETER_NAME) String firstName,
                             @JsonProperty(LASTNAME_PARAMETER_NAME) String lastName,
                             @JsonProperty(ADDRESS_PARAMETER_NAME) Address address,
                             @JsonProperty(SESSION_TOKEN_PARAMETER_NAME) String sessionToken) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sessionToken = sessionToken;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getSessionToken() {
        return sessionToken;
    }

}
