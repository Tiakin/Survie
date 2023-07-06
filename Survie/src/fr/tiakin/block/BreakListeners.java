package fr.tiakin.block;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.FluidCollisionMode;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageAbortEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Cause;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.tiakin.item.Tool;
import fr.tiakin.main.Custom;
import fr.tiakin.main.Main;

public class BreakListeners implements Listener {

    @EventHandler
    public void onEffectExpire(EntityPotionEffectEvent e) {
    	if(e.getEntity() instanceof Player && e.getCause().equals(Cause.EXPIRATION) && e.getOldEffect().getType().equals(PotionEffectType.SLOW_DIGGING)) {
    		addSlowDig(((Player)e.getEntity()));
    	}
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    	addSlowDig(event.getPlayer());
    }
    
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	addSlowDig(event.getPlayer());
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
    	if(event.getPlayer().hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
    		if(event.getPlayer().getPotionEffect(PotionEffectType.SLOW_DIGGING).getAmplifier() == -1) {
    			removeSlowDig(event.getPlayer());
    		}
    	}
    }
    
    private float hardness;
    @EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event){
    	hardness = -1;
    	List<Block> squareBlock = new ArrayList<>(); 
    	if(Tool.isHammer(event.getItemInHand())) {
    		squareBlock = Tool.getSquare(event.getBlock().getLocation(), Tool.getFacing(event.getPlayer()), Tool.getHammerRadius(event.getItemInHand()));
	    	for(Block b : squareBlock) {
	    		if(Tool.canHarvest(b, event.getItemInHand()) && Tool.isBestTool(b, event.getItemInHand())) {
	    				if(hardness < Tool.getHardness(b))
	    					hardness = Tool.getHardness(b);
	    		}
	    	}
    	}
    	if(hardness < Tool.getHardness(event.getBlock()))
    		hardness = Tool.getHardness(event.getBlock());
    	Main.brokenBlocksService.createBrokenBlock(event.getBlock(), hardness, (Tool.isHammer(event.getItemInHand())) ? squareBlock : null);
    	addSlowDig(event.getPlayer());
    }
    
    
    @EventHandler
    public void onAbortBlock(BlockDamageAbortEvent event){
    	Player p = event.getPlayer();
        Location loc = event.getBlock().getLocation();
        BrokenBlock a = Main.brokenBlocksService.getBrokenBlock(loc);
        
        if(a.getDamage() != 0 || a.getHardeness() == 0 || a.isBroken()) {
	        resetpotion(p);
	        a.destroyBlockObject();
        }
    }
    
    @EventHandler
    public void onBrokenBlock(BlockBreakEvent e) {
    	Player p = e.getPlayer();
    	Block b = e.getBlock();
    	if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
	    	Blocks block = Custom.getCustomBlock(b);
	    	if(block != null) {
	    		e.setDropItems(false);
	    		Tool.breakblock(b, p, block);
	    	}
	    	if(Main.brokenBlocksService.isBrokenBlock(b.getLocation())) {
	    		BrokenBlocksService.removeBrokenBlock(b.getLocation());
	    	}
    	}
    }
    
    @EventHandler
    public void onBreakingBlock(PlayerAnimationEvent event){
        Player player = event.getPlayer();
        Block block = player.getTargetBlockExact(5,FluidCollisionMode.NEVER);
        if(block == null) return;
        Location blockPosition = block.getLocation();
        if(!Main.brokenBlocksService.isBrokenBlock(blockPosition)) return;
        
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        
        double distanceX = blockPosition.getX() - player.getLocation().getX();
        double distanceY = blockPosition.getY() - player.getLocation().getY();
        double distanceZ = blockPosition.getZ() - player.getLocation().getZ();

        if(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ >= 1024.0D) return;
        Main.brokenBlocksService.getBrokenBlock(blockPosition).incrementDamage(player, Tool.getToolSpeed(itemStack));
    }

	public static void resetpotion(Player breaker) {
    	if(breaker.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
        	PotionEffect p = breaker.getPotionEffect(PotionEffectType.SLOW_DIGGING);
        	switch(p.getAmplifier()) {
        	case -1:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false,false));
        		break;
        	case 3:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 0, false, true));
        		break;
        	case 4:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 1, false, true));
        		break;
        	case 5:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 2, false, true));
        		break;
        	}
        } else {
        	breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false,false));
        }
    }
	
	public static void addSlowDig(Player player){
        if(player.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
        	PotionEffect p = player.getPotionEffect(PotionEffectType.SLOW_DIGGING);
        	switch(p.getAmplifier()) {
        	case -1:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false,false));
        		
        		break;
        	case 0:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 3, false, true));
        		break;
        	case 1:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 4, false, true));
        		break;
        	case 2:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 5, false, true));
        		break;
        	
        	}
        } else {
        	player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false,false));
        }
    }
	
    public static void removeSlowDig(Player player){
        player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    }
    
}
