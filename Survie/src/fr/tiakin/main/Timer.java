package fr.tiakin.main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import fr.tiakin.damage.damageCooldown;
import fr.tiakin.damage.healCooldown;

public class Timer extends BukkitRunnable {
	
	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE) {
				if(Custom.hasShield(p)) {
					int totalShield = Custom.getTotalShield(p);
					float shield = Custom.getShield(p);
					if(totalShield > 0)
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(Custom.actionShield(shield, totalShield)));
					if(shield < totalShield) {
						if(damageCooldown.getPlayerTiming(p) > 5000l)
							if(healCooldown.isPlayerOnTiming(p)) {
								if(healCooldown.getPlayerTiming(p) > 1500l) {
									Custom.setShield(p, shield+1);
									healCooldown.addPlayerOnTiming(p);
								}
							}else {
								healCooldown.addPlayerOnTiming(p);
							}
					}
					if(shield > totalShield) {
						Custom.setShield(p, totalShield);
					}
				}else {
					Custom.setShield(p, 0);
				}
			}
		}
	}
}
