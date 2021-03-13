package plugin.ai.general.scriptrepository.runecrafting

import core.cache.def.impl.ItemDefinition
import core.game.interaction.DestinationFlag
import core.game.interaction.MovementPulse
import core.game.interaction.NodeUsageEvent
import core.game.interaction.UseWithHandler
import core.game.interaction.inter.FairyRing
import core.game.node.`object`.GameObject
import core.game.node.entity.player.link.RunScript
import core.game.node.entity.skill.Skills
import core.game.node.entity.skill.crafting.armour.HardCraftPulse
import core.game.world.map.Location
import core.game.world.update.flag.context.ChatMessage
import core.game.world.update.flag.player.ChatFlag
import core.tools.Items
import core.tools.stringtools.colorize
import plugin.ai.general.GeneralBotCreator
import plugin.ai.general.ScriptAPI
import plugin.ai.general.scriptrepository.*


/**
 * Slayes creatures passed as arguments
 *@author aspect
 */

@PlayerCompatible
@ScriptName("Simple Monster Killer")
@ScriptDescription("Start anywhere near chosen monster with '::script slayer monstername'.",
        "Make sure monster name matches spelling exactly.",
        "Replace spaces with '_'.")
@ScriptIdentifier("slayer")
class Slayer() : Script() {
    var state = State.SETUP
    var overlay: ScriptAPI.BottingOverlay?= null
    var slayedAmt = 0
    var talismanChild : GameObject? = null
    var interactChild : GameObject? = null
    var sentFailedMessage = false
    var waitLeft = 0
    var monstertoslay = "blank"
    var startLocation = Location(0,0,0)
    var timer = 3

    enum class State {
        FAILED,
        KILLING,
        INIT,
        SETUP_WAIT,
        SETUP,
        CONFIG,
        LOOTING,
        IDLE
    }



    override fun tick() {
        when (state) {

            State.SETUP -> {
                var monstertype = 0
                if (arguments.size > 0) {
                    if (arguments[0].contains("help")) {
                        bot.sendMessage(colorize("%RUsage: %B::script slayer_s [monstername]"))
                        bot.sendMessage("Name must be exact and case sensitive")
                        bot.sendMessage("Bot does not eat")
                        sentFailedMessage = true
                        state = State.FAILED
                        return
                    }

                    state = State.FAILED
                    if (arguments[0] != null) {
                        monstertoslay = arguments[0]
                        monstertoslay = monstertoslay.replace("_", " ")
                        bot.sendMessage(colorize("Monster Chosen: " + monstertoslay))
                        state = State.INIT
                        bot.sendMessage(colorize("%PStarting slayer for " + arguments[0]))
                    }
                } else {
                    bot.sendMessage(colorize("No Argument Given, Getting one"))
                    bot.setAttribute("slayer", object : RunScript() {
                        override fun handle(): Boolean {
                            var v = value as String
                            bot.sendMessage(colorize("Input was : ") + v)
                            state = State.FAILED
                                if (v != null) {
                                    bot.sendMessage(colorize("v not null") + v)
                                    monstertoslay = v
                                    bot.sendMessage(colorize("slaying ") + monstertoslay)
                                    state = State.INIT
                                    bot.sendMessage(colorize("%PStarting slayer for " + monstertoslay))
                                }
                            return true
                        }
                    })
                    bot.dialogueInterpreter.sendInput(true, "Enter monster to slay. Must be exact name and case")
                    state = State.SETUP_WAIT
                }
            }

            State.INIT -> {
                sentFailedMessage = false
                startLocation = bot.location
                overlay = scriptAPI.getOverlay()
                overlay!!.init()
                overlay!!.setTitle(monstertoslay)
                overlay!!.setTaskLabel("Monsters Slayed: ")
                overlay!!.setAmount(0)
                state = Slayer.State.CONFIG
                state = Slayer.State.KILLING
            }

            State.KILLING -> {
                val target = scriptAPI.getNearestNode(monstertoslay)
                if (target == null) {
                    scriptAPI.randomWalkTo(startLocation, 3)
                } else {
                    scriptAPI.attackNpcInRadius(bot, monstertoslay, 10)

                    slayedAmt++
                    overlay!!.setAmount(slayedAmt)
                }
            }

            State.IDLE -> {
                if (timer-- <= 0) {
                    state = Slayer.State.LOOTING
                }
            }

            State.LOOTING -> {
                scriptAPI.takeNearestGroundItem(Items.FEATHER_314)
                state = State.KILLING
            }
        }
    }


    override fun newInstance(): Script {
        return this
    }

    companion object {
        const val SPECIAL_ZONE = -42069
    }
}