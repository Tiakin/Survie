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
		for(int i = 1; i <=40;i++)
			list.add(new NamespacedKey(Main.getPlugin(Main.class), "farming"+i));
				
		list.add(new NamespacedKey(Main.getPlugin(Main.class), "miningroot"));
		for(int i = 1; i <=23;i++)
			list.add(new NamespacedKey(Main.getPlugin(Main.class), "mining"+i));
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
		
		Items item = Custom.getCustomItem(is);
		
		if(item !=null)
			switch(item) {
			case diamond_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming3"));
			case enchanted_diamond_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming4"));
			case emerald_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming5"));
			case enchanted_emerald_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming6"));
			case netherite_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming7"));
			case enchanted_netherite_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming8"));
			case enderite_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming9"));
			case enchanted_enderite_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming10"));
			case discordium_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming11"));
			case enchanted_discordium_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming12"));
			case blazite_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming13"));
			case enchanted_blazite_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming14"));
			case manyullyn_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming15"));
			case enchanted_manyullyn_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming16"));
			case chaos_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming17"));
			case enchanted_chaos_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming18"));
			case netherstar_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming19"));
			case enchanted_netherstar_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming20"));
			case infinity_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming21"));
			case enchanted_infinity_apple -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming22"));
			
			case diamond_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming23"));
			case emerald_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming24"));
			case netherite_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming25"));
			case enderite_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming26"));
			case discordium_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming27"));
			case blazite_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming28"));
			case manyullyn_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming29"));
			case chaos_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming30"));
			case netherstar_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming31"));
			case infinity_carrot -> grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming32"));
			default -> {} 
			}
		if(is.getType().equals(Material.GOLDEN_APPLE))
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
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming33"));
    		else if(Custom.isSimilar(Items.blazite_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming34"));
    		else if(Custom.isSimilar(Items.manyullyn_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming35"));
    		else if(Custom.isSimilar(Items.chaos_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming36"));
    		else if(Custom.isSimilar(Items.netherstar_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming37"));
    		else if(Custom.isSimilar(Items.infinity_hoe.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming38"));
    		else if(is.getType() == Material.NETHERITE_INGOT)
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "miningroot"));
    		else if(Custom.isSimilar(Blocks.netherstar_block.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining6"));
    		else if(Custom.isSimilar(Blocks.infinity_block.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining7"));
    		else if(Custom.isSimilar(Items.diamond_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining8"));
    		else if(Custom.isSimilar(Items.discordium_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining11"));
    		else if(Custom.isSimilar(Items.blazite_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining12"));
    		else if(Custom.isSimilar(Items.manyullyn_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining13"));
    		else if(Custom.isSimilar(Items.chaos_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining14"));
    		else if(Custom.isSimilar(Items.netherstar_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining15"));
    		else if(Custom.isSimilar(Items.infinity_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining16"));
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
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "farming32"));
    		else if(Custom.isSimilar(Items.manyullyn_ingot.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining4"));
    		else if(Custom.isSimilar(Items.netherite_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining9"));
    		else if(Custom.isSimilar(Items.enderite_hammer.getItemStack(), is))
    			grantAdvancement(p, new NamespacedKey(Main.getPlugin(Main.class), "mining10"));
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
