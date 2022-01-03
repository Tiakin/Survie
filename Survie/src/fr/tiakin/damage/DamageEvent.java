package fr.tiakin.damage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import fr.tiakin.main.Custom;

public class DamageEvent implements Listener {
	
	@EventHandler
    public void damage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			DamageCooldown.addPlayerOnTiming(p);
			float rest = (float) (  ( (double) Custom.getShield(p) )  -  ( e.getDamage() / 5 )  );
			if(rest < 0) {
				Custom.setShield(p, 0);
				rest *= 5;
				rest = Math.abs(rest);
			}else {
				Custom.setShield(p, rest);
				rest = 0;
			}
			e.setDamage(rest);
		}
	}
}
