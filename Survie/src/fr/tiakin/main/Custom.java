package fr.tiakin.main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.HeightMap;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Jukebox;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R1.block.CraftBlockStates;
import org.bukkit.craftbukkit.v1_18_R1.block.data.CraftBlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.noise.SimplexNoiseGenerator;

import fr.tiakin.block.Blocks;
import fr.tiakin.item.Tool;
import fr.tiakin.mob.InfinityBoss;
import fr.tiakin.item.Discs;
import fr.tiakin.item.Foods;
import fr.tiakin.item.Items;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.block.state.IBlockData;

public class Custom implements Listener {
	
	static NamespacedKey key;
	static ShapedRecipe shapedrecipe;
	static ShapelessRecipe shapelessrecipe;
	static FurnaceRecipe furnacerecipe;
	static BlastingRecipe blastingrecipe;
	static SmithingRecipe smithingrecipe;
	static ArrayList<ArrayList<NamespacedKey>> recipe = new ArrayList<>(7);
	{
		for(int i=0; i < 8; i++) {
			recipe.add(new ArrayList<NamespacedKey>());
		}
	}
	// Recipe :
	
	public static void customrecipe() {
		other();
        Gold();
		Diamond();
		Emerald();
		Netherite();
        Enderite();
        Discordium();
        Blazite();
        Manyullyn();
        Chaos();
        Netherstar();
        Infinity();
	}
	
