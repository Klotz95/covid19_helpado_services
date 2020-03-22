package org.wirvsvirushackathon.helpado.user.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class defines the structure of addresses of the user
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class UserAddress {

    private static final String POSTAL_CODE_PARAMETER_NAME = "postalCode";
    private static final String CITY_PARAMETER_NAME = "city";

    @JsonProperty(POSTAL_CODE_PARAMETER_NAME)
    private String postalCode;
    @JsonProperty(CITY_PARAMETER_NAME)
    private String city;

    public UserAddress(){}

    public UserAddress(String postalCode, String city) {
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
