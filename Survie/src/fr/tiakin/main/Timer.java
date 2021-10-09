package fr.tiakin.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import fr.tiakin.damage.damageCooldown;

public class Timer extends BukkitRunnable {
	
	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			int totalShield = Custom.getTotalShield(p);
			float shield = Custom.getShield(p);
			if(totalShield > 0)
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(Custom.actionShield(shield, totalShield)));
			if(shield < totalShield) {
				if(damageCooldown.getPlayerTiming(p) > 2000l)
					Custom.setShield(p, shield+1);
			}
			if(shield > totalShield) {
				Custom.setShield(p, totalShield);
			}
		}
	}

}
