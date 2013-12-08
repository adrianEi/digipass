package main;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


import java.sql.*;

public class Main extends HttpServlet {

	public boolean populateSchema() throws ServletException {
		try {
			System.out.println("Populate Initial Data - Begin");
			Class.forName(Settings.dbDriver).newInstance();

			Connection conn = DriverManager.getConnection(Settings.dbUrl,
					Settings.dbUserName, Settings.dbPassword);

			conn = DriverManager.getConnection(
					Settings.dbUrl + Settings.dbName, Settings.dbUserName,
					Settings.dbPassword);

			Statement stmt = (Statement) conn.createStatement();

			String populateUserTypesTable = "INSERT INTO account_type (description) VALUES"
					+ "('Regular'),"
					+ "('Student'),"
					+ "('Pensioner'),"
					+ "('Handicapped');";

			String populateUsers = "INSERT INTO users (idpersonal, firstname, lastname, password, subscriptiondate, accounttype, balance) VALUES"
					+ "('012345678', 'David', 'Cohen', 'dcohen', '2013-01-01', '1', '350'),"
					+ "('300394780', 'Lilac', 'Orenshtein', 'lilac', '2013-01-01', '2', '200'),"
					+ "('032764785', 'Evyatar', 'Levi', 'evyatar', '2013-03-03', '3', '150');";

			stmt.execute(populateUserTypesTable);
			stmt.execute(populateUsers);
			System.out.println("Populate Initial Data - End");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean createSchema() throws ServletException {
		try {
			System.out.println("Schema Create - Begin");
			Class.forName(Settings.dbDriver).newInstance();

			Connection conn = DriverManager.getConnection(Settings.dbUrl,
					Settings.dbUserName, Settings.dbPassword);
			Statement s = (Statement) conn.createStatement();

			s.executeUpdate("CREATE DATABASE " + Settings.dbName);
			System.out.println("DB Create - END");

			conn = DriverManager.getConnection(
					Settings.dbUrl + Settings.dbName, Settings.dbUserName,
					Settings.dbPassword);

			Statement stmt = (Statement) conn.createStatement();

			String createUserTypesTable = "CREATE TABLE IF NOT EXISTS account_type ("
					+ "idaccounttype INT NOT NULL AUTO_INCREMENT ,"
					+ "description VARCHAR(45) NULL ,"
					+ "PRIMARY KEY (idaccounttype))";

			String createUserTable = "CREATE TABLE IF NOT EXISTS users ("
					+ "idsystem INT NOT NULL AUTO_INCREMENT ,"
					+ "idpersonal VARCHAR(10) NULL ,"
					+ "firstname VARCHAR(45) NULL ,"
					+ "lastname VARCHAR(45) NULL ,"
					+ "password VARCHAR(45) NULL ,"
					+ "accountactive BINARY NULL DEFAULT 1,"
					+ "subscriptiondate DATETIME NULL,"
					+ "accounttype INT NULL ,"
					+ "balance INT NULL,"
					+ "PRIMARY KEY (idsystem), "
					+ "FOREIGN KEY (accounttype) REFERENCES account_type (idaccounttype))";
			
			
			stmt.execute(createUserTypesTable);
			stmt.execute(createUserTable);

			System.out.println("Schema Create - End");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteDatabase() throws ServletException {
		try {
			System.out.println("DB Delete - Begin");
			Class.forName(Settings.dbDriver).newInstance();

			Connection conn = DriverManager.getConnection(Settings.dbUrl,
					Settings.dbUserName, Settings.dbPassword);
			Statement s = (Statement) conn.createStatement();

			s.executeUpdate("DROP DATABASE " + Settings.dbName);
			System.out.println("DB Delete - END");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");

		response.setContentType("text/html");

		String cmd = request.getParameter("cmd");
		String nextPage = "/admin.jsp";
		switch (cmd) {
		case "create":
			if (createSchema() == true) {
				response.setHeader("msgType", "success");
				response.setHeader("msg", "Database was successfully created!");
			} else {
				response.setHeader("msgType", "danger");
				response.setHeader("msg",
						"There was a problem creating the database!");
			}
			break;
		case "populate":
			if (populateSchema() == true) {
				response.setHeader("msgType", "success");
				response.setHeader("msg",
						"Database was successfully populated with initial data!");
			} else {
				response.setHeader("msgType", "danger");
				response.setHeader("msg",
						"There was a problem populating the database with initial data!");
			}
			break;
		case "delete":
			if (deleteDatabase()) {
				response.setHeader("msgType", "success");
				response.setHeader("msg", "Database was successfully deleted!");
			} else {
				response.setHeader("msgType", "danger");
				response.setHeader("msg",
						"There was a problem deleting the database!");
			}
			break;
		default:
			System.out.println("No value 'cmd' detected in URL");
			response.setHeader("msgType", "danger");
			response.setHeader("msg", "No matching 'cmd' could be found!");
			break;
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		String nextJSP = "/index.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
}
