package fr.tiakin.generation;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;
import org.bukkit.util.Vector;

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
    
    
    public static boolean load(Location origin, String name) {
        BlockPosition originPos = new BlockPosition(origin.getBlockX(), origin.getBlockY(), origin.getBlockZ());
        BlockPosition originPos2 = new BlockPosition(origin.getBlockX()+48, origin.getBlockY()+48, origin.getBlockZ()+48);
        WorldServer world = ((CraftWorld) origin.getWorld()).getHandle();
        //MinecraftServer server = world.getMinecraftServer();
        DefinedStructureManager structureManager = world.p();
        DefinedStructure structure = structureManager.b(new MinecraftKey(name)).get();
        if (structure == null) {
            return false;
        } else {
            DefinedStructureInfo structureInfo = (new DefinedStructureInfo()).a(EnumBlockMirror.a).a(EnumBlockRotation.a).a(false).c(true);
            //structure.a(world, originPos, structureInfo);
            structure.a(world, originPos, originPos2, structureInfo, new Random(origin.getWorld().getSeed()), 2);
            return true;
        }
    }
}
