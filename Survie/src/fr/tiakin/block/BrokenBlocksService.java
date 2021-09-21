package fr.tiakin.block;

import java.util.HashMap;
import java.util.stream.Stream;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class BrokenBlocksService {
	private static HashMap<Location, BrokenBlock> brokenBlocks = new HashMap<>();
	
    public void createBrokenBlock(Block block){
        createBrokenBlock(block, -1,null);
    }
    
    
    public void createBrokenBlock(Block block, float f, Stream<Block> stream){
        if(isBrokenBlock(block.getLocation())) return;
        BrokenBlock brokenBlock;
        if(f == -1) brokenBlock = new BrokenBlock(block, 0, stream);
        else brokenBlock = new BrokenBlock(block, f, stream);
        brokenBlocks.put(block.getLocation(), brokenBlock);
    }

    public static void removeBrokenBlock(Location location){
        brokenBlocks.remove(location);
    }
    
    
    public BrokenBlock getBrokenBlock(Location location){
        createBrokenBlock(location.getBlock());
        return brokenBlocks.get(location);
    }

    public boolean isBrokenBlock(Location location){
        return brokenBlocks.containsKey(location);
    }

	public static HashMap<Location, BrokenBlock> getBrokenBlocks() {
		return brokenBlocks;
	}
}
