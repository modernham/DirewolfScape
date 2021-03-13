package plugin.ai.general;

import core.game.node.entity.player.Player;

public class cleverbothandler {

        public String var;
        public Player player;

        public static void startChat(Player botplayer, String themessage) {
            System.out.println("Starting Chat Thread");
            cleverbot myRunnable = new cleverbot(botplayer,themessage);
            Thread t = new Thread(myRunnable);
            t.start();
        }


}
