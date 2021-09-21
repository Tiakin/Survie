package fr.tiakin.block;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;

public class AbortBreakingBlockEvent extends Event {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private BlockPosition blockPos;
    private EnumDirection facingDirection;
    private Player player;
    
    public AbortBreakingBlockEvent(BlockPosition blockPos, EnumDirection facingDirection, Player player) {
    	this.blockPos = blockPos;
    	this.facingDirection = facingDirection;
    	this.player = player;
	}

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public BlockPosition getBlockPosition() {
        return blockPos;
    }

    public EnumDirection getEnumDirection() {
        return facingDirection;
    }

    public Player getPlayer() {
        return player;
    }
}
