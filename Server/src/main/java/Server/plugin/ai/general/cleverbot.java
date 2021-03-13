package plugin.ai.general;
import com.michaelwflaherty.cleverbotapi.CleverBotQuery;

import core.game.node.entity.player.Player;
import core.game.world.update.flag.player.ChatFlag;

import java.io.IOException;

public class cleverbot implements Runnable {

    public String var;
    public Player player;
    public String response;

    public static String chatRequest(String input) {
        System.out.println("Gettign Query");
        CleverBotQuery bot = new CleverBotQuery("CC98lqk3sTEIelOzsE1mpLsW85Q", input);
        System.out.println("Got Response");
        String response;
        try
        {
            System.out.println("Try Getting Request");
            bot.sendRequest();
            response = bot.getResponse();
        }
        catch (IOException e)
        {
            System.out.println("Error Getting Message");
            response = e.getMessage();
        }
        System.out.println(response);
        return response;

    }

    public cleverbot(Player botplayer, String var) {
        this.var = var;
        player = botplayer;
    }

    public void run() {
        System.out.println("Thread Started");
        chatRequest(var);
        while(response == null){

        }
        System.out.println("Sending Chat");
        player.sendChat(response);
        return;
    }


}

