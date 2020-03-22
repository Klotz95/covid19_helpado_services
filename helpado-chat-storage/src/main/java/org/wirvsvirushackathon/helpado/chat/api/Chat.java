package org.wirvsvirushackathon.helpado.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This Class defines the structure of a {@link Chat} which is between a order creator and a order
 * executor
 *
 * @author NKO (NicoKotlenga@live.de)
 * @since 22.03.2020
 */
public class Chat {

    private static final String CHAT_ID_PARAMETER_NAME = "chatId";
    private static final String PARTICIPANT_A_ID_PARAMETER_NAME = "participantAId";
    private static final String PARTICIPANT_B_ID_PARAMETER_NAME = "participantBId";
    private static final String LAST_MESSAGE_ID_PARAMETER_NAME = "lastMessageId";
    private static final String ORDER_ID_PARAMETER_NAME = "orderId";

    @JsonProperty(CHAT_ID_PARAMETER_NAME)
    private String chatId;
    @JsonProperty(PARTICIPANT_A_ID_PARAMETER_NAME)
    private String participantAId;
    @JsonProperty(PARTICIPANT_B_ID_PARAMETER_NAME)
    private String participantBId;
    @JsonProperty(LAST_MESSAGE_ID_PARAMETER_NAME)
    private String lastMessageId;
    @JsonProperty(ORDER_ID_PARAMETER_NAME)
    private String orderId;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getParticipantAId() {
        return participantAId;
    }

    public void setParticipantAId(String participantAId) {
        this.participantAId = participantAId;
    }

    public String getParticipantBId() {
        return participantBId;
    }

    public void setParticipantBId(String participantBId) {
        this.participantBId = participantBId;
    }

    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String oderId) {
        this.orderId = oderId;
    }
}
