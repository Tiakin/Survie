package fr.tiakin.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Timer extends BukkitRunnable {

	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			int totalShield = Custom.getTotalShield(p);
			if(totalShield > 0)
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("shield: "+ totalShield+" & "));
			//if(damageCooldown.getPlayerTiming(p) > 30l)
		}
	}

}
