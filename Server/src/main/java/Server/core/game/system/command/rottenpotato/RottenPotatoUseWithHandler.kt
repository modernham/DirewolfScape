package core.game.system.command.rottenpotato

import core.game.node.Node
import core.game.node.`object`.GameObject
import core.game.node.entity.npc.NPC
import core.game.node.entity.player.Player
import core.game.node.item.Item
import core.tools.stringtools.colorize

/**
 * Rotten Potato use-with handling
 * @author Ceikry
 */
object RottenPotatoUseWithHandler{
    @JvmStatic
    fun handle(node: Node, player: Player){
        if(node is GameObject){
            val go = node.asObject()
        }

        if(node is NPC){
            player.sendMessage(colorize("MODE IS NPC"))
            val npc = node.asNpc()
            player.dialogueInterpreter.open(RPUseWithNPCDialogue().ID,npc)
        }

        if(node is Item){
            player.sendMessage(colorize("MODE IS ITEM"))
            val item = node.asItem()
        }

        if(node is Player){
            player.sendMessage(colorize("MODE IS PLAYER"))
            val p = node.asPlayer()
            player.dialogueInterpreter.open(RPUseWithPlayerDialogue().ID,p)
        }
    }
}