package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BusinessLogic.ResultSetUtils;
import connection.ConnectionFactory;
import model.Client;
import presentation.ClientInterface;



/**
 * This class contains the SQL commands for the client table
 *
 */
public class ClientDAO {
	
	public static void insertClient(String clientId,String clientName,String clientAddress) {
		

		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {
		
			// here I insert into the table

			if (clientName != null && clientAddress != null && clientId != null) {
				String query = "INSERT INTO client(id, name, address) VALUES (?, ?, ?)";
				st = con.prepareStatement(query);
				st.setString(1, clientId);
				st.setString(2, clientName);
				st.setString(3, clientAddress);
				st.executeUpdate();
				System.out.println("Succesfully added!");
			} else {
				System.out.println("Null address/clientId/clientName");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public static void deleteClient(String clientId,String clientName,String clientAddress) {
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {

			// here I DELETE FROM the table

			if (clientName != null && clientAddress != null && clientId != null) {
				String query = "DELETE FROM client WHERE ID= " + clientId;
				st = con.prepareStatement(query);
				st.executeUpdate();
				System.out.println("Succesfully deleted!");
			} else {
				System.out.println("Null address/clientId/clientName");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void updateClient(String clientId,String clientName,String clientAddress) {
		
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {
		
			// here I update the table

			if (clientName != null && clientAddress != null && clientId != null) {
				String query = "UPDATE client SET name = ? WHERE id = ?";
				st = con.prepareStatement(query);
				st.setString(1, clientName);
				st.setString(2, clientId);
				st.executeUpdate();
				System.out.println("Successfully updated!");
			} else {
				System.out.println("Null address/clientId/clientName");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	
	public static void viewClients(String clientId,String clientName,String clientAddress,ClientInterface clientInterface) {
		
		PreparedStatement st = null;
		Connection con = ConnectionFactory.getConnection();
		try {
			
			// here I select the table
			DefaultTableModel model = new DefaultTableModel(new Object[0],0);

			if (clientName != null && clientAddress != null && clientId != null) {
				String query = "SELECT * FROM client";
				st = con.prepareStatement(query);

				ResultSet rs;
				rs = st.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				model = (DefaultTableModel) clientInterface.getTable().getModel();

			
				model.setColumnIdentifiers(new Object[0]);
				
				model.setRowCount(0);
				
				try {
					ResultSetUtils.generateHeaderUsingReflection(model,Client.class);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
	
				try {
					ResultSetUtils.populateTable(rs, model,Client.class);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clientInterface.getTable().setModel(model);
					System.out.println("Inside rs next while.");
				//}

				System.out.println("Successfully view!");
			} else {
				System.out.println("Null address/clientId/clientName");
			}
			// clientInterface.getViewButton().setEnabled(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
	}


