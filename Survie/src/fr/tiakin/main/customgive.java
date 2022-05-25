package fr.tiakin.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
					 p.sendMessage("§c/customgive [block/item] [nom de l'item/block] (nombre)");
					 p.sendMessage("§4-------");
				 }else {
					 if(args[0].equalsIgnoreCase("block")) {
						 Blocks block = Blocks.valueOf(args[1]);
							if(block != null) {
								ItemStack is = block.getItemStack().clone();
								if(args.length == 3) {
									int count = Integer.parseInt(args[2]);
									is = Custom.multi(is, count);
								}
								p.getInventory().addItem(is);
							}
					 }else if(args[0].equalsIgnoreCase("item")) {
						 Items item = Items.valueOf(args[1]);
							if(item != null) {
								ItemStack is = item.getItemStack().clone();
								if(args.length == 3) {
									int count = Integer.parseInt(args[2]);
									is = Custom.multi(is, count);
								}
								p.getInventory().addItem(is);
							}
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
							if(b.name().startsWith(args[1]) || args[1].isBlank())
								autoCompletes.add(b.name());
						}
					}else if(args[0].equalsIgnoreCase("item")) {
						for(Items b : Items.values()) {
							if(b.name().startsWith(args[1]) || args[1].isBlank())
								autoCompletes.add(b.name());
						}
					}
				}
			}
		}
		return autoCompletes;
	}

}
