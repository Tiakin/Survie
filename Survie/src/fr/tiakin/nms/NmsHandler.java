package fr.tiakin.nms;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.entity.Player;

import fr.tiakin.block.Blocks;
import fr.tiakin.item.Tool;
import fr.tiakin.main.Custom;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;

public class NmsHandler {

	//
	// S/O to Kapstok and TheDarkSword for the tutorial to create a custom breaking system, I have personally made a lot improvement and change.
	//
	
    public static void sendBreakPacket(int animation, Block block) {
        ((CraftServer) Bukkit.getServer()).getHandle().a(null, block.getX(), block.getY(), block.getZ(), 120,
                ((CraftWorld) block.getWorld()).getHandle().aa(), new PacketPlayOutBlockBreakAnimation(getBlockEntityId(block), getBlockPosition(block), animation));
    }

    public static void sendBreakBlock(Player player, Block block) {
        player.breakBlock(block);
        
    }

    public static void playBlockSound(Block block) {
    	
    	block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, Tool.getSound(block));
    	
    }
    public static void place(Location loc, Blocks block) {
    	BlockPosition bp = new BlockPosition(loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
		((CraftWorld) loc.getWorld()).getHandle().l(bp).a(bp, Custom.createCustomBlock(block), true);
		
    }
    //getX getY getZ
    public static Location getLocation(BlockPosition block, World w) {
    	
		return new Location(w,block.u(),block.v(),block.w());
		
    }
    private static BlockPosition getBlockPosition(Block block){
        return new BlockPosition(block.getX(), block.getY(), block.getZ());
    }
    private static int getBlockEntityId(Block block){
        return ((block.getX() & 0xFFF) << 20 | (block.getZ() & 0xFFF) << 8) | (block.getY() & 0xFF);
    }
}
