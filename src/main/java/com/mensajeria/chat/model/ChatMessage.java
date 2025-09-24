// Archivo: src/main/java/com/mensajeria/chat/model/ChatMessage.java
package com.mensajeria.chat.model; 

public class ChatMessage {
    private String sender;
    private String content;

    public ChatMessage() {} 
    
    // Getters y Setters
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}