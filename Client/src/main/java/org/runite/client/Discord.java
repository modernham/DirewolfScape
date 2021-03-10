package org.runite.client;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.Timer;
import java.util.TimerTask;

public class Discord {

    public static DiscordEventHandlers discord;

    public static final String APPLICATION_ID = "750136793814401134";

    public static boolean startedDiscord = false;

    public static void InitalizeDiscord() {
    }

    static class DiscordUpdate extends TimerTask {
        public void run() {
        }
    }
}
