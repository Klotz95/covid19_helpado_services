package org.wirvsvirushackathon.helpado.user.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.user.api.User;
import org.wirvsvirushackathon.helpado.user.api.Address;
import org.wirvsvirushackathon.helpado.user.api.ViewUser;
import org.wirvsvirushackathon.helpado.user.exceptions.UserMailNotFoundException;
import org.wirvsvirushackathon.helpado.user.exceptions.UserNotFoundException;

import java.util.*;


public class UserStorageMockImpl implements UserStorage {

    private static final Logger logger = LoggerFactory.getLogger(UserStorageMockImpl.class);

    private final List<User> storedUsers;

    public UserStorageMockImpl() {
        storedUsers = new ArrayList<>();
    }

    @Override
    public Optional<String> checkCredentials(String email, String password) {
        logger.debug("Checking credentials of user having email {}", email);

        Optional<User> currentUser = getUserByEmail(email);

        if (currentUser.isPresent()) {
            if (currentUser.get().getPassword().equals(password)) {
                return Optional.of(currentUser.get().getUserId());
            }

            return Optional.empty();
        } else {
            throw new UserMailNotFoundException(email);
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return storedUsers.stream().filter(user -> user.getMailAddress()
                .equals(email)).findFirst();
    }

    @Override
    public Optional<User> getUser(String userId) {
        logger.debug("User having id {} has been requested from storage", userId);

        return storedUsers.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
    }

    @Override
    public Optional<ViewUser> getViewUser(String userId) {
        logger.debug("View user having id {} has been requested", userId);

        return this.getUser(userId).map(this::convertToViewUser);
    }

    @Override
    public void changeUserPassword(String userId, String newPassword) {
        logger.debug("Changing password of user having id {}", userId);

        this.getUser(userId).ifPresentOrElse(user -> user.setPassword(newPassword), () -> {
            throw new UserNotFoundException(userId);
        });
    }

    @Override
    public void changeUserAddress(String userId, Address address) {
        logger.debug("Changing address of user having id {}", userId);

        this.getUser(userId).ifPresentOrElse(user -> user.setAddress(address), () -> {
            throw new UserNotFoundException(userId);
        });
    }

    @Override
    public void changeUserFirstName(String userId, String newFirstName) {
        logger.debug("Changing user firstName of user having id {}", userId);

        this.getUser(userId).ifPresentOrElse(user -> user.setFirstName(newFirstName), () -> {
            throw new UserNotFoundException(userId);
        });
    }

    @Override
    public void changeUserLastName(String userId, String newLastName) {
        logger.debug("Changing user lastName of user having id {}", userId);

        this.getUser(userId).ifPresentOrElse(user -> user.setLastName(newLastName), () -> {
            throw new UserNotFoundException(userId);
        });
    }

    @Override
    public Optional<String> createUser(String password, String mailAddress, String firstName, String lastName,
                                       Address address) {
        String uuid = UUID.randomUUID().toString();

        User newUser = new User();
        newUser.setAddress(address);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setMailAddress(mailAddress);
        newUser.setUserId(uuid);

        this.storedUsers.add(newUser);
        return Optional.of(uuid);
    }

    /**
     * Converts a {@link User} object to a {@link ViewUser} object
     *
     * @param user which need to get converted to a {@link ViewUser} object
     */
    private ViewUser convertToViewUser(User user) {
        ViewUser res = new ViewUser();

        res.setLastName(user.getLastName());
        res.setFirstName(user.getFirstName());
        res.setUserId(user.getUserId());
        res.setMailAddress(user.getMailAddress());
        res.setAddress(user.getAddress());

        return res;
    }
}
