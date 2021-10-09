package fr.tiakin.damage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiakin.main.Custom;
import fr.tiakin.main.main;

public class damageEvent implements Listener {
	
	@EventHandler
    public void damage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			damageCooldown.addPlayerOnTiming(p);
			float rest = (float) (Custom.getShield(p) - (e.getDamage() / 2.5) );
			JavaPlugin.getPlugin(main.class).getLogger().info(rest+"");
			if(rest < 0) {
				Custom.setShield(p, 0);
				rest *= 2.5;
				rest = Math.abs(rest);
			}else {
				Custom.setShield(p, rest);
				rest = 0;
			}
			JavaPlugin.getPlugin(main.class).getLogger().info(rest+"");
			e.setDamage(rest);
			JavaPlugin.getPlugin(main.class).getLogger().info(e.getFinalDamage()+"");
		}
	}
}
