package fr.tiakin.generation;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.util.Vector;

import fr.tiakin.main.Main;
import net.minecraft.core.BaseBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EnumBlockMirror;
import net.minecraft.world.level.block.EnumBlockRotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.DefinedStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.DefinedStructureInfo;
import net.minecraft.world.level.levelgen.structure.templatesystem.DefinedStructureManager;

public class StructureUtil {
    
    public static boolean save(Location start, Vector size, String name, String author) {
        BlockPosition startPos = new BlockPosition(start.getBlockX(), start.getBlockY(), start.getBlockZ());
        BlockPosition sizePos = new BlockPosition(size.getBlockX(),size.getBlockY(),size.getBlockZ());
        WorldServer world = ((CraftWorld) start.getWorld()).getHandle();
        //MinecraftServer server = world.getMinecraftServer();
        DefinedStructureManager structureManager = world.p();
        DefinedStructure structure = structureManager.a(new MinecraftKey(name));
        structure.a(world, startPos, sizePos, true, Blocks.dj); // false -> do not includ entities, dj -> stucture void
        structure.a(author);
        
        return structureManager.c(new MinecraftKey(name));
    }
    
    
    public static void register() {
    	LinkedList<File> list = new LinkedList<>();
		list.add(new File("world/generated/minecraft/structures/arbre1.nbt"));
		list.add(new File("world/generated/minecraft/structures/arbre2.nbt"));
		list.add(new File("world/generated/minecraft/structures/arbre3.nbt"));
		list.add(new File("world/generated/minecraft/structures/arbre4.nbt"));
		list.add(new File("world/generated/minecraft/structures/lac1.nbt"));
		list.add(new File("world/generated/minecraft/structures/lac2.nbt"));
		list.add(new File("world/generated/minecraft/structures/lac3.nbt"));
		list.add(new File("world/generated/minecraft/structures/lavalac1.nbt"));
		list.add(new File("world/generated/minecraft/structures/lavalac2.nbt"));
		list.add(new File("world/generated/minecraft/structures/lavalac3.nbt"));
		for(File file : list) {
			if (!file.exists()){
				try {
					file.getParentFile().mkdirs();
					FileUtils.copyURLToFile(Main.class.getResource("/src/resources/structures/"+file.getName()), file);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
		}
    }
    
    
    public static boolean load(Location origin, String name,boolean centered) {
        BlockPosition originPos = new BlockPosition(origin.getBlockX(), origin.getBlockY(), origin.getBlockZ());
        	
        WorldServer world = ((CraftWorld) origin.getWorld()).getHandle();
        DefinedStructureManager structureManager = world.p();
        DefinedStructure structure = structureManager.b(new MinecraftKey(name)).get();
        if (structure == null) {
            return false;
        } else {
            DefinedStructureInfo structureInfo = (new DefinedStructureInfo()).a(EnumBlockMirror.a).a(EnumBlockRotation.a).a(false).c(true);
            BaseBlockPosition BBP = structure.a();
            BlockPosition originPos2 = new BlockPosition(origin.getBlockX()+BBP.u(), origin.getBlockY()+BBP.v(), origin.getBlockZ()+BBP.w());
            if(centered) {
            	originPos = new BlockPosition(origin.getBlockX()-(int) (BBP.u()/2), origin.getBlockY(), origin.getBlockZ()-(int) (BBP.w()/2));
            	originPos2 = new BlockPosition(origin.getBlockX()+(int) (BBP.u()/2), origin.getBlockY()+BBP.v(), origin.getBlockZ()+(int) (BBP.w()/2));
            }
            final BlockPosition foriginPos = originPos;
            final BlockPosition foriginPos2 = originPos2;
            Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> structure.a(world, foriginPos, foriginPos2, structureInfo, new Random(origin.getWorld().getSeed()), 2));
            return true;
        }
    }
    
    public static BaseBlockPosition getSize(World w,String name) {
        	
        WorldServer world = ((CraftWorld) w).getHandle();
        DefinedStructureManager structureManager = world.p();
        DefinedStructure structure = structureManager.b(new MinecraftKey(name)).get();
        if (structure == null) {
            return null;
        } else {
            BaseBlockPosition BBP = structure.a();
            return BBP;
        }
    }
}
