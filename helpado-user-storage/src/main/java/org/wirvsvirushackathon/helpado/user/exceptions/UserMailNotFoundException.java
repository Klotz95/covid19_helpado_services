package org.wirvsvirushackathon.helpado.user.exceptions;

public class UserMailNotFoundException extends RuntimeException {

    private final String mailAddress;

    public UserMailNotFoundException(String mailAddress){
        super("No user with email address " + mailAddress + " has been found");
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }

}
