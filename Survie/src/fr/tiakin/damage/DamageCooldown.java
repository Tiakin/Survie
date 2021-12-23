package fr.tiakin.damage;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class DamageCooldown {
	private static HashMap<Player,Long> timelist = new HashMap<>();
	public static void addPlayerOnTiming(Player p){
    	if(timelist.containsKey(p))
    		timelist.replace(p, System.currentTimeMillis());
    	else
    		timelist.put(p, System.currentTimeMillis());
    }
    
    public static long getPlayerTiming(Player p){
    	if(timelist.containsKey(p)) {
    		return System.currentTimeMillis() - timelist.get(p);
    	}
		return Integer.MAX_VALUE;
    }
}
