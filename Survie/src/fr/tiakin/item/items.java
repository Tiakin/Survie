package fr.tiakin.item;

import java.util.Arrays;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import fr.tiakin.main.Custom;

public enum items {
	
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
	
	//netherite
	
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
	
	//infinity
	
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
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 13, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", sword_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	infinity_pickaxe(new ItemStack(Material.NETHERITE_PICKAXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Pickaxe");
			im.setLore(Arrays.asList("Infinity Pickaxe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", pickaxe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	infinity_axe(new ItemStack(Material.NETHERITE_AXE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Axe");
			im.setLore(Arrays.asList("Infinity Axe"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 15, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "speed", axe_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
			this.setItemMeta(im);
		}
	}),
	infinity_shovel(new ItemStack(Material.NETHERITE_SHOVEL) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Shovel");
			im.setLore(Arrays.asList("Infinity Shovel"));
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11.5, Operation.ADD_NUMBER, EquipmentSlot.HAND));
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
			im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "damage", 11, Operation.ADD_NUMBER, EquipmentSlot.HAND));
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
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 6, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.HEAD));
			im = Custom.setItemShield(im, 3);
			this.setItemMeta(im);
		}
	}),
	infinity_chestplate(new ItemStack(Material.NETHERITE_CHESTPLATE) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Chestplate");
			im.setLore(Arrays.asList("Infinity Chestplate"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 11, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
			im = Custom.setItemShield(im, 8);
			this.setItemMeta(im);
		}
	}),
	infinity_leggings(new ItemStack(Material.NETHERITE_LEGGINGS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Leggings");
			im.setLore(Arrays.asList("Infinity Leggings"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 9, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.LEGS));
			im = Custom.setItemShield(im, 6);
			this.setItemMeta(im);
			}
	}),
	infinity_boots(new ItemStack(Material.NETHERITE_BOOTS) {
		ItemMeta im;{
			im = this.getItemMeta();
			im.setDisplayName(ChatColor.RESET+"Infinity Boots");
			im.setLore(Arrays.asList("Infinity Boots"));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "ar", 6, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "art", 6, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "kb", .1, Operation.ADD_NUMBER, EquipmentSlot.FEET));
			im = Custom.setItemShield(im, 3);
			this.setItemMeta(im);
		}
	});
	
	static final float sword_speed = -2.4f;
	static final float pickaxe_speed = -2.8f;
	static final float axe_speed = -3.2f;
	static final float shovel_speed = -3f;
	static final float hoe_speed = -3f;
	
	private ItemStack is;
    items(ItemStack itemStack){
        this.is = itemStack;
    }
    public ItemStack getItemStack() {
    	return is;
    }
}
