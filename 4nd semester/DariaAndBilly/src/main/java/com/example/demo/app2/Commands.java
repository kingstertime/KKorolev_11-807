package com.example.demo.app2;

import com.example.demo.context.MessageReceiver;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Commands extends ListenerAdapter {

    @Autowired
    private MessageReceiver messageReceiver;

    public Commands(MessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        System.out.println(event.getMessage().getContentRaw());
        if (!event.getMessage().getContentRaw().equals("") && !event.getAuthor().getName().equalsIgnoreCase("DariaBot")) {
            // эта проверка отсекает пустые строки и сообщения самого бота(если проверки не будет, пойдет рекурсия)
            try {
                messageReceiver.receiveFromDiscord(event); 
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
