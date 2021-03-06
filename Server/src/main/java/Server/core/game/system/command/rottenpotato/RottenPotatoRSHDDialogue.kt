package core.game.system.command.rottenpotato

import core.game.node.entity.player.Player
import core.game.node.entity.player.info.login.PlayerParser
import core.game.node.entity.player.link.RunScript
import core.game.world.ImmerseWorld
import core.game.world.repository.Repository
import core.plugin.Initializable
import plugin.ai.AIPlayer
import plugin.ai.AIRepository
import core.game.content.dialogue.DialoguePlugin
import core.tools.stringtools.colorize

@Initializable
/**
 * Rotten Potato "RS HD" option menu
 * @author Ceikry
 */
class RottenPotatoRSHDDialogue(player: Player? = null) : DialoguePlugin(player) {
    val ID = 38575793
    override fun newInstance(player: Player?): DialoguePlugin {
        return RottenPotatoRSHDDialogue(player)
    }

    override fun open(vararg args: Any?): Boolean {
        options("Wipe Bots", "Spawn Bots", "Force Log Players")
        return true
    }

    override fun handle(interfaceId: Int, buttonId: Int): Boolean {
                when (buttonId) {
                    //Wipe Bots
                    1 -> AIRepository.PulseRepository.toTypedArray().forEach { it.stop(); it.botScript.bot.clear(); AIPlayer.deregister((it.botScript.bot as AIPlayer).uid) }.also { player.sendMessage(colorize("%RBots wiped.")); end() }
                    //Spawn Bots
                    2 -> ImmerseWorld.init().also { player.sendMessage(colorize("%RBots Respawning...")); end() }
                    //Force Log All Online Players
                    3 -> {
                        Repository.disconnectionQueue.clear().also { end() }
                        Repository.players.toArray().forEach {
                            val p = it.asPlayer()
                            if (p != null && !p.isArtificial()) { // Should never be null.
                                p.removeAttribute("combat-time")
                                p.clear()
                                PlayerParser.save(p)
                                p.getDetails().save()
                            }
                        }
                    }
                }
        player.sendMessage(colorize("HANDLE AS RS HD"))
        return true
    }

    override fun getIds(): IntArray {
        return intArrayOf(ID)
    }
}