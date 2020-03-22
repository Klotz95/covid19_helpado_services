package org.wirvsvirushackathon.helpado.user.api;

/**
 * This class describes the basic structure of a user used by the
 * {@link org.wirvsvirushackathon.helpado.user.storage.UserStorage}
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class User {

    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String mailAddress;
    private Address address;

    public User() {
    }

    public User(String userId, String password, String mailAddress, String firstName, String lastName, Address address) {
        this.userId = userId;
        this.password = password;
        this.mailAddress = mailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
