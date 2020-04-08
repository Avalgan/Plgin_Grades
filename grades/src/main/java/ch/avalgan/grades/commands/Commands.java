package ch.avalgan.grades.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (label.equalsIgnoreCase("gd")) {
			if (args.length !=2) {
				sender.sendMessage("Mauvaise utilisation,/gd <Grade> <Player>");
			} 
		if (sender instanceof Player) {
			if (player.hasPermission("gd.use")) {
				
			}
		}
		}
		return false;
	}

}
