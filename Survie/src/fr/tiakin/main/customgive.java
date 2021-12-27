package fr.tiakin.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import fr.tiakin.block.Blocks;
import fr.tiakin.item.Items;

public class customgive implements CommandExecutor,TabCompleter {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String msg, String[] args) {
		if(cs instanceof Player) {
			Player p = (Player) cs;
			if(p.isOp()) {
				 if(args.length < 2) {
					 p.sendMessage("§4-------");
					 p.sendMessage("§cErreur : la commande que vous avez rentrer n'est pas complète, faîtes :");
					 p.sendMessage("§c/customgive (block/item) (nom de l'item/block)");
					 p.sendMessage("§4-------");
				 }else {
					 if(args[0].equalsIgnoreCase("block")) {
						 Blocks block = Blocks.valueOf(args[1]);
							if(block != null)
								p.getInventory().addItem(block.getItemStack());
					 }else if(args[0].equalsIgnoreCase("item")) {
						 Items item = Items.valueOf(args[1]);
							if(item != null)
								p.getInventory().addItem(item.getItemStack());
					 }
				 }
			}
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender cs, Command cmd, String alias, String[] args) {
		List<String> autoCompletes = new ArrayList<>();
		if(cs instanceof Player) {
			Player p = (Player) cs;
			if(p.isOp()) {
				if (args.length == 1) { 
					autoCompletes.add("block");
					autoCompletes.add("item");
				} else if(args.length == 2) {
					if(args[0].equalsIgnoreCase("block")) {
						for(Blocks b : Blocks.values()) {
							autoCompletes.add(b.name());
						}
					}else if(args[0].equalsIgnoreCase("item")) {
						for(Items b : Items.values()) {
							autoCompletes.add(b.name());
						}
					}
				}
			}
		}
		return autoCompletes;
	}

}
