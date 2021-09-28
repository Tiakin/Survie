package fr.tiakin.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import fr.tiakin.damage.damageCooldown;

public class Timer extends BukkitRunnable {
	
	char blueHeart = '\uEff1';
	char halfBlueHeart = '\uEff2';
	char darkBlueHeart = '\uEff4';
	char halfDarkBlueHeart = '\uEff3';
	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			int totalShield = Custom.getTotalShield(p);
			int shield = Custom.getShield(p);
			
			if(totalShield > 0)
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("shield: "+ shield));
			if(totalShield == shield)
			if(damageCooldown.getPlayerTiming(p) > 2000l)
				Custom.setShield(p, totalShield+1);
		}
	}

}
