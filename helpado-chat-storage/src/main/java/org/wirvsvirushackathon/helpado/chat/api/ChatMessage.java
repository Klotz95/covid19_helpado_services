package org.wirvsvirushackathon.helpado.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * This class describes the structure of a message inside the {@link Chat}
 * A {@link ChatMessage} referenced to the previous {@link ChatMessage};
 *
 * TODO: Add generics which describes the content type of the chat message. So a chat message can not only be text but also for example an image
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 22.03.2020
 */
public class ChatMessage {

    private static final String MESSAGE_ID_PARAMETER_NAME = "messageId";
    private static final String CHAT_ID_PARAMETER_NAME = "chatId";
    private static final String MESSAGE_PARAMETER_NAME = "message";
    private static final String CREATED_AT_PARAMETER_NAME = "createdAt";
    private static final String CREATED_BY_PARAMETER_NAME = "createdBy";
    private static final String PREVIOUS_MESSAGE_ID_PARAMETER_NAME = "previousMessage";

    @JsonProperty(MESSAGE_ID_PARAMETER_NAME)
    private String messageId;
    @JsonProperty(CHAT_ID_PARAMETER_NAME)
    private String chatId;
    @JsonProperty(MESSAGE_PARAMETER_NAME)
    private String message;
    @JsonProperty(CREATED_AT_PARAMETER_NAME)
    private Date createdAt;
    @JsonProperty(CREATED_BY_PARAMETER_NAME)
    private String createdBy;
    @JsonProperty(PREVIOUS_MESSAGE_ID_PARAMETER_NAME)
    private String previousMessageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPreviousMessageId() {
        return previousMessageId;
    }

    public void setPreviousMessageId(String previousMessageId) {
        this.previousMessageId = previousMessageId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
