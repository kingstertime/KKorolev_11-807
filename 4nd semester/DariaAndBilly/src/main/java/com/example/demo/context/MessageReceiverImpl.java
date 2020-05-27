package com.example.demo.context;

import com.example.demo.app1.TelegramBot;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MessageReceiverImpl implements MessageReceiver {

    private TelegramBot telegramBot;
    private GuildMessageReceivedEvent event;
    private Update update;



    @Autowired
    private Game game;

    @Override
    public void receiveFromDiscord(GuildMessageReceivedEvent event) throws TelegramApiException {
        if (this.event == null) {
            if (!event.getMessage().getContentRaw().equals("!join")) {
                event.getChannel().sendMessage("Введите !join чтобы присоединиться к игре").queue();
            } else {
                this.event = event;
                sendAll(game.getCurrentStatus());
            }
        } else { 
            sendToTelegram(event.getAuthor().getName() + ": " + event.getMessage().getContentRaw());
            sendGameResponse(event.getMessage().getContentRaw()); 
        }
    }

    @SneakyThrows
    @Override
    public void receiveFromTelegram(TelegramBot telegramBot, Update update) { 
        if (this.telegramBot == null) {
            if (!update.getMessage().getText().equals("!join")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Введите !join чтобы присоединиться к игре");
                sendMessage.setChatId(update.getMessage().getChatId());
                telegramBot.execute(sendMessage);
            } else {
                this.telegramBot = telegramBot;
                this.update = update;
                sendAll(game.getCurrentStatus());
            }
        } else {
            sendToDiscord(update.getMessage().getFrom().getUserName() + ": " + update.getMessage().getText());
            sendGameResponse(update.getMessage().getText());
        }
    }

    @SneakyThrows
    @Override
    public void sendGameResponse(String word) {
        String response = game.handleWord(word);
        sendAll(response);
    }

    @SneakyThrows
    private void sendToTelegram(String text) { 
        if (this.update != null) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(text);
            sendMessage.setChatId(update.getMessage().getChatId());
            this.telegramBot.execute(sendMessage);
        }
    }

    private void sendToDiscord(String text) {
        if (this.event != null) {
            this.event.getChannel().sendMessage(text).queue();
        }
    }

    private void sendAll(String text) {
        sendToDiscord(text);
        sendToTelegram(text);
    }
}
