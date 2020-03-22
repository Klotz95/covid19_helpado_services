package org.wirvsvirushackathon.helpado.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    private static final String STREET_PARAMETER_NAME = "street";

    @JsonProperty(POSTAL_CODE_PARAMETER_NAME)
    private String postalCode;
    @JsonProperty(CITY_PARAMETER_NAME)
    private String city;
    @JsonProperty(STREET_PARAMETER_NAME)
    private String street;

    @JsonCreator
    public UserAddress(
            @JsonProperty(POSTAL_CODE_PARAMETER_NAME) String postalCode,
            @JsonProperty(CITY_PARAMETER_NAME) String city,
            @JsonProperty(STREET_PARAMETER_NAME) String street) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
