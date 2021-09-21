package fr.tiakin.block;


import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import fr.tiakin.block.nms.nmsHandler;
import fr.tiakin.item.Tool;
import fr.tiakin.main.main;

public class BrokenBlock {
	private float hardeness;
    private int oldAnimation;
    private double damage = 0;
    private Block block;
    private Boolean InstantBreak = false;
    private Stream<Block> stream;
    
    public BrokenBlock(Block block, float f, Stream<Block> stream){
        this.block = block;
        this.hardeness = f;
        this.stream = stream;
    }

    public void incrementDamage(Player from, float toolMultiplier){
        if(isBroken()) return;
        float ldamage;
        if(block.getType().getHardness() == -1f) {
        	ldamage = 0;
        } else if(BreakCooldown.isPlayerOnCooldown(from)) {
        	ldamage = 0;
        } else
        	ldamage = getDestroySpeed(from, toolMultiplier);
        
        if(!Tool.canHarvest(block, from.getInventory().getItemInMainHand())) {
        	ldamage /= 100;
        } else {
        	ldamage /=30;
        }
        if(Tool.isHammer(from.getInventory().getItemInMainHand()))
        	ldamage /= 3;
        damage += ldamage;
        if(hardeness <= ldamage)
        	InstantBreak = true;
        int animation = getAnimation();
        if(animation != oldAnimation){
            if(animation < 10){
                sendBreakPacket(animation);
                
            } else {
            	breakBlock(from);
            	if(Tool.isHammer(from.getInventory().getItemInMainHand()))
                	stream.forEach(b -> {
                		from.breakBlock(b);
                	});
                
                
                return;
            }
        }
        oldAnimation = animation;
    }
    
    public double getDamage(){
    	return damage;
    }
    
    public double getHardeness(){
    	return hardeness;
    }

    public boolean isBroken(){
        return getAnimation() >= 10;
    }

    public void breakBlock(Player breaker){
        destroyBlockObject();
        nmsHandler.playBlockSound(block);
        if(breaker == null) return;
        if(!isInstantBreak())
        	Bukkit.getScheduler().runTaskAsynchronously(JavaPlugin.getPlugin(main.class), () -> BreakCooldown.addPlayerOnCooldown(breaker));
        nmsHandler.sendBreakBlock(breaker, block);
        BreakListeners.resetpotion(breaker);
        
    }
    
    
    public void destroyBlockObject(){
        sendBreakPacket(-1);
        BrokenBlocksService.removeBrokenBlock(block.getLocation());
    }

    public int getAnimation(){
        return (int) (damage / hardeness*11) - 1;
    }

    public void sendBreakPacket(int animation){
        nmsHandler.sendBreakPacket(animation, block);
    }

	public Boolean isInstantBreak() {
		return InstantBreak;
	}
	
	
	public float getDestroySpeed(Player from, float toolMultiplier) {
		
		float speedMultiplier = 1;
        ItemStack hand = from.getInventory().getItemInMainHand();
        
        if(Tool.isBestTool(block, hand)) {
        	
        	speedMultiplier = toolMultiplier;
        	if(hand.hasItemMeta() && hand.getItemMeta().hasEnchant(Enchantment.DIG_SPEED)){
        		float e = hand.getItemMeta().getEnchantLevel(Enchantment.DIG_SPEED);
        		speedMultiplier +=  e*e + 1;
        	}
        }
        
        if(from.hasPotionEffect(PotionEffectType.FAST_DIGGING))
        	speedMultiplier *= 1 + (0.2 * from.getPotionEffect(PotionEffectType.FAST_DIGGING).getAmplifier());
        
        if(from.hasPotionEffect(PotionEffectType.SLOW_DIGGING))
        	switch(from.getPotionEffect(PotionEffectType.SLOW_DIGGING).getAmplifier()) {
        	case 0:
        	case 3:
        		speedMultiplier *= 0.3;
        		break;
        	case 1:
        	case 4:
        		speedMultiplier *= 0.09;
        		break;
        	case 2:
        	case 5:
        		speedMultiplier *= 0.0027;
        		break;
        	}
    	
        if(from.getLocation().getBlock().isLiquid() && !from.getInventory().getHelmet().containsEnchantment(Enchantment.WATER_WORKER))
        	speedMultiplier /= 5;
        if(from.isFlying())
        	speedMultiplier /= 5;
		return speedMultiplier;
	}
}
