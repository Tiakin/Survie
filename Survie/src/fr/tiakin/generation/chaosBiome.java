package fr.tiakin.generation;

import java.lang.reflect.Field;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_17_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import net.minecraft.core.BlockPosition;
import net.minecraft.core.IRegistry;
import net.minecraft.core.IRegistryWritable;
import net.minecraft.network.protocol.game.PacketPlayOutMapChunk;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.World;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.BiomeFog;
import net.minecraft.world.level.biome.BiomeFog.GrassColor;
import net.minecraft.world.level.biome.BiomeSettingsGeneration;
import net.minecraft.world.level.biome.BiomeSettingsMobs;
import com.mojang.serialization.Lifecycle;

import fr.tiakin.main.main;

public class chaosBiome {
	
	static Server server = Bukkit.getServer();
	static CraftServer craftserver = (CraftServer)server;
	static DedicatedServer dedicatedserver = craftserver.getServer();
	
	public static void create() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		ResourceKey<BiomeBase> newKey = ResourceKey.a(IRegistry.aO, new MinecraftKey("survie", "chaos"));
		
		ResourceKey<BiomeBase> oldKey = ResourceKey.a(IRegistry.aO, new MinecraftKey("minecraft", "end_highlands"));
		IRegistryWritable<BiomeBase> registrywritable = dedicatedserver.getCustomRegistry().b(IRegistry.aO);
		BiomeBase endbiome = registrywritable.a(oldKey);
		
		BiomeBase.a newBiome = new BiomeBase.a();
		newBiome.a(endbiome.t());
		newBiome.a(endbiome.c());
	
		Field biomeSettingMobsField = BiomeBase.class.getDeclaredField("m");
		biomeSettingMobsField.setAccessible(true);
		BiomeSettingsMobs biomeSettingMobs = (BiomeSettingsMobs) biomeSettingMobsField.get(endbiome);
		newBiome.a(biomeSettingMobs);
	
		Field biomeSettingGenField = BiomeBase.class.getDeclaredField("l");
		biomeSettingGenField.setAccessible(true);
		BiomeSettingsGeneration biomeSettingGen = (BiomeSettingsGeneration) biomeSettingGenField.get(endbiome);
		newBiome.a(biomeSettingGen);
		
		newBiome.a(0.2F); //Depth of biome
		newBiome.b(0.05F); //Scale of biome
		newBiome.c(0.7F); //Temperature of biome
		newBiome.d(0.8F); //Downfall of biome
		newBiome.a(BiomeBase.TemperatureModifier.a); //BiomeBase.TemperatureModifier.a will make your biome normal, BiomeBase.TemperatureModifier.b will make your biome frozen
		
		BiomeFog.a newFog = new BiomeFog.a();
		newFog.a(GrassColor.a); //This doesn't affect the actual final grass color, just leave this line as it is or you will get errors
		
		int darkRed = Integer.parseInt("983D21",16); //Dont forget to remove the # in front of the hex color code
		int black = Integer.parseInt("260E06",16);
		//Necessary values; removing them will break your biome
		newFog.a(black); //fogcolor
		newFog.b(darkRed); //water color
		newFog.c(black); //water fog color
		newFog.d(black); //sky color

		//Unnecessary values; can be removed safely if you don't want to change them
		newFog.e(darkRed); //foliage color (leaves, fines and more)
		newFog.f(darkRed); //grass blocks color
		
		newBiome.a(newFog.a());
		
