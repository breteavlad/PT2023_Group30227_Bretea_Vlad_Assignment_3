package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import connection.ConnectionFactory;
import presentation.ClientInterface;
import presentation.ProductInterface;

public class OrdersModel {
private  ArrayList<Client> clientList;
private ArrayList<Product> productList;
private ProductInterface productInterface;
private ClientInterface clientInterface;

public OrdersModel() {
	clientList=new ArrayList<Client>();
	productList=new ArrayList<Product>();
	
}

public void addToClientList(Client c) {
	clientList.add(c);
}
public void addToProductList(Product p) {
	productList.add(p);
}
public Client returnNClient(int i) {
	return clientList.get(i);
}
public Product returnNProduct(int i) {
	return productList.get(i);
}

public void addTableClientToList() {
    PreparedStatement st = null;
    Connection con = ConnectionFactory.getConnection();
    
    try {
        String query = "SELECT * FROM client";
        st = con.prepareStatement(query);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            int clientId = rs.getInt("id");
            String clientName = rs.getString("name");
            String clientAddress = rs.getString("address");
            
            Client client = new Client(clientId, clientName, clientAddress);
            clientList.add(client);
        }
    } catch (SQLException e1) {
        e1.printStackTrace();
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

public void addTableProductToList() {
    PreparedStatement st = null;
    Connection con = ConnectionFactory.getConnection();
    
    try {
        String query = "SELECT * FROM products";
        st = con.prepareStatement(query);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            String productName = rs.getString("name");
            int productPrice = rs.getInt("price");
            int productStock = rs.getInt("stock");
            
            Product p=new Product(productName,productPrice,productStock);
           productList.add(p);
        }
    } catch (SQLException e1) {
        e1.printStackTrace();
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

public ArrayList<Client> retClientList(){
	return clientList;
}

public ArrayList<Product> retProductList(){
	return productList;
}



}
