/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Utilities;

/**
 *
 * @author James
 */
public class ConfigConstants {

    public class MiningActivities {

        public static final String ACTIVITY_MINING_PpL_INSTABREAK = "activity.mining.PercentageChancePerLevelToInstaBreak";
        public static final String ACTIVITY_MINING_PpL_DOUBLE_DROP = "activity.mining.PercentageChancePerLevelToDoubleDrop";
    }

    public class CombatActivities {

        public static final String ACTIVITY_COMBAT_PpL_DODGE = "activity.combat.PercentageChancePerLevelToDodge";
        public static final String ACTIVITY_COMBAT_PpL_CRIT = "activity.combat.PercentageChancePerLevelToCrit";        
    }
    
    public class PassiveActivities {
        public static final String ACTIVITY_PASSIVE_REGEN_HH_PER_LEVEL = "activity.passive.regeneration.HalfheartsPerLevel";
        public static final String ACTIVITY_PASSIVE_REGEN_DELAY = "activity.passive.regeneration.RegenIntervalInSeconds";
    }
    
    public class GlobalSettings {
        
        public static final String WORLD_NAME = "settings.WorldName";
        public static final String SETTINGS_COMBAT_DODGE_MODIFIER = "settings.combat.PercentageDamageFromDodge";
        public static final String SETTINGS_COMBAT_CRIT_MODIFIER = "settings.combat.PercentageDamageFromCrit";
        public static final String SETTINGS_COMBAT_HEADSHOT_MODIFIER = "settings.combat.PercentageDamageFromHeadshot";
        public static final String SETTINGS_COMBAT_MAX_CRIT_CHANCE = "settings.combat.MaximumChanceForCrit";
        public static final String SETTINGS_COMBAT_MAX_DODGE_CHANCE = "settings.combat.MaximumChanceForDodge";
        
        public static final String SETTING_DEATH_PERCENTAGE_XP_RETAINED = "settings.death.PercentageOfXPRetained";
        public static final String SETTING_DEATH_PERCENTAGE_XP_DROPPED = "settings.death.PercentageOfXPDropped";
    }
    
    public class Commands {
        public static final String COMMANDS_SHOW_STATS = "stats";
    }
    
    public class LocalizedMessages {
        public static final String CHANCE_TO_CRIT = "localization.stats.ChanceToCrit";
        public static final String CHANCE_TO_DODGE = "localization.stats.ChanceToDodge";
        public static final String CHANCE_TO_DOUBLEDROP = "localization.stats.ChanceToDoubleDrop";
        public static final String CHANCE_TO_INSTABREAK = "localization.stats.ChanceToInstaBreak";
        public static final String EXTRA_REGEN = "localization.stats.ExtraRegenPerSecond";
        public static final String CRITICAL_HIT = "localization.combat.CriticalHit";
        public static final String DODGE = "localization.combat.Dodge";
        public static final String HEADSHOT = "localization.combat.HeadShot";
    }
}
