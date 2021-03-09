package core.game.system.command.sets

import core.game.component.Component
import core.plugin.Initializable
import plugin.ai.general.GeneralBotCreator
import plugin.ai.general.scriptrepository.PlayerScripts
import plugin.ai.general.scriptrepository.Script
import core.game.system.command.Command
import core.tools.stringtools.colorize

@Initializable
class BottingCommandSet : CommandSet(Command.Privilege.STANDARD) {
    override fun defineCommands() {
        define("scripts"){player, _ ->
            if(!player.getAttribute("botting:warning_shown",false)){
                player.dialogueInterpreter.sendDialogue(colorize("%RYou must be in World 2 to run botting scripts"))
                player.dialogueInterpreter.addAction { player, buttonId -> player.setAttribute("/save:botting:warning_shown",true) }
                return@define
            }
        }
        define("script"){player,args ->
            if(!player.getAttribute("botting:warning_shown",false)){
                player.dialogueInterpreter.sendDialogue(colorize("%RYou must be in World 2 to run botting scripts"))
                player.dialogueInterpreter.addAction { player, buttonId -> player.setAttribute("/save:botting:warning_shown",true) }
                return@define
            }
        }
    }
}