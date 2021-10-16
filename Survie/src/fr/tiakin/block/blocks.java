package fr.tiakin.block;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import fr.tiakin.item.items;
import fr.tiakin.main.Custom;

public enum blocks {
		
	
		//enderite
		enderite_ore(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Enderite Ore");
					im.setCustomModelData(2000);
					im.setLore(Arrays.asList("Enderite Ore"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","netherite",
			50,
			true,null,
			false,false,false,false,false,true,
			Material.STONE
		),
		
		enderite_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Enderite Block");
					im.setCustomModelData(2001);
					im.setLore(Arrays.asList("Enderite Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","netherite",
			60,
			true,null,
			true,false,false,false,false,false,
			Material.STONE
		),
		
		
		//discordium
		discordium_ore(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Discordium Ore");
					im.setCustomModelData(2002);
					im.setLore(Arrays.asList("Discordium Ore"));
					this.setItemMeta(im);
				}
			}, 
			Material.MUSHROOM_STEM,
			"pickaxe","enderite",
			55,
			false,items.discordium_chunk.getItemStack(),
			true,false,false,false,false,true,
			Material.STONE
		),
		
		discordium_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Discordium Block");
					im.setCustomModelData(2003);
					im.setLore(Arrays.asList("Discordium Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","enderite",
			65,
			true,null,
			false,false,false,true,false,false,
			Material.STONE
		),
		
		
		//blazite
		blazite_ore(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Blazite Ore");
					im.setCustomModelData(2004);
					im.setLore(Arrays.asList("Blazite Ore"));
					this.setItemMeta(im);
				}
			}, 
			Material.MUSHROOM_STEM,
			"pickaxe","discordium",
			60,
			false,items.blazite_chunk.getItemStack(),
			false,false,false,true,false,true,
			Material.STONE
		),
		
