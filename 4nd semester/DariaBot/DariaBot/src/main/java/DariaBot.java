import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DariaBot {
    public static JDA jda;

    public static void main(String[] args) throws LoginException, InterruptedException {
        jda = new JDABuilder(AccountType.BOT).setToken("NzEyNzgwNjYwNzc0Nzk3MzMx.XsaUOw.mjwDZ3beBHNFUtCvL9tZ9ZHoUuY").build().awaitReady();
        jda.addEventListener(new Commands(), new LeadListener());
    }
}
