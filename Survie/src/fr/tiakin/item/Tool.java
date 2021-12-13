package fr.tiakin.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiakin.block.blocks;
import fr.tiakin.main.Custom;
import fr.tiakin.main.main;

public class Tool {
	public static boolean canHarvest(Block block, ItemStack item) {
		blocks customblock = Custom.getCustomBlock(block);
		if(customblock != null) {
			if(getOrder(getTier(item)) >= getOrder(customblock.getTier()))
				return true;
			else
				return false;
		} else if(!block.getDrops(item).isEmpty())
			return true;
		return false;
	}
	
	public static Material getSound(Block block) {
		blocks customblock = Custom.getCustomBlock(block);
		Material hardness;
		if(customblock != null)
			hardness = customblock.getSound();
		else
			hardness = block.getType();
		
		return hardness;
    }
	
	public static float getHardness(Block block) {
		blocks customblock = Custom.getCustomBlock(block);
		float hardness;
		if(customblock != null)
			hardness = customblock.getHardness();
		else
			hardness = block.getType().getHardness();
		
		return hardness;
    }
	public static boolean isMushroom(Material m) {
		return switch(m) {
			case MUSHROOM_STEM,RED_MUSHROOM_BLOCK,BROWN_MUSHROOM_BLOCK -> true;
			default -> false;
		};
	}
	public static boolean isBestTool(Block block, ItemStack item) {
		blocks customblocks = Custom.getCustomBlock(block);
		switch(getTool(item)) {
		case 1:
			if((Tag.MINEABLE_PICKAXE.isTagged(block.getType()) && customblocks == null) ||(customblocks != null && customblocks.getTool().equalsIgnoreCase("pickaxe")))
				return true;
			break;
		case 2:
			if(((isMushroom(block.getType()) || Tag.MINEABLE_AXE.isTagged(block.getType())) && customblocks == null) || (customblocks != null && customblocks.getTool().equalsIgnoreCase("axe")))
				return true;
			break;
		case 3:
			if((Tag.MINEABLE_SHOVEL.isTagged(block.getType()) && customblocks == null) ||(customblocks != null && customblocks.getTool().equalsIgnoreCase("shovel")))
				return true;
			break;
		case 4:
			if((Tag.MINEABLE_HOE.isTagged(block.getType()) && customblocks == null) ||(customblocks != null && customblocks.getTool().equalsIgnoreCase("hoe")))
				return true;
			break;
		}
		return false;
	}
	
	public static boolean isHammer(ItemStack item) {
		if(item.hasItemMeta() && item.getItemMeta().hasLore() && item.getItemMeta().getLore().get(0).split(" ")[1].equalsIgnoreCase("hammer"))
			return true;
		return false;
	}
	
	
	public static int getTool(ItemStack itemStack) {
		Material m = itemStack.getType();
		if(m.toString().contains("_PICKAXE"))
			return 1;
		if(m.toString().contains("_AXE"))
    		return 2;
    	if(m.toString().contains("_SHOVEL"))
    		return 3;
    	if(m.toString().contains("_HOE"))
    		return 4;
		return 0;
	}
	
