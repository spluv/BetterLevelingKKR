/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.EventHandlers;

import me.monstuhs.betterleveling.BetterLeveling;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @author James
 */
public class DeathListener implements Listener {
    
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        
        Player deadBro = event.getEntity();
        int newXP = BetterLeveling.PlayerLvlManager.getNewXPAfterDeath(deadBro);
        int droppedXP = BetterLeveling.PlayerLvlManager.getXPDropped(deadBro);
        
        event.setNewExp(newXP);
        event.setDroppedExp(droppedXP);
    }
    
}
