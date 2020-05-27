import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeadListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Random random = new Random();
        List<Emoji> emojis = new ArrayList(EmojiManager.getAll());
        List<User> users = event.getMessage().getMentionedUsers();
        if (event.getMessage().getContentRaw().contains("lead")) {
            for (int i = 0; i < 7; i++) {
                event.getMessage().addReaction(emojis.get(random.nextInt(emojis.size() - 1)).getUnicode()).queue();
            }
            for (User user : users) {
                if (user.getId().equals(event.getJDA().getSelfUser().getId())) {
                    List<Member> members = new ArrayList();
                    for (Member member : event.getGuild().getMembers()) {
                        if (member.getUser().isBot() && !member.getUser().getId().equals(event.getJDA().getSelfUser().getId())) {
                            members.add(member);
                        }
                    }
                    event.getChannel().sendMessage("lead <@" + members.get(random.nextInt(members.size() - 1)).getUser().getId() + ">" + emojis.get(random.nextInt(emojis.size() - 1)).getUnicode()).queue();
                }
            }
        }
    }
}