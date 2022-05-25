package fr.tiakin.mob;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import fr.tiakin.main.Custom;
import fr.tiakin.main.Main;

public class WitherBoss implements Listener {
	
	public static void spawn(Location loc) {
		Entity entity = loc.getWorld().spawnEntity(loc, EntityType.WITHER);
		Wither WBoss = (Wither) entity;
		
		WBoss.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "Boss"),PersistentDataType.SHORT,(short) 2);
		
		AttributeInstance healthAttribute = WBoss.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		healthAttribute.setBaseValue(800);
		WBoss.setHealth(800);
		
		WBoss.setCustomName("§cThe Wither's Father");
		WBoss.getBossBar().setColor(BarColor.BLUE);

	}
	@EventHandler
	public void onplace(BlockPlaceEvent e) {
		if(e.getBlockPlaced().getType() == Material.WITHER_SKELETON_SKULL || e.getBlockPlaced().getType() == Material.WITHER_SKELETON_WALL_SKULL) {
			Block b = e.getBlockPlaced();
			b.getRelative(0, 0, 0);
			
		}
	}
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if(e.getEntity() instanceof Wither) {
			Wither w = (Wither) e.getEntity();
			if(w.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT) && 
			   w.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT).shortValue() == (short) 2) {
				e.setDroppedExp(150);
				Random r = new Random();
				e.getDrops().set(0,new ItemStack(Material.NETHER_STAR,r.nextInt(7)+2));
			}
		}
	}
}
