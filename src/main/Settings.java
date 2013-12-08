package main;

import java.sql.DriverManager;
/**
 * Global project settings used for DigiPass
 * @author aeilim
 *
 */
public class Settings {
	public static String dbUrl = "jdbc:mysql://localhost/";
	public static String dbName = "digipass";
	public static String dbDriver = "com.mysql.jdbc.Driver";
	public static String dbUserName = "root";
	public static String dbPassword = "";
}