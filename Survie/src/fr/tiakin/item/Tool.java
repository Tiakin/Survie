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

import fr.tiakin.block.Blocks;
import fr.tiakin.main.Custom;

public class Tool {
	
	public static boolean canHarvest(Block block, ItemStack item) {
		Blocks customblock = Custom.getCustomBlock(block);
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
		Blocks customblock = Custom.getCustomBlock(block);
		Material hardness;
		if(customblock != null)
			hardness = customblock.getSound();
		else
			hardness = block.getType();
		
		return hardness;
    }
	
	public static float getHardness(Block block) {
		Blocks customblock = Custom.getCustomBlock(block);
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
		Blocks customblocks = Custom.getCustomBlock(block);
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
		case 5:
			if(block.getType() == Material.COBWEB || block.getType() == Material.BAMBOO)
				return true;
			break;
		case 6:
			if(isLeaves(block.getType()))
				return true;
			break;
			
		}
		return false;
	}
	
	public static boolean isLeaves(Material m) {
		return switch(m) {
		case ACACIA_LEAVES,AZALEA_LEAVES,BIRCH_LEAVES,DARK_OAK_LEAVES,FLOWERING_AZALEA_LEAVES,JUNGLE_LEAVES,OAK_LEAVES,SPRUCE_LEAVES -> true;
		default -> false;
		};
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
    	if(m.toString().contains("_SWORD"))
    		return 5;
    	if(m.toString().equalsIgnoreCase("SHEARS"))
    		return 6;
		return 0;
	}
	
	public static String getTier(ItemStack itemStack) {
		Material m = itemStack.getType();
		return switch(m) {
		case WOODEN_PICKAXE,WOODEN_AXE,WOODEN_SHOVEL,WOODEN_HOE,WOODEN_SWORD -> "wooden";
		case LEATHER_HELMET,LEATHER_CHESTPLATE,LEATHER_LEGGINGS,LEATHER_BOOTS -> "leather";
		case GOLDEN_PICKAXE,GOLDEN_AXE,GOLDEN_SHOVEL,GOLDEN_HOE,GOLDEN_SWORD,GOLDEN_HELMET,GOLDEN_CHESTPLATE,GOLDEN_LEGGINGS,GOLDEN_BOOTS -> "golden";
		case STONE_PICKAXE,STONE_AXE,STONE_SHOVEL,STONE_HOE,STONE_SWORD -> "stone";
		case CHAINMAIL_HELMET,CHAINMAIL_CHESTPLATE,CHAINMAIL_LEGGINGS,CHAINMAIL_BOOTS -> "chainmail";
		case IRON_PICKAXE,IRON_AXE,IRON_SHOVEL,IRON_HOE,IRON_SWORD,IRON_HELMET,IRON_CHESTPLATE,IRON_LEGGINGS,IRON_BOOTS,SHEARS -> "iron";
		case DIAMOND_PICKAXE,DIAMOND_AXE,DIAMOND_SHOVEL,DIAMOND_HOE,DIAMOND_SWORD,DIAMOND_HELMET,DIAMOND_CHESTPLATE,DIAMOND_LEGGINGS,DIAMOND_BOOTS -> "diamond";
		case NETHERITE_PICKAXE,NETHERITE_AXE,NETHERITE_SHOVEL,NETHERITE_HOE,NETHERITE_SWORD,NETHERITE_HELMET,NETHERITE_CHESTPLATE,NETHERITE_LEGGINGS,NETHERITE_BOOTS -> {
			if(itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
				yield switch(itemStack.getItemMeta().getLore().get(0).split(" ")[0]) {
				case "Netherite" -> "netherite";
				case "Enderite" -> "enderite";
				case "Discordium" -> "discordium";
    			case "Blazite" -> "blazite";
    			case "Manyullyn" -> "manyullyn";
    			case "Chaos" -> "chaos";
    			case "Netherstar" -> "netherstar";
    			case "Infinity" -> "infinity";
				default -> "netherite";
				};
			}else {
				yield "netherite";
			}
		}
		default -> "nop";
		};
	}
	
	public static int getHammerRadius(ItemStack itemStack) {
		switch(getOrder(getTier(itemStack))) {
		case 4,5,6,7,8:
			return 1;
		case 9,10,11:
			return 2;
		case 12,13:
			return 3;
		}
		return 0;
	}
	
	public static int getOrder(String e) {
		return switch(e) {
		case "wooden","leather" -> 1;
		case "golden" -> 2;
		case "stone","chainmail" -> 3;
		case "iron" -> 4;
		case "diamond" -> 5;
		case "netherite" -> 6;
		case "enderite" -> 7;
		case "discordium" -> 8;
		case "blazite" -> 9;
		case "manyullyn" -> 10;
		case "chaos" -> 11;
		case "netherstar" -> 12;
		case "infinity" -> 13;
		default -> 0;
		};
	}
	public static int getOrder(ItemStack itemStack) {
		return getOrder(getTier(itemStack));
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
    		return 12;
    	case "discordium":
    		return 16;
    	case "blazite":
			return 22;
		case "manyullyn":
			return 26;
		case "chaos":
			return 30;
		case "netherstar":
			return 34;	
		case "infinity":
			return 40;
    	default:
    		return 1;
    	}
    }
	
    public static void breakblock(Block b, Player p, Blocks block) {
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
		if(pitch < -45)
			return BlockFace.UP;
		else if(pitch > 45)
			return BlockFace.DOWN;
		else
			return player.getFacing();
	}

    public static List<Block> getSquare(Location loc, BlockFace face,int radius) {
    	List<Block> blocks = new ArrayList<>();
    	int axis = switch(face) {
    	case NORTH,SOUTH -> 1;
    	case EAST,WEST -> 2;
		default -> 0;
    	};
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
            	case 0 -> blocks.add(loc.getWorld().getBlockAt(rx, relativeY, rz));
            	case 1 -> blocks.add(loc.getWorld().getBlockAt(rx, rz, relativeY));
            	case 2 -> blocks.add(loc.getWorld().getBlockAt(relativeY, rx, rz));
            	}
            }
        }
        return blocks;
    }
}
