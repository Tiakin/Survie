package fr.tiakin.damage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.tiakin.main.Custom;

public class damageEvent implements Listener {
	
	@EventHandler
    public void damage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			damageCooldown.addPlayerOnTiming(p);
			float rest = (float) (Custom.getShield(p) - e.getDamage()) / 10;
			if(rest < 0) {
				Custom.setShield(p, 0);
				rest *= 10;
			}else {
				Custom.setShield(p, rest);
				rest = 0;
			}
			e.setDamage(rest);
		}
	}
}
