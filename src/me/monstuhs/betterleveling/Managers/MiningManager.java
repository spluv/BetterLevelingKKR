/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import java.util.Random;
import me.monstuhs.betterleveling.BetterLeveling;
import me.monstuhs.betterleveling.Utilities.ConfigConstants;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
public class MiningManager {

    private static double _chanceToBreakPerLevel = 0;
    private static double _chanceToDoubleDropPerLevel = 0;

    public double getChanceToBreakPerLevel() {
        return _chanceToBreakPerLevel;
    }

    public double getChanceToDoubleDropPerLevel() {
        return _chanceToDoubleDropPerLevel;
    }

    public MiningManager(){
        _chanceToBreakPerLevel      = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.MiningActivities.ACTIVITY_MINING_PpL_INSTABREAK);
        _chanceToDoubleDropPerLevel = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.MiningActivities.ACTIVITY_MINING_PpL_DOUBLE_DROP);
    }

    public boolean getDoubleDropForPlayer(Player miner){
        double chance = getChanceToDoubleDropPerLevel();
        return chance > 0 && new Random().nextInt(100) <= (miner.getLevel() * chance);
    }

    public boolean getInstaBreakForPlayer(Player miner){
        double chance = getChanceToDoubleDropPerLevel();
        return chance > 0 && new Random().nextInt(100) <= (miner.getLevel() * chance);
    }
}
