package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BusinessLogic.ResultSetUtils;
import connection.ConnectionFactory;
import model.Product;
import presentation.ProductInterface;

/**
 * This class contains the sql commands for the products table
 *
 */
public class ProductDAO {
	
	public static void productInsert(String textName,String textPrice,String textStock) {
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {
			
			// here I insert into the table

			if (textPrice != null && textStock != null && textName != null) {
				String query = "INSERT INTO products(name,price,stock) VALUES (?, ?,?)";
				st = con.prepareStatement(query);
				st.setString(1, textName);
				st.setString(2, textPrice);
				st.setString(3, textStock);
				st.executeUpdate();
				System.out.println("Succesfully added!");
			} else {
				System.out.println("Null name/price/stock");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void productDelete(String textName,String textPrice, String textStock) {
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {

			// here I DELETE FROM the table

			if (textPrice != null && textStock != null && textName != null) {
				String query = "DELETE FROM products WHERE name = '" + textName + "'";
				st = con.prepareStatement(query);
				st.executeUpdate();
				System.out.println("Succesfully deleted!");
			} else {
				System.out.println("Null price/stock/name");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void productPriceUpdate(String textName,String textPrice,String textStock) {
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {
			
			// here I update the table

			if (textPrice != null && textStock != null && textName != null) {
				String query = "UPDATE products SET price = ? WHERE name = ?";
				st = con.prepareStatement(query);
				st.setString(1, textPrice);
				st.setString(2, textName);
				st.executeUpdate();
				System.out.println("Successfully updated!");
			} else {
				System.out.println("Null name/price/stock");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void productStockUpdate(String textName,String textPrice,String textStock) {
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {
			
			// here I update the table

			if (textPrice != null && textStock != null && textName != null) {
				String query = "UPDATE products SET stock = ? WHERE name = ?";
				st = con.prepareStatement(query);
				st.setString(1, textStock);
				st.setString(2, textName);
				st.executeUpdate();
				System.out.println("Successfully updated!");
			} else {
				System.out.println("Null name/price/stock");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void viewProducts(String textName,String textPrice,String textStock,ProductInterface productInterface) {
		
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		
		try {
			
			// here I select the table
			DefaultTableModel model = new DefaultTableModel();

			if (textPrice != null && textStock != null && textName != null) {
				String query = "SELECT * FROM products";
				st = con.prepareStatement(query);

				ResultSet rs;
				rs = st.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				model = (DefaultTableModel) productInterface.getTable().getModel();
				
				model.setColumnIdentifiers(new Object[0]);
				
				model.setRowCount(0);
				
				try {
					ResultSetUtils.generateHeaderUsingReflection(model,Product.class);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				try {
					ResultSetUtils.populateTable(rs, model,Product.class);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				productInterface.getTable().setModel(model);

				System.out.println("Successfully view!");
			} else {
				System.out.println("Null price/stock/name");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
