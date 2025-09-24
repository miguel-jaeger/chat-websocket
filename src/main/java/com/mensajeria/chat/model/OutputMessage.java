// Archivo: src/main/java/com/mensajeria/chat/model/OutputMessage.java
package com.mensajeria.chat.model; 

public class OutputMessage {
    private String from;
    private String text;
    private String time;

    public OutputMessage(String from, String text) {
        this.from = from;
        this.text = text;
        this.time = java.time.LocalTime.now().toString().substring(0, 8); 
    }

    // Getters (necesarios para serialización)
    public String getFrom() { return from; }
    public String getText() { return text; }
    public String getTime() { return time; }
}