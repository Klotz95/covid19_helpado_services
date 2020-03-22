package org.wirvsvirushackathon.helpado.user.api;

/**
 * This class represents the structure of the objects represented at the frontend
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class ViewUser {

    private String userId;
    private String mailAddress;
    private String firstName;
    private String lastName;
    private Address address;

    public ViewUser() {
    }

    public ViewUser(User user) {
        this.userId = user.getUserId();
        this.mailAddress = user.getMailAddress();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.address = user.getAddress();
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
