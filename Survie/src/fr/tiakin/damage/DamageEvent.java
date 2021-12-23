package fr.tiakin.damage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiakin.main.Custom;
import fr.tiakin.main.Main;

public class DamageEvent implements Listener {
	
	@EventHandler
    public void damage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			DamageCooldown.addPlayerOnTiming(p);
			float rest = (float) (  ( (double) Custom.getShield(p) )  -  ( e.getDamage() / 5 )  );
			JavaPlugin.getPlugin(Main.class).getLogger().info(rest+" "+e.getDamage()+" "+e.getFinalDamage());
			if(rest < 0) {
				Custom.setShield(p, 0);
				rest *= 5;
				rest = Math.abs(rest);
			}else {
				Custom.setShield(p, rest);
				rest = 0;
			}
			e.setDamage(rest);
			JavaPlugin.getPlugin(Main.class).getLogger().info(e.getDamage()+" "+e.getFinalDamage());
		}
	}
}
