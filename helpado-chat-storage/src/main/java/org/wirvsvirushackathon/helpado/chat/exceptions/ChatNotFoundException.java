package org.wirvsvirushackathon.helpado.chat.exceptions;

public class ChatNotFoundException extends RuntimeException{

    private final String chatId;

    public ChatNotFoundException(String chatId){
        super("No chat with id " + chatId + " has been found");

        this.chatId = chatId;
    }

    public String getChatId() {
        return chatId;
    }
}
