package ch.avalgan.grades.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.avalgan.grades.grade.PluginGrades;
import ch.avalgan.grades.utils.SQLConnection;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		SQLConnection sql = PluginGrades.getInstance().sql;
		if (label.equalsIgnoreCase("gd")) {
			if (args.length != 2) {
				sender.sendMessage("Mauvaise utilisation,/gd <Grade> <Player>");
			}
			if (sender instanceof Player) {
				if (player.hasPermission("gd.use")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) {
						if (args[0].equalsIgnoreCase("militaire")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " militaire");
							if (!sql.getGrades(target).equalsIgnoreCase("militaire")) {
								target.sendMessage("Vous avez été unranked!");
							}
							sql.deleteReport(target);
							sql.createGrade(target, "militaire");
						}
						if (args[0].equalsIgnoreCase("soldat")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " soldat");
						}
						if (args[0].equalsIgnoreCase("caporal")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " caporal");
						}
						if (args[0].equalsIgnoreCase("major")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " major");
						}
						if (args[0].equalsIgnoreCase("colonel")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " colonel");
						}
						if (args[0].equalsIgnoreCase("general")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " general");
						}
						if (args[0].equalsIgnoreCase("guide")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " guide");
						}
						if (args[0].equalsIgnoreCase("streamer")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " streamer");
						}
					} else {
						player.sendMessage("Ce joueur n'est pas en ligne! || Ou n'existe pas!");
					}
				} else {
					player.sendMessage("Vous n'avez pas la permission!");
				}
			} else {
				Player target = Bukkit.getPlayer(args[1]);
				if (target != null) {
					if (args[0].equalsIgnoreCase("militaire")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " militaire");
					}
					if (args[0].equalsIgnoreCase("soldat")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " soldat");
					}
					if (args[0].equalsIgnoreCase("caporal")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " caporal");
					}
					if (args[0].equalsIgnoreCase("major")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " major");
					}
					if (args[0].equalsIgnoreCase("colonel")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " colonel");
					}
					if (args[0].equalsIgnoreCase("general")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " general");
					}
					if (args[0].equalsIgnoreCase("guide")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " guide");
					}
					if (args[0].equalsIgnoreCase("streamer")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " streamer");
					}
				} else {
					sender.sendMessage("Ce joueur n'est pas en ligne! || Ou n'existe pas!");
				}
			}
		}
		return false;
	}

}
