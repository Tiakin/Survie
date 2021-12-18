package fr.tiakin.main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.craftbukkit.v1_18_R1.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiakin.block.AbortBreakingBlockEvent;
import fr.tiakin.block.BreakListeners;
import fr.tiakin.block.BrokenBlocksService;
import fr.tiakin.block.blocks;
import fr.tiakin.damage.damageEvent;
import fr.tiakin.generation.chaosBiome;
import fr.tiakin.generation.tempload;
import fr.tiakin.generation.tempsave;
import fr.tiakin.item.Tool;
import fr.tiakin.item.items;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.network.protocol.game.PacketPlayInBlockDig;
import net.minecraft.network.protocol.game.PacketPlayInBlockDig.EnumPlayerDigType;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.SeededRandom;
import net.minecraft.world.level.levelgen.synth.NoiseGenerator3Handler;

public class main extends JavaPlugin implements Listener{
	public static BrokenBlocksService brokenBlocksService = new BrokenBlocksService();
	
	Advancements advancement = new Advancements();
	
	public void onEnable(){
		getLogger().info("c lancer");
		try {
			chaosBiome.create();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new Custom(), this);
		Bukkit.getPluginManager().registerEvents(new BreakListeners(), this);
		Bukkit.getPluginManager().registerEvents(new damageEvent(), this);
		Bukkit.getPluginManager().registerEvents(advancement, this);
		getCommand("save").setExecutor(new tempsave());
		getCommand("load").setExecutor(new tempload());
		mineableaxe();
		Timer timer = new Timer();
		timer.runTaskTimerAsynchronously(this, 0, 2l);
		Custom.customrecipe();
		advancement.loadAdvancements();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			Custom.discoverrecipe(p.getPlayer());
			injectPlayer(p.getPlayer());
			getLogger().info("player ciblé");
		}
	}
	
	private void mineableaxe() {
		File tagblock = new File("world/datapacks/bukkit/data/minecraft/tags/blocks/mineable/axe.json");
        if (!tagblock.exists()){
        	try {
        		tagblock.getParentFile().mkdirs();
				Files.copy(main.class.getClassLoader().getResourceAsStream("resources/axe.json"), tagblock.toPath());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

	public void onDisable() {
		getLogger().info("c stop");
		for(Player p : Bukkit.getOnlinePlayers()) {
			removePlayer(p.getPlayer());
			getLogger().info("player retirer");
		}
	}
	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		String[] message = e.getMessage().split(" ");
		if(message[0].equalsIgnoreCase("item")) {
			items item = items.valueOf(message[1]);
			if(item != null)
				e.getPlayer().getInventory().addItem(item.getItemStack());
		} else if(message[0].equalsIgnoreCase("block")) {
			blocks block = blocks.valueOf(message[1]);
			if(block != null)
				e.getPlayer().getInventory().addItem(block.getItemStack());
		} else if(message[0].equalsIgnoreCase("setbiome")) {
			chaosBiome.setBiome(message[1],e.getPlayer().getWorld().getChunkAt(new Location(e.getPlayer().getWorld(), Integer.parseInt(message[2]) , 0 , Integer.parseInt(message[3]) )));
		}
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Custom.discoverrecipe(e.getPlayer());
		injectPlayer(e.getPlayer());
	}
	
	@EventHandler
    public void chunkLoad(ChunkLoadEvent e){
		SeededRandom tr = new SeededRandom(new LegacyRandomSource(e.getWorld().getSeed()));
		tr.b(17292);
		if(e.getWorld().getEnvironment().equals(Environment.THE_END)) {
			
			NoiseGenerator3Handler islandnoise = new net.minecraft.world.level.levelgen.synth.NoiseGenerator3Handler(tr);
			
			chaosBiome.generateBiome(e.getChunk(),islandnoise);
			if(e.isNewChunk()) {
				for (int x = 0; x <= 15; x++) {
					for (int z = 0; z <= 15; z++) {
						int i = (e.getChunk().getX() * 16 + x) >> 2;
				      	int j = (e.getChunk().getZ() * 16 + z) >> 2;
						Block b = Custom.gethighestendstone(e.getWorld(),e.getChunk().getX() * 16 + x, e.getChunk().getZ() * 16 + z);
						if(b != null) {
							if(i*i + j*j > 4096L) {
								if(net.minecraft.world.level.biome.WorldChunkManagerTheEnd.a(islandnoise, i*2 + 1, j*2 + 1) > 40) {
									b.setBlockData(CraftBlockData.fromData(Custom.createCustomBlock(blocks.chaos_nylium)));
								}
							}
							
							if(tr.nextInt(128) == 0) {
								int down = tr.nextInt(20);
								if(b.getY() - down >= 0) {
									b = b.getRelative(BlockFace.DOWN, down);
									if(Custom.materialsWhitelist(b.getType()))
										b.setBlockData(CraftBlockData.fromData(Custom.createCustomBlock(blocks.enderite_ore)));
									for (int n = 0; n <= 1; n++) {
										int luck = tr.nextInt(5);
										if(luck == 0) {
											Block tb = b.getRelative(tr.nextInt(3)-1, tr.nextInt(2), tr.nextInt(3)-1);
											if(Custom.materialsWhitelist(tb.getType()))
												tb.setBlockData(CraftBlockData.fromData(Custom.createCustomBlock(blocks.enderite_ore)));
										}
									}
								}
							}
						}
			        }
				}
			}
		}else if(e.getWorld().getEnvironment().equals(Environment.NORMAL)) {
			if(e.isNewChunk()) {
				for (int x = 0; x <= 15; x++) {
					for (int z = 0; z <= 15; z++) {
						if(tr.nextInt(200) == 0) {
							Block b = new Location(e.getWorld(),e.getChunk().getX() * 16 + x,tr.nextInt(20)-60, e.getChunk().getZ() * 16 + z).getBlock();
							if(Custom.materialsWhitelist(b.getType()))
								b.setBlockData(CraftBlockData.fromData(Custom.createCustomBlock(blocks.discordium_ore)));
							for (int n = 0; n <= 2; n++) {
								int luck = tr.nextInt(5);
								if(luck == 0) {
									Block tb = b.getRelative(tr.nextInt(3)-1, tr.nextInt(2), tr.nextInt(3)-1);
									if(Custom.materialsWhitelist(tb.getType()))
									tb.setBlockData(CraftBlockData.fromData(Custom.createCustomBlock(blocks.discordium_ore)));
								}
							}
						}else if(tr.nextInt(200) == 0) {
							Block b = new Location(e.getWorld(),e.getChunk().getX() * 16 + x,tr.nextInt(40)-40, e.getChunk().getZ() * 16 + z).getBlock();
							if(Custom.materialsWhitelist(b.getType()))
								b.setBlockData(CraftBlockData.fromData(Custom.createCustomBlock(blocks.cobalt_ore)));
							for (int n = 0; n <= 6; n++) {
								int luck = tr.nextInt(5);
								if(luck == 0) {
									Block tb = b.getRelative(tr.nextInt(3)-1, tr.nextInt(2), tr.nextInt(3)-1);
									if(Custom.materialsWhitelist(tb.getType()))
									tb.setBlockData(CraftBlockData.fromData(Custom.createCustomBlock(blocks.cobalt_ore)));
								}
							}
						}
					}
				}
			}
		}
		
	}
	
	@EventHandler
    public void onleave(PlayerQuitEvent e){
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
                	Bukkit.getScheduler().runTask(getPlugin(main.class), () -> Bukkit.getPluginManager().callEvent(event));
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
            updateclient(e.getBlock(), e.getBlock().getWorld().getNearbyEntities(e.getBlock().getLocation(), 50, 50, 50));
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
        }else if(m.equals(Material.PLAYER_HEAD) || m.equals(Material.PLAYER_WALL_HEAD)) {
        	blocks a = Custom.getCustomBlock(e.getItemInHand());
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

