package fr.tiakin.generation;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.util.noise.SimplexNoiseGenerator;

import net.minecraft.core.BlockPosition;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.IRegistryWritable;
import net.minecraft.core.RegistryMaterials;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.World;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.BiomeFog;
import net.minecraft.world.level.biome.BiomeFog.GrassColor;
import com.mojang.serialization.Lifecycle;

import fr.tiakin.main.Custom;
import fr.tiakin.main.Main;

public class ChaosBiome {
	
	
	// S/o Kapstok
	
	static Server server = Bukkit.getServer();
	static CraftServer craftserver = (CraftServer)server;
	static DedicatedServer dedicatedserver = craftserver.getServer();
	
	@SuppressWarnings("unchecked")
	public static void create() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		 RegistryMaterials<BiomeBase> materials = ((RegistryMaterials<BiomeBase>) dedicatedserver.aV().b(Registries.ap));
         Field isFrozen = materials.getClass().getDeclaredField("bL");
         isFrozen.setAccessible(true);
         isFrozen.set(materials, false);
         
		ResourceKey<BiomeBase> newKey = ResourceKey.a(Registries.ap, new MinecraftKey("survie", "chaos"));
		
		ResourceKey<BiomeBase> oldKey = ResourceKey.a(Registries.ap, new MinecraftKey("minecraft", "end_highlands"));
		IRegistryWritable<BiomeBase> registrywritable = (IRegistryWritable<BiomeBase>) dedicatedserver.aV().b(Registries.ap);
		BiomeBase oldbiome = registrywritable.a(oldKey);
		BiomeBase.a newBiome = new BiomeBase.a();
		newBiome.a(oldbiome.c()); //precipitation
		newBiome.a(BiomeBase.TemperatureModifier.a); //BiomeBase.TemperatureModifier.a = normal
		newBiome.a(oldbiome.e()); //setting generation
		newBiome.a(oldbiome.b()); //setting mob
		newBiome.a(oldbiome.i()); //temperature
		
		BiomeFog.a newFog = new BiomeFog.a();
		newFog.a(GrassColor.a); //je sais pas frere(obligé)
		
		int darkRed = Integer.parseInt("983D21",16); 
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
		
		((IRegistryWritable<BiomeBase>) dedicatedserver.aV().b(Registries.ap)).a(newKey, newBiome.a(), Lifecycle.stable());
		
		isFrozen.set(materials, true); 
	}
	@SuppressWarnings("unchecked")
	public static BiomeBase getbase(String newBiomeName) {
		BiomeBase base;
        IRegistryWritable<BiomeBase> registrywritable = (IRegistryWritable<BiomeBase>) dedicatedserver.aV().b(Registries.ap);
   
        ResourceKey<BiomeBase> rkey = ResourceKey.a(Registries.ap, new MinecraftKey(newBiomeName.toLowerCase()));
        base = registrywritable.a(rkey);
        if(base == null) {
            if(newBiomeName.contains(":")) {
                ResourceKey<BiomeBase> newrkey = ResourceKey.a(Registries.ap, new MinecraftKey(newBiomeName.split(":")[0].toLowerCase(), newBiomeName.split(":")[1].toLowerCase()));
                base = registrywritable.a(newrkey);
                if(base == null) {
                    return null;
                }
            } else {
                return null;
            }
        }
        return base;
	}
	
	public static boolean setBiome(String newBiomeName, Chunk c) {
   
        BiomeBase base = getbase(newBiomeName);
        
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
 
    private static void setBiome(int x, int y, int z, World w, BiomeBase bb) {
          BlockPosition pos = new BlockPosition(x, 0, z);
          if (w.o(pos)) {
             net.minecraft.world.level.chunk.Chunk chunk = w.l(pos);
             if (chunk != null) {
                chunk.setBiome(x >> 2, y >> 2, z >> 2, Holder.a(bb));
                
             }
          }
      }

    private static void refreshChunksForAll(Chunk chunk) {
    	chunk.unload();
    	chunk.load();
    }
    
    
    
	public static void generateBiome(Chunk chunk, SimplexNoiseGenerator noise) {
		World w = ((CraftWorld)chunk.getWorld()).getHandle();
		for (int x = 0; x <= 15; x++) {
            for (int z = 0; z <= 15; z++) {
            	int i = chunk.getX() * 16 + x;
            	int j = chunk.getZ() * 16 + z;
            	int i2 = i >> 2;
            	int j2 = j >> 2;
            	if(i2*i2 + j2*j2 > 4096L) {
            		if(Custom.noise(noise,i2*2+1, j2*2+1) > 0) {
            			for(int y = 0; y <= chunk.getWorld().getMaxHeight(); y++) {
            				setBiome(i, y, j, w, getbase("survie:chaos"));
            			}
                	}
            	}
            }
		}
		
		Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> refreshChunksForAll(chunk));
	}
        
}
