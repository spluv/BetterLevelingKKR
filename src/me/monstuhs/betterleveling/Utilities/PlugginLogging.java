/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Utilities;

import me.monstuhs.betterleveling.BetterLeveling;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
public class PlugginLogging {
    public static void WriteMessageToConsole(String message) {
        System.out.println(message);
    }
    
    public static void SendDodgeMessageToPlayer(Player player, int newDamage, int originalDamage){
        String message =  BetterLeveling.ConfigManager.getConfigFile().getString(ConfigConstants.LocalizedMessages.DODGE);
        if(!"".equals(message)){
            player.sendMessage(ChatColor.DARK_PURPLE + message +  " (" + newDamage + " / " + originalDamage + ")");
        }
    }
    
    public static void SendCritMessageToPlayer(Player player, double critDamageMultifier){
        String message = BetterLeveling.ConfigManager.getConfigFile().getString(ConfigConstants.LocalizedMessages.CRITICAL_HIT);
        if(!"".equals(message)){
            player.sendMessage(ChatColor.BLUE + message + " (x " + critDamageMultifier + ")");
        }
    }
    
    public static void SendHeadShotMessageToPlayer(Player player, double headshotDamageModifier){
        String message = BetterLeveling.ConfigManager.getConfigFile().getString(ConfigConstants.LocalizedMessages.HEADSHOT);
        if(!"".equals(message)){
            player.sendMessage(ChatColor.RED + message + " (x " + headshotDamageModifier + ")");
        }
    }
    
    public static void SendMessageToPlayer(Player player, ChatColor color, String message){
        if(!"".equals(message)){
            player.sendMessage(message);
        }
    }
}
