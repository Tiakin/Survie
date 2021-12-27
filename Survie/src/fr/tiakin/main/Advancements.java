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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import com.google.common.io.Resources;

import fr.tiakin.block.Blocks;
import fr.tiakin.item.Items;

public class Advancements implements Listener {
	public void loadAdvancements(){
		LinkedList<NamespacedKey> list = new LinkedList<>();
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farmingroot"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming1"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming2"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming3"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming4"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming5"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming6"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming7"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming8"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming9"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming10"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming11"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming12"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "miningroot"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "mining1"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "mining2"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "mining3"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "mining4"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "mining5"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "mining6"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "adventureroot"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "adventure1"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "adventure2"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "adventure3"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "adventure4"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "eastereggroot"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "easteregg1"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "easteregg2"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "easteregg3"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "easteregg4"));
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "easteregg5"));
		
		try {
			createadvancements(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getResourceFileAsString(String fileName) throws IOException {
		return Resources.toString(Main.class.getResource(fileName),StandardCharsets.UTF_8);
	    
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
			  Bukkit.getUnsafe().loadAdvancement(key,getResourceFileAsString("/src/resources/advancements/"+key.getKey()+".txt"));
		  }
	}

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event){
    	Player p = event.getPlayer();
		ItemStack is = event.getItem();
    	if(Custom.isSimilar(Items.diamond_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming3"));
    	else if(Custom.isSimilar(Items.enchanted_diamond_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming4"));
    	else if(Custom.isSimilar(Items.emerald_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming5"));
    	else if(Custom.isSimilar(Items.enchanted_emerald_apple.getItemStack(), is))
			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming6"));
    	else if(is.getType().equals(Material.GOLDEN_APPLE))
			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming1"));
    	else if(is.getType().equals(Material.ENCHANTED_GOLDEN_APPLE))
			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming2"));
    }
    
    @EventHandler
    public void onPlayerCraft(CraftItemEvent event){
    	if(event.getWhoClicked() instanceof Player) {
    		Player p = (Player) event.getWhoClicked();
    		ItemStack is = event.getCurrentItem();
    		if(Custom.isSimilar(Items.discordium_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming8"));
    		else if(Custom.isSimilar(Items.blazite_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming9"));
    		else if(Custom.isSimilar(Items.manyullyn_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming10"));
    		else if(Custom.isSimilar(Items.chaos_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming11"));
    		else if(Custom.isSimilar(Items.infinity_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming12"));
    		else if(is.getType() == Material.NETHERITE_INGOT)
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "miningroot"));
    		else if(Custom.isSimilar(Blocks.infinity_block.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining6"));
    		else if(Custom.isSimilar(Items.melo_disc.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "easteregg1"));
    		else if(Custom.isSimilar(Items.moonlight_disc.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "easteregg2"));
    		else if(Custom.isSimilar(Items.ice_disc.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "easteregg3"));
    		else if(Custom.isSimilar(Items.pillaged_disc.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "easteregg4"));
    		else if(Custom.isSimilar(Items.shulk_disc.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "easteregg5"));
    	}
    }
    
    @EventHandler
    public void onPlayerSmith(SmithItemEvent event){
    	if(event.getWhoClicked() instanceof Player) {
    		Player p = (Player) event.getWhoClicked();
    		ItemStack is = event.getCurrentItem();
    		if(Custom.isSimilar(Items.enderite_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming7"));
    		else if(Custom.isSimilar(Items.manyullyn_ingot.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining4"));
    	}
    }

    @EventHandler
    public void onPlayerPickItem(EntityPickupItemEvent event){
    	if(event.getEntity() instanceof Player) {
    		Player p = (Player) event.getEntity();
    		ItemStack is = event.getItem().getItemStack();
	    	if(is.getType().equals(Material.APPLE))
	    		grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farmingroot"));
	    	else if(Custom.isSimilar(Blocks.enderite_ore.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining1"));
	    	else if(Custom.isSimilar(Items.discordium_chunk.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining2"));
	    	else if(Custom.isSimilar(Items.blazite_chunk.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining3"));
	    	else if(Custom.isSimilar(Items.chaos_chunk.getItemStack(), is))
	    		grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining5"));
	    
	    }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
    	Player p = (Player) event.getWhoClicked();
    	ItemStack is = event.getCurrentItem();
    	if(is == null) return;
    	if(is.getType().equals(Material.MUSIC_DISC_PIGSTEP))
    		grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "eastereggroot"));
    		
    }
    
    public void grantAdvancement(Player player,NamespacedKey key) {
    	AdvancementProgress progress = player.getAdvancementProgress(Bukkit.getAdvancement(key));
    	for(String criteria : progress.getRemainingCriteria())
    	    progress.awardCriteria(criteria);
    }
    
    @EventHandler
    public void onAdvancementGrant(PlayerAdvancementDoneEvent event){
    	Custom.discoverrecipe(event.getPlayer());
    }
}
