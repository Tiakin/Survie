package fr.tiakin.item;

import java.util.Arrays;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.tiakin.main.Custom;

public enum Items {
	
	//food
	
	uncooked_fries(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Uncooked Fries");
			im.setLore(Arrays.asList("Uncooked Fries"));
			this.setItemMeta(im);
		}
	}),
	cooked_fries(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Cooked Fries");
			im.setLore(Arrays.asList("Cooked Fries"));
			this.setItemMeta(im);
		}
	}),
	chocolate_caramel_fudge(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chocolate Caramel Fudge");
			im.setLore(Arrays.asList("Chocolate Caramel Fudge"));
			this.setItemMeta(im);
		}
	}),
	cotton_candy(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Cotton Candy");
			im.setLore(Arrays.asList("Cotton Candy"));
			this.setItemMeta(im);
		}
	}),
	baguette(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Baguette");
			im.setLore(Arrays.asList("Baguette"));
			this.setItemMeta(im);
		}
	}),
	hamburger(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Hamburger");
			im.setLore(Arrays.asList("Hamburger"));
			this.setItemMeta(im);
		}
	}),
	cheese_burger(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Cheese Burger");
			im.setLore(Arrays.asList("Cheese Burger"));
			this.setItemMeta(im);
		}
	}),
	bacon_cheese_burger(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Bacon Cheese Burger");
			im.setLore(Arrays.asList("Bacon Cheese Burger"));
			this.setItemMeta(im);
		}
	}),
	fish_and_chips(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Fish & Chips");
			im.setLore(Arrays.asList("Fish & Chips"));
			this.setItemMeta(im);
		}
	}),
	cheese(new ItemStack(Material.APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Cheese");
			im.setLore(Arrays.asList("Cheese"));
			this.setItemMeta(im);
		}
	}),
	
	//disc
	melo_disc(new ItemStack(Material.MUSIC_DISC_PIGSTEP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+""+ChatColor.AQUA+"Music Disc");
			im.setLore(Arrays.asList(ChatColor.GRAY+"Melo Coton - PARTOUZE ANALE"));
			im.addItemFlags(ItemFlag.values());
			this.setItemMeta(im);
		}
	}),
	moonlight_disc(new ItemStack(Material.MUSIC_DISC_PIGSTEP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+""+ChatColor.AQUA+"Music Disc");
			im.setLore(Arrays.asList(ChatColor.GRAY+"XXXTENTACION - MOONLIGHT"));
			im.addItemFlags(ItemFlag.values());
			this.setItemMeta(im);
		}
	}),
	ice_disc(new ItemStack(Material.MUSIC_DISC_PIGSTEP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+""+ChatColor.AQUA+"Music Disc");
			im.setLore(Arrays.asList(ChatColor.GRAY+"Pikpik36 - Ice"));
			im.addItemFlags(ItemFlag.values());
			this.setItemMeta(im);
		}
	}),
	pillaged_disc(new ItemStack(Material.MUSIC_DISC_PIGSTEP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+""+ChatColor.AQUA+"Music Disc");
			im.setLore(Arrays.asList(ChatColor.GRAY+"JamiesName - Pillaged"));
			im.addItemFlags(ItemFlag.values());
			this.setItemMeta(im);
		}
	}),
	shulk_disc(new ItemStack(Material.MUSIC_DISC_PIGSTEP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+""+ChatColor.AQUA+"Music Disc");
			im.setLore(Arrays.asList(ChatColor.GRAY+"JamiesName - Shulk"));
			im.addItemFlags(ItemFlag.values());
			this.setItemMeta(im);
		}
	}),
	
	//food
	
	
	//diamant
	
	//apple
	diamond_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Diamond Apple");
			im.setLore(Arrays.asList("Diamond Apple! Shiny"));
			this.setItemMeta(im);
		}
	}),
	enchanted_diamond_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Diamond Apple");
			im.setLore(Arrays.asList("Enchanted Diamond Apple???"));
			this.setItemMeta(im);
		}
	}),
	
	
	//carrot
	diamond_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Diamond Carrot");
			im.setLore(Arrays.asList("Diamond Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//hammer
	diamond_hammer(new ItemStack(Material.DIAMOND_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Diamond Hammer");
			im.setLore(Arrays.asList("Diamond Hammer"));
			this.setItemMeta(im);
		}
	}),
	
	//emeraude
	
	//apple
	emerald_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Emerald Apple");
			im.setLore(Arrays.asList("Emerald Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_emerald_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Emerald Apple");
			im.setLore(Arrays.asList("Enchanted Emerald Apple"));
			this.setItemMeta(im);
		}
	}),
	
	
	//carrot
	emerald_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Emerald Carrot");
			im.setLore(Arrays.asList("Emerald Carrot"));
			this.setItemMeta(im);
		}
	}),
		
		
	//netherite
	
	//apple
	netherite_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherite Apple");
			im.setLore(Arrays.asList("Netherite Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_netherite_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Netherite Apple");
			im.setLore(Arrays.asList("Enchanted Netherite Apple"));
			this.setItemMeta(im);
		}
	}),
	
	//carrot
	netherite_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherite Carrot");
			im.setLore(Arrays.asList("Netherite Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//hammer
	netherite_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherite Hammer");
			im.setLore(Arrays.asList("Netherite Hammer"));
			this.setItemMeta(im);
		}
	}),
	
	//enderite
	
	//apple
	enderite_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Apple");
			im.setLore(Arrays.asList("Enderite Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_enderite_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Enderite Apple");
			im.setLore(Arrays.asList("Enchanted Enderite Apple"));
			this.setItemMeta(im);
		}
	}),
		
	//carrot
	enderite_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Carrot");
			im.setLore(Arrays.asList("Enderite Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//base
	enderite_scrap(new ItemStack(Material.NETHERITE_SCRAP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Scrap");
			im.setLore(Arrays.asList("Enderite Scrap"));
			this.setItemMeta(im);
		}
	}),
	enderite_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Ingot");
			im.setLore(Arrays.asList("Enderite Ingot"));
			this.setItemMeta(im);
		}
	}),
	
	//outils
	enderite_sword(new ItemStack(Material.NETHERITE_SWORD) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Sword");
			im.setLore(Arrays.asList("Enderite Sword"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 8, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	enderite_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Pickaxe");
			im.setLore(Arrays.asList("Enderite Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 6, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	enderite_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Axe");
			im.setLore(Arrays.asList("Enderite Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 10, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	enderite_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Shovel");
			im.setLore(Arrays.asList("Enderite Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 6.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", shovel_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	enderite_hoe(new ItemStack(Material.NETHERITE_HOE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Hoe");
			im.setLore(Arrays.asList("Enderite Hoe"));
			this.setItemMeta(im);
		}
	}),
	//hammer
	enderite_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Hammer");
			im.setLore(Arrays.asList("Enderite Hammer"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 6, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	
	
	//armure
	enderite_helmet(new ItemStack(Material.NETHERITE_HELMET) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Helmet");
			im.setLore(Arrays.asList("Enderite Helmet"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 3.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 3.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			this.setItemMeta(im);
		}
	}),
	enderite_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Chestplate");
			im.setLore(Arrays.asList("Enderite Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 8.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 3.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			this.setItemMeta(im);
		}
	}),
	enderite_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Leggings");
			im.setLore(Arrays.asList("Enderite Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 6.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 3.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			this.setItemMeta(im);
		}
	}),
	enderite_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enderite Boots");
			im.setLore(Arrays.asList("Enderite Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 3.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 3.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			this.setItemMeta(im);
		}
	}),
	
	//discordium
	
	//apple
	discordium_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Apple");
			im.setLore(Arrays.asList("Discordium Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_discordium_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Discordium Apple");
			im.setLore(Arrays.asList("Enchanted Discordium Apple"));
			this.setItemMeta(im);
		}
	}),
	
	//carrot
	discordium_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Carrot");
			im.setLore(Arrays.asList("Discordium Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//base
	discordium_chunk(new ItemStack(Material.NETHERITE_SCRAP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Chunk");
			im.setLore(Arrays.asList("Discordium Chunk"));
			this.setItemMeta(im);
		}
	}),
	discordium_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Ingot");
			im.setLore(Arrays.asList("Discordium Ingot"));
			this.setItemMeta(im);
		}
	}),
	
	//outils
	discordium_sword(new ItemStack(Material.NETHERITE_SWORD) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Sword");
			im.setLore(Arrays.asList("Discordium Sword"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 9, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	discordium_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Pickaxe");
			im.setLore(Arrays.asList("Discordium Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 7, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	discordium_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Axe");
			im.setLore(Arrays.asList("Discordium Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	discordium_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Shovel");
			im.setLore(Arrays.asList("Discordium Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 7.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", shovel_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	discordium_hoe(new ItemStack(Material.NETHERITE_HOE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Hoe");
			im.setLore(Arrays.asList("Discordium Hoe"));
			this.setItemMeta(im);
		}
	}),
	//hammer
	discordium_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Hammer");
			im.setLore(Arrays.asList("Discordium Hammer"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 7, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	
	
	//armure
	discordium_helmet(new ItemStack(Material.NETHERITE_HELMET) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Helmet");
			im.setLore(Arrays.asList("Discordium Helmet"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 4, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 4, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im = Custom.setItemShield(im, 1);
			this.setItemMeta(im);
		}
	}),
	discordium_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Chestplate");
			im.setLore(Arrays.asList("Discordium Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 9, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 4, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im = Custom.setItemShield(im, 3);
			this.setItemMeta(im);
		}
	}),
	discordium_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Leggings");
			im.setLore(Arrays.asList("Discordium Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 7, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 4, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im = Custom.setItemShield(im, 2);
			this.setItemMeta(im);
		}
	}),
	discordium_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Discordium Boots");
			im.setLore(Arrays.asList("Discordium Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 4, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 4, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im = Custom.setItemShield(im, 1);
			this.setItemMeta(im);
		}
	}),
	
	//blazite
	
	//apple
	blazite_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Apple");
			im.setLore(Arrays.asList("Blazite Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_blazite_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Blazite Apple");
			im.setLore(Arrays.asList("Enchanted Blazite Apple"));
			this.setItemMeta(im);
		}
	}),
	
	//carrot
	blazite_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Carrot");
			im.setLore(Arrays.asList("Blazite Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//base
	blazite_chunk(new ItemStack(Material.NETHERITE_SCRAP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Chunk");
			im.setLore(Arrays.asList("Blazite Chunk"));
			this.setItemMeta(im);
		}
	}),
	blazite_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Ingot");
			im.setLore(Arrays.asList("Blazite Ingot"));
			this.setItemMeta(im);
		}
	}),
	
	//outils
	blazite_sword(new ItemStack(Material.NETHERITE_SWORD) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Sword");
			im.setLore(Arrays.asList("Blazite Sword"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 10, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	blazite_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Pickaxe");
			im.setLore(Arrays.asList("Blazite Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 8, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	blazite_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Axe");
			im.setLore(Arrays.asList("Blazite Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 12, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	blazite_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Shovel");
			im.setLore(Arrays.asList("Blazite Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 8.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", shovel_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	blazite_hoe(new ItemStack(Material.NETHERITE_HOE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Hoe");
			im.setLore(Arrays.asList("Blazite Hoe"));
			this.setItemMeta(im);
		}
	}),
	//hammer
	blazite_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Hammer");
			im.setLore(Arrays.asList("Blazite Hammer"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 8, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	
	
	//armure
	blazite_helmet(new ItemStack(Material.NETHERITE_HELMET) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Helmet");
			im.setLore(Arrays.asList("Blazite Helmet"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 4.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 4.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im = Custom.setItemShield(im, 2);
			this.setItemMeta(im);
		}
	}),
	blazite_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Chestplate");
			im.setLore(Arrays.asList("Blazite Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 9.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 9.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im = Custom.setItemShield(im, 5);
			this.setItemMeta(im);
		}
	}),
	blazite_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Leggings");
			im.setLore(Arrays.asList("Blazite Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 7.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 4.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im = Custom.setItemShield(im, 3);
			this.setItemMeta(im);
		}
	}),
	blazite_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Blazite Boots");
			im.setLore(Arrays.asList("Blazite Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 4.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 4.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im = Custom.setItemShield(im, 1);
			this.setItemMeta(im);
		}
	}),
	
	//manyullyn
	
	//apple
	manyullyn_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Apple");
			im.setLore(Arrays.asList("Manyullyn Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_manyullyn_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Manyullyn Apple");
			im.setLore(Arrays.asList("Enchanted Manyullyn Apple"));
			this.setItemMeta(im);
		}
	}),
	
	//carrot
	manyullyn_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Carrot");
			im.setLore(Arrays.asList("Manyullyn Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//base
	cobalt_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Cobalt Ingot");
			im.setLore(Arrays.asList("Cobalt Ingot"));
			this.setItemMeta(im);
		}
	}),
	ardite_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Ardite Ingot");
			im.setLore(Arrays.asList("Ardite Ingot"));
			this.setItemMeta(im);
		}
	}),
	manyullyn_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Ingot");
			im.setLore(Arrays.asList("Manyullyn Ingot"));
			this.setItemMeta(im);
		}
	}),
	
	//outils
	manyullyn_sword(new ItemStack(Material.NETHERITE_SWORD) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Sword");
			im.setLore(Arrays.asList("Manyullyn Sword"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	manyullyn_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Pickaxe");
			im.setLore(Arrays.asList("Manyullyn Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 9, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	manyullyn_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Axe");
			im.setLore(Arrays.asList("Manyullyn Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 13, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	manyullyn_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Shovel");
			im.setLore(Arrays.asList("Manyullyn Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 9.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", shovel_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	manyullyn_hoe(new ItemStack(Material.NETHERITE_HOE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Hoe");
			im.setLore(Arrays.asList("Manyullyn Hoe"));
			this.setItemMeta(im);
		}
	}),
	//hammer
	manyullyn_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Hammer");
			im.setLore(Arrays.asList("Manyullyn Hammer"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 9, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	
	
	//armure
	manyullyn_helmet(new ItemStack(Material.NETHERITE_HELMET) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Helmet");
			im.setLore(Arrays.asList("Manyullyn Helmet"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im = Custom.setItemShield(im, 2);
			this.setItemMeta(im);
		}
	}),
	manyullyn_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Chestplate");
			im.setLore(Arrays.asList("Manyullyn Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 10, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im = Custom.setItemShield(im, 5);
			this.setItemMeta(im);
		}
	}),
	manyullyn_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Leggings");
			im.setLore(Arrays.asList("Manyullyn Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 8, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im = Custom.setItemShield(im, 4);
			this.setItemMeta(im);
		}
	}),
	manyullyn_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Manyullyn Boots");
			im.setLore(Arrays.asList("Manyullyn Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im = Custom.setItemShield(im, 1);
			this.setItemMeta(im);
		}
	}),
	
	//chaos
	
	//apple
	chaos_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Apple");
			im.setLore(Arrays.asList("Chaos Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_chaos_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Chaos Apple");
			im.setLore(Arrays.asList("Enchanted Chaos Apple"));
			this.setItemMeta(im);
		}
	}),
	
	//carrot
	chaos_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Carrot");
			im.setLore(Arrays.asList("Chaos Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//base
	chaos_chunk(new ItemStack(Material.NETHERITE_SCRAP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Chunk");
			im.setLore(Arrays.asList("Chaos Chunk"));
			this.setItemMeta(im);
		}
	}),
	chaos_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Ingot");
			im.setLore(Arrays.asList("Chaos Ingot"));
			this.setItemMeta(im);
		}
	}),
	
	//outils
	chaos_sword(new ItemStack(Material.NETHERITE_SWORD) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Sword");
			im.setLore(Arrays.asList("Chaos Sword"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 12, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	chaos_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Pickaxe");
			im.setLore(Arrays.asList("Chaos Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 10, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	chaos_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Axe");
			im.setLore(Arrays.asList("Chaos Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 14, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	chaos_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Shovel");
			im.setLore(Arrays.asList("Chaos Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 10.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", shovel_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	chaos_hoe(new ItemStack(Material.NETHERITE_HOE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Hoe");
			im.setLore(Arrays.asList("Chaos Hoe"));
			this.setItemMeta(im);
		}
	}),
	//hammer
	chaos_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Hammer");
			im.setLore(Arrays.asList("Chaos Hammer"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 10, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	
	
	//armure
	chaos_helmet(new ItemStack(Material.NETHERITE_HELMET) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Helmet");
			im.setLore(Arrays.asList("Chaos Helmet"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 5.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im = Custom.setItemShield(im, 2);
			this.setItemMeta(im);
		}
	}),
	chaos_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Chestplate");
			im.setLore(Arrays.asList("Chaos Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 10.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im = Custom.setItemShield(im, 6);
			this.setItemMeta(im);
		}
	}),
	chaos_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Leggings");
			im.setLore(Arrays.asList("Chaos Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 8.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im = Custom.setItemShield(im, 5);
			this.setItemMeta(im);
		}
	}),
	chaos_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Chaos Boots");
			im.setLore(Arrays.asList("Chaos Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 5.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 5.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im = Custom.setItemShield(im, 2);
			this.setItemMeta(im);
		}
	}),
	
	//netherstar
	
	//apple
	netherstar_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Apple");
			im.setLore(Arrays.asList("Netherstar Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_netherstar_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Netherstar Apple");
			im.setLore(Arrays.asList("Enchanted Netherstar Apple"));
			this.setItemMeta(im);
		}
	}),
	
	//carrot
	netherstar_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Carrot");
			im.setLore(Arrays.asList("Netherstar Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//outils
	netherstar_sword(new ItemStack(Material.NETHERITE_SWORD) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Sword");
			im.setLore(Arrays.asList("Netherstar Sword"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 13, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	netherstar_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Pickaxe");
			im.setLore(Arrays.asList("Netherstar Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	netherstar_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Axe");
			im.setLore(Arrays.asList("Netherstar Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 15, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	netherstar_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Shovel");
			im.setLore(Arrays.asList("Netherstar Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", shovel_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	netherstar_hoe(new ItemStack(Material.NETHERITE_HOE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Hoe");
			im.setLore(Arrays.asList("Netherstar Hoe"));
			this.setItemMeta(im);
		}
	}),
	//hammer
	netherstar_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Hammer");
			im.setLore(Arrays.asList("Netherstar Hammer"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	
	
	//armure
	netherstar_helmet(new ItemStack(Material.NETHERITE_HELMET) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Helmet");
			im.setLore(Arrays.asList("Netherstar Helmet"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 6, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im = Custom.setItemShield(im, 3);
			this.setItemMeta(im);
		}
	}),
	netherstar_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Chestplate");
			im.setLore(Arrays.asList("Netherstar Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 11, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im = Custom.setItemShield(im, 8);
			this.setItemMeta(im);
		}
	}),
	netherstar_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Leggings");
			im.setLore(Arrays.asList("Netherstar Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 9, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im = Custom.setItemShield(im, 6);
			this.setItemMeta(im);
			}
	}),
	netherstar_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Netherstar Boots");
			im.setLore(Arrays.asList("Netherstar Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 6, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im = Custom.setItemShield(im, 3);
			this.setItemMeta(im);
		}
	}),
	
	//infinity
	
	//apple
	infinity_apple(new ItemStack(Material.GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Apple");
			im.setLore(Arrays.asList("Infinity Apple"));
			this.setItemMeta(im);
		}
	}),
	enchanted_infinity_apple(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Enchanted Infinity Apple");
			im.setLore(Arrays.asList("Enchanted Infinity Apple"));
			this.setItemMeta(im);
		}
	}),
	
	//carrot
	infinity_carrot(new ItemStack(Material.GOLDEN_CARROT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Carrot");
			im.setLore(Arrays.asList("Infinity Carrot"));
			this.setItemMeta(im);
		}
	}),
	
	//base
	infinity_egg(new ItemStack(Material.ENDERMITE_SPAWN_EGG) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Egg");
			im.setLore(Arrays.asList("Infinity Egg"));
			this.setItemMeta(im);
		}
	}),
	infinity_catalyst(new ItemStack(Material.NETHERITE_SCRAP) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Catalyst");
			im.setLore(Arrays.asList("Infinity Catalyst"));
			this.setItemMeta(im);
		}
	}),
	infinity_ingot(new ItemStack(Material.NETHERITE_INGOT) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Ingot");
			im.setLore(Arrays.asList("Infinity Ingot"));
			this.setItemMeta(im);
		}
	}),
	
	//outils
	infinity_sword(new ItemStack(Material.NETHERITE_SWORD) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Sword");
			im.setLore(Arrays.asList("Infinity Sword"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 14, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	infinity_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Pickaxe");
			im.setLore(Arrays.asList("Infinity Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 12, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	infinity_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Axe");
			im.setLore(Arrays.asList("Infinity Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 16, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	infinity_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Shovel");
			im.setLore(Arrays.asList("Infinity Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 12.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", shovel_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	infinity_hoe(new ItemStack(Material.NETHERITE_HOE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Hoe");
			im.setLore(Arrays.asList("Infinity Hoe"));
			this.setItemMeta(im);
		}
	}),
	//hammer
	infinity_hammer(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Hammer");
			im.setLore(Arrays.asList("Infinity Hammer"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 12, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	
	
	//armure
	infinity_helmet(new ItemStack(Material.NETHERITE_HELMET) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Helmet");
			im.setLore(Arrays.asList("Infinity Helmet"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 6.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6.5, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im = Custom.setItemShield(im, 4);
			this.setItemMeta(im);
		}
	}),
	infinity_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Chestplate");
			im.setLore(Arrays.asList("Infinity Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 11.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6.5, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im = Custom.setItemShield(im, 10);
			this.setItemMeta(im);
		}
	}),
	infinity_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Leggings");
			im.setLore(Arrays.asList("Infinity Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 9.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6.5, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im = Custom.setItemShield(im, 7);
			this.setItemMeta(im);
			}
	}),
	infinity_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Boots");
			im.setLore(Arrays.asList("Infinity Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 6.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6.5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im = Custom.setItemShield(im, 4);
			this.setItemMeta(im);
		}
	});
	
	static final float sword_speed = -2.4f;
	static final float pickaxe_speed = -2.8f;
	static final float axe_speed = -3.2f;
	static final float shovel_speed = -3f;
	static final float hoe_speed = -3f;
	
	private ItemStack is;
    Items(ItemStack itemStack){
        this.is = itemStack;
    }
    public ItemStack getItemStack() {
    	return is;
    }
}
