package ch.avalgan.grades.grade;

import org.bukkit.plugin.java.JavaPlugin;

import ch.avalgan.grades.commands.Commands;
import ch.avalgan.grades.utils.SQLConnection;

public class PluginGrades extends JavaPlugin {
	public SQLConnection sql;
private static PluginGrades instance;
//code
//onenable{
	@Override
	public void onEnable() {
		sql = new SQLConnection("jdbc:mysql://", "avalgan.ch", ":3306", "gd", "verif", "plugin");
		sql.connection();
		System.out.println("Lancement du plugin Grades Avalgan!");
		getCommand("gd").setExecutor(new Commands());
	}

	@Override
	public void onDisable() {
		System.out.println("BYEBYE");
	}

	public static PluginGrades getInstance() {
		return instance;
	}

}
