// Archivo: src/main/java/com/mensajeria/chat/config/WebSocketConfig.java
package com.mensajeria.chat.config; 

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Habilita el soporte para WebSockets con STOMP.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 1. Broker Simple (Difusión): El broker usará /topic para difundir mensajes (Pub/Sub).
        config.enableSimpleBroker("/topic"); 
        
        // 2. Prefijo de Aplicación: Los mensajes que van a ser procesados por el Controller (lógica de negocio) 
        // deben usar el prefijo /app.
        config.setApplicationDestinationPrefixes("/app"); 
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 3. Endpoint de Conexión: La URL inicial a la que el cliente se conecta.
        // .withSockJS() es clave: proporciona un fallback para entornos donde WebSockets nativos fallan.
        registry.addEndpoint("/ws").withSockJS(); 
    }
}