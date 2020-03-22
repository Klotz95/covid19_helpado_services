package org.wirvsvirushackathon.helpado.chat.storage;

import org.wirvsvirushackathon.helpado.chat.api.Chat;

import java.util.Optional;

/**
 * This storage handles the creation and modifying of {@link org.wirvsvirushackathon.helpado.chat.api.Chat}s
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 22.03.2020
 */
public interface ChatStorage {

    /**
     * Generates a new chat. Returns the id of the chat if the creation was successful
     *
     * @param orderId for which the chat will be generated
     * @param participantBId of the chat
     *
     * @return an {@link Optional} containing the id of the chat
     */
    Optional<String> createChat(String orderId, String participantBId);

    /**
     * Deletes the specified chat
     *
     * @param chatId of the chat which need to get delete
     */
    void deleteChat(String chatId);

    /**
     * Returns the {@link Chat} referenced to the Order
     *
     * @param orderId of order for which the {@link Chat} should be loaded
     * @return an {@link Optional} containing the chat
     */
    Optional<Chat> getChatByOrder(String orderId);

    /**
     * Returns the {@link Chat} having the specified id
     *
     * @param chatId of the chat
     * @return an {@link Optional} containing the {@link Chat}
     * if present
     */
    Optional<Chat> getChatByChatId(String chatId);
}
