package fr.tiakin.mob;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.bukkit.GameMode;

import fr.tiakin.block.Blocks;
import fr.tiakin.item.Items;
import fr.tiakin.item.Tool;
import fr.tiakin.main.Custom;
import fr.tiakin.main.Main;
import fr.tiakin.nms.NmsHandler;

public class InfinityBoss implements Listener {
	
	public static void spawn(Location loc) {
		Entity entity = loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		Zombie zombie = (Zombie) entity;
		
		zombie.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "Boss"),PersistentDataType.SHORT,(short) 1);
		
		zombie.getEquipment().setBoots(Items.infinity_boots.getItemStack());
		zombie.getEquipment().setLeggings(Items.infinity_leggings.getItemStack());
		zombie.getEquipment().setChestplate(Items.infinity_chestplate.getItemStack());
		zombie.getEquipment().setHelmet(Items.infinity_helmet.getItemStack());
		
		ItemStack is = Items.infinity_axe.getItemStack().clone();
		is.addEnchantment(Enchantment.DAMAGE_ALL, 5);
		zombie.getEquipment().setItemInMainHand(is);
		
		
		zombie.getEquipment().setBootsDropChance(0);
		zombie.getEquipment().setLeggingsDropChance(0);
		zombie.getEquipment().setChestplateDropChance(0);
		zombie.getEquipment().setHelmetDropChance(0);
		
		zombie.getEquipment().setItemInMainHandDropChance(0);
		
		AttributeInstance healthAttribute = zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		healthAttribute.setBaseValue(500);
		zombie.setHealth(500);
		
		AttributeInstance speedAttribute = zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
		speedAttribute.setBaseValue(0.5);
		
		zombie.setCustomName("§4Infinity Boss");
		BossBar bar = Bukkit.createBossBar("§4Infinity Boss",BarColor.RED, BarStyle.SOLID);
		
		
		
		loop(zombie,bar);
	}
	
	public static void loop(Zombie zombie,BossBar bar) {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (!zombie.isDead()) {
					bar.setProgress(zombie.getHealth() / zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
					for(Player p : Bukkit.getOnlinePlayers())
						bar.addPlayer(p);
					
					Random r = new Random();
					switch(r.nextInt(400)) {
					case 0:
						Bukkit.broadcastMessage("§cPar le feu soyez purifier !");
						for(int i=0;i<50;i++) {
							final int j = i;
							Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> {
								Fireball fireball = zombie.getWorld().spawn(zombie.getLocation(),Fireball.class);
								fireball.setDirection(new Vector(Math.cos(j*Math.PI*2/50), 0, Math.sin(j*Math.PI*2/50)));
								fireball.setVelocity(new Vector(Math.cos(j*Math.PI*2/50), 0, Math.sin(j*Math.PI*2/50)));
								Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> fireball.remove(),200l);
							},j*2);
						}
						break;
					case 1:
						Bukkit.broadcastMessage("§5Bye bye");
						Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> {
							for(Entity entity : zombie.getWorld().getNearbyEntities(zombie.getLocation(), 20, 20, 20)) {
								if(entity instanceof Player) {
									Player p = (Player) entity;
									if(p.getGameMode() != GameMode.CREATIVE) {
										p.setVelocity(new Vector(0,10,0));
										BukkitTask e = Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(Main.class), () -> {
											if(p.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "bossAttack"),PersistentDataType.INTEGER))
												p.getPersistentDataContainer().remove(new NamespacedKey(Main.getPlugin(Main.class), "bossAttack"));
										},2000L);
										p.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "bossAttack"), PersistentDataType.INTEGER, e.getTaskId());
											
									}
								}
							}
						});
						break;
					}
					
				} else {
			        for (Player player : bar.getPlayers()) {
			        	bar.removePlayer(player);
			        }
			        bar.setVisible(false);
			        cancel();
			       }
					
				}
		}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 2, 2);
	}
	
	@EventHandler
	public void fallAttack(EntityDamageEvent e) {
		if(e.getCause() == DamageCause.FALL) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if(p.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "bossAttack"),PersistentDataType.INTEGER)) {
					Bukkit.getScheduler().cancelTask(p.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "bossAttack"), PersistentDataType.INTEGER));
					p.getPersistentDataContainer().remove(new NamespacedKey(Main.getPlugin(Main.class), "bossAttack"));
					int i = 0;
					for(ItemStack is : p.getInventory().getArmorContents()) {
						if(is != null) {
							if(Tool.getOrder(Tool.getTier(is)) >= 11) { // si l'armure est au dessus de chaos
								i++;
							}
						}
					}
					if(i == 4) {
						e.setCancelled(true);
						p.sendMessage("§dVous avez été protéger par le chaos !");
						for(Block b : Tool.getSquare(p.getLocation().add(0, -1, 0),BlockFace.DOWN,1)) {
							if(Custom.materialsWhitelist(b.getType())) {
								NmsHandler.place(b.getLocation(), Blocks.chaos_nylium);
							}
						}
					}
				}
			}else if(e.getEntity() instanceof Zombie) {
				if(e.getEntity().getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT) && 
				   e.getEntity().getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT).shortValue() == (short) 1) {
						e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if(e.getEntity() instanceof Zombie) {
			Zombie z = (Zombie) e.getEntity();
			if(z.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT) && 
			   z.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT).shortValue() == (short) 1) {
				e.setDroppedExp(100);
				Random r = new Random();
				e.getDrops().add(Custom.multi(Items.infinity_catalyst.getItemStack().clone(), r.nextInt(5)+2));
			}
			for(Entity fireball : z.getWorld().getEntities()) {
				if(fireball instanceof Fireball) {
					fireball.remove();
				}
				}
		}
	}
}
