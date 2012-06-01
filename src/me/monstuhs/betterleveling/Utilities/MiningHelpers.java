/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Utilities;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

/**
 *
 * @author James
 */
public class MiningHelpers {
    
    public static Material getDropTypeForBlock(Material blockMat){
        switch(blockMat){
            case COAL_ORE: return Material.COAL;
            case DIAMOND_ORE: return Material.DIAMOND;            
            case GLOWING_REDSTONE_ORE: return Material.REDSTONE;
            case REDSTONE_ORE: return Material.REDSTONE;
            case GLOWSTONE: return Material.GLOWSTONE_DUST;
            case LAPIS_ORE: return Material.REDSTONE;
            default: return blockMat;                
        }
    }
    
    public static boolean isToolCorrectForMaterial(Material tool, Material block){
        switch(tool){
            case IRON_PICKAXE:
            case WOOD_PICKAXE:
            case STONE_PICKAXE:
            case GOLD_PICKAXE:
            case DIAMOND_PICKAXE:
                return isBreakableByPick(block);
            case IRON_AXE:
            case WOOD_AXE:
            case STONE_AXE:
            case GOLD_AXE:
            case DIAMOND_AXE:
                return isBreakableByAxe(block);
            case IRON_SPADE:
            case WOOD_SPADE:
            case STONE_SPADE:
            case GOLD_SPADE:
            case DIAMOND_SPADE:
                return isBreakableByShovel(block);
            default: return false;
        }
    }
    
    public static boolean isAttachedToFragileMaterial(Block block){
        return 
                isFragile(block.getRelative(BlockFace.UP).getType())    ||
                isFragile(block.getRelative(BlockFace.DOWN).getType())  ||
                isFragile(block.getRelative(BlockFace.EAST).getType())  ||
                isFragile(block.getRelative(BlockFace.WEST).getType())  ||
                isFragile(block.getRelative(BlockFace.NORTH).getType()) ||
                isFragile(block.getRelative(BlockFace.SOUTH).getType());
    }
    
    private static boolean isFragile(Material material){
        
        switch(material){
            case WOODEN_DOOR:
            case DETECTOR_RAIL:
            case RAILS:
            case STONE_BUTTON: 
            case LEVER:
            case IRON_DOOR:
                return true;
            default: return false;                
        }
    }
    
    public static boolean isOre(Material blockMat){
        switch(blockMat){
            case COAL_ORE:
            case DIAMOND_ORE:
            case GOLD_ORE:
            case GLOWING_REDSTONE_ORE:
            case GLOWSTONE:
            case IRON_ORE:
            case LAPIS_ORE:
            case REDSTONE_ORE:
                return true;
            default:
                return false;
                
        }
    }
    
    private static boolean isBreakableByPick(Material blockMat){
        
        switch(blockMat){
            case COAL_ORE:
            case DIAMOND_ORE:
            case GOLD_ORE:
            case GLOWING_REDSTONE_ORE:
            case GLOWSTONE:
            case IRON_ORE:
            case LAPIS_ORE:
            case REDSTONE_ORE:
            case STONE:
            case COBBLESTONE: 
            case COBBLESTONE_STAIRS:
            case SANDSTONE: 
            case SMOOTH_BRICK:
            case SMOOTH_STAIRS:
            case BRICK:
            case BRICK_STAIRS:
            case NETHER_BRICK:
            case NETHER_BRICK_STAIRS:
            case NETHERRACK:                
                return true;
            default:
                return false;
                
        }
    }
    
    private static boolean isBreakableByAxe(Material blockMat){
        
        switch(blockMat){
            case WOOD:
            case CACTUS:            
            case LOG:
                return true;
            default:
                return false;
                
        }
    }
    
    private static boolean isBreakableByShovel(Material blockMat){
        switch(blockMat){
            case GRASS:
            case DIRT:
            case SAND:
            case CLAY_BRICK:
            case SNOW_BLOCK:
            case SOUL_SAND:
                return true;
            default: return false;
        }
    }
}
