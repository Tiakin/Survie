package fr.tiakin.block;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiakin.main.Main;

public class BreakCooldown {
	
	private static Set<Player> cooldownlist = new HashSet<>();
	
	public static void addPlayerOnCooldown(Player p){
    	cooldownlist.add(p);
    	Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(Main.class), new Runnable() {
    		  @Override
    		  public void run() {
    			  removePlayerOnCooldown(p);
    		  }
    		}, 6l);
    }
    
    public static void removePlayerOnCooldown(Player p){
    	if(isPlayerOnCooldown(p)) {
    		cooldownlist.remove(p);
    	}
    }
    
    public static Boolean isPlayerOnCooldown(Player p){
    	if(cooldownlist.contains(p))
    		return true;
		return false;
    }
}
