package core.game.system.command.rottenpotato

import core.game.node.entity.combat.ImpactHandler
import core.game.node.entity.npc.NPC
import core.game.node.entity.player.Player
import core.plugin.Initializable
import core.game.content.dialogue.DialoguePlugin
import core.tools.stringtools.colorize

/**
 * Rotten potato -> npc interaction menu
 * @author Ceikry
 */
@Initializable
class RPUseWithNPCDialogue(player: Player? = null) : DialoguePlugin(player) {
    var npc: NPC? = null
    val ID = 38575795
    override fun newInstance(player: Player?): DialoguePlugin {
        return RPUseWithNPCDialogue(player)
    }

    override fun open(vararg args: Any?): Boolean {
        npc = args[0] as NPC
        options("Remove NPC","Kill","Copy Appearance")
        return true
    }

    override fun handle(interfaceId: Int, buttonId: Int): Boolean {
        when(buttonId){
            //remove NPC
            1 -> {
                npc.isRespawn = false
                npc.clear()
                player.sendMessage(colorize("%RNPC Cleared."))
            }
            //Kill
            2 -> {
                npc.impactHandler.manualHit(player,npc.skills.lifepoints,ImpactHandler.HitsplatType.NORMAL)
            }
            //Copy Appearance
            3 -> {
                player.appearance.transformNPC(npc.id)
            }
        }
        player.sendMessage(colorize("INTERACTING AS PLAYER"))
        return true
    }

    override fun getIds(): IntArray {
        return intArrayOf(ID)
    }

}