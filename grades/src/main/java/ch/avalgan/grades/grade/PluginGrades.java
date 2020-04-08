package ch.avalgan.grades.grade;

import org.bukkit.plugin.java.JavaPlugin;

import ch.avalgan.grades.commands.Commands;

public class PluginGrades extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Lancement du plugin Grades Avalgan!");
		getCommand("gd").setExecutor(new Commands());
	}

	@Override
	public void onDisable() {
		System.out.println("BYEBYE");
	}

}
