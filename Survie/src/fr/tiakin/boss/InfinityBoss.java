package fr.tiakin.boss;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class InfinityBoss {

	
	public static void spawn(Location loc) {
		Entity p = loc.getWorld().spawnEntity(loc, EntityType.PLAYER);
	}
}
