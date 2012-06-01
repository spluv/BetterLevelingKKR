/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import java.util.Random;
import me.monstuhs.betterleveling.BetterLeveling;
import me.monstuhs.betterleveling.Utilities.ConfigConstants;
import me.monstuhs.betterleveling.Utilities.PlugginLogging;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
public class CombatManager {

    private static double _chanceToDodgePerLevel = 0;
    private static double _dodgeDamageModifier = 1;
    private static double _chanceToCritPerLevel = 0;
    private static double _critDamageModifier = 1;
    private static double _headshotDamageModifier = 1;
    private static double _maxCritChance = 100;
    private static double _maxDodgeChance = 100;
    

    public static double getChanceToDodge(int playerLevel) {
        return Math.min((playerLevel * _chanceToDodgePerLevel), _maxDodgeChance);
    }

    public static double getChanceToCrit(int playerLevel) {
        return Math.min((playerLevel * _chanceToCritPerLevel), _maxCritChance);
    }

    public CombatManager() {
        _chanceToDodgePerLevel = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.CombatActivities.ACTIVITY_COMBAT_PpL_DODGE);
        _dodgeDamageModifier = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_DODGE_MODIFIER) / 100;
        
        _chanceToCritPerLevel = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.CombatActivities.ACTIVITY_COMBAT_PpL_CRIT);
        _critDamageModifier = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_CRIT_MODIFIER) / 100;
        
        _headshotDamageModifier = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_HEADSHOT_MODIFIER) / 100;
        _maxCritChance = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_CRIT_CHANCE);
        _maxDodgeChance = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_DODGE_CHANCE);
    }

    public static int getDamageAfterDodgeAttempt(Player defender, int originalDamage) {
        
        double roll = new Random().nextInt(100);
        int newDamage = originalDamage;
        boolean doesPlayerDodge = roll <= getChanceToDodge(defender.getLevel());
        if (doesPlayerDodge) {
            newDamage = (int) (originalDamage * _dodgeDamageModifier);
            defender.sendMessage(ChatColor.DARK_PURPLE + BetterLeveling.ConfigManager.getConfigFile().getString(ConfigConstants.LocalizedMessages.DODGE) + " (" + newDamage + " / " + originalDamage + ")");
        }
        return newDamage;
    }
    
    public static int getDamageAfterCritAttempt(Player attacker, int originalDamage){
        double roll = new Random().nextInt(100);
        boolean doesPlayerCrit =  roll <= getChanceToCrit(attacker.getLevel());        
        if(doesPlayerCrit){
            attacker.sendMessage(ChatColor.BLUE + BetterLeveling.ConfigManager.getConfigFile().getString(ConfigConstants.LocalizedMessages.CRITICAL_HIT) + " (x " + _critDamageModifier + ")");
            originalDamage *= _critDamageModifier;            
        }
        return originalDamage;
    }
    
    public static int getDamageAfterHeadshotAttempt(Arrow arrow, LivingEntity defender, int originalDamage){
        Location pointOfContact = arrow.getLocation();
        Location eyeLocation = defender.getEyeLocation();        
        
        double yOffset = pointOfContact.getY() - eyeLocation.getY();
//        double xOffset = pointOfContact.getX() - eyeLocation.getX();
//        double zOffset = pointOfContact.getZ() - eyeLocation.getZ();
        
        if (Math.abs(yOffset) >= 0.75) {
            
            ((Player)arrow.getShooter()).sendMessage(ChatColor.RED + BetterLeveling.ConfigManager.getConfigFile().getString(ConfigConstants.LocalizedMessages.HEADSHOT) + " (x " + _headshotDamageModifier + ")");
            originalDamage *= _headshotDamageModifier;
            
        }
        return originalDamage;
    }
}