		blazite_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Blazite Block");
					im.setCustomModelData(2005);
					im.setLore(Arrays.asList("Blazite Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","discordium",
			70,
			true,null,
			true,false,false,true,false,false,
			Material.STONE
		),
		
		
		//ardite -> manyullyn
		ardite_ore(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Ardite Ore");
					im.setCustomModelData(2006);
					im.setLore(Arrays.asList("Ardite Ore"));
					this.setItemMeta(im);
				}
			}, 
			Material.MUSHROOM_STEM,
			"pickaxe","blazite",
			60,
			true,null,
			true,false,false,true,false,true,
			Material.STONE
		),
		
		ardite_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Ardite Block");
					im.setCustomModelData(2007);
					im.setLore(Arrays.asList("Ardite Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","blazite",
			70,
			true,null,
			false,false,true,false,false,false,
			Material.STONE
		),
		
		//cobalt -> manyullyn
		cobalt_ore(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Cobalt Ore");
					im.setCustomModelData(2008);
					im.setLore(Arrays.asList("Cobalt Ore"));
					this.setItemMeta(im);
				}
			}, 
			Material.MUSHROOM_STEM,
			"pickaxe","blazite",
			60,
			true,null,
			false,false,true,false,false,true,
			Material.STONE
		),
		
		cobalt_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Cobalt Block");
					im.setCustomModelData(2009);
					im.setLore(Arrays.asList("Cobalt Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","blazite",
			70,
			true,null,
			true,false,true,false,false,false,
			Material.STONE
		),
		
		//manyullyn
		manyullyn_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Manyullyn Block");
					im.setCustomModelData(2010);
					im.setLore(Arrays.asList("Manyullyn Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","blazite",
			80,
			true,null,
			true,false,true,false,false,true,
			Material.STONE
		),
		
		
		//chaos
		chaos_ore(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Chaos Ore");
					im.setCustomModelData(2011);
					im.setLore(Arrays.asList("Chaos Ore"));
					this.setItemMeta(im);
				}
			}, 
			Material.MUSHROOM_STEM,
			"pickaxe","manyullyn",
			110,
			false,items.chaos_chunk.getItemStack(),
			false,false,true,true,false,false,
			Material.STONE
		),
		
		chaos_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Chaos Block");
					im.setCustomModelData(2012);
					im.setLore(Arrays.asList("Chaos Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","manyullyn",
			130,
			true,null,
			false,false,true,true,false,true,
			Material.STONE
		),
		
		chaos_nylium(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Chaos Nylium");
					im.setCustomModelData(2013);
					im.setLore(Arrays.asList("Chaos Nylium"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","manyullyn",
			80,
			true,null,
			true,false,true,true,false,false,
			Material.STONE
		),
		
		chaos_log(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Chaos Log");
					im.setCustomModelData(2014);
					im.setLore(Arrays.asList("Chaos Log"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"axe","manyullyn",
			90,
			true,null,
			true,false,true,true,false,true,
			Material.OAK_LOG
		),
		
		chaos_planks(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Chaos Planks");
					im.setCustomModelData(2015);
					im.setLore(Arrays.asList("Chaos Planks"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"axe","manyullyn",
			80,
			true,null,
			false,false,false,false,true,false,
			Material.OAK_LOG
		),
		
		//infinity
		infinity_block(
			new ItemStack(Material.PLAYER_HEAD) {
				ItemMeta im;{
					im = this.getItemMeta();
					im.setDisplayName(ChatColor.RESET+"Infinity Block");
					im.setCustomModelData(666);
					im.setLore(Arrays.asList("Infinity Block"));
					this.setItemMeta(im);
				}
			},
			Material.MUSHROOM_STEM,
			"pickaxe","chaos",
			150,
			true,null,
			false,false,false,false,true,true,
			Material.STONE
		);
	
		private ItemStack is;
		
		private Material material;
		
		private String tool;
		private String tier;
		
		private float hardness;
		
		private boolean selfdrop;
		private ItemStack drop;
		
		private boolean up,down,north,south,east,west;

		private Material sound;
		
		
	    blocks(ItemStack itemStack,Material material, String tool, String tier,float hardness, boolean selfdrop, ItemStack drop, boolean up, boolean down, boolean north, boolean south, boolean east, boolean west, Material sound){
	    	
	        this.is = itemStack; // la playerhead de l'item qui permet de poser le block ou de l'utiliser en tant que recipe c;
	        
	        this.material = material; // le materiel du block, de base il y en a trois possible : les mushroom stem, red ou brown mushroom
	        
	        this.tool = tool; // le tool necessaire pour peter le fiak du block
	        this.tier = tier; // le tier de l'item necessaire pour peter le fiak du block
	        
	        this.hardness = hardness; // la dureté 
	        
	        this.selfdrop = selfdrop; //cette variable de type boolean ne va probablement pas être utiliser autre part que dans cette class
	        this.drop = drop; // ce que drop l'item si jamais le drop n'est pas null ou que la personne possède silktouch
	        
	        this.up = up;  // blockface du haut
	        this.down = down; // blockface du bas
	        this.north = north; // blockface du nord
	        this.south = south; // blockface du sud (comme libe)
	        this.east = east; // blockface de l'est
	        this.west = west; // blockface de l'ouest 
	        
	        this.sound = sound; // le son de break du block
	    }
	    public ItemStack getItemStack() {
	    	return is;
	    }
	    public Material getMaterial() {
	    	return material;
	    }
	    public String getTool() {
	    	return tool;
	    }
	    public String getTier() {
	    	return tier;
	    }
	    public float getHardness() {
	    	return hardness;
	    }
	    public boolean getSelfDrops() {
	    	return selfdrop;
	    }
	    public ItemStack getDrops(boolean silktouch, int fortune) {
	    	if(getSelfDrops() || silktouch)
	    		return is;
	    	else {
	            if (fortune > 0) {
	            	Random rdm = new Random();
	                int i = rdm.nextInt(fortune + 2) - 1;
	                if (i < 0) {
	                   i = 0;
	                }
	    			drop = Custom.multi(drop, i + 1);
	    		}
	    		
	    	}
	    	return drop;
	    }
	    public boolean getBlockFace(BlockFace face) {
	    	if(face.equals(BlockFace.UP))
	    		return up;
	    	if(face.equals(BlockFace.DOWN))
	    		return down;
	    	if(face.equals(BlockFace.NORTH))
	    		return north;
	    	if(face.equals(BlockFace.SOUTH))
	    		return south;
	    	if(face.equals(BlockFace.EAST))
	    		return east;
	    	if(face.equals(BlockFace.WEST))
	    		return west;
	    	return false;
	    }
		public Material getSound() {
			return sound;
		}
}
