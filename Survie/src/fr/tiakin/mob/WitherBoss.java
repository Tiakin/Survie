package fr.tiakin.mob;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.tiakin.block.Blocks;
import fr.tiakin.item.Items;
import fr.tiakin.main.Custom;
import fr.tiakin.main.Main;

public class WitherBoss implements Listener {
	
	public static void spawn(Location loc) {
		Entity entity = loc.getWorld().spawnEntity(loc, EntityType.WITHER);
		Wither WBoss = (Wither) entity;
		
		WBoss.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "Boss"),PersistentDataType.SHORT,(short) 2);
		
		AttributeInstance healthAttribute = WBoss.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		healthAttribute.setBaseValue(800);
		WBoss.setHealth(800);
		
		WBoss.setCustomName("§cThe Wither Grandfather");
		WBoss.getBossBar().setColor(BarColor.BLUE);

		loop(WBoss);
	}
	
	public static void loop(Wither WBoss) {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (!WBoss.isDead()) {
					
					Random r = new Random();
					switch(r.nextInt(800)) {
					case 0,1,2,3:
						Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> {
						WBoss.getWorld().playSound(WBoss.getLocation(),Sound.BLOCK_ANVIL_PLACE, 1, 1);
						WBoss.getWorld().createExplosion(WBoss.getLocation(), 3, true);
						});
						break;
					case 4:
						Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> {
						WBoss.getWorld().playSound(WBoss.getLocation(),Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1, 1);
							for(Entity entity : WBoss.getWorld().getNearbyEntities(WBoss.getLocation(), 20, 20, 20)) {
								if(entity instanceof Player p) {
									if(p.getGameMode() != GameMode.CREATIVE) {
										p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 15, 0));
									}
								}
							}
						});
						break;
					case 5:
						Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> {
							for(int i =0;i<8;i++) {
								WitherSkeleton WS = (WitherSkeleton) WBoss.getWorld().spawnEntity(WBoss.getLocation(), EntityType.WITHER_SKELETON);
								AttributeInstance healthAttribute = WS.getAttribute(Attribute.GENERIC_MAX_HEALTH);
								healthAttribute.setBaseValue(40);
								WS.setHealth(40);
							}
						});
						break;
					case 6:
						Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> {
							Fireball fireball = WBoss.getWorld().spawn(WBoss.getEyeLocation(),Fireball.class);
							Player[] ps = (Player[]) WBoss.getWorld().getNearbyEntities(WBoss.getLocation(), 20, 20, 20, (e) -> e instanceof Player).toArray();
							if(ps.length > 0) {
								fireball.setVelocity(ps[r.nextInt(ps.length)].getLocation().toVector());
							}
						});
						break;
					}
					
				} else {
			        cancel();
			      }
					
				}
		}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 2, 2);
	}
	
	@EventHandler
	public void explosionattack(EntityDamageEvent e) {
		if(e.getEntity() instanceof Zombie && (e.getCause() == DamageCause.BLOCK_EXPLOSION || e.getCause() == DamageCause.ENTITY_EXPLOSION)) {
			if(e.getEntity().getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT) && 
			   e.getEntity().getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT).shortValue() == (short) 2) {
					e.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onplace(BlockPlaceEvent e) {
		if(Custom.isWitherSkeletonSkull(e.getBlockPlaced().getType())) {
			Block b = e.getBlockPlaced();
			
			Material mxm2 = b.getRelative(-2, 0, 0).getType();
			Material mxm1 = b.getRelative(-1, 0, 0).getType();
			
			Material mx1 = b.getRelative(1, 0, 0).getType();
			Material mx2 = b.getRelative(2, 0, 0).getType();
			
			Material mzm2 = b.getRelative(0, 0, -2).getType();
			Material mzm1 = b.getRelative(0, 0, -1).getType();
			
			Material mz1 = b.getRelative(0, 0, 1).getType();
			Material mz2 = b.getRelative(0, 0, 2).getType();
			
			boolean bool;
			if(Custom.isWitherSkeletonSkull(mxm2) && Custom.isWitherSkeletonSkull(mxm1)) {
				b =  b.getRelative(-1, 0, 0);
				bool = false;
			} else if(Custom.isWitherSkeletonSkull(mxm1) && Custom.isWitherSkeletonSkull(mx1)) {
				bool = false;
			} else if(Custom.isWitherSkeletonSkull(mx1) && Custom.isWitherSkeletonSkull(mx2)) {
				b =  b.getRelative(1, 0, 0);
				bool = false;
			} else if(Custom.isWitherSkeletonSkull(mzm2) && Custom.isWitherSkeletonSkull(mzm1)) {
				b =  b.getRelative(0, 0, -1);
				bool = true;
			} else if(Custom.isWitherSkeletonSkull(mzm1) && Custom.isWitherSkeletonSkull(mz1)) {
				bool = true;
			} else if(Custom.isWitherSkeletonSkull(mz1) && Custom.isWitherSkeletonSkull(mz2)) {
				b =  b.getRelative(0, 0, 1);
				bool = true;
			} else {
				return;
			}
			if(structure(b,bool)) {
				delete(b,bool);
				spawn(b.getLocation());
			}
		}
	}
	
	private void delete(Block b, boolean isZ) {
		b.setType(Material.AIR);
		b.getRelative(0, -1, 0).setType(Material.AIR);
		b.getRelative(0, -2, 0).setType(Material.AIR);
		if(isZ) {
			b.getRelative(0, -1, -1).setType(Material.AIR);
			b.getRelative(0, -1, 1).setType(Material.AIR);
			b.getRelative(0, 0, -1).setType(Material.AIR);
			b.getRelative(0, 0, 1).setType(Material.AIR);
		} else {
			b.getRelative(-1, -1, 0).setType(Material.AIR);
			b.getRelative(1, -1, 0).setType(Material.AIR);
			b.getRelative(-1, 0, 0).setType(Material.AIR);
			b.getRelative(1, 0, 0).setType(Material.AIR);
		}
	}
	
	public boolean structure(Block b,boolean isZ) {
		if(Custom.isCustomBlockSimilar(Blocks.wither_core, b.getRelative(0, -1, 0)) && b.getRelative(0, -2, 0).getType() == Material.SOUL_SAND) {
			if(isZ) {
				if(b.getRelative(0, -1, -1).getType() == Material.SOUL_SAND && b.getRelative(0, -1, 1).getType() == Material.SOUL_SAND) {
					return true;
				}
			}else {
				if(b.getRelative(-1, -1, 0).getType() == Material.SOUL_SAND && b.getRelative(1, -1, 0).getType() == Material.SOUL_SAND) {
					return true;
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if(e.getEntity() instanceof Wither) {
			Wither w = (Wither) e.getEntity();
			if(w.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT) && 
			   w.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(Main.class), "Boss"), PersistentDataType.SHORT).shortValue() == (short) 2) {
				e.setDroppedExp(150);
				Random r = new Random();
				e.getDrops().set(0,new ItemStack(Material.NETHER_STAR,r.nextInt(7)+2));
			}
		} else if(e.getEntity() instanceof WitherSkeleton) {
			int r = new Random().nextInt(100);
			if(r < 3) {
				e.getDrops().add(Custom.multi(Items.wither_bone.getItemStack(),2));
			} else if(r < 15) {
				e.getDrops().add(Items.wither_bone.getItemStack());
			}
		}
	}
}
