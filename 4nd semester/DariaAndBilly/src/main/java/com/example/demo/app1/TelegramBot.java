package com.example.demo.app1;

import com.example.demo.context.MessageReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private MessageReceiver messageReceiver;

    public TelegramBot(MessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
    }


    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        messageReceiver.receiveFromTelegram(this, update);
    }

    @Override
    public String getBotUsername() {
        return "BobbyHillBot";
    }

    @Override
    public String getBotToken() {
        return "not found";
    }
}
