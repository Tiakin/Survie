package fr.tiakin.generation;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Tempsave implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player) {
			Player p = (Player) arg0;
			if(arg1.getName().equalsIgnoreCase("save")) {
				int x1 = Integer.parseInt(arg3[0]);
				int y1 = Integer.parseInt(arg3[1]);
				int z1 = Integer.parseInt(arg3[2]);
				int x2 = Integer.parseInt(arg3[3]);
				int y2 = Integer.parseInt(arg3[4]);
				int z2 = Integer.parseInt(arg3[5]);
				StructureUtil.save(new Location(p.getWorld(),x1,y1,z1), new Vector(x2, y2, z2), arg3[6], p.getName());
					
			}
		}
		return false;
	}

}
