package org.wirvsvirushackathon.helpado.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the structure of the objects represented at the frontend
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class ViewUser {

    private static final String USER_ID_PARAMETER_NAME = "userId";
    private static final String MAIL_ADDRESS_PARAMETER_NAME = "mailAddress";
    private static final String FIRSTNAME_PARAMETER_NAME = "firstName";
    private static final String LASTNAME_PARAMETER_NAME = "lastName";
    private static final String USER_ADDRESS_PARAMETER_NAME = "address";

    @JsonProperty(USER_ID_PARAMETER_NAME)
    private String userId;
    @JsonProperty(MAIL_ADDRESS_PARAMETER_NAME)
    private String mailAddress;
    @JsonProperty(FIRSTNAME_PARAMETER_NAME)
    private String firstName;
    @JsonProperty(LASTNAME_PARAMETER_NAME)
    private String lastName;
    @JsonProperty(USER_ADDRESS_PARAMETER_NAME)
    private UserAddress userAddress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
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

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}
