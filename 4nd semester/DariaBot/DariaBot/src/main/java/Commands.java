import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().equalsIgnoreCase("!hi")) {
            String username = event.getAuthor().getName();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Hi, " + username + "! Glad to see you!").queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("!info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Info");
            info.setDescription("Hello! I am a bot and I education project!");
            info.setColor(0xf45642);
            info.setFooter("Created by kingstertime", event.getMember().getUser().getAvatarUrl());
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("!time")) {

            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Current time: " + dateFormat.format(date)).queue();
        }
    }
}
