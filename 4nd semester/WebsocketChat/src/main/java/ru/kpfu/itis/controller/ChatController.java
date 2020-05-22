package ru.kpfu.itis.controller;

import ru.kpfu.itis.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatMessage.setAdditionalContent("В сообщении \"" + chatMessage.getContent() + "\" " + chatMessage.getContent().length() + " символов");
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/join")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // добавляем юзернейм в веб сокет сессию
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    
}
