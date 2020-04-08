package ch.avalgan.grades.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class SQLConnection {
	private Connection connection;
	private String urlbase, host, database, user, password, port;

	public SQLConnection(String urlbase, String host, String port, String database, String user, String password) {
		this.urlbase = urlbase;
		this.host = host;
		this.database = database;
		this.user = user;
		this.password = password;
		this.port = port;
	}

	public void connection() {
		if (!isConnected()) {

			try {
				connection = DriverManager.getConnection(urlbase + host + port + "/" + database, user, password);
				System.out.println("BDD connectee");
			} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
				e.printStackTrace();
			}

		}
	}

	public void disconnect() {
		if (isConnected()) {
			try {
				connection.close();
				System.out.println("La base de donnee a ete deconnectee");
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
				e.printStackTrace();
			}
		}
	}

	public boolean isConnected() {
		return connection != null;
	}

	public void createGrade(Player target, String grade) {
		try {
			// Préparation de la requête
			PreparedStatement q = connection.prepareStatement("INSERT INTO info(joueur, grade) VALUES (?,?)");

			// remplacement des ? par les valeurs
			q.setString(1, target.getUniqueId().toString());
			q.setString(2, grade);
			// execution
			q.execute();

			// fermeture
			q.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getGrades(Player joueur) {
		String raisons = "Aucune info !";
		try {
			PreparedStatement q = connection.prepareStatement("SELECT`grade` FROM `info` WHERE `joueur` = ?");
			q.setString(1, joueur.getUniqueId().toString());

			raisons = "";
			ResultSet rs = q.executeQuery();
			while (rs.next()) {
				raisons = raisons + rs.getString("grade") + ", ";
				System.out.println(rs.getString("grade"));
			}

			q.close();

			if (raisons.equalsIgnoreCase("")) {
				raisons = "Aucune info !";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return raisons;
	}

	public void deleteReport(Player player) {
		try {
			PreparedStatement q = connection.prepareStatement("DELETE FROM `info` WHERE `joueur` = ?");
			q.setString(1, player.getUniqueId().toString());
			q.executeUpdate();
			q.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
