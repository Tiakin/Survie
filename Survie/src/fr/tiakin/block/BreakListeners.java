package fr.tiakin.block;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Cause;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.tiakin.item.Tool;
import fr.tiakin.main.Custom;
import fr.tiakin.main.main;
import net.minecraft.core.BlockPosition;

public class BreakListeners implements Listener {

    @EventHandler
    public void onEffectExpire(EntityPotionEffectEvent e) {
    	if(e.getEntity() instanceof Player && e.getCause().equals(Cause.EXPIRATION) && e.getOldEffect().getType().equals(PotionEffectType.SLOW_DIGGING)) {
    		addSlowDig(((Player)e.getEntity()));
    		JavaPlugin.getPlugin(main.class).getLogger().info("re-effect");
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
    	List<Block> squareBlock = null;
    	if(Tool.isHammer(event.getItemInHand())) {
    		squareBlock = Tool.getSquare(event.getBlock().getLocation(), Tool.getFacing(event.getPlayer()), Tool.getHammerRadius(event.getItemInHand()));
	    	squareBlock.stream().filter(b -> Tool.canHarvest(b, event.getItemInHand()) && Tool.isBestTool(b, event.getItemInHand())).forEach(b -> {
	    		if(hardness < Tool.getHardness(b))
	    			hardness = Tool.getHardness(b);
	    	});
    	}
    	if(hardness < Tool.getHardness(event.getBlock()))
    		hardness = Tool.getHardness(event.getBlock());
    	main.brokenBlocksService.createBrokenBlock(event.getBlock(), hardness, (Tool.isHammer(event.getItemInHand())) ? squareBlock.stream().filter(b -> Tool.canHarvest(b, event.getItemInHand()) && Tool.isBestTool(b, event.getItemInHand())) : null);
    	addSlowDig(event.getPlayer());
    }
    
    @EventHandler
    public void onAbortBlock(AbortBreakingBlockEvent event){
    	Player p = event.getPlayer();
    	World w = p.getWorld();
    	BlockPosition b = event.getBlockPosition();
        Location loc = new Location(w,b.getX(),b.getY(),b.getZ());
        BrokenBlock a = main.brokenBlocksService.getBrokenBlock(loc);
        JavaPlugin.getPlugin(main.class).getLogger().info("aborted");
        
        if(a.getDamage() != 0 || a.getHardeness() == 0 || a.isBroken()) {
        	JavaPlugin.getPlugin(main.class).getLogger().info("really aborted");
	        resetpotion(p);
	        a.destroyBlockObject();
        }
    }
    
    @EventHandler
    public void onBrokenBlock(BlockBreakEvent e) {
    	Player p = e.getPlayer();
    	Block b = e.getBlock();
    	if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
	    	blocks block = Custom.getCustomBlock(b);
	    	if(block != null) {
	    		e.setDropItems(false);
	    		Tool.breakblock(b, p, block);
	    	}
	    	if(main.brokenBlocksService.isBrokenBlock(b.getLocation())) {
	    		BrokenBlocksService.removeBrokenBlock(b.getLocation());
	    	}
    	}
    }
    
    @EventHandler
    public void onBreakingBlock(PlayerAnimationEvent event){
        Player player = event.getPlayer();
        Block block = player.getTargetBlockExact(5);
        if(block == null) return;
        Location blockPosition = block.getLocation();
        if(!main.brokenBlocksService.isBrokenBlock(blockPosition)) return;
        
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        
        double distanceX = blockPosition.getX() - player.getLocation().getX();
        double distanceY = blockPosition.getY() - player.getLocation().getY();
        double distanceZ = blockPosition.getZ() - player.getLocation().getZ();

        if(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ >= 1024.0D) return;
        main.brokenBlocksService.getBrokenBlock(blockPosition).incrementDamage(player, Tool.getToolSpeed(itemStack));
    }

	public static void resetpotion(Player breaker) {
		JavaPlugin.getPlugin(main.class).getLogger().info("Reset");
    	if(breaker.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
        	PotionEffect p = breaker.getPotionEffect(PotionEffectType.SLOW_DIGGING);
        	switch(p.getAmplifier()) {
        	case -1:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false));
        		JavaPlugin.getPlugin(main.class).getLogger().info("R -1 = -1 "+p.getDuration());
        		break;
        	case 3:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 0, false, true));
        		JavaPlugin.getPlugin(main.class).getLogger().info("R 3 > 0 "+p.getDuration());
        		break;
        	case 4:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 1, false, true));
        		JavaPlugin.getPlugin(main.class).getLogger().info("R 4 > 1 "+p.getDuration());
        		break;
        	case 5:
        		removeSlowDig(breaker);
        		breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 2, false, true));
        		JavaPlugin.getPlugin(main.class).getLogger().info("R 5 > 2 "+p.getDuration());
        		break;
        	}
        } else {
        	breaker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false));
    		JavaPlugin.getPlugin(main.class).getLogger().info("R(impossible) X > -1 ");
        }
    }
	
	public static void addSlowDig(Player player){
		JavaPlugin.getPlugin(main.class).getLogger().info("Add");
        if(player.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
        	PotionEffect p = player.getPotionEffect(PotionEffectType.SLOW_DIGGING);
        	switch(p.getAmplifier()) {
        	case -1:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false));
        		JavaPlugin.getPlugin(main.class).getLogger().info("A -1 = -1");
        		break;
        	case 0:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 3, false, true));
        		JavaPlugin.getPlugin(main.class).getLogger().info("A 0 > 3");
        		break;
        	case 1:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 4, false, true));
        		JavaPlugin.getPlugin(main.class).getLogger().info("A 1 > 4");
        		break;
        	case 2:
        		removeSlowDig(player);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, p.getDuration(), 5, false, true));
        		JavaPlugin.getPlugin(main.class).getLogger().info("A 1 > 5");
        		break;
        	
        	}
        } else {
        	player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE , -1, false, false));
        	JavaPlugin.getPlugin(main.class).getLogger().info("A X > -1");
        }
    }
	
    public static void removeSlowDig(Player player){
        player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    }
    
}
