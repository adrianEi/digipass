package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Queries extends HttpServlet {
	// get user balance by sysid
	// get user balance by personalid
	// deduct balance from sysid
	// deduct balance from pesonalsid

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");

		String cmd = request.getParameter("cmd");
		String nextPage = "/admin.jsp";

		/**
		 * Available cmd commands: getBalance - receives a personal id (pid) and
		 * returns the remaining balance on user's account chargeaccount -
		 * receives a personal id (pid) and amount (amount) and deducts it from
		 * user's account. Returns updated balance.
		 */
		String pid, amount;
		Integer balance;

		switch (cmd) {
		case "getBalance":
			pid = request.getParameter("pid");
			balance = getUserBalance(pid);
			response.addIntHeader("balance", balance);
			response.addHeader("msgType", "success");
			response.addHeader("msg", "User " + pid + "'s balance is "
					+ balance);
			break;
		case "chargeAccount":
			pid = request.getParameter("pid");
			amount = request.getParameter("amount");
			balance = chargeAccount(pid, amount);
			response.addIntHeader("balance", balance);
			response.addHeader("msgType", "success");
			response.addHeader("msg", "User " + pid + "'s new balance is "
					+ balance);
			break;
		case "showAllUsers":
			ResultSet res = getAllUsers();
		
			break;
		default:
			break;
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

	private ResultSet getAllUsers() {
		ResultSet result = null;
		try {
			Statement stmt = (Statement) createConnection().createStatement();


			String queryUserTable = "SELECT * FROM users";
			result = stmt.executeQuery(queryUserTable);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private Connection createConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					Settings.dbUrl + Settings.dbName, Settings.dbUserName,
					Settings.dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	private Integer chargeAccount(String pid, String amount) {
		Integer balance = 0;
		try {
			Statement stmt = (Statement) createConnection().createStatement();

			balance = getUserBalance(pid);
			System.out.println("Balance before charge " + balance);
			balance = balance - Integer.parseInt(amount);
			System.out.println("Balance after charge " + balance);

			String updateUserBalance = "UPDATE users SET balance=" + balance
					+ " WHERE idpersonal='" + pid + "'";
			stmt.executeUpdate(updateUserBalance);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return balance;
	}

	public Integer getUserBalance(String pid) throws ServletException {
		Integer balance = 0;
		try {
			Statement stmt = (Statement) createConnection().createStatement();
			String queryUserBalance = "SELECT balance FROM users WHERE idpersonal= '"
					+ pid + "'";
			System.out.println(queryUserBalance);
			ResultSet result = stmt.executeQuery(queryUserBalance);

			while (result.next()) {
				balance = result.getInt(1);
			}
			System.out.print(balance);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return balance;
	}
}
