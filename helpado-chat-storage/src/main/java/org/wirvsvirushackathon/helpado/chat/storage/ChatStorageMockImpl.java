package org.wirvsvirushackathon.helpado.chat.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wirvsvirushackathon.helpado.chat.api.Chat;
import org.wirvsvirushackathon.helpado.chat.exceptions.ChatNotFoundException;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is an mock implementation of the {@link ChatStorage}
 * It writes the received data onto memory
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 22.03.2020
 */
public class ChatStorageMockImpl implements ChatStorage{

    private static final Logger logger = LoggerFactory.getLogger(ChatStorageMockImpl.class);

    private final Map<String, Chat> chatByOrderId;
    private final Map<String, Chat> chatByChatId;


    public ChatStorageMockImpl(){
        logger.info("Generating memory chat storage");
        this.chatByOrderId = new ConcurrentHashMap<>();
        this.chatByChatId = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<String> createChat(String orderId, String participantAId, String participantBId) {
        logger.info("Generating chat for order having id {}", orderId);

        String chatId = UUID.randomUUID().toString();

        Chat newChat = new Chat();
        newChat.setChatId(chatId);
        newChat.setOrderId(orderId);
        newChat.setParticipantAId(participantAId);
        newChat.setParticipantBId(participantBId);

        chatByChatId.put(newChat.getChatId(), newChat);
        chatByOrderId.put(newChat.getOrderId(), newChat);

        return Optional.of(chatId);
    }

    @Override
    public void deleteChat(String chatId) {
        logger.info("Deleting chat having id {}", chatId);

        if(chatByChatId.containsKey(chatId)) {
            Chat chatToDelete = chatByChatId.get(chatId);

            chatByChatId.remove(chatId);
            chatByOrderId.remove(chatToDelete.getOrderId());
        }
        else{
            throw new ChatNotFoundException(chatId);
        }

    }

    @Override
    public Optional<Chat> getChatByOrder(String orderId) {
        logger.debug("Chat related to order having id {} has been requested", orderId);

        return Optional.ofNullable(chatByOrderId.get(orderId));
    }

    @Override
    public Optional<Chat> getChatByChatId(String chatId) {
        logger.debug("Chat having id {} has been requested", chatId);

        return Optional.ofNullable(chatByChatId.get(chatId));
    }

    @Override
    public void updateLastMessageId(String chatId, String lastMessageId) {
        logger.debug("Updating last message id of chat having id {}", chatId);

        if(this.chatByChatId.containsKey(chatId)){
            this.chatByChatId.get(chatId).setLastMessageId(lastMessageId);
        } else {
            throw new ChatNotFoundException(chatId);
        }

    }
}
