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
							return true;
						}
						if (args[0].equalsIgnoreCase("soldat")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " soldat");
							if (sql.getGrades(target).equalsIgnoreCase("millitaire")) {
								target.sendMessage("Vous avez été promu!");
							} else {
								target.sendMessage("Vous avez été unrank !");
							}
							sql.deleteReport(target);
							sql.createGrade(target, "soldat");
							return true;
						}
						if (args[0].equalsIgnoreCase("caporal")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " caporal");
							if (sql.getGrades(target).equalsIgnoreCase("militaire")
									|| sql.getGrades(target).equalsIgnoreCase("soldat")) {
								target.sendMessage("Vous avez été promu !");
							} else {
								target.sendMessage("Vous avez été unrank !");
							}
							sql.deleteReport(target);
							sql.createGrade(target, "caporal");
							return true;
						}
						if (args[0].equalsIgnoreCase("major")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " major");
							if (sql.getGrades(target).equalsIgnoreCase("colonel")
									|| sql.getGrades(target).equalsIgnoreCase("general")) {
								target.sendMessage("Vous avez été unrank !");
							} else {
								target.sendMessage("Vous avez été promu !");
							}
							sql.deleteReport(target);
							sql.createGrade(target, "major");
							return true;
						}
						if (args[0].equalsIgnoreCase("colonel")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " colonel");
							if (sql.getGrades(target).equalsIgnoreCase("general")) {
								target.sendMessage("vous avez été unrank !");
							} else {
								target.sendMessage("Vous avez été promu !");
							}
							sql.deleteReport(target);
							sql.createGrade(target, "colonel");
							return true;
						}
						if (args[0].equalsIgnoreCase("general")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " general");
							target.sendMessage("Vous avez été promu général !");
							sql.deleteReport(target);
							sql.createGrade(target, "general");
							return true;
						}

						if (args[0].equalsIgnoreCase("guide")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " guide");
							sql.deleteReport(target);
							sql.createGrade(target, "guide");
							return true;
						}
						if (args[0].equalsIgnoreCase("streamer")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"manuadd " + target.getName() + " streamer");
							target.sendMessage(
									"Vous avez atteint l'objectif pour etre reconnu comme streamer/youtuber sur le serveur !");
							sql.deleteReport(target);
							sql.createGrade(target, "streamer");
							return true;
						}
						player.sendMessage("Ce grade n'est pas valide");
						return false;
					} else {
						player.sendMessage("Ce joueur n'est pas en ligne! || Ou n'existe pas!");
						return false;
					}
				} else {
					player.sendMessage("Vous n'avez pas la permission!");
					return false;
				}
			} else {
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
						return true;
					}
					if (args[0].equalsIgnoreCase("soldat")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"manuadd " + target.getName() + " soldat");
						if (sql.getGrades(target).equalsIgnoreCase("millitaire")) {
							target.sendMessage("Vous avez été promu!");
						} else {
							target.sendMessage("Vous avez été unrank !");
						}
						sql.deleteReport(target);
						sql.createGrade(target, "soldat");
						return true;
					}
					if (args[0].equalsIgnoreCase("caporal")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"manuadd " + target.getName() + " caporal");
						if (sql.getGrades(target).equalsIgnoreCase("militaire")
								|| sql.getGrades(target).equalsIgnoreCase("soldat")) {
							target.sendMessage("Vous avez été promu !");
						} else {
							target.sendMessage("Vous avez été unrank !");
						}
						sql.deleteReport(target);
						sql.createGrade(target, "caporal");
						return true;
					}
					if (args[0].equalsIgnoreCase("major")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " major");
						if (sql.getGrades(target).equalsIgnoreCase("colonel")
								|| sql.getGrades(target).equalsIgnoreCase("general")) {
							target.sendMessage("Vous avez été unrank !");
						} else {
							target.sendMessage("Vous avez été promu !");
						}
						sql.deleteReport(target);
						sql.createGrade(target, "major");
						return true;
					}
					if (args[0].equalsIgnoreCase("colonel")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"manuadd " + target.getName() + " colonel");
						if (sql.getGrades(target).equalsIgnoreCase("general")) {
							target.sendMessage("vous avez été unrank !");
						} else {
							target.sendMessage("Vous avez été promu !");
						}
						sql.deleteReport(target);
						sql.createGrade(target, "colonel");
						return true;
					}
					if (args[0].equalsIgnoreCase("general")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"manuadd " + target.getName() + " general");
						target.sendMessage("Vous avez été promu général !");
						sql.deleteReport(target);
						sql.createGrade(target, "general");
						return true;
					}

					if (args[0].equalsIgnoreCase("guide")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + target.getName() + " guide");
						sql.deleteReport(target);
						sql.createGrade(target, "guide");
						return true;
					}
					if (args[0].equalsIgnoreCase("streamer")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"manuadd " + target.getName() + " streamer");
						target.sendMessage(
								"Vous avez atteint l'objectif pour etre reconnu comme streamer/youtuber sur le serveur !");
						sql.deleteReport(target);
						sql.createGrade(target, "streamer");
						return true;
					}
					sender.sendMessage("Ce grade n'est pas valide !");
					return false;
				} else {
					player.sendMessage("Ce joueur n'est pas en ligne! || Ou n'existe pas!");
					return false;
				}
			}
		}
		return false;
	}

}
