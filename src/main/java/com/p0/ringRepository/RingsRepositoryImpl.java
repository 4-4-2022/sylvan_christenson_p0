package com.p0.ringRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.Menus.AccountManagement;
import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.model.Rings;
import com.p0.ui.ScreenPrint;
import com.p0.util.Connector;
import com.p0.util.SQL;

public class RingsRepositoryImpl{
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);
	public static SQL sql = new SQL();
	public AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
	public Scanner scanner = new Scanner(System.in);
	
	
	
	
	public void printRingList(List<Rings> ringList) {
		
		for (Rings ring : ringList) {
			System.out.println(ring.toStringNoOwner());
			System.out.println("-----------------------");

		}
		System.out.println("List complete.");

	}

	public void printRingList() {

		for (Rings account : findAllRings()) {
			System.out.println(account.toStringNoOwner());
			System.out.println("-----------------------");

		}
		System.out.println("List complete.");

	}

	public void seeMenu() {

	}

	public void giveRing(String receivingUser) {

	}
	public Rings newRingOnlyJeweler() {
		Rings newRing = new Rings();
		System.out.println("Who would you like to make this ring?");
		newRing.setJeweler(scanner.next());
		return newRing;
		}
	
	public Rings newRing() {
		Rings newRing = new Rings();
		System.out.println("What is the name of this ring?");
		newRing.setItemName(scanner.nextLine());
		System.out.println("Who would you like to make this ring?");
		newRing.setJeweler(scanner.nextLine());
		System.out.println("What material would you like this ring to be made out of?");
		newRing.setMaterial(scanner.nextLine());
		System.out.println("What type of gem would you like to be placed in this ring?");
		newRing.setGem(scanner.nextLine());
		System.out.println("What engraving would you like placed on this ring?");
		newRing.setEngraving(scanner.nextLine());
		System.out.println("Who was the previous owner of this ring?");
		newRing.setPreviousOwner(scanner.nextLine());
		System.out.println("Who is the current owner of this ring?");
		newRing.setCurrentOwner(scanner.nextLine());
		System.out.println("What is the price of this ring?");
		newRing.setPrice(scanner.nextDouble());
		return newRing;
		
		

	}


	public Rings customRing() {
		Rings customRing = new Rings();
		System.out.println("Who would you like to make this ring?");
		customRing.setJeweler(scanner.next());
		System.out.println("What material would you like this ring to be made out of?");
		customRing.setMaterial(scanner.next());
		System.out.println("What type of gem would you like to be placed in this ring?");
		customRing.setGem(scanner.next());
		
		return customRing;
		
		

	}
	
	public void purchaseRing(String username) throws SQLException {
		
		System.out.println("Please indicate the name of the ring you wish to purchase.");
		String ringName = scanner.nextLine();
		if (findSingleRing(ringName).getPrice() > sql
				.executeQuerySQL(sql.getAccountBalanceSQL(username)).getDouble(1)) {
			System.out.println("Insufficient Balance");
			return;
		}
		else {
		buyRing(findSingleRing(ringName).getPrice(),ringName, username);
		}

		ScreenPrint.printTransactionSuccessful();
		return;
		
		
	}
	
	
	
	
	

	public void buyRing(double price, String ringName, String username) throws SQLException {
		accountRepo.withdraw(username, price);
		logger.info(username + " " + "purchased a ring called" + " " +  ringName + " " + "for" + " " + price + ".");}
		
		

	
	
	public List<Rings> searchByJeweler() {
		List<Rings> ringList = new ArrayList<Rings>();
		String searchParameter;
		System.out.println("Please enter the jeweler you wish to search for.");
		searchParameter = scanner.nextLine();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from rings where rings_jewler = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, searchParameter);
			set = stmt.executeQuery();
			while (set.next()) {

				ringList.add(new Rings(set.getString(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getDouble(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ringList;

	}
	public List<Rings> searchByGem() {
		List<Rings> ringList = new ArrayList<Rings>();
		String searchParameter;
		System.out.println("Please enter the gem you wish to search for.");
		searchParameter = scanner.nextLine();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from rings where rings_gem = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, searchParameter);
			set = stmt.executeQuery();
			while (set.next()) {

				ringList.add(new Rings(set.getString(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getDouble(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ringList;

	}
	
	
	
	
	
	public List<Rings> searchByMaterial() {
		List<Rings> ringList = new ArrayList<Rings>();
		String searchParameter;
		System.out.println("Please enter the material you wish to search for.");
		searchParameter = scanner.nextLine();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from rings where rings_material = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, searchParameter);
			set = stmt.executeQuery();
			while (set.next()) {

				ringList.add(new Rings(set.getString(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getDouble(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ringList;

	}

	public Rings findSingleRing( String itemName) {
		Rings ring = new Rings();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from rings where rings_itemname = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, itemName);
			set = stmt.executeQuery();
			while (set.next()) {

				ring.setItemName(set.getString(1));
				ring.setMaterial(set.getString(2));
				ring.setGem(set.getString(3));
				ring.setJeweler(set.getString(4));
				ring.setEngraving(set.getString(5));
				ring.setCurrentOwner(set.getString(6));
				ring.setPreviousOwner(set.getString(7));
				ring.setPrice(set.getDouble(8));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ring;

	}

	public List<Rings> findAllRings() {

		List<Rings> ringList = new ArrayList<Rings>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from rings";

		try {
			conn = Connector.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				ringList.add(new Rings(set.getString(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getDouble(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ringList;
	}

	
public void saveRingToRings(Rings newRing) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into rings values( ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, newRing.getItemName());
			stmt.setString(2, newRing.getMaterial());
			stmt.setString(3, newRing.getGem());
			stmt.setString(4, newRing.getJeweler());
			stmt.setString(5, newRing.getEngraving());
			stmt.setString(6, newRing.getCurrentOwner());
			stmt.setString(7, newRing.getPreviousOwner());
			stmt.setDouble(8, newRing.getPrice());
			stmt.execute();

		} catch (SQLException e) {

		} finally {
			try {
				conn.close();
				stmt.close();
				System.out.println( newRing.getItemName() + " added to ring menu successfully.");
				logger.info(newRing.getItemName() + " added to ring menu successfully.");
			} catch (SQLException e) {

			}
		}

	}

	public void saveRingToCustomRings(Rings customRing) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into customrings values( ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, customRing.getItemName());
			stmt.setString(2, customRing.getMaterial());
			stmt.setString(3, customRing.getGem());
			stmt.setString(4, customRing.getJeweler());
			stmt.setString(5, customRing.getEngraving());
			stmt.setString(6, customRing.getCurrentOwner());
			stmt.setString(7, customRing.getPreviousOwner());
			stmt.setDouble(8, customRing.getPrice());
			stmt.execute();

		} catch (SQLException e) {

		} finally {
			try {
				conn.close();
				stmt.close();
				System.out.println("Custom ring added to order list Successfully");
			} catch (SQLException e) {

			}
		}

	}
}
