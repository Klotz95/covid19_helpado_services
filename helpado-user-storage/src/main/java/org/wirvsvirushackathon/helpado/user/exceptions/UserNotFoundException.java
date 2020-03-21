package org.wirvsvirushackathon.helpado.user.exceptions;

public class UserNotFoundException extends RuntimeException {

    private final String userId;

    public UserNotFoundException(String userId){
        super("No user having id " + userId + " has been found");
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

}