	private static void other() {
		//disc
		key = new NamespacedKey(Main.getPlugin(Main.class), "melo_disc");
		recipe.get(1).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.melo_disc.getItemStack());
        shapedrecipe.shape("MSM","SNS","MSM");
        shapedrecipe.setIngredient('M', new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        shapedrecipe.setIngredient('S', Material.END_STONE);
        shapedrecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "moonlight_disc");
		recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.moonlight_disc.getItemStack());
        shapedrecipe.shape("CIC","INI","CIC");
        shapedrecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        shapedrecipe.setIngredient('I', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        shapedrecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "ice_disc");
		recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.ice_disc.getItemStack());
        shapedrecipe.shape("DID","INI","DID");
        shapedrecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        shapedrecipe.setIngredient('I', Material.PACKED_ICE);
        shapedrecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "pillaged_disc");
		recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.pillaged_disc.getItemStack());
        shapedrecipe.shape("TET","ENE","TET");
        shapedrecipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        shapedrecipe.setIngredient('E', Material.EMERALD_BLOCK);
        shapedrecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "shulk_disc");
		recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.shulk_disc.getItemStack());
        shapedrecipe.shape("OSO","SNS","OSO");
        shapedrecipe.setIngredient('O', Material.OBSIDIAN);
        shapedrecipe.setIngredient('S', Material.SHULKER_SHELL);
        shapedrecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(shapedrecipe);
        
        //carrot
     	key = new NamespacedKey(Main.getPlugin(Main.class), "diamond_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.diamond_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I', Material.DIAMOND);
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "emerald_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.emerald_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I', Material.EMERALD);
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherite_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherite_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I', Material.NETHERITE_INGOT);
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enderite_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I',  new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I',  new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I',  new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I', Material.NETHER_STAR);
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_carrot");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_carrot.getItemStack());
        shapedrecipe.shape("III","ICI","III");
        shapedrecipe.setIngredient('I', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        shapedrecipe.setIngredient('C', Material.CARROT);
        Bukkit.addRecipe(shapedrecipe);
        
        //food
        key = new NamespacedKey(Main.getPlugin(Main.class), "uncooked_fries");
        recipe.get(0).add(key);
        shapelessrecipe = new ShapelessRecipe(key, Items.uncooked_fries.getItemStack());
        	shapelessrecipe.addIngredient(Material.POTATO);
        Bukkit.addRecipe(shapelessrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "cooked_fries");
        recipe.get(0).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.cooked_fries.getItemStack(),new RecipeChoice.ExactChoice(Items.uncooked_fries.getItemStack()),0f,200);
        Bukkit.addRecipe(furnacerecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "cotton_candy");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.cotton_candy.getItemStack());
        shapedrecipe.shape(" A","BC");
        shapedrecipe.setIngredient('A', Material.SUGAR);
        shapedrecipe.setIngredient('B', Material.STICK);
        shapedrecipe.setIngredient('C', Material.FLINT_AND_STEEL);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "baguette");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.baguette.getItemStack());
        shapedrecipe.shape("A  "," A ","  A");
        shapedrecipe.setIngredient('A', Material.WHEAT);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "hamburger");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.hamburger.getItemStack());
        shapedrecipe.shape("A","B","A");
        shapedrecipe.setIngredient('A', Material.BREAD);
        shapedrecipe.setIngredient('B', Material.COOKED_BEEF);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "cheese_burger");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.cheese_burger.getItemStack());
        shapedrecipe.shape("A ","CB","A ");
        shapedrecipe.setIngredient('A', Material.BREAD);
        shapedrecipe.setIngredient('B', Material.COOKED_BEEF);
        shapedrecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.cheese.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "bacon_cheese_burger");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.bacon_cheese_burger.getItemStack());
        shapedrecipe.shape("A ","CB","A ");
        shapedrecipe.setIngredient('A', Material.BREAD);
        shapedrecipe.setIngredient('B', Material.COOKED_PORKCHOP);
        shapedrecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.cheese.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "fish_and_chips");
      	recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.fish_and_chips.getItemStack());
        shapedrecipe.shape("A","B","C");
        shapedrecipe.setIngredient('A', new RecipeChoice.ExactChoice(Items.cooked_fries.getItemStack()));
        shapedrecipe.setIngredient('B', Material.CARROT);
        shapedrecipe.setIngredient('C', Material.COOKED_COD);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "cheese");
        recipe.get(0).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.cheese.getItemStack(),Material.MILK_BUCKET,0f,200);
        Bukkit.addRecipe(furnacerecipe);
	}

	private static void Gold() {
		//apple
		key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_golden_apple");
		recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.GOLD_BLOCK);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
	}
	
	private static void Diamond() {
		//hammer
		key = new NamespacedKey(Main.getPlugin(Main.class), "diamond_hammer");
		recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.diamond_hammer.getItemStack());
        shapedrecipe.shape("DBD","DSD"," S ");
        shapedrecipe.setIngredient('D', Material.DIAMOND);
        shapedrecipe.setIngredient('B', Material.DIAMOND_BLOCK);
        shapedrecipe.setIngredient('S',Material.STICK);
        Bukkit.addRecipe(shapedrecipe);
        
        //apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "diamond_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.diamond_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.DIAMOND);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_diamond_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_diamond_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.DIAMOND_BLOCK);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
	}
	
	private static void Emerald() {
		//apple
		key = new NamespacedKey(Main.getPlugin(Main.class), "emerald_apple");
		recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.emerald_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.EMERALD);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_emerald_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_emerald_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.EMERALD_BLOCK);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
	}
	
	private static void Netherite() {
		//hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherite_hammer");
        smithingrecipe = new SmithingRecipe(key, Items.netherite_hammer.getItemStack(), new RecipeChoice.ExactChoice(Items.diamond_hammer.getItemStack()), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        Bukkit.addRecipe(smithingrecipe);
	
        //apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherite_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherite_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(new ItemStack(Material.NETHERITE_INGOT)));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_netherite_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_netherite_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(new ItemStack(Material.NETHERITE_BLOCK)));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
	}
	
	private static void Enderite() {
		
		//apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enderite_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_enderite_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_enderite_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Blocks.enderite_block.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
		
		//base
		key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_scrap");
        recipe.get(1).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.enderite_scrap.getItemStack(),new RecipeChoice.ExactChoice(Blocks.enderite_ore.getItemStack()),7f,300);
        Bukkit.addRecipe(furnacerecipe);
        
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_enderite_scrap");
        recipe.get(1).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.enderite_scrap.getItemStack(),new RecipeChoice.ExactChoice(Blocks.enderite_ore.getItemStack()),7f,150);
        Bukkit.addRecipe(blastingrecipe);
		
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_ingot");
        recipe.get(1).add(key);
        shapelessrecipe = new ShapelessRecipe(key, Items.enderite_ingot.getItemStack());
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.enderite_scrap.getItemStack()));
        	shapelessrecipe.addIngredient(4,Material.DIAMOND);
        	shapelessrecipe.addIngredient(Material.ENDER_PEARL);
        Bukkit.addRecipe(shapelessrecipe);
        
        //block
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_block");
        recipe.get(1).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.enderite_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_ingot_from_block");
        recipe.get(1).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.enderite_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.enderite_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_sword");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_sword.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_pickaxe");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_pickaxe.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_PICKAXE), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_axe");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_axe.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_AXE), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_shovel");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_shovel.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_SHOVEL), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_hoe");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_hoe.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_HOE), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        //Hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_hammer");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_hammer.getItemStack(), new RecipeChoice.ExactChoice(Items.netherite_hammer.getItemStack()), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        //armor
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_helmet");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_helmet.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_chestplate");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_chestplate.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_leggings");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_leggings.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_LEGGINGS), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enderite_boots");
        smithingrecipe = new SmithingRecipe(key, Items.enderite_boots.getItemStack(), new RecipeChoice.MaterialChoice(Material.NETHERITE_BOOTS), new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
	
	}
	
	private static void Discordium() {
		
		//apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_discordium_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_discordium_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Blocks.discordium_block.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
		
		//base
		key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_chunk");
        recipe.get(2).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.discordium_chunk.getItemStack(),new RecipeChoice.ExactChoice(Blocks.discordium_ore.getItemStack()),5f,400);
        Bukkit.addRecipe(furnacerecipe);
		
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_ingot");
        recipe.get(2).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.discordium_ingot.getItemStack(),new RecipeChoice.ExactChoice(Items.discordium_chunk.getItemStack()),10f,400);
        Bukkit.addRecipe(furnacerecipe);
        
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_discordium_chunk");
        recipe.get(2).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.discordium_chunk.getItemStack(),new RecipeChoice.ExactChoice(Blocks.discordium_ore.getItemStack()),5f,200);
        Bukkit.addRecipe(blastingrecipe);
		
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_discordium_ingot");
        recipe.get(2).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.discordium_ingot.getItemStack(),new RecipeChoice.ExactChoice(Items.discordium_chunk.getItemStack()),10f,200);
        Bukkit.addRecipe(blastingrecipe);
        
        //block
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_block");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.discordium_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_ingot_from_block");
        recipe.get(2).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.discordium_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.discordium_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_sword");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_pickaxe");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_axe");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_shovel");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_hoe");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_hammer");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.discordium_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_helmet");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_chestplate");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_leggings");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "discordium_boots");
        recipe.get(2).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.discordium_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.enderite_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	private static void Blazite() {
		
		//apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_blazite_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_blazite_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Blocks.blazite_block.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
		
		//base
		key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_chunk");
        recipe.get(3).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.blazite_chunk.getItemStack(),new RecipeChoice.ExactChoice(Blocks.blazite_ore.getItemStack()),5f,400);
        Bukkit.addRecipe(furnacerecipe);
		
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_ingot");
        recipe.get(3).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.blazite_ingot.getItemStack(),new RecipeChoice.ExactChoice(Items.blazite_chunk.getItemStack()),10f,400);
        Bukkit.addRecipe(furnacerecipe);
        
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_blazite_chunk");
        recipe.get(3).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.blazite_chunk.getItemStack(),new RecipeChoice.ExactChoice(Blocks.blazite_ore.getItemStack()),5f,200);
        Bukkit.addRecipe(blastingrecipe);
		
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_blazite_ingot");
        recipe.get(3).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.blazite_ingot.getItemStack(),new RecipeChoice.ExactChoice(Items.blazite_chunk.getItemStack()),10f,200);
        Bukkit.addRecipe(blastingrecipe);
        
        //block
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_block");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.blazite_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_ingot_from_block");
        recipe.get(3).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.blazite_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.blazite_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_sword");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_pickaxe");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_axe");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_shovel");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_hoe");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_hammer");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.blazite_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_helmet");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_chestplate");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_leggings");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blazite_boots");
        recipe.get(3).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.blazite_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.discordium_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	private static void Manyullyn() {
		
		//apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_manyullyn_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_manyullyn_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Blocks.manyullyn_block.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
		
		//base
		key = new NamespacedKey(Main.getPlugin(Main.class), "cobalt_ingot");
        recipe.get(4).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.cobalt_ingot.getItemStack(),new RecipeChoice.ExactChoice(Blocks.cobalt_ore.getItemStack()),12f,600);
        Bukkit.addRecipe(furnacerecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "ardite_ingot");
        recipe.get(4).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.ardite_ingot.getItemStack(),new RecipeChoice.ExactChoice(Blocks.ardite_ore.getItemStack()),12f,600);
        Bukkit.addRecipe(furnacerecipe);
        
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_cobalt_ingot");
        recipe.get(4).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.cobalt_ingot.getItemStack(),new RecipeChoice.ExactChoice(Blocks.cobalt_ore.getItemStack()),12f,300);
        Bukkit.addRecipe(blastingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_ardite_ingot");
        recipe.get(4).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.ardite_ingot.getItemStack(),new RecipeChoice.ExactChoice(Blocks.ardite_ore.getItemStack()),12f,300);
        Bukkit.addRecipe(blastingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_ingot_from_cobalt");
        smithingrecipe = new SmithingRecipe(key, Items.manyullyn_ingot.getItemStack(), new RecipeChoice.ExactChoice(Items.cobalt_ingot.getItemStack()), new RecipeChoice.ExactChoice(Items.ardite_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_ingot_from_ardite");
        smithingrecipe = new SmithingRecipe(key, Items.manyullyn_ingot.getItemStack(), new RecipeChoice.ExactChoice(Items.ardite_ingot.getItemStack()), new RecipeChoice.ExactChoice(Items.cobalt_ingot.getItemStack()));
        Bukkit.addRecipe(smithingrecipe);
        
        //block
        key = new NamespacedKey(Main.getPlugin(Main.class), "cobalt_block");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.cobalt_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.cobalt_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "cobalt_ingot_from_block");
        recipe.get(4).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.cobalt_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.cobalt_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "ardite_block");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.ardite_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.ardite_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "ardite_ingot_from_block");
        recipe.get(4).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.ardite_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.ardite_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_block");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.manyullyn_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_ingot_from_block");
        recipe.get(4).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.manyullyn_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.manyullyn_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_sword");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_pickaxe");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_axe");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_shovel");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_hoe");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_hammer");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.manyullyn_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_helmet");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_chestplate");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_leggings");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "manyullyn_boots");
        recipe.get(4).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.manyullyn_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.blazite_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	private static void Chaos() {
		
		//apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_chaos_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_chaos_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Blocks.chaos_block.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
		
		//log
		key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_planks");
        recipe.get(5).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Blocks.chaos_planks.getItemStack(),4));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.chaos_log.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
		
		//base
		key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_chunk");
        recipe.get(5).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.chaos_chunk.getItemStack(),new RecipeChoice.ExactChoice(Blocks.chaos_ore.getItemStack()),12f,800);
        Bukkit.addRecipe(furnacerecipe);
		
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_ingot");
        recipe.get(5).add(key);
        furnacerecipe = new FurnaceRecipe(key,Items.chaos_ingot.getItemStack(),new RecipeChoice.ExactChoice(Items.chaos_chunk.getItemStack()),24f,800);
        Bukkit.addRecipe(furnacerecipe);
        
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_chaos_chunk");
        recipe.get(5).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.chaos_chunk.getItemStack(),new RecipeChoice.ExactChoice(Blocks.chaos_ore.getItemStack()),12f,400);
        Bukkit.addRecipe(blastingrecipe);
		
        key = new NamespacedKey(Main.getPlugin(Main.class), "blasting_chaos_ingot");
        recipe.get(5).add(key);
        blastingrecipe = new BlastingRecipe(key,Items.chaos_ingot.getItemStack(),new RecipeChoice.ExactChoice(Items.chaos_chunk.getItemStack()),24f,400);
        Bukkit.addRecipe(blastingrecipe);
        
        //block
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_block");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.chaos_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_ingot_from_block");
        recipe.get(5).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.chaos_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.chaos_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_sword");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_sword.getItemStack());
        	shapedrecipe.shape("D","D","E");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_pickaxe");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_pickaxe.getItemStack());
        	shapedrecipe.shape("DDD"," E "," D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_axe");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_axe.getItemStack());
        	shapedrecipe.shape("DD","ED","D ");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_shovel");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_shovel.getItemStack());
        	shapedrecipe.shape("D","E","D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_hoe");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_hammer");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_hammer.getItemStack());
        	shapedrecipe.shape("DBD","DED"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.chaos_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_helmet");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_helmet.getItemStack());
        	shapedrecipe.shape("DDD","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_chestplate");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_leggings");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_leggings.getItemStack());
        	shapedrecipe.shape("DDD","DED","D D");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "chaos_boots");
        recipe.get(5).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.chaos_boots.getItemStack());
        	shapedrecipe.shape("D D","DED");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.manyullyn_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}

	private static void Netherstar() {
        
		//apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', Material.NETHER_STAR);
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_netherstar_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_netherstar_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
		
        //block
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_block");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.netherstar_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_ingot_from_block");
        recipe.get(6).add(key);
        shapelessrecipe = new ShapelessRecipe(key,new ItemStack(Material.NETHER_STAR,9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        
        //Tool
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_sword");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_sword.getItemStack());
        	shapedrecipe.shape("B","B","E");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_pickaxe");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_pickaxe.getItemStack());
        	shapedrecipe.shape("BBB"," E "," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_axe");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_axe.getItemStack());
        	shapedrecipe.shape("BB","EB","D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_shovel");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_shovel.getItemStack());
        	shapedrecipe.shape("D","E","B");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_hoe");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_hoe.getItemStack());
        	shapedrecipe.shape("BB"," E"," D");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_hammer");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_hammer.getItemStack());
        	shapedrecipe.shape("BDB","BEB"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_helmet");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_helmet.getItemStack());
        	shapedrecipe.shape("BDB","DED");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_chestplate");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","BDB");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_leggings");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_leggings.getItemStack());
        	shapedrecipe.shape("BDB","DED","D D");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "netherstar_boots");
        recipe.get(6).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.netherstar_boots.getItemStack());
        	shapedrecipe.shape("D D","BEB");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.netherstar_block.getItemStack()));
        	shapedrecipe.setIngredient('D', Material.NETHER_STAR);
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.chaos_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	private static void Infinity() {
		
		//apple
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "enchanted_infinity_apple");
        recipe.get(0).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.enchanted_infinity_apple.getItemStack());
        shapedrecipe.shape("GGG","GAG","GGG");
        shapedrecipe.setIngredient('G', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        shapedrecipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(shapedrecipe);
		
		//base
		key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_egg");
        recipe.get(7).add(key);
        shapelessrecipe = new ShapelessRecipe(key,Items.infinity_egg.getItemStack());
        
        shapelessrecipe.addIngredient(Material.NETHERITE_INGOT);
        shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.enderite_ingot.getItemStack()));
        shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.discordium_ingot.getItemStack()));
        shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.blazite_ingot.getItemStack()));
        shapelessrecipe.addIngredient(Material.DIAMOND_BLOCK);
        shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.cobalt_ingot.getItemStack()));
        shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.ardite_ingot.getItemStack()));
        shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.manyullyn_ingot.getItemStack()));
        shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Items.chaos_ingot.getItemStack()));
        
        Bukkit.addRecipe(shapelessrecipe);
		
		
		key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_ingot");
	    smithingrecipe = new SmithingRecipe(key, Items.infinity_ingot.getItemStack(), new RecipeChoice.ExactChoice(Items.infinity_catalyst.getItemStack()), new RecipeChoice.MaterialChoice(Material.NETHER_STAR));
	    Bukkit.addRecipe(smithingrecipe);
        
        //block
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_block");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Blocks.infinity_block.getItemStack());
        	shapedrecipe.shape("DDD","DDD","DDD");
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_ingot_from_block");
        recipe.get(7).add(key);
        shapelessrecipe = new ShapelessRecipe(key, multi(Items.infinity_ingot.getItemStack(),9));
        	shapelessrecipe.addIngredient(new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        Bukkit.addRecipe(shapelessrecipe);
        
        //Tool
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_sword");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_sword.getItemStack());
        	shapedrecipe.shape("B","B","E");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_sword.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_pickaxe");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_pickaxe.getItemStack());
        	shapedrecipe.shape("BBB"," E "," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_pickaxe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_axe");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_axe.getItemStack());
        	shapedrecipe.shape("BB","EB","D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_axe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_shovel");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_shovel.getItemStack());
        	shapedrecipe.shape("B","E","B");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_shovel.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_hoe");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_hoe.getItemStack());
        	shapedrecipe.shape("DD"," E"," B");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_hoe.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        //hammer
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_hammer");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_hammer.getItemStack());
        	shapedrecipe.shape("BDB","BEB"," D ");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_hammer.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        //armor
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_helmet");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_helmet.getItemStack());
        	shapedrecipe.shape("BDB","DED");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_helmet.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_chestplate");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_chestplate.getItemStack());
        	shapedrecipe.shape("DED","DDD","BDB");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_chestplate.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_leggings");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_leggings.getItemStack());
        	shapedrecipe.shape("BDB","DED","D D");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_leggings.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
        key = new NamespacedKey(Main.getPlugin(Main.class), "infinity_boots");
        recipe.get(7).add(key);
        shapedrecipe = new ShapedRecipe(key,Items.infinity_boots.getItemStack());
        	shapedrecipe.shape("D D","BEB");
        	shapedrecipe.setIngredient('B', new RecipeChoice.ExactChoice(Blocks.infinity_block.getItemStack()));
        	shapedrecipe.setIngredient('D', new RecipeChoice.ExactChoice(Items.infinity_ingot.getItemStack()));
        	shapedrecipe.setIngredient('E', new RecipeChoice.ExactChoice(Items.netherstar_boots.getItemStack()));
        Bukkit.addRecipe(shapedrecipe);
        
	}
	
	public static ItemStack multi(ItemStack itemStack,int amount) {
		ItemStack is = itemStack.clone();
		is.setAmount(amount);
		return is;
	}
	
	public static void discoverrecipe(Player p) {
		//add recipe for player
		p.discoverRecipes(recipe.get(0));
		AdvancementProgress progress = p.getAdvancementProgress(Bukkit.getAdvancement(new NamespacedKey(Main.getPlugin(Main.class), "miningroot")));
		if(progress.isDone())
			p.discoverRecipes(recipe.get(1));
		 progress = p.getAdvancementProgress(Bukkit.getAdvancement(new NamespacedKey(Main.getPlugin(Main.class), "mining1")));
		if(progress.isDone())
			p.discoverRecipes(recipe.get(2));
		 progress = p.getAdvancementProgress(Bukkit.getAdvancement(new NamespacedKey(Main.getPlugin(Main.class), "mining2")));
		if(progress.isDone())
			p.discoverRecipes(recipe.get(3));
		 progress = p.getAdvancementProgress(Bukkit.getAdvancement(new NamespacedKey(Main.getPlugin(Main.class), "mining3")));
		if(progress.isDone())
			p.discoverRecipes(recipe.get(4));
		 progress = p.getAdvancementProgress(Bukkit.getAdvancement(new NamespacedKey(Main.getPlugin(Main.class), "mining4")));
		if(progress.isDone())
			p.discoverRecipes(recipe.get(5));
		 progress = p.getAdvancementProgress(Bukkit.getAdvancement(new NamespacedKey(Main.getPlugin(Main.class), "mining5")));
		if(progress.isDone()) {
			p.discoverRecipes(recipe.get(6));
			progress = p.getAdvancementProgress(Bukkit.getAdvancement(NamespacedKey.minecraft("nether/summon_wither")));
			if(progress.isDone())
				p.discoverRecipes(recipe.get(7));
		}

		
	}
	@EventHandler
	public void spawn(CreatureSpawnEvent e) {
		if(e.getSpawnReason() == SpawnReason.SPAWNER_EGG) {
			if(e.getEntityType().equals(EntityType.ENDERMITE)) {
				Bukkit.getScheduler().runTask(JavaPlugin.getPlugin(Main.class), () -> e.getEntity().remove());
				InfinityBoss.spawn(e.getLocation());
			}
		}
	}
	@EventHandler
	public void craft(PrepareItemCraftEvent e) {
		ItemStack[] itemStacks = e.getInventory().getMatrix();
		Map<Enchantment, Integer> ench = null;
		boolean customresult = false;
		boolean antidupli = false;
		if(itemStacks.length == 9) {
			for(int i=0;i<itemStacks.length;i++) {
				Items item = getCustomItem(itemStacks[i]);
				if(itemStacks[i] != null) {
					if(itemStacks[i].hasItemMeta() && itemStacks[i].getItemMeta().hasEnchants()) {
						ench = itemStacks[i].getItemMeta().getEnchants();
						antidupli = true;
					}
				}
				
				if(item != null) {
					itemStacks[i] = item.getItemStack().clone();
					customresult = true;
				}
				
			}
			if(antidupli) {
				ItemStack[] ISS = e.getInventory().getContents();
				for(int i=0;i<ISS.length;i++) {
					if((ISS[i] != null) && (ISS[i].getAmount() > 1)) {
						e.getInventory().setResult(null);
						
						return;
					}
				}	
			}
			
			Recipe r = Bukkit.getCraftingRecipe(itemStacks, e.getViewers().get(0).getWorld());
			
			if(r != null && customresult) {
				ItemStack is = r.getResult().clone();
				if(ench != null)
					is.addEnchantments(ench);
				e.getInventory().setResult(is);
			}
		}
	}
	
	
	@EventHandler
	public void smith(PrepareSmithingEvent e) {
		  ItemStack tool = e.getInventory().getItem(0);
		  ItemStack ingot = e.getInventory().getItem(1);
		  ItemStack result = null;
		  if(tool !=null && ingot != null) {
			  if(!tool.getItemMeta().hasLore() && ingot.getItemMeta().hasLore()) {
				  if(isSimilar(ingot,Items.enderite_ingot.getItemStack())) {
					  
					  if(tool.getType().equals(Material.NETHERITE_SWORD)) {
						  result = Items.enderite_sword.getItemStack().clone();
					  } else if(tool.getType().equals(Material.NETHERITE_PICKAXE)) {
						  result = Items.enderite_pickaxe.getItemStack().clone();
						  
					  } else if(tool.getType().equals(Material.NETHERITE_AXE)) {
						  result = Items.enderite_axe.getItemStack().clone();
						  
					  } else if(tool.getType().equals(Material.NETHERITE_SHOVEL)) {
						  result = Items.enderite_shovel.getItemStack().clone();
						  
					  } else if(tool.getType().equals(Material.NETHERITE_HOE)) {
						  result = Items.enderite_hoe.getItemStack().clone();
						  
					  } else if(tool.getType().equals(Material.NETHERITE_HELMET)) {
						  result = Items.enderite_helmet.getItemStack().clone();
						  
					  } else if(tool.getType().equals(Material.NETHERITE_CHESTPLATE)) {
						  result = Items.enderite_chestplate.getItemStack().clone();
						  
					  } else if(tool.getType().equals(Material.NETHERITE_LEGGINGS)) {
						  result = Items.enderite_leggings.getItemStack().clone();
						  
					  } else if(tool.getType().equals(Material.NETHERITE_BOOTS)) {
						  result = Items.enderite_boots.getItemStack().clone();
						  
					  }
				  }
			  }else if(tool.getItemMeta().hasLore() && ingot.getItemMeta().hasLore()) {
				  if(isSimilar(ingot,Items.enderite_ingot.getItemStack())) {
					  if(isSimilar(tool, Items.netherite_hammer.getItemStack())) {
						  result = Items.enderite_hammer.getItemStack().clone();
					  }
				  }else if((isSimilar(ingot, Items.ardite_ingot.getItemStack()) && isSimilar(tool, Items.cobalt_ingot.getItemStack())) || (isSimilar(ingot, Items.cobalt_ingot.getItemStack()) && isSimilar(tool, Items.ardite_ingot.getItemStack()))) {
					  result = Items.manyullyn_ingot.getItemStack().clone();
				  }
			  } else if(tool.getItemMeta().hasLore() && !ingot.getItemMeta().hasLore()) {
				  if(ingot.getType().equals(Material.NETHERITE_INGOT)) {
					  if(isSimilar(tool, Items.diamond_hammer.getItemStack())) {
						  result = Items.netherite_hammer.getItemStack().clone();
					  }
				  }else if(ingot.getType().equals(Material.NETHER_STAR)) {
					  if(isSimilar(tool, Items.infinity_catalyst.getItemStack())) {
						  result = Items.infinity_ingot.getItemStack().clone();
					  }
				  }
			  }
			 if(result != null) {
				 if(tool.hasItemMeta() && tool.getItemMeta().hasEnchants())
					 result.addEnchantments(tool.getItemMeta().getEnchants());
			  	e.setResult(result);
			 }
		  }
	}
	
	
	// Compare :
	
	public static boolean isSimilar(ItemStack is1,ItemStack is2) {
		if(is1 != null && is2 != null) {
			if(is1.getType().equals(Material.PLAYER_WALL_HEAD)) is1.setType(Material.PLAYER_HEAD);
			if(is2.getType().equals(Material.PLAYER_WALL_HEAD)) is2.setType(Material.PLAYER_HEAD);
			if(is1.getType().equals(is2.getType())) {
				if(!is1.hasItemMeta() && !is2.hasItemMeta()) {
					return true;
				}else if(is1.hasItemMeta() && is2.hasItemMeta()) {
					if(is1.getItemMeta().hasLore() && is2.getItemMeta().hasLore())
						if(is1.getItemMeta().getLore().equals(is2.getItemMeta().getLore()))
							return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isCustomBlockSimilar(Material customBlockMaterial,MultipleFacing blockdata,Block block) {
		if(block.getType().equals(customBlockMaterial) && block.getBlockData().matches(blockdata))
			return true;
		return false;
	}
	
	
	// Getters :
	
	public static final BlockFace[] faces = {
		    BlockFace.DOWN,
		    BlockFace.UP,
		    BlockFace.NORTH,
		    BlockFace.EAST,
		    BlockFace.SOUTH,
		    BlockFace.WEST
		};
	
	public static Discs getCustomDisc(ItemStack is) {
		for(Discs i : Discs.values()) {
			if(isSimilar(i.getItem().getItemStack(),is))
				return i;
		}
		return null;
	}
	
	public static Foods getCustomFood(ItemStack is) {
		for(Foods i : Foods.values()) {
			if(isSimilar(i.getItem().getItemStack(),is))
				return i;
		}
		return null;
	}
	
	public static Items getCustomItem(ItemStack is) {
		for(Items i : Items.values()) {
			if(isSimilar(i.getItemStack(),is))
				return i;
		}
		return null;
	}
	
	public static Blocks getCustomBlock(ItemStack is) {
		for(Blocks i : Blocks.values()) {
			if(isSimilar(i.getItemStack(),is))
				return i;
		}
		return null;
	}
	
	public static Blocks getCustomBlock(Block block) {
		for(Blocks i : Blocks.values()) {
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
	
	public static Block gethighestendstone(World world,int x,int z) {
		int ymax = world.getHighestBlockYAt(x, z, HeightMap.OCEAN_FLOOR_WG);
		if(ymax == -1) return null;
		
		for (int y = ymax; y >= 0; y--) {
			Block block = world.getBlockAt(x, y, z);
			Blocks b = getCustomBlock(block);
			if(block.getType().equals(Material.END_STONE) || (b != null && b.equals(Blocks.chaos_nylium)))
				return block;
		}
		
		return null;
	}
	
	public static IBlockData createCustomBlock(Blocks b) {
		
		
		BlockState state = CraftBlockStates.getBlockState(b.getMaterial(), null);
		MultipleFacing e = (MultipleFacing) state.getBlockData();
		for(BlockFace face : faces) {
			if(!e.getAllowedFaces().contains(face)) return null;
			e.setFace(face, b.getBlockFace(face));
			}
		state.setBlockData(e);
		return CraftBlockData.newData(null, state.getBlockData().getAsString()).getState();
	}
	
	
	// EventHandler :
	
	@EventHandler
	public void customFood(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		ItemStack is = e.getItem();
		Foods f = getCustomFood(is);
		if(f != null) {
			p.addPotionEffects(f.getEffets());
		}	
	}

	@EventHandler
	public void itemDamage(PlayerItemDamageEvent e) {
		ItemStack is = e.getItem();
    	int max = Tool.getOrder(Tool.getTier(is))-5;
    	if(max <1)
    		max = 1;
    	if(Tool.isHammer(is))
    		max *= (Tool.getHammerRadius(is)*2+1)*(Tool.getHammerRadius(is)*2+1);
    	if(max > 1) {
    		int rand = new Random().nextInt(max);
    		if(rand != 0)
    			e.setDamage(0);
    	}
			
	}
	
	@EventHandler
	public void customdisc(PlayerInteractEvent e) {
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(e.getPlayer().isSneaking() && e.getPlayer().getInventory().getItemInMainHand().getType().isBlock()) return;
		if(e.hasBlock()) {
			Block b = e.getClickedBlock();
			b.getState();
			if(b.getType().equals(Material.JUKEBOX)) {
				Player p = e.getPlayer();
				ItemStack item = p.getInventory().getItemInMainHand();
				Jukebox jb = (Jukebox) b.getState();
				if(jb.getRecord().getType().equals(Material.AIR)) {
					
					Discs disc = getCustomDisc(item);
					if(disc != null) {
						Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(Main.class), () -> jb.stopPlaying(),2l);
						jb.getWorld().playSound(jb.getLocation(), disc.getSound() ,SoundCategory.RECORDS, 3.0F, 1F);
					}
				} else {
					for(Entity ent : jb.getWorld().getNearbyEntities(jb.getLocation(), 75, 50, 75)) {
						if (ent instanceof Player all ) {
							Discs disc = getCustomDisc(jb.getRecord());
							if(disc != null) {
								all.stopSound(disc.getSound(),SoundCategory.RECORDS);
							}
						}
					}
				}
			}
		}
	}
	

	// Shield :
	
	public static ItemMeta setItemShield(ItemMeta im,int amount) {
		im.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "maxshield"), PersistentDataType.INTEGER, amount);
		return im;
	}
	
	public static int getItemShield(ItemMeta im) {
		return im.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "maxshield"), PersistentDataType.INTEGER);
	}
	
	public static boolean hasItemShield(ItemMeta im) {
		return im.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "maxshield"), PersistentDataType.INTEGER);
	}
	
	public static boolean hasShield(Player p) {
		return p.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "shield"), PersistentDataType.FLOAT);
	}
	
	public static void setShield(Player p,float amount) {
		p.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "shield"), PersistentDataType.FLOAT, amount);
	}
	
	public static float getShield(Player p) {
		return p.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "shield"), PersistentDataType.FLOAT);
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
	
	static char greenHeart = '\uEff5';
	static char halfGreenHeart = '\uEff6';
	static char darkGreenHeart = '\uEff7';
	static char halfDarkGreenHeart = '\uEff8';
	
	static char voidHeart = '\uF828';
	static char halfVoidHeart = '\uF824';
	
	public static String actionShield(float shield, int totalShield) {
		StringBuilder builder = new StringBuilder("\uF80B\uF80A\uF802");
		
		char frontShield = blueHeart;
		char halfFrontShield = halfBlueHeart;
		char backShield = darkBlueHeart;
		char halfBackShield = halfDarkBlueHeart;
		
		char backgroundShield = '0';
		
		
		
		int shieldint = Math.round(shield);
		if(shieldint > 20) {
			
			shieldint -=20;
			totalShield -=20;
			
			
			frontShield = greenHeart;
			halfFrontShield = halfGreenHeart;
			backShield = darkGreenHeart;
			halfBackShield = halfDarkGreenHeart;
			
			backgroundShield = blueHeart;
			
		}
		for(int r = 0; r<20;) {
			if(shieldint >=r+2) {
				builder.append('\uF802'); // decalage d'un pixels de coeur vers la gauche (-2px)
				builder.append(frontShield);
			}else if(shieldint == r+1) {
				if(totalShield >=r+2) {
					builder.append('\uF802');
					builder.append(backShield);
					builder.append("\uF808"); // decalage d'un coeur vers la gauche (-8px)
				}else if(backgroundShield != '0') {
					builder.append("\uF802");
					builder.append(backgroundShield);
					builder.append("\uF808");
				}
				builder.append('\uF802');
				builder.append(halfFrontShield);
				builder.append(halfVoidHeart);
			}else {
				if(totalShield >=r+2) {
					builder.append("\uF802");
					builder.append(backShield);
				}else if(totalShield == r+1) {
					if(backgroundShield != '0') {
						builder.append('\uF802');
						builder.append(backgroundShield);
						builder.append("\uF808");
					}
					builder.append("\uF802");
					builder.append(halfBackShield);
					builder.append(halfVoidHeart);
				}else {
					if(backgroundShield != '0') {
						builder.append("\uF802");
						builder.append(backgroundShield);
					} else { 
						builder.append(voidHeart);
					}
				}
			}
			r += 2;
		}
		return builder.toString();
	}
	
	public static boolean materialsWhitelist(Material m) {
		return switch(m) {
		case STONE,BASALT,BLACKSTONE,TUFF,DEEPSLATE,ANDESITE,DIORITE,GRANITE,DIRT,GRAVEL,NETHERRACK,END_STONE -> true;
		default ->  false;
		};
	}

	public static void generateOre(World world, Chunk chunk, Random random, IBlockData iBlockData, int minY, int maxY,int chance, int tries,int luck, int maxVein,boolean centered,boolean bypassWhitelist) {
		int X, Y, Z, vein = 0;
		boolean Whitelisted;
		for (int i = 1; i <= tries ; i++) {
		    if (random.nextInt(chance) == 0) {
		    	X = centered ? chunk.getX()*16 : random.nextInt(16) + chunk.getX()*16;
		    	Z = centered ? chunk.getZ()*16 : random.nextInt(16) + chunk.getZ()*16;
		    	Y = random.nextInt(maxY-minY)+minY;
		    	if (materialsWhitelist(world.getBlockAt(X, Y, Z).getType()) || bypassWhitelist) {
		    		Whitelisted = true;
		    		while (Whitelisted) {
		    			vein++;
		    			BlockPosition bp = new BlockPosition(X,Y,Z);
						((CraftWorld) world).getHandle().l(bp).a(bp, iBlockData, true);
		    			if (random.nextInt(luck) == 0 && vein <= maxVein)  {
		    				switch (random.nextInt(6)) {
								case 0 -> X++;
								case 1 -> Y++;
								case 2 -> Z++;
								case 3 -> X--;
								case 4 -> Y--;
								case 5 -> Z--;
		    				}
		    			Whitelisted = materialsWhitelist(world.getBlockAt(X, Y, Z).getType()) || bypassWhitelist;
		    			} 
		    			else Whitelisted = false;
		    		}
		    	}
		    }
		}
	}
    public static double noise(SimplexNoiseGenerator noise,int x, int y) {
		return noise.noise(x, y, 9, 0.5, 5);
    	
    }

	public static boolean explosionProtect(ItemStack is) {
		int order = Tool.getOrder(is);
		if(order >= 13) {
			return true;
		}
		if(Custom.isSimilar(is,Blocks.infinity_block.getItemStack()))
			return true;
		return switch(Custom.getCustomItem(is)) {
		case infinity_apple,enchanted_infinity_apple,infinity_carrot,infinity_egg,infinity_catalyst,infinity_ingot -> true;
		default -> false;
		};
	}
}
