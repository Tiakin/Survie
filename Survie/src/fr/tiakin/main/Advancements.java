package fr.tiakin.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import com.google.common.io.Resources;

import fr.tiakin.block.blocks;
import fr.tiakin.item.items;

public class Advancements implements Listener {
	public void loadAdvancements(){
		LinkedList<NamespacedKey> list = new LinkedList<>();
		list.add(new NamespacedKey(main.getPlugin(main.class), "farmingroot"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming1"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming2"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming3"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming4"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming5"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming6"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming7"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming8"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming9"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming10"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming11"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "farming12"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "miningroot"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "mining1"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "mining2"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "mining3"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "mining4"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "mining5"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "mining6"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "adventureroot"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "adventure1"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "adventure2"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "adventure3"));
		list.add(new NamespacedKey(main.getPlugin(main.class), "adventure4"));
		
		try {
			createadvancements(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getResourceFileAsString(String fileName) throws IOException {
		return Resources.toString(main.class.getClassLoader().getResource(fileName),StandardCharsets.UTF_8);
	    
	}
	
	@SuppressWarnings("deprecation")
	private void createadvancements(LinkedList<NamespacedKey> list) throws IOException {
		  Iterator<Advancement> e = Bukkit.advancementIterator();
		  while (e.hasNext()) {
			  NamespacedKey namespacedkey = e.next().getKey();
			  if(list.contains(namespacedkey)) {
				  list.remove(namespacedkey);
			  }
		  }
		  for(NamespacedKey key : list) { 
			  Bukkit.getUnsafe().loadAdvancement(key,getResourceFileAsString("resources/advancements/"+key.getKey()+".txt"));
		  }
	}

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event){
    	Player p = event.getPlayer();
		ItemStack is = event.getItem();
    	if(Custom.isSimilar(items.diamond_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming3"));
    	else if(Custom.isSimilar(items.enchanted_diamond_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming4"));
    	else if(Custom.isSimilar(items.emerald_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming5"));
    	else if(Custom.isSimilar(items.enchanted_emerald_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming6"));
    	else if(is.getType().equals(Material.GOLDEN_APPLE))
			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming1"));
    	else if(is.getType().equals(Material.ENCHANTED_GOLDEN_APPLE))
			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming2"));
    }
    
    @EventHandler
    public void onPlayerCraft(CraftItemEvent event){
    	if(event.getWhoClicked() instanceof Player) {
    		Player p = (Player) event.getWhoClicked();
    		ItemStack is = event.getCurrentItem();
    		if(Custom.isSimilar(items.discordium_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming8"));
    		else if(Custom.isSimilar(items.blazite_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming9"));
    		else if(Custom.isSimilar(items.manyullyn_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming10"));
    		else if(Custom.isSimilar(items.chaos_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming11"));
    		else if(Custom.isSimilar(items.infinity_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming12"));
    		else if(Custom.isSimilar(blocks.infinity_block.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "mining6"));
    	}
    }
    
    @EventHandler
    public void onPlayerSmith(SmithItemEvent event){
    	if(event.getWhoClicked() instanceof Player) {
    		Player p = (Player) event.getWhoClicked();
    		ItemStack is = event.getCurrentItem();
    		if(Custom.isSimilar(items.enderite_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farming7"));
    		else if(Custom.isSimilar(items.manyullyn_ingot.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "mining4"));
    	}
    }

    @EventHandler
    public void onPlayerPickItem(EntityPickupItemEvent event){
    	if(event.getEntity() instanceof Player) {
    		Player p = (Player) event.getEntity();
    		ItemStack is = event.getItem().getItemStack();
	    	if(is.getType().equals(Material.APPLE))
	    		grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "farmingroot"));
	    	else if(Custom.isSimilar(blocks.enderite_ore.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "mining1"));
	    	else if(Custom.isSimilar(items.discordium_chunk.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "mining2"));
	    	else if(Custom.isSimilar(items.blazite_chunk.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "mining3"));
	    	else if(Custom.isSimilar(items.chaos_chunk.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(main.getPlugin(main.class), "mining5"));
	    
	    }
    }
    
    public void grantAdvancement(Player player,NamespacedKey key) {
    	AdvancementProgress progress = player.getAdvancementProgress(Bukkit.getAdvancement(key));
    	for(String criteria : progress.getRemainingCriteria())
    	    progress.awardCriteria(criteria);
    }
}