		dedicatedserver.getCustomRegistry().b(IRegistry.aO).a(newKey, newBiome.a(), Lifecycle.stable());
		
	}
	
	public static boolean setBiome(String newBiomeName, Chunk c) {
   
        BiomeBase base;
        IRegistryWritable<BiomeBase> registrywritable = dedicatedserver.getCustomRegistry().b(IRegistry.aO);
   
        ResourceKey<BiomeBase> rkey = ResourceKey.a(IRegistry.aO, new MinecraftKey(newBiomeName.toLowerCase()));
        base = registrywritable.a(rkey);
        if(base == null) {
            if(newBiomeName.contains(":")) {
                ResourceKey<BiomeBase> newrkey = ResourceKey.a(IRegistry.aO, new MinecraftKey(newBiomeName.split(":")[0].toLowerCase(), newBiomeName.split(":")[1].toLowerCase()));
                base = registrywritable.a(newrkey);
                if(base == null) {
                    return false;
                }
            } else {
                return false;
            }
        }
   
        World w = ((CraftWorld)c.getWorld()).getHandle();
   
        for (int x = 0; x <= 15; x++) {
            for (int z = 0; z <= 15; z++) {
                for(int y = 0; y <= c.getWorld().getMaxHeight(); y++) {
               
                    setBiome(c.getX() * 16 + x, y, c.getZ() * 16 + z, w, base);
                }
            }
        }
        refreshChunksForAll(c);
        return true;
    }

    public static boolean setBiome(String newBiomeName, Location l) {
        BiomeBase base;
        IRegistryWritable<BiomeBase> registrywritable = dedicatedserver.getCustomRegistry().b(IRegistry.aO);
   
        ResourceKey<BiomeBase> rkey = ResourceKey.a(IRegistry.aO, new MinecraftKey(newBiomeName.toLowerCase()));
        base = registrywritable.a(rkey);
        if(base == null) {
            if(newBiomeName.contains(":")) {
                ResourceKey<BiomeBase> newrkey = ResourceKey.a(IRegistry.aO, new MinecraftKey(newBiomeName.split(":")[0].toLowerCase(), newBiomeName.split(":")[1].toLowerCase()));
                base = registrywritable.a(newrkey);
                if(base == null) {
                    return false;
                }
            } else {
                return false;
            }
        }
   
        setBiome(l.getBlockX(), l.getBlockY(), l.getBlockZ(), ((CraftWorld)l.getWorld()).getHandle(), base);
        refreshChunksForAll(l.getChunk());
        return true;
    }
 
    private static void setBiome(int x, int y, int z, World w, BiomeBase bb) {
          BlockPosition pos = new BlockPosition(x, 0, z);
     
          if (w.isLoaded(pos)) {
       
             net.minecraft.world.level.chunk.Chunk chunk = w.getChunkAtWorldCoords(pos);
             if (chunk != null) {
           
                chunk.getBiomeIndex().setBiome(x >> 2, y >> 2, z >> 2, bb);
                chunk.markDirty();
             }
          }
      }

    private static void refreshChunksForAll(Chunk chunk) {
        net.minecraft.world.level.chunk.Chunk c = ((CraftChunk)chunk).getHandle();
        for (Player player : chunk.getWorld().getPlayers()) {
            if (player.isOnline()) {
                if((player.getLocation().distance(chunk.getBlock(0, 0, 0).getLocation()) < (Bukkit.getServer().getViewDistance() * 16))) {
                    ((CraftPlayer) player).getHandle().b.sendPacket(new PacketPlayOutMapChunk(c));
                }
            }
        }
    }
    
    
    public static void generateBiome(Chunk chunk) {
    	SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(chunk.getWorld().getSeed()), 8);
        generator.setScale(0.005D);
        int chunkX = chunk.getX();
        int chunkZ= chunk.getZ();
        JavaPlugin.getPlugin(main.class).getLogger().info(""+generator.noise(chunkX*16, chunkZ*16, 0.5D, 0.5D) +"AA"+ generator.noise(chunkX*16, chunkZ*16, 0.5D, 0.5D));
        if(generator.noise(chunkX*16, chunkZ*16, 0.5D, 0.5D) >= 0.68) {
        	JavaPlugin.getPlugin(main.class).getLogger().info("truc gen "+chunkX+" "+chunkZ);
        	//chaosBiome.setBiome("survie:chaos",chunk);
        }
        
    }
}
