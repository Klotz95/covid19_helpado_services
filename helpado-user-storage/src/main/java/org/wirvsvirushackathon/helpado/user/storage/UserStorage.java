package org.wirvsvirushackathon.helpado.user.storage;

import org.jvnet.hk2.annotations.Service;
import org.wirvsvirushackathon.helpado.user.api.User;
import org.wirvsvirushackathon.helpado.user.api.Address;
import org.wirvsvirushackathon.helpado.user.api.ViewUser;

import java.util.Optional;

/**
 * This interface describes the basic functions of an user storage.
 * The user storage handles the login and registration process of users.
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
@Service
public interface UserStorage {

    /**
     * This method will check the passed credentials of a user
     * If the credential check succeed the id of the user will be returned
     *
     * @param email    of the user who wants to login
     * @param password of the user who wants to login
     * @return an {@link Optional} containing the userId if the login was successful
     */
    Optional<String> checkCredentials(String email, String password);

    Optional<User> getUserByEmail(String email);

    /**
     * Returns the {@link User} having the specified id if existing
     *
     * @param userId of the {@link User}
     * @return an {@link Optional} containing the {@link User} if existing
     */
    Optional<User> getUser(String userId);

    /**
     * Returns a {@link ViewUser} object containing all information represented at the frontend
     *
     * @param userId of the user
     * @return an {@link Optional} containing the {@link ViewUser} if existing
     */
    Optional<ViewUser> getViewUser(String userId);

    /**
     * Changes the password of the user
     *
     * @param userId      of the {@link User} who change the password
     * @param newPassword which will be saved
     */
    void changeUserPassword(String userId, String newPassword);

    /**
     * Changes the address of the {@link User}
     *
     * @param userId      of the {@link User} who change the address
     * @param address which will be saved
     */
    void changeUserAddress(String userId, Address address);

    /**
     * Changes the firstName of the {@link User}
     *
     * @param userId       of the {@link User} who changes the firstName
     * @param newFirstName which will be saved
     */
    void changeUserFirstName(String userId, String newFirstName);

    /**
     * Changes the lastName of the {@link User}
     *
     * @param userId      of the {@link User} who changes the lastName
     * @param newLastName which will be saved
     */
    void changeUserLastName(String userId, String newLastName);

    /**
     * Creates a user
     *
     * @param password    of the new user
     * @param mailAddress of the new user
     * @param firstName   of the new user
     * @param lastName    of the new user
     * @param address of the new user
     * @return an {@link Optional} containing the userid if the creation was successful
     */
    Optional<String> createUser(String password, String mailAddress, String firstName, String lastName,
                                Address address);
}
