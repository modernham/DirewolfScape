package plugin.ai.general.scriptrepository

import core.game.content.global.action.DropItemHandler
import core.game.node.entity.skill.Skills
import core.game.node.item.Item
import core.game.world.map.Location
import core.game.world.map.zone.ZoneBorders
import core.tools.Items
import core.tools.stringtools.colorize
import plugin.ai.skillingbot.SkillingBotAssembler


/**
 * Powermines ore closest to the player
 *@author aspect
 */

@PlayerCompatible
@ScriptName("PowerMiner")
@ScriptDescription("Start with '::script powerminer'.",
        "Start near ore you want to mine.")

@ScriptIdentifier("powerminer")
class PowerMiner : Script() {

    enum class State {
        FAILED,
        MINING,
        INIT,
        DROPPING,
        ID}

    var targetore = 22

    var state = State.INIT
    var startLocation = Location(0,0,0)



    override fun tick() {
        when (state) {
            State.INIT -> {
                bot.sendMessage(colorize("Starting Script"))
                startLocation = bot.location
                state = State.MINING
            }
            State.MINING -> {
                val rock = scriptAPI.getNearestNode("rocks",true)
                if (rock != null) {
                    rock.interaction.handle(bot, rock.interaction[0])
                    if (bot.inventory.isFull){
                        state = State.DROPPING
                    }
                }
                if (rock == null){
                    bot.sendMessage(colorize("Looking for new rock"))
                    scriptAPI.randomWalkTo(startLocation,3)
                }
            }
            State.DROPPING -> {
                for(i in 1..27){
                    if(bot.inventory[i] != null) {
                        if (bot.inventory[i].id == Items.COPPER_ORE_436) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                        else if (bot.inventory[i].id == Items.TIN_ORE_438) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                        else if (bot.inventory[i].id == Items.IRON_ORE_440) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                        else if (bot.inventory[i].id == Items.SILVER_ORE_442) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                        else if (bot.inventory[i].id == Items.GOLD_ORE_444) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                        else if (bot.inventory[i].id == Items.MITHRIL_ORE_447) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                        else if (bot.inventory[i].id == Items.COAL_453) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                        else if (bot.inventory[i].id == Items.ADAMANTITE_ORE_449) {
                            scriptAPI.dropItem(bot, bot.inventory.get(i))
                        }
                    }
                }
                if(!bot.inventory.containsItem(Item(Items.COPPER_ORE_436)) && !bot.inventory.containsItem(Item(Items.TIN_ORE_438)) && !bot.inventory.containsItem(Item(Items.IRON_ORE_440)) && !bot.inventory.containsItem(Item(Items.SILVER_ORE_442)) && !bot.inventory.containsItem(Item(Items.GOLD_ORE_444)) && !bot.inventory.containsItem(Item(Items.MITHRIL_ORE_447)) && !bot.inventory.containsItem(Item(Items.COAL_453))&& !bot.inventory.containsItem(Item(Items.ADAMANTITE_ORE_449)))
                    state = State.MINING

            }
        }
    }

    override fun newInstance(): Script {
        return this
    }

    init {
    }

}