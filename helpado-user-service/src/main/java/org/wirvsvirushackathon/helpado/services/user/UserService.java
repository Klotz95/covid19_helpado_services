package org.wirvsvirushackathon.helpado.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.services.user.api.LoginAnswer;
import org.wirvsvirushackathon.helpado.services.user.api.LoginRequest;
import org.wirvsvirushackathon.helpado.services.user.api.UserCreateRequest;
import org.wirvsvirushackathon.helpado.services.user.api.UserUpdateRequest;
import org.wirvsvirushackathon.helpado.session.SessionManager;
import org.wirvsvirushackathon.helpado.user.api.UserAddress;
import org.wirvsvirushackathon.helpado.user.api.ViewUser;
import org.wirvsvirushackathon.helpado.user.storage.UserStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * This resource offering all functions to create, update and get user information
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 21.03.2020
 */
@Path("/user-service/v1")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserStorage userStorage;
    private final SessionManager sessionManager;

    /**
     * Constructs the {@link UserService}
     *
     * @param userStorage    which should be used by the {@link UserService}
     * @param sessionManager which should be used by the {@link UserService}
     */
    public UserService(UserStorage userStorage, SessionManager sessionManager) {
        logger.info("Constructing UserService with storage type {} ", userStorage.getClass());
        this.userStorage = userStorage;
        this.sessionManager = sessionManager;
    }

    @GET
    @Path("/users/{userId}")
    public ViewUser getUserInformation(@PathParam("userId") String userId) {
        logger.debug("view-information of user having id {} has been requested", userId);
        Optional<ViewUser> viewUser = userStorage.getViewUser(userId);

        if (viewUser.isPresent()) {
            return viewUser.get();
        } else {
            throw new NotFoundException();
        }
    }

    @PUT
    @Path("/users")
    public Response createUser(UserCreateRequest createRequest) {
        logger.info("The creation of a user for email address {} has been requested", createRequest.getMailAddress());

        Optional<String> createdUserId = userStorage.createUser(createRequest.getUsername(), createRequest.getPassword(),
                createRequest.getMailAddress(), createRequest.getDescription(), createRequest.getBirthday(), createRequest.getUserAddress());

        if (createdUserId.isPresent()) {
            return Response.status(Response.Status.CREATED).entity(createdUserId.get())
                    .build();
        } else {
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }

    @PATCH
    @Path("/users/{userId}")
    public Response updateUser(@PathParam("userId") String userId, UserUpdateRequest updateRequest) {
        logger.info("Updating user having id {}", userId);
        String description = updateRequest.getDescription();
        UserAddress userAddress = updateRequest.getUserAddress();
        String password = updateRequest.getPassword();

        if (sessionManager.validateSessionToken(userId, updateRequest.getSessionToken())) {
            if (description != null) {
                logger.debug("Changing description of user having id {}", userId);
                userStorage.changeUserDescription(userId, description);
            }

            if (userAddress != null) {
                logger.debug("Changing address information of user having id {}", userId);
                userStorage.changeUserAddress(userId, userAddress);
            }

            if (password != null) {
                logger.debug("Changing password of user having id {}", userId);
                userStorage.changeUserPassword(userId, password);
            }

            return Response.status(Response.Status.OK).build();
        }

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    @POST
    @Path("/users")
    public Response loginUser(LoginRequest loginRequest) {
        Optional<String> userId = userStorage.checkCredentials(loginRequest.getMailAddress(), loginRequest.getPassword());

        if (userId.isPresent()) {
            logger.debug("Login user having id {}", userId.get());
            //password was correct. Generate session token and send it to frontend
            String sessionToken = sessionManager.generateSessionToken(userId.get());
            LoginAnswer loginAnswer = new LoginAnswer(sessionToken, userId.get());

            return Response.ok(loginAnswer).build();
        }
        logger.warn("Declined login attempt for user having id {}", userId.get());
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @DELETE
    @Path("/users/{userId}")
    public Response deleteUser(@PathParam("userId") String userId, String sessionToken) {
        if (sessionManager.validateSessionToken(userId, sessionToken)) {
            logger.info("Delete user having id {}", userId);
            //TODO: Implement delete procedure
        }

        logger.warn("Declined delete attempt for user having id {}", userId);
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("/users/{userId}/logout")
    public Response logoutUser(@PathParam("userId") String userId, String sessionToken) {
        logger.debug("Logout of user having id {} has been requested", userId);
        return sessionManager.endSession(userId, sessionToken) ? Response.status(Response.Status.OK).build() :
                Response.status(Response.Status.UNAUTHORIZED).build();

    }
}
