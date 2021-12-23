package fr.tiakin.main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import fr.tiakin.damage.DamageCooldown;
import fr.tiakin.damage.HealCooldown;

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
						if(DamageCooldown.getPlayerTiming(p) > 5000l)
							if(HealCooldown.isPlayerOnTiming(p)) {
								if(HealCooldown.getPlayerTiming(p) > 1500l) {
									Custom.setShield(p, shield+1);
									HealCooldown.addPlayerOnTiming(p);
								}
							}else {
								HealCooldown.addPlayerOnTiming(p);
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