	public static String getTier(ItemStack itemStack) {
		Material m = itemStack.getType();
		if(m.equals(Material.WOODEN_PICKAXE) || m.equals(Material.WOODEN_AXE) || m.equals(Material.WOODEN_SHOVEL) || m.equals(Material.WOODEN_HOE))
			return "wooden";
		if(m.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.GOLDEN_AXE) || m.equals(Material.GOLDEN_SHOVEL) || m.equals(Material.GOLDEN_HOE))
			return "golden";
		if(m.equals(Material.STONE_PICKAXE) || m.equals(Material.STONE_AXE) || m.equals(Material.STONE_SHOVEL) || m.equals(Material.STONE_HOE))
    		return "stone";
    	if(m.equals(Material.IRON_PICKAXE) || m.equals(Material.IRON_AXE) || m.equals(Material.IRON_SHOVEL) || m.equals(Material.IRON_HOE))
    		return "iron";
    	if(m.equals(Material.DIAMOND_PICKAXE) || m.equals(Material.DIAMOND_AXE) || m.equals(Material.DIAMOND_SHOVEL) || m.equals(Material.DIAMOND_HOE))
    		return "diamond";
    	if(m.equals(Material.NETHERITE_PICKAXE) || m.equals(Material.NETHERITE_AXE) || m.equals(Material.NETHERITE_SHOVEL) || m.equals(Material.NETHERITE_HOE)) {
    		if(itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
    			switch(itemStack.getItemMeta().getLore().get(0).split(" ")[0]) {
    			case "Netherite":
    				return "netherite";
    			case "Enderite":
    				return "enderite";
    			case "Discordium":
    				return "discordium";
    			case "Blazite":
    				return "blazite";
    			case "Manyullyn":
    				return "manyullyn";
    			case "Chaos":
    				return "chaos";
    			case "Infinity":
    				return "infinity";
    			}
    		} else { 
    			return "netherite";
    		}
    	}
		return null;
	}
	
	public static int getHammerRadius(ItemStack itemStack) {
		switch(getOrder(getTier(itemStack))) {
		case 4,5,6,7,8:
			return 1;
		case 9,10,11:
			return 2;
		case 12:
			return 3;
		}
		return 0;
	}
	
	public static int getOrder(String e) {
		switch(e) {
		case "wooden":
			return 1;
		case "golden":
			return 2;
		case "stone":
			return 3;
		case "iron":
			return 4;
		case "diamond":
			return 5;
		case "netherite":
			return 6;
		case "enderite":
			return 7;
		case "discordium":
			return 8;
		case "blazite":
			return 9;
		case "manyullyn":
			return 10;
		case "chaos":
			return 11;
		case "infinity":
			return 12;
		default:
			return 0;
		}
	}
	
    public static float getToolSpeed(ItemStack itemStack) {
    	switch(getTier(itemStack)) {
    	case "wooden":
    		return 2;
    	case "golden":
    		return 12;
    	case "stone":
    		return 4;
    	case "iron":
    		return 6;
    	case "diamond":
    		return 8;
    	case "netherite":
    		return 9;
    	case "enderite":
    		return 11;
    	case "discordium":
    		return 13;
    	case "blazite":
			return 15;
		case "manyullyn":
			return 17;
		case "chaos":
			return 19;
		case "infinity":
			return 21;
    	default:
    		return 1;
    	}
    }
	
    public static void breakblock(Block b, Player p, blocks block) {
    	if(canHarvest(b, p.getInventory().getItemInMainHand())) {
    		boolean silkTouch = false;
    		int fortune = 0;
    		if(p.getInventory().getItemInMainHand().hasItemMeta()) {
    			ItemMeta im = p.getInventory().getItemInMainHand().getItemMeta();
    			silkTouch = im.hasEnchant(Enchantment.SILK_TOUCH);
    			fortune = im.hasEnchant(Enchantment.LOOT_BONUS_BLOCKS) ? im.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS) : 0;
    		}
    		b.getWorld().dropItemNaturally(b.getLocation(), block.getDrops(silkTouch,fortune));
		}
    	
    }

	
    public static BlockFace getFacing(Player player) {
    	float pitch = player.getEyeLocation().getPitch();
    	JavaPlugin.getPlugin(main.class).getLogger().info("truc : "+ pitch);
		if(pitch < -45)
			return BlockFace.UP;
		else if(pitch > 45)
			return BlockFace.DOWN;
		else
			return player.getFacing();
	}

    public static List<Block> getSquare(Location loc, BlockFace face,int radius) {
    	List<Block> blocks = new ArrayList<>();
    	int axis = 0;
    	switch(face) {
    	case NORTH:
    	case SOUTH:
    		axis = 1;
    		break;
    	case EAST:
    	case WEST:
    		axis = 2;
    		break;
		default:
			break;
    	}
    	int relativeX = 0, relativeY = 0, relativeZ = 0;
    	switch(axis) {
    	case 0:
    		relativeX = loc.getBlockX();
    		relativeY = loc.getBlockY();
    		relativeZ = loc.getBlockZ();
    		break;
    	case 1:
    		relativeX = loc.getBlockX();
    		relativeY = loc.getBlockZ();
    		relativeZ = loc.getBlockY();
    		break;
    	case 2:
    		relativeX = loc.getBlockY();
    		relativeY = loc.getBlockX();
    		relativeZ = loc.getBlockZ();
    		break;
    	}
        for(int rx = relativeX - radius; rx <= relativeX + radius; rx++) {
            for(int rz = relativeZ - radius; rz <= relativeZ + radius; rz++) {
            	switch(axis) {
            	case 0:
            		blocks.add(loc.getWorld().getBlockAt(rx, relativeY, rz));
            		break;
            	case 1:
            		blocks.add(loc.getWorld().getBlockAt(rx, rz, relativeY));
            		break;
            	case 2:
            		blocks.add(loc.getWorld().getBlockAt(relativeY, rx, rz));
            		break;
            	}
            }
        }
        return blocks;
    }
}
