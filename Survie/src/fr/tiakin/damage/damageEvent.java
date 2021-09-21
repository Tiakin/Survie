package fr.tiakin.damage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiakin.main.main;

public class damageEvent implements Listener {
	
	@EventHandler
    public void damage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			Bukkit.getScheduler().runTaskAsynchronously(JavaPlugin.getPlugin(main.class), () -> damageCooldown.addPlayerOnTiming(p));
		}
	}
}
