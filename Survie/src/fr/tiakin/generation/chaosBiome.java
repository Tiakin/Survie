package fr.tiakin.generation;

import java.lang.reflect.Field;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_17_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.IRegistry;
import net.minecraft.core.IRegistryWritable;
import net.minecraft.data.worldgen.BiomeDecoratorGroups;
import net.minecraft.data.worldgen.StructureFeatures;
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
import net.minecraft.world.level.levelgen.WorldGenStage;
import net.minecraft.world.level.levelgen.surfacebuilders.WorldGenSurface;
import net.minecraft.world.level.levelgen.surfacebuilders.WorldGenSurfaceComposite;
import net.minecraft.world.level.levelgen.surfacebuilders.WorldGenSurfaceConfigurationBase;
import net.minecraft.world.level.levelgen.synth.NoiseGenerator3Handler;
import com.mojang.serialization.Lifecycle;

import fr.tiakin.block.blocks;
import fr.tiakin.main.Custom;

public class chaosBiome {
	
	static Server server = Bukkit.getServer();
	static CraftServer craftserver = (CraftServer)server;
	static DedicatedServer dedicatedserver = craftserver.getServer();
	
	public static void create() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		ResourceKey<BiomeBase> newKey = ResourceKey.a(IRegistry.aO, new MinecraftKey("survie", "chaos"));
		
		ResourceKey<BiomeBase> oldKey = ResourceKey.a(IRegistry.aO, new MinecraftKey("minecraft", "end_highlands"));
		IRegistryWritable<BiomeBase> registrywritable = dedicatedserver.getCustomRegistry().b(IRegistry.aO);
		BiomeBase oldbiome = registrywritable.a(oldKey);
		BiomeBase.a newBiome = new BiomeBase.a();
		newBiome.a(oldbiome.t());
		newBiome.a(oldbiome.c());
		BiomeSettingsGeneration.a chaosGeneration = new BiomeSettingsGeneration.a();
		  //Custom.createCustomBlock(blocks.chaos_nylium)
		WorldGenSurfaceComposite<WorldGenSurfaceConfigurationBase> chaosSurface = WorldGenSurface.w.a(new WorldGenSurfaceConfigurationBase(Custom.createCustomBlock(blocks.chaos_nylium) , net.minecraft.world.level.block.Blocks.gg.getBlockData(), net.minecraft.world.level.block.Blocks.eq.getBlockData()));
		
		chaosGeneration.a(chaosSurface).a(StructureFeatures.q).a(WorldGenStage.Decoration.e, BiomeDecoratorGroups.b).a(WorldGenStage.Decoration.i, BiomeDecoratorGroups.d); //ok inch allah sa passe
		
		newBiome.a(chaosGeneration.a());
		
		Field biomeSettingMobsField = BiomeBase.class.getDeclaredField("m");
		biomeSettingMobsField.setAccessible(true);
		BiomeSettingsMobs biomeSettingMobs = (BiomeSettingsMobs) biomeSettingMobsField.get(oldbiome);
		newBiome.a(biomeSettingMobs);
		
		newBiome.a(0.2F); //Depth of biome
		newBiome.b(0.05F); //Scale of biome
		newBiome.c(0.7F); //Temperature of biome
		newBiome.d(0.8F); //Downfall of biome
		newBiome.a(BiomeBase.TemperatureModifier.a); //BiomeBase.TemperatureModifier.a will make your biome normal, BiomeBase.TemperatureModifier.b will make your biome frozen
		
		BiomeFog.a newFog = new BiomeFog.a();
		newFog.a(GrassColor.a); //je sais pas frere(obligé)
		
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
	public static BiomeBase getbase(String newBiomeName) {
		BiomeBase base;
        IRegistryWritable<BiomeBase> registrywritable = dedicatedserver.getCustomRegistry().b(IRegistry.aO);
   
        ResourceKey<BiomeBase> rkey = ResourceKey.a(IRegistry.aO, new MinecraftKey(newBiomeName.toLowerCase()));
        base = registrywritable.a(rkey);
        if(base == null) {
            if(newBiomeName.contains(":")) {
                ResourceKey<BiomeBase> newrkey = ResourceKey.a(IRegistry.aO, new MinecraftKey(newBiomeName.split(":")[0].toLowerCase(), newBiomeName.split(":")[1].toLowerCase()));
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
    
    
    
	public static void generateBiome(Chunk chunk, NoiseGenerator3Handler islandnoise) {
		World w = ((CraftWorld)chunk.getWorld()).getHandle();
		for (int x = 0; x <= 15; x++) {
            for (int z = 0; z <= 15; z++) {
            	int i = chunk.getX() * 16 + x;
            	int j = chunk.getZ() * 16 + z;
            	int i2 = i >> 2;
            	int j2 = j >> 2;
            	if(net.minecraft.world.level.biome.WorldChunkManagerTheEnd.a(islandnoise, i2*2+1, j2*2+1) > 50) {
            		for(int y = 0; y <= chunk.getWorld().getMaxHeight(); y++) {
                		setBiome(i, y, j, w, getbase("survie:chaos"));
                	}
                }
            }
		}
		refreshChunksForAll(chunk);
	}
        
}
