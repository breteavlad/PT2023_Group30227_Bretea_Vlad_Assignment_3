package BusinessLogic;
import presentation.ClientInterface;
import presentation.ProductInterface;
import presentation.ProductOrder;

import java.awt.event.ActionEvent;

/**
 * This class acts as the controller for the application, handling user interactions and
 * coordinating between the view and the DAO classes.
 */
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connection.ConnectionFactory;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.OrdersModel;
import model.Product;
import presentation.ProductInterface;
import presentation.ProductOrder;
import presentation.View;

public class Controller {
//TODO:...

	private ProductInterface productInterface;
	private ProductOrder productOrder;
	private View view;
	private String clientAddress;
	private String clientName;
	private String clientId;
	private String textPrice;
	private String textStock;
	private String textName;
	
	/**
     * Constructs a new Controller object.
     *
     * @param view The view instance associated with the controller.
     */

	public Controller(View view) {
		this.view = view;

		// =======================here are the buttons for addition, deletion, update
		// and view from client interface============
		this.view.addClientListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClientInterface clientInterface = new ClientInterface();
				clientInterface.setVisible(true);

				clientInterface.additionClientListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc(clientInterface);
						ClientDAO.insertClient(clientId, clientName, clientAddress);
					}

				});

				clientInterface.deletionClientListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						// TODO Auto-generated method stub

						utilFunc(clientInterface);

						ClientDAO.deleteClient(clientId, clientName, clientAddress);

					}

				});

				clientInterface.updateOfClientListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc(clientInterface);

						ClientDAO.updateClient(clientId, clientName, clientAddress);
					}

				});

				clientInterface.viewListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc(clientInterface);

						ClientDAO.viewClients(clientId, clientName, clientAddress, clientInterface);

					}

				});

				// =======================end of the buttons for addition, deletion, update and
				// view from client interface============

			}

		});

		this.view.addProductsListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductInterface productInterface = new ProductInterface();
				productInterface.setVisible(true);

				productInterface.insertProductListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc2(productInterface);

						ProductDAO.productInsert(textName, textPrice, textStock);

					}

				});

				productInterface.deleteProductListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc2(productInterface);

						ProductDAO.productDelete(textName, textPrice, textStock);

					}

				});

				productInterface.updateProductPriceListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc2(productInterface);

						ProductDAO.productPriceUpdate(textName, textPrice, textStock);
					}

				});

				productInterface.updateProductStockListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc2(productInterface);

						ProductDAO.productStockUpdate(textName, textPrice, textStock);
					}

				});

				productInterface.viewProductListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						utilFunc2(productInterface);

						ProductDAO.viewProducts(textName, textPrice, textStock, productInterface);

					}

				});

			}
		});

		this.view.addOrdersListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductOrder productOrder = new ProductOrder();
				productOrder.setVisible(true);
				OrdersModel om = new OrdersModel();
				om.addTableClientToList();
				om.addTableProductToList();

				ArrayList<String> productNames = new ArrayList();
				for (Product product : om.retProductList()) {
					productNames.add(product.getProductName());
				}

				ArrayList<Integer> clientIds = new ArrayList();
				for (Client c : om.retClientList()) {
					clientIds.add(c.getId());
				}

				productOrder.retComboBoxClient()
						.setModel(new DefaultComboBoxModel<>(clientIds.toArray(new Integer[0])));
				productOrder.retComboBoxProduct()
						.setModel(new DefaultComboBoxModel<>(productNames.toArray(new String[0])));
				// comboBoxProduct.setModel(new DefaultComboBoxModel<>(productNames.toArray(new
				// String[0])));

				productOrder.orderListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int quantity, clientId;
						String productName;
						quantity = Integer.parseInt(productOrder.getTextFieldQuantity());
						clientId = ((Integer) productOrder.retComboBoxClient().getSelectedItem()).intValue();
						productName = (String) productOrder.retComboBoxProduct().getSelectedItem();
						System.out.println(
								"client id: " + clientId + " quantity: " + quantity + " product name: " + productName);

						PreparedStatement st = null;
						Connection con = ConnectionFactory.getConnection();
						ResultSet rs = null;

//==================THIS IS THE PART WHERE I EXTRACT THE STOCK FROM PRODUCTS TABLE AND UPDATE THE STOCK =============================================		
						int[] stockQuantity = { 0 };
						int newStockQuantity;

						OrderDAO.selectBasedStock(productName, stockQuantity);

						newStockQuantity = stockQuantity[0] - quantity;
//===============THIS IS THE PART WHERE I UPDATE THE TABLE FROM PRODUCTS WITH THE NEW STOCK =============================================================
						if (newStockQuantity >= 0) {

							OrderDAO.updateNewStock(newStockQuantity, productName);

//====================THIS IS THE PART WHERE I UPDATE THE ORDER TABLE ===================================================================================

							OrderDAO.updateOrderTable(clientId, productName, quantity);
							System.out.println("Succesfully added!");

						} else {
							JOptionPane.showMessageDialog(null, "Under-stock!");
						}

					}

				});
			}

		});

	}
	  /**
     * Utility method to extract client information from the ClientInterface and perform client-related operations.
     *
     * @param clientInterface The ClientInterface instance from which to extract client information.
     */

	public void utilFunc(ClientInterface clientInterface) {

		this.clientAddress = clientInterface.getClientAddress();
		this.clientName = clientInterface.getClientName();
		this.clientId = clientInterface.getClientId();
	}
	  /**
     * Utility method to extract product information from the ProductInterface and perform product-related operations.
     *
     * @param productInterface The ProductInterface instance from which to extract product information.
     */

	public void utilFunc2(ProductInterface productInterface) {

		textPrice = productInterface.getTextPrice();
		textStock = productInterface.getTextStock();
		textName = productInterface.getTextName();
	}

}
