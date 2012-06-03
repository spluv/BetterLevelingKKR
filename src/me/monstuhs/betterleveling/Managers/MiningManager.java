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
    
    private static int _chanceToBreakPerLevel = 0;
    private static int _chanceToDoubleDropPerLevel = 0;

    public int getChanceToBreakPerLevel() {
        return _chanceToBreakPerLevel;
    }

    public int getChanceToDoubleDropPerLevel() {
        return _chanceToDoubleDropPerLevel;
    }
    
    public MiningManager(){        
        _chanceToBreakPerLevel = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.MiningActivities.ACTIVITY_MINING_PpL_INSTABREAK);
        _chanceToDoubleDropPerLevel = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.MiningActivities.ACTIVITY_MINING_PpL_DOUBLE_DROP);
    }
    
    public boolean getDoubleDropForPlayer(Player miner){        
        int chance = getChanceToDoubleDropPerLevel();
        return chance > 0 && new Random().nextInt(100) <= (miner.getLevel() * chance);
    }
    
    public boolean getInstaBreakForPlayer(Player miner){        
        int chance = getChanceToDoubleDropPerLevel();
        return chance > 0 && new Random().nextInt(100) <= (miner.getLevel() * chance);
    }
}
