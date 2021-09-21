package fr.tiakin.block;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiakin.main.main;

public class BreakCooldown {
	
	private static Set<Player> cooldownlist = new HashSet<>();
	
	public static void addPlayerOnCooldown(Player p){
    	JavaPlugin.getPlugin(main.class).getLogger().info("cooldown :x");
    	cooldownlist.add(p);
    	Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(main.class), new Runnable() {
    		  @Override
    		  public void run() {
    			  removePlayerOnCooldown(p);
    		  }
    		}, 6l);
    }
    
    public static void removePlayerOnCooldown(Player p){
    	if(isPlayerOnCooldown(p)) {
    		cooldownlist.remove(p);
    		JavaPlugin.getPlugin(main.class).getLogger().info("cooldown enlever :)");
    	}
    }
    
    public static Boolean isPlayerOnCooldown(Player p){
    	if(cooldownlist.contains(p))
    		return true;
		return false;
    }
}
