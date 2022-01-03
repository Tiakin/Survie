package fr.tiakin.mob;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Protector implements Listener {
	
	public static void spawn(Location loc) {
		Entity entity = loc.getWorld().spawnEntity(loc, EntityType.WITHER_SKELETON);
		WitherSkeleton WSkeleton = (WitherSkeleton) entity;
		
		AttributeInstance healthAttribute = WSkeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		healthAttribute.setBaseValue(100);
		WSkeleton.setHealth(100);
		
		WSkeleton.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
		
		WSkeleton.getEquipment().setItemInMainHandDropChance(0f);
		
		AttributeInstance speedAttribute = WSkeleton.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
		speedAttribute.setBaseValue(0.5);
		
		WSkeleton.setCustomName("§4Protector");
		
	}
	
}
