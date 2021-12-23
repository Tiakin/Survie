package fr.tiakin.generation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tempload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player) {
			Player p = (Player) arg0;
			if(arg1.getName().equalsIgnoreCase("load")) {
				if(arg3.length == 1) {
					StructureUtil.load(p.getLocation(), arg3[0],false);
				}else {
					if(arg3[1].equalsIgnoreCase("centered"))
						StructureUtil.load(p.getLocation(), arg3[0],true);
				}
				
			}
		}
		return false;
	}

}
