package org.wirvsvirushackathon.helpado.chat.storage;

import org.wirvsvirushackathon.helpado.chat.api.ChatMessage;

import java.util.Optional;

/**
 * This interface describes the basic functions of a storage
 * containing {@link org.wirvsvirushackathon.helpado.chat.api.ChatMessage}s
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 22.03.2020
 */
public interface ChatMessageStorage {

    /**
     * Creates a new chat message
     *
     * @param chatId of the chat for which the {@link org.wirvsvirushackathon.helpado.chat.api.ChatMessage} will be generated
     * @param createdBy id of the User which creates the message
     * @param previousMessageId of the message before
     * @param message which will be send
     *
     * @return an {@link Optional} containing the id of the generated message
     */
    Optional<String> createChatMessage(String chatId, String createdBy, String previousMessageId, String message);

    /**
     * Deletes {@link org.wirvsvirushackathon.helpado.chat.api.ChatMessage}s of the referenced chat
     *
     * @param chatId of the chat for which the {@link org.wirvsvirushackathon.helpado.chat.api.ChatMessage}s will be deleted
     */
    void deleteChatMessagesOfChat(String chatId);

    /**
     * Return the {@link org.wirvsvirushackathon.helpado.chat.api.ChatMessage} having the specified id
     *
     * @param chatMessageId of the {@link org.wirvsvirushackathon.helpado.chat.api.ChatMessage}
     * @return an {@link Optional} containing the {@link ChatMessage} if present
     */
    Optional<ChatMessage> getChatMessageById(String chatMessageId);
}
