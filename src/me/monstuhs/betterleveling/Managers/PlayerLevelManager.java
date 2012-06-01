/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import me.monstuhs.betterleveling.Utilities.BukkitHelpers;
import me.monstuhs.betterleveling.Utilities.ConfigConstants;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
public class PlayerLevelManager {
    
    private double _regenHalfHeartsPerLevel;
    private long _regenDelay;
    private double _percentageOfXpToRetain;
    private double _percentageOfXpToDrop;
    private FileConfiguration _config;
    
    public PlayerLevelManager(ConfigurationManager configManager){
        _regenHalfHeartsPerLevel    = configManager.getConfigFile().getDouble(ConfigConstants.PassiveActivities.ACTIVITY_PASSIVE_REGEN_HH_PER_LEVEL);        
        _regenDelay                 = configManager.getConfigFile().getLong(ConfigConstants.PassiveActivities.ACTIVITY_PASSIVE_REGEN_DELAY);
        _percentageOfXpToRetain     = configManager.getConfigFile().getInt(ConfigConstants.GlobalSettings.SETTING_DEATH_PERCENTAGE_XP_RETAINED);
        _percentageOfXpToDrop       = configManager.getConfigFile().getInt(ConfigConstants.GlobalSettings.SETTING_DEATH_PERCENTAGE_XP_DROPPED);
        
        _config = configManager.getConfigFile();
    }
    
    public void displayPlayerStats(Player player){
        
        int playerLevel = player.getLevel();
        
        player.sendMessage(_config.getString(ConfigConstants.LocalizedMessages.CHANCE_TO_CRIT)       + ": " + CombatManager.getChanceToCrit(playerLevel)  + " / " + _config.getString(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_CRIT_CHANCE));
        player.sendMessage(_config.getString(ConfigConstants.LocalizedMessages.CHANCE_TO_DODGE)      + ": " + CombatManager.getChanceToDodge(playerLevel) + " / " + _config.getString(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_DODGE_CHANCE));
        player.sendMessage(_config.getString(ConfigConstants.LocalizedMessages.CHANCE_TO_DOUBLEDROP) + ": " + MiningManager.getChanceToDoubleDropPerLevel() * playerLevel);
        player.sendMessage(_config.getString(ConfigConstants.LocalizedMessages.CHANCE_TO_INSTABREAK) + ": " + MiningManager.getChanceToBreakPerLevel() * playerLevel);        
        
        double regenPerSecond = player.getLevel() * getRegenHalfHeartsPerLevel() / _regenDelay;
        player.sendMessage(BukkitHelpers.formatDouble(regenPerSecond) + " " + _config.getString(ConfigConstants.LocalizedMessages.EXTRA_REGEN));
    }
    
    public int getPlayerRegenAmount(Player player){
        return (int) (player.getLevel() * getRegenHalfHeartsPerLevel());
    }

    public double getRegenHalfHeartsPerLevel() {
        return _regenHalfHeartsPerLevel;
    }
    
    public int getNewXPAfterDeath(Player player){        
        int xpBeforeDeath = player.getTotalExperience();        
        int newXP = (int) (xpBeforeDeath * (_percentageOfXpToRetain / 100));                
        return newXP;
    }
    
    public int getXPDropped(Player player){
        int xpBeforeDeath = player.getTotalExperience();
        return (int) (xpBeforeDeath * (_percentageOfXpToDrop / 100));
    }
}
