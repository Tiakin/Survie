package fr.tiakin.main;


import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.noise.SimplexNoiseGenerator;

import fr.tiakin.block.AbortBreakingBlockEvent;
import fr.tiakin.block.Blocks;
import fr.tiakin.block.BreakListeners;
import fr.tiakin.block.BrokenBlocksService;
import fr.tiakin.damage.DamageEvent;
import fr.tiakin.generation.ChaosBiome;
import fr.tiakin.generation.StructureUtil;
import fr.tiakin.item.Tool;
import fr.tiakin.mob.InfinityBoss;
import fr.tiakin.mob.WitherBoss;
import fr.tiakin.nms.NmsHandler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;

import net.minecraft.core.BaseBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.network.protocol.game.PacketPlayInBlockDig;
import net.minecraft.network.protocol.game.PacketPlayInBlockDig.EnumPlayerDigType;

public class Main extends JavaPlugin implements Listener{
	public static BrokenBlocksService brokenBlocksService = new BrokenBlocksService();
	
	Advancements advancement = new Advancements();
	
	public void onEnable(){
		getLogger().info("Plugin Survie lancé !");
		try {
			ChaosBiome.create();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new Custom(), this);
		Bukkit.getPluginManager().registerEvents(new BreakListeners(), this);
		Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);
		Bukkit.getPluginManager().registerEvents(advancement, this);
		Bukkit.getPluginManager().registerEvents(new InfinityBoss(), this);
		Bukkit.getPluginManager().registerEvents(new WitherBoss(), this);
		getCommand("customgive").setExecutor(new customgive());
		mineableaxe();
		Timer timer = new Timer();
		timer.runTaskTimerAsynchronously(this, 0, 2l);
		Custom.customrecipe();
		advancement.loadAdvancements();
		StructureUtil.register();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			Custom.discoverrecipe(p.getPlayer());
			injectPlayer(p.getPlayer());
		}
	}
	
	private void mineableaxe() {
		File tagblock = new File("world/datapacks/bukkit/data/minecraft/tags/blocks/mineable/axe.json");
        if (!tagblock.exists()){
        	try {
        		tagblock.getParentFile().mkdirs();
        		FileUtils.copyURLToFile(Main.class.getResource("/src/resources/axe.json"), tagblock);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

	public void onDisable() {
		getLogger().info("Plugin Survie éteint !");
		for(Player p : Bukkit.getOnlinePlayers()) {
			removePlayer(p.getPlayer());
		}
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Custom.discoverrecipe(e.getPlayer());
		e.getPlayer().setResourcePack("http://85.214.226.235/survivalV2.3.zip");
		injectPlayer(e.getPlayer());
		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 10,false,true,false));
	}
	
	private static HashMap<World, SimplexNoiseGenerator> noises = new HashMap<>();
	Random random = new Random();
	
	@EventHandler
    public void chunkLoad(ChunkLoadEvent e) {
		if(e.isNewChunk()) {
			if(e.getWorld().getEnvironment().equals(Environment.THE_END)) {
				if(!noises.containsKey(e.getWorld())) {
					noises.put(e.getWorld(), new SimplexNoiseGenerator(e.getWorld().getSeed()));
				}
				SimplexNoiseGenerator noise = noises.get(e.getWorld());
				ChaosBiome.generateBiome(e.getChunk(),noise);
				for (int x = 0; x <= 15; x++) {
					for (int z = 0; z <= 15; z++) {
						int i = (e.getChunk().getX() * 16 + x) >> 2;
				      	int j = (e.getChunk().getZ() * 16 + z) >> 2;
						if(i*i + j*j > 4096L) {
							if(Custom.noise(noise,i*2+1, j*2+1) > 0) {
								Block b = Custom.gethighestendstone(e.getWorld(),e.getChunk().getX() * 16 + x, e.getChunk().getZ() * 16 + z);
								if(b != null) {
									NmsHandler.place(b.getLocation(), Blocks.chaos_nylium);
								}
							}
						}
			        }
				}
					int i = (e.getChunk().getX() * 16) >> 2;
			      	int j = (e.getChunk().getZ() * 16) >> 2;
					
					if(i*i + j*j > 4096L) {
						Block b = Custom.gethighestendstone(e.getWorld(),e.getChunk().getX() * 16, e.getChunk().getZ() * 16);
						if(b != null) {
							if(Custom.noise(noise,i*2+1, j*2+1) > 0) {
									if(random.nextInt(150) == 0) {
										StructureUtil.load(b.getLocation().add(0, -2, 0), "arbre1", true);
										Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.chaos_ore,b.getY()-5,b.getY(),1,1,2,4, true, true);
									}else if(random.nextInt(100) == 0) {
										StructureUtil.load(b.getLocation().add(0, -1, 0), "arbre2", true);
										Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.chaos_ore,b.getY()-5,b.getY(),2,1,3,4, true, true);
									}else if(random.nextInt(75) == 0) {
										StructureUtil.load(b.getLocation().add(0, -1, 0), "arbre3", true);
										Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.chaos_ore,b.getY()-5,b.getY(),3,1,3,2, true, true);
									}else if(random.nextInt(75) == 0) {
										StructureUtil.load(b.getLocation().add(0, -1, 0), "arbre4", true);
										Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.chaos_ore,b.getY()-5,b.getY(),3,1,3,2, true, true);
									}else if(random.nextInt(50) == 0) {
										BaseBlockPosition bbp = StructureUtil.getSize(e.getWorld(), "lac1");
										Block b2 = Custom.gethighestendstone(e.getWorld(), b.getRelative(bbp.getX()/2, 0,0).getX() ,b.getRelative(0, 0,bbp.getZ()/2).getZ());
										if(b2 != null)
											if(b.getY() - b2.getY() < 3 )
												if(random.nextInt(2) == 0) {
													StructureUtil.load(b.getLocation().add(0, -2, 0), "lac1", true);
												} else {
													StructureUtil.load(b.getLocation().add(0, -2, 0), "lavalac1", true);
												}
										
									}else if(random.nextInt(75) == 0) {
										BaseBlockPosition bbp = StructureUtil.getSize(e.getWorld(), "lac2");
										Block b2 = Custom.gethighestendstone(e.getWorld(), b.getRelative(bbp.getX()/2, 0,0).getX() ,b.getRelative(0, 0,bbp.getZ()/2).getZ());
										if(b2 != null) {
											if(b.getY() - b2.getY() < 3 ) {
												if(random.nextInt(2) == 0) {
													StructureUtil.load(b.getLocation().add(0, -4, 0), "lac2", true);
													if(random.nextInt(2) == 0) {
														StructureUtil.load(b.getLocation().add(random.nextInt(11) - 5, 5 + random.nextInt(15), random.nextInt(11) - 5), "lac3", true);
													}
												}else {
													StructureUtil.load(b.getLocation().add(0, -4, 0), "lavalac2", true);
													if(random.nextInt(2) == 0) {
														StructureUtil.load(b.getLocation().add(random.nextInt(11) - 5, 5 + random.nextInt(15), random.nextInt(11) - 5), "lavalac3", true);
													}
												}	
											}
										}
									}										
							}	
						}
					}
				Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.enderite_ore,0,60,5,6,3,4, false, false);
			}else if(e.getWorld().getEnvironment().equals(Environment.NORMAL)) {
					Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.discordium_ore,-60,0,2,3,2,4, false, false);
					Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.charoite_ore,-40,10,2,4,2,6, false, false);
			}else if(e.getWorld().getEnvironment().equals(Environment.NETHER)) {
					Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.blazite_ore,0,20,2,3,2,4, false, false);
					Custom.generateOre(e.getWorld(),e.getChunk(),random,Blocks.carnelian_ore,100,128,2,4,3,4, false, false);
			}
		}
	}
	
	@EventHandler
    public void onLeave(PlayerQuitEvent e){
        removePlayer(e.getPlayer());
    }
	
	private void removePlayer(Player player) {
        Channel channel = ((CraftPlayer) player).getHandle().b.a.k;
        channel.eventLoop().submit(() -> {
            channel.pipeline().remove(player.getName());
            return null;
        });
    }
	
    private void injectPlayer(Player player) {
    	
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {

            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
            	super.channelRead(channelHandlerContext, packet);
            	if(packet instanceof PacketPlayInBlockDig) {
            		BlockPosition b = ((PacketPlayInBlockDig) packet).b();
            		EnumDirection c = ((PacketPlayInBlockDig) packet).c();
            		EnumPlayerDigType d = ((PacketPlayInBlockDig) packet).d();
            		
                
            		if(d.equals(EnumPlayerDigType.b)) {
            			AbortBreakingBlockEvent event = new AbortBreakingBlockEvent(b,c,player);
            			Bukkit.getScheduler().runTask(getPlugin(Main.class), () -> Bukkit.getPluginManager().callEvent(event));
                }
            	}
                
            }
            
            @Override
            public void write(ChannelHandlerContext channelHandlerContext, Object packet, ChannelPromise channelPromise) throws Exception {
                super.write(channelHandlerContext, packet, channelPromise);
            }


        };

        ChannelPipeline pipeline = ((CraftPlayer) player).getHandle().b.a.k.pipeline();
        pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);

    }
    
    @EventHandler
    private void onEventExplosion(EntityDamageEvent e) {
        if (e.getEntity().getType() != EntityType.DROPPED_ITEM || !(e.getEntity() instanceof Item)) {
            return;
        }
        if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION
                && e.getCause() != EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
            return;
        }
        ItemStack is = ((Item) e.getEntity()).getItemStack();
        if (is != null && Custom.explosionProtect(is)) {
        	e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void entityExplode(EntityExplodeEvent e) {
    	Iterator<Block> it = e.blockList().iterator();
        while(it.hasNext()) {
            Block block = it.next();
            if(Tool.isMushroom(block.getType())){
                it.remove();
            }
        }
    }
    @EventHandler
    public void blockExplode(BlockExplodeEvent e) {
    	Iterator<Block> it = e.blockList().iterator();
        while(it.hasNext()) {
            Block block = it.next();
            if(Tool.isMushroom(block.getType())){
                it.remove();
            }
        }
    }
    
    @EventHandler
    public void pistonextend(BlockPistonExtendEvent e) {
    	for(Block b : e.getBlocks()) {
    		if(Tool.isMushroom(b.getType())) {
    			e.setCancelled(true);
    		}
    	}
    }
    
    @EventHandler
    public void pistonretract(BlockPistonRetractEvent e) {
    	for(Block b : e.getBlocks()) {
    		if(Tool.isMushroom(b.getType())) {
    			e.setCancelled(true);
    		}
    	}
    }
    
	@EventHandler
    public void mushroominteract(BlockPhysicsEvent e){
		Material m = e.getChangedType();
		if(m.equals(Material.REDSTONE_WIRE))
			return;
		if(isMushroom(m)){
            e.setCancelled(true);
        }
    }
	
	@EventHandler
    public void mushroomplace(BlockPlaceEvent e){
		Material m = e.getBlock().getType();
        if(m.equals(Material.BROWN_MUSHROOM_BLOCK) || m.equals(Material.RED_MUSHROOM_BLOCK) || m.equals(Material.MUSHROOM_STEM)){
        	MultipleFacing multiFacing = (MultipleFacing) e.getBlock().getBlockData();
        	for(BlockFace face : Custom.faces) {
        	multiFacing.setFace(face, true);
        	}
        	e.getBlock().setBlockData(multiFacing);
        	Bukkit.getScheduler().runTaskAsynchronously(getPlugin(Main.class), () -> updateclient(e.getBlock(), e.getPlayer()));
        }else if(m.equals(Material.PLAYER_HEAD) || m.equals(Material.PLAYER_WALL_HEAD)) {
        	Blocks a = Custom.getCustomBlock(e.getItemInHand());
	        if(a != null) {
	        	Block block = e.getBlock();
	        	block.setType(a.getMaterial());
	        	MultipleFacing multiFacing = (MultipleFacing) e.getBlock().getBlockData();
	        	for(BlockFace face : Custom.faces) {
	        		multiFacing.setFace(face, a.getBlockFace(face));
	            	}
	        	block.setBlockData(multiFacing);
	        	}
        }else if(m.equals(Material.REDSTONE_WIRE) && isMushroom(e.getBlock().getRelative(BlockFace.DOWN).getType())) {
        	e.setCancelled(true);
        }
        
    }
	
	
	
	public boolean isMushroom(Material m) {
		if(m.equals(Material.BROWN_MUSHROOM_BLOCK) || m.equals(Material.RED_MUSHROOM_BLOCK) || m.equals(Material.MUSHROOM_STEM)) return true;
		return false;
	}
	
	public void updateclient(Block block, Collection<Entity> collection) {
		if(collection == null) {
			return;	
		}
		Set<Block> e = getConnectedblocks(block);
		
		for(Block b : e)
			for(Entity entity : collection) {
				if(entity instanceof Player)
					((Player) entity).sendBlockChange(b.getLocation(), b.getBlockData());
			}
	}
	public void updateclient(Block block, Player collection) {
		if(collection == null) {
			return;	
		}
		Set<Block> e = getConnectedblocks(block);
		
		for(Block b : e)
			collection.sendBlockChange(b.getLocation(), b.getBlockData());
	}
	
	private void getConnectedblocks(Block block, Set<Block> results, List<Block> todo) {
	    Set<Block> result = results;
	    for(BlockFace face : Custom.faces) {
	        Block b = block.getRelative(face);
	        if(b.getType() == block.getType()) {
	            if(result.add(b)) {
	                todo.add(b);
	            }
	        }
	    }
	}
	
    public Set<Block> getConnectedblocks(Block block) {
    	Set<Block> set = new HashSet<>();
	    LinkedList<Block> list = new LinkedList<>();
	    list.add(block);
	    while((block = list.poll()) != null) {
	        getConnectedblocks(block, set, list);
	    }
	    return set;
    }
}

