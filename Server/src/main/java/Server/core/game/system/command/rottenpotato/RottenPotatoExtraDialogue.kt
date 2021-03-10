package core.game.system.command.rottenpotato

import core.game.node.entity.npc.NPC
import core.game.node.entity.player.Player
import core.game.node.entity.player.link.RunScript
import core.game.world.map.RegionManager
import core.game.world.repository.Repository
import core.plugin.Initializable
import core.game.content.dialogue.DialoguePlugin
import core.tools.stringtools.colorize

@Initializable
/**
 * Rotten Potato Right click -> Extra dialogue menu
 * @author Ceikry
 */
class RottenPotatoExtraDialogue(player: Player? = null) : DialoguePlugin(player) {
    val ID = 38575794
    val AMEs = arrayOf("chicken","Sandwich Lady","tree spirit","rick turpentine","Genie")
    val BossIDs = arrayOf(50,8350,8133,2745)
    val BossNames = arrayOf("KBD","Tormented Demon","Corporeal Beast","Jad")

    override fun newInstance(player: Player?): DialoguePlugin {
        return RottenPotatoExtraDialogue(player)
    }

    override fun open(vararg args: Any?): Boolean {
        options("Send Player Notification","Kill All Nearby NPCs")
        return true
    }

    override fun handle(interfaceId: Int, buttonId: Int): Boolean {
            when (buttonId) {
               //Send Player Notification
               1 -> {
                   player.setAttribute("runscript", object : RunScript() {
                       override fun handle(): Boolean {
                           val message = getValue().toString()
                           for (p in Repository.players) {
                               p ?: continue
                               p.packetDispatch.sendString(colorize("%Y${message.replace("_", " ").capitalize()}"), 754, 5)
                           }
                           return true
                       }
                   })
                   player.dialogueInterpreter.sendLongInput("Enter the notification message:")
               }
               //Kill all nearby NPCs
               2 -> {
                   RegionManager.getLocalNpcs(player).forEach {
                       it.finalizeDeath(player)
                   }
               }

           }
        player.sendMessage(colorize("INTERACTING AS EXTRA"))
        return true
    }

    override fun getIds(): IntArray {
        return intArrayOf(ID)
    }

}