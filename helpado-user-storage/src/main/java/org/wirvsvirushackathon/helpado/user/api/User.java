package org.wirvsvirushackathon.helpado.user.api;

import java.util.Date;

/**
 * This class describes the basic structure of a user used by the
 * {@link org.wirvsvirushackathon.helpado.user.storage.UserStorage}
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
public class User {

    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String mailAddress;
    private String description;
    private Date birthday;
    private UserAddress userAddress;

    public User() {
    }

    public User(String userId, String username, String password, String mailAddress, String firstName, String lastName, String description, Date birthday,
                UserAddress userAddress) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mailAddress = mailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.birthday = birthday;
        this.userAddress = userAddress;
    }

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

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}
