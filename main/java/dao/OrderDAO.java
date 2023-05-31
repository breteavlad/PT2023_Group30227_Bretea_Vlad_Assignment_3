package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;


/**
 * This class contains the SQL commands for the order table 
 *
 */
public class OrderDAO {

	
	public static void selectBasedStock(String productName,int[] stockQuantity) {
		ResultSet rs = null;
		

		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {

			String query = "SELECT stock FROM products WHERE name = ?";
			st = con.prepareStatement(query);
			st.setString(1, productName);

			System.out.println("Successfully selected!");

			// Execute the query
			rs = st.executeQuery();

			// Process the result
			if (rs.next()) {
				stockQuantity[0] = rs.getInt("stock");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public static void updateNewStock(int newStockQuantity,String productName) {
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		
		String query = "UPDATE products SET stock = ? WHERE name = ?";
		try {
			st = con.prepareStatement(query);
			st.setInt(1, newStockQuantity);
			st.setString(2, productName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rowsAffected = 0;
		try {
			rowsAffected = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rowsAffected > 0) {
			System.out.println("Stock updated successfully!");
		} else {
			System.out.println("Failed to update stock.");
		}
	}
	
	
	public static void updateOrderTable(int clientId,String productName, int quantity) {
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		
		String query2 = "INSERT INTO orders_table(client_id,product_name,product_stock) VALUES (?, ?,?)";
		try {
			st = con.prepareStatement(query2);
			st.setInt(1, clientId);
			st.setString(2, productName);
			st.setInt(3, quantity);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
