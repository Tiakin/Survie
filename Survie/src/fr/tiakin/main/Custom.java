package fr.tiakin.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.tiakin.block.blocks;
import fr.tiakin.item.items;

public class Custom implements Listener {
	
	static NamespacedKey key;
	static ShapedRecipe shapedrecipe;
	static ShapelessRecipe shapelessrecipe;
	static FurnaceRecipe furnacerecipe;
	static SmithingRecipe smithingrecipe;
	static ArrayList<NamespacedKey> recipe = new ArrayList<NamespacedKey>();
	   
	public static void customrecipe() {
        Gold();
		Diamond();
		Emerald();
		Netherite();
        Enderite();
        Discordium();
        Blazite();
        Manyullyn();
        Chaos();
        Infinity();
	}
	
	private static void Gold() {
		//apple
		key = new NamespacedKey(main.getPlugin(main.class), "enchanted_golden_apple");
		recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.GOLD_BLOCK);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
	}
	
	private static void Diamond() {
		//hammer
		key = new NamespacedKey(main.getPlugin(main.class), "diamond_hammer");
		recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.diamond_hammer.getItemStack());
        shapedrecipe.shape("DBD","DSD"," S ");
        shapedrecipe.setIngredient('D', Material.DIAMOND);
        shapedrecipe.setIngredient('B', Material.DIAMOND_BLOCK);
        shapedrecipe.setIngredient('S',Material.STICK);
        Bukkit.addRecipe(shapedrecipe);
        
        //apple
        key = new NamespacedKey(main.getPlugin(main.class), "diamond_apple");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.diamond_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.DIAMOND);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enchanted_diamond_apple");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.enchanted_diamond_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.DIAMOND_BLOCK);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
	}
	
	private static void Emerald() {
		//apple
		key = new NamespacedKey(main.getPlugin(main.class), "emerald_apple");
		recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.emerald_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.EMERALD);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enchanted_emerald_apple");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.enchanted_emerald_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.EMERALD_BLOCK);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
	}
	
	private static void Netherite() {
		//hammer
        key = new NamespacedKey(main.getPlugin(main.class), "netherite_hammer");
        smithingrecipe = new SmithingRecipe(key, items.netherite_hammer.getItemStack(), new RecipeChoice.ExactChoice(items.diamond_hammer.getItemStack()), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        Bukkit.addRecipe(smithingrecipe);
	}
	
	private static void Enderite() {
		
		//base
		key = new NamespacedKey(main.getPlugin(main.class), "enderite_scrap");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.enderite_scrap.getItemStack(),new RecipeChoice.ExactChoice(blocks.enderite_ore.getItemStack()),7f,300);
        Bukkit.addRecipe(furnacerecipe);
		
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_ingot");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, items.enderite_ingot.getItemStack());
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(4,Material.DIAMOND);
        	shapelessrecipe.addIngredient(Material.ENDER_PEARL);
        Bukkit.addRecipe(shapelessrecipe);
        
        //block
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.enderite_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.enderite_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.enderite_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_sword");
        smithingrecipe = new SmithingRecipe(key, items.enderite_sword.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_pickaxe");
        smithingrecipe = new SmithingRecipe(key, items.enderite_pickaxe.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_PICKAXE), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_axe");
        smithingrecipe = new SmithingRecipe(key, items.enderite_axe.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_AXE), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_shovel");
        smithingrecipe = new SmithingRecipe(key, items.enderite_shovel.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_SHOVEL), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_hoe");
        smithingrecipe = new SmithingRecipe(key, items.enderite_hoe.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_HOE), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        //Hammer
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_hammer");
        smithingrecipe = new SmithingRecipe(key, items.enderite_hammer.getItemStack(), new RecipeChoice.ExactChoice(items.netherite_hammer.getItemStack()), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        //armor
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_helmet");
        smithingrecipe = new SmithingRecipe(key, items.enderite_helmet.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_chestplate");
        smithingrecipe = new SmithingRecipe(key, items.enderite_chestplate.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_leggings");
        smithingrecipe = new SmithingRecipe(key, items.enderite_leggings.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_LEGGINGS), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "enderite_boots");
        smithingrecipe = new SmithingRecipe(key, items.enderite_boots.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_BOOTS), new RecipeChoice.ExactChoice(items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
	}
	
	private static void Discordium() {
		
		//base
		key = new NamespacedKey(main.getPlugin(main.class), "discordium_chunk");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.discordium_chunk.getItemStack(),new RecipeChoice.ExactChoice(blocks.discordium_ore.getItemStack()),5f,400);
        Bukkit.addRecipe(furnacerecipe);
		
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_ingot");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.discordium_ingot.getItemStack(),new RecipeChoice.ExactChoice(items.discordium_chunk.getItemStack()),10f,400);
        Bukkit.addRecipe(furnacerecipe);
        
        //block
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.discordium_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.discordium_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.discordium_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_sword");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_pickaxe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_axe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_shovel");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_hoe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_hammer");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.discordium_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_helmet");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_chestplate");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_leggings");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "discordium_boots");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.discordium_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.enderite_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	private static void Blazite() {
		
		//base
		key = new NamespacedKey(main.getPlugin(main.class), "blazite_chunk");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.blazite_chunk.getItemStack(),new RecipeChoice.ExactChoice(blocks.blazite_ore.getItemStack()),5f,400);
        Bukkit.addRecipe(furnacerecipe);
		
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_ingot");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.blazite_ingot.getItemStack(),new RecipeChoice.ExactChoice(items.blazite_chunk.getItemStack()),10f,400);
        Bukkit.addRecipe(furnacerecipe);
        
        //block
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.blazite_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.blazite_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.blazite_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_sword");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_pickaxe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_axe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_shovel");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_hoe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_hammer");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.blazite_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_helmet");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_chestplate");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_leggings");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "blazite_boots");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.blazite_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.discordium_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	private static void Manyullyn() {
		
		//base
		key = new NamespacedKey(main.getPlugin(main.class), "cobalt_ingot");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.cobalt_ingot.getItemStack(),new RecipeChoice.ExactChoice(blocks.cobalt_ore.getItemStack()),12f,600);
        Bukkit.addRecipe(furnacerecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "ardite_ingot");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.ardite_ingot.getItemStack(),new RecipeChoice.ExactChoice(blocks.ardite_ore.getItemStack()),12f,600);
        Bukkit.addRecipe(furnacerecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_ingot_from_cobalt");
        smithingrecipe = new SmithingRecipe(key, items.manyullyn_ingot.getItemStack(), new RecipeChoice.ExactChoice(items.cobalt_ingot.getItemStack()), new RecipeChoice.ExactChoice(items.ardite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_ingot_from_ardite");
        smithingrecipe = new SmithingRecipe(key, items.manyullyn_ingot.getItemStack(), new RecipeChoice.ExactChoice(items.ardite_ingot.getItemStack()), new RecipeChoice.ExactChoice(items.cobalt_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        //block
        key = new NamespacedKey(main.getPlugin(main.class), "cobalt_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.cobalt_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.cobalt_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "cobalt_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.cobalt_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.cobalt_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "ardite_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.ardite_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.ardite_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "ardite_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.ardite_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.ardite_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.manyullyn_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.manyullyn_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.manyullyn_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_sword");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_pickaxe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_axe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_shovel");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_hoe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_hammer");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.manyullyn_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_helmet");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_chestplate");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_leggings");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "manyullyn_boots");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.manyullyn_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.blazite_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	private static void Chaos() {
		
		//base
		key = new NamespacedKey(main.getPlugin(main.class), "chaos_chunk");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.chaos_chunk.getItemStack(),new RecipeChoice.ExactChoice(blocks.chaos_ore.getItemStack()),12f,800);
        Bukkit.addRecipe(furnacerecipe);
		
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_ingot");
        recipe.add(key);
        furnacerecipe = new FurnaceRecipe(key,items.chaos_ingot.getItemStack(),new RecipeChoice.ExactChoice(items.chaos_chunk.getItemStack()),24f,800);
        Bukkit.addRecipe(furnacerecipe);
        
        //block
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.chaos_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.chaos_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.chaos_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_sword");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_pickaxe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_axe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_shovel");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_hoe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_hammer");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.chaos_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_helmet");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_chestplate");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_leggings");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "chaos_boots");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.chaos_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.manyullyn_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}

	private static void Infinity() {
		
		//base
		key = new NamespacedKey(main.getPlugin(main.class), "infinity_ingot");
	    smithingrecipe = new SmithingRecipe(key, items.infinity_ingot.getItemStack(), new RecipeChoice.ExactChoice(items.infinity_catalyst.getItemStack()), new RecipeChoice.MaterialChoice(Material.NETHER_STAR));
	    Bukkit.addRecipe(smithingrecipe);
        
        //block
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_block");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,blocks.infinity_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_ingot_from_block");
        recipe.add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(items.infinity_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_sword");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_sword.getItemStack());
        	shapedrecipe.shape("B","B","E");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_pickaxe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," B ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_axe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","B ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_shovel");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_shovel.getItemStack());
        	shapedrecipe.shape("D","E","B");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_hoe");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," B");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_hammer");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_hammer.getItemStack());
        	shapedrecipe.shape("BDB","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_helmet");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_helmet.getItemStack());
        	shapedrecipe.shape("DBD","DED");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_chestplate");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","BDB");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_leggings");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_leggings.getItemStack());
        	shapedrecipe.shape("DBD","DED","D D");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(main.getPlugin(main.class), "infinity_boots");
        recipe.add(key);
        shapedrecipe = new ShapedRecipe(key,items.infinity_boots.getItemStack());
        	shapedrecipe.shape("D D","BEB");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(items.chaos_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	public static ItemStack multi(ItemStack itemStack,int amount) {
		ItemStack is = itemStack.clone();
		is.setAmount(amount);
		return is;
	}
	
	public static void discoverrecipe(Player p) {
		//add recipe for player
		p.discoverRecipes(recipe);
	}
	
	@EventHandler
	public void smith(PrepareSmithingEvent e) {
		  ItemStack tool = e.getInventory().getItem(0);
		  ItemStack ingot = e.getInventory().getItem(1);
		  if(tool !=null && ingot != null) {
			  if(!tool.getItemMeta().hasLore() && ingot.getItemMeta().hasLore()) {
				  if(isSimilar(ingot,items.enderite_ingot.getItemStack())) {
					  
					  if(tool.getType().equals(Material.NETHERITE_SWORD)) {
						  e.setResult(items.enderite_sword.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_PICKAXE)) {
						  e.setResult(items.enderite_pickaxe.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_AXE)) {
						  e.setResult(items.enderite_axe.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_SHOVEL)) {
						  e.setResult(items.enderite_shovel.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_HOE)) {
						  e.setResult(items.enderite_hoe.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_HELMET)) {
						  e.setResult(items.enderite_helmet.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_CHESTPLATE)) {
						  e.setResult(items.enderite_chestplate.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_LEGGINGS)) {
						  e.setResult(items.enderite_leggings.getItemStack());
						  
					  } else if(tool.getType().equals(Material.NETHERITE_BOOTS)) {
						  e.setResult(items.enderite_boots.getItemStack());
						  
					  }
				  }
			  }else if(tool.getItemMeta().hasLore() && ingot.getItemMeta().hasLore()) {
				  if(isSimilar(ingot,items.enderite_ingot.getItemStack())) {
					  if(isSimilar(tool, items.netherite_hammer.getItemStack())) {
						  e.setResult(items.enderite_hammer.getItemStack());
						  
					  }
				  }else if((isSimilar(ingot, items.ardite_ingot.getItemStack()) && isSimilar(tool, items.cobalt_ingot.getItemStack())) || (isSimilar(ingot, items.cobalt_ingot.getItemStack()) && isSimilar(tool, items.ardite_ingot.getItemStack()))) {
					  e.setResult(items.manyullyn_ingot.getItemStack());
				  }
			  } else if(tool.getItemMeta().hasLore() && !ingot.getItemMeta().hasLore()) {
				  if(ingot.getType().equals(Material.NETHERITE_INGOT)) {
					  if(isSimilar(tool, items.diamond_hammer.getItemStack())) {
						  e.setResult(items.netherite_hammer.getItemStack());
						  
					  }
				  }
			  }
				  
		  }
	}
	
	public static boolean isSimilar(ItemStack is1,ItemStack is2) {
		if(is1.getType().equals(Material.PLAYER_WALL_HEAD)) is1.setType(Material.PLAYER_HEAD);
		if(is2.getType().equals(Material.PLAYER_WALL_HEAD)) is2.setType(Material.PLAYER_HEAD);
		if(Bukkit.getItemFactory().equals(is1.getItemMeta(), is2.getItemMeta()) && is1.getType().equals(is2.getType()))
			return true;
		return false;
	}
	
	public static boolean isCustomBlockSimilar(Material customBlockMaterial,MultipleFacing blockdata,Block block) {
		if(block.getType().equals(customBlockMaterial) && block.getBlockData().matches(blockdata))
			return true;
		return false;
	}
	
	public static final BlockFace[] faces = {
		    BlockFace.DOWN,
		    BlockFace.UP,
		    BlockFace.NORTH,
		    BlockFace.EAST,
		    BlockFace.SOUTH,
		    BlockFace.WEST
		};

	public static items getCustomItem(ItemStack is) {
		for(items i : items.values()) {
			if(isSimilar(i.getItemStack(),is))
				return i;
		}
		return null;
	}
	
	public static blocks getCustomBlock(ItemStack is) {
		for(blocks i : blocks.values()) {
			if(isSimilar(i.getItemStack(),is))
				return i;
		}
		return null;
	}
	
	public static blocks getCustomBlock(Block block) {
		for(blocks i : blocks.values()) {
			if(block.getBlockData() instanceof MultipleFacing) {
				MultipleFacing e = (MultipleFacing) block.getBlockData();
				for(BlockFace face : faces) {
					if(!e.getAllowedFaces().contains(face)) return null;
					e.setFace(face, i.getBlockFace(face));
					}
				if(isCustomBlockSimilar(i.getMaterial(),e,block))
					return i;
			}
		}
		return null;
	}
	
	@EventHandler
	public void customApple(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		ItemStack is = e.getItem();
    	if(Custom.isSimilar(items.diamond_apple.getItemStack(), is)) {
    		p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0));
    	} else if(Custom.isSimilar(items.enchanted_diamond_apple.getItemStack(), is)) {
    		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 24000, 0));
    		p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 1));
    	} else if(Custom.isSimilar(items.emerald_apple.getItemStack(), is)) {
    		p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 6000, 0));
    		p.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 12000, 2));
    	} else if(Custom.isSimilar(items.enchanted_emerald_apple.getItemStack(), is)) {
    		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 24000, 0));
    		p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 12000, 1));
    		p.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 30000, 5));
    	}
			
	}
	
	public static ItemMeta setItemShield(ItemMeta im,int amount) {
		im.getPersistentDataContainer().set(new NamespacedKey(main.getPlugin(main.class), "maxshield"), PersistentDataType.INTEGER, amount);
		return im;
	}
	
	public static int getItemShield(ItemMeta im) {
		return im.getPersistentDataContainer().get(new NamespacedKey(main.getPlugin(main.class), "maxshield"), PersistentDataType.INTEGER);
	}
	
	public static boolean hasItemShield(ItemMeta im) {
		return im.getPersistentDataContainer().has(new NamespacedKey(main.getPlugin(main.class), "maxshield"), PersistentDataType.INTEGER);
	}
	
	public static boolean hasShield(Player p) {
		return p.getPersistentDataContainer().has(new NamespacedKey(main.getPlugin(main.class), "shield"), PersistentDataType.FLOAT);
	}
	
	public static void setShield(Player p,float amount) {
		p.getPersistentDataContainer().set(new NamespacedKey(main.getPlugin(main.class), "shield"), PersistentDataType.FLOAT, amount);
	}
	
	public static float getShield(Player p) {
		return p.getPersistentDataContainer().get(new NamespacedKey(main.getPlugin(main.class), "shield"), PersistentDataType.FLOAT);
	}
	
	public static int getTotalShield(Player p) {
		int shieldpoint = 0;
		ItemStack mainHand = p.getInventory().getItemInMainHand();
		ItemStack offHand = p.getInventory().getItemInOffHand();
		for(ItemStack is : p.getInventory().getArmorContents()) {
			if(is != null)
			if(is.hasItemMeta()) {
				ItemMeta im = is.getItemMeta();
				if(hasItemShield(im))
					shieldpoint += getItemShield(im);
			}
		}
		if(mainHand != null)
		if(mainHand.hasItemMeta()) {
			ItemMeta im = mainHand.getItemMeta();
			if(hasItemShield(im))
				shieldpoint += getItemShield(im);
		}
		if(offHand != null)
		if(offHand.hasItemMeta()) {
			ItemMeta im = offHand.getItemMeta();
			if(hasItemShield(im))
				shieldpoint += getItemShield(im);
		}
		
		
		return shieldpoint;
	}
	
	static char blueHeart = '\uEff1';
	static char halfBlueHeart = '\uEff2';
	static char darkBlueHeart = '\uEff3';
	static char halfDarkBlueHeart = '\uEff4';
	static char voidHeart = '\uF828';
	static char halfVoidHeart = '\uF824';
	
	public static String actionShield(float shield, int totalShield) {
		StringBuilder builder = new StringBuilder("\uF80B\uF80A\uF802");
		int shieldint = Math.round(shield);
		for(int r = 0; r<20;) {
			if(shieldint >=r+2) {
				builder.append('\uF802');
				builder.append(blueHeart);
			}else if(shieldint == r+1) {
				if(totalShield >=r+2) {
					builder.append('\uF802');
					builder.append(darkBlueHeart);
					builder.append("\uF802\uF808");
				}
				builder.append('\uF802');
				builder.append(halfBlueHeart);
				builder.append(halfVoidHeart);
			}else {
				if(totalShield >=r+2) {
					builder.append("\uF802");
					builder.append(darkBlueHeart);
				}else if(totalShield == r+1) {
					builder.append("\uF802");
					builder.append(halfDarkBlueHeart);
					builder.append(halfVoidHeart);
				}else {
					builder.append(voidHeart);
				}
			}
			r += 2;
		}
		return builder.toString();
	}
	
}
