// Archivo: src/main/java/com/mensajeria/chat/controller/ChatController.java
package com.mensajeria.chat.controller; 

import com.mensajeria.chat.model.ChatMessage;
import com.mensajeria.chat.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // @MessageMapping("/send"): Recibe mensajes que llegan del cliente a /app/send.
    @MessageMapping("/send") 
    
    // @SendTo("/topic/public"): Difunde el valor de retorno (OutputMessage) al broker, 
    // que lo entregará a todos los clientes suscritos a /topic/public.
    @SendTo("/topic/public") 
    public OutputMessage sendMessage(ChatMessage message) throws Exception {
        // Lógica de negocio simulada
        Thread.sleep(100); 
        
        // Retorna el mensaje procesado para la difusión
        return new OutputMessage(message.getSender(), message.getContent());
    }
}