package presentation;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Client;
import model.OrdersModel;
import model.Product;

public class ProductOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldQuantity;
	private JLabel lblSelClient;
	private JLabel lblSelProduct;
	private JLabel lblSelQuantity;
	private JComboBox<Integer> comboBoxClient ;
	private JComboBox<String> comboBoxProduct;
	private JButton btnOrder;

    /**
     * Constructs a new ProductOrder object.
     * Sets up the UI components and layout.
     */

	public ProductOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblSelClient = new JLabel("Select Client:");
		lblSelClient.setBounds(10, 65, 96, 20);
		contentPane.add(lblSelClient);
		
		 lblSelProduct = new JLabel("Select Product:");
		lblSelProduct.setBounds(10, 135, 96, 14);
		contentPane.add(lblSelProduct);
		
		lblSelQuantity = new JLabel("Quantity:");
		lblSelQuantity.setBounds(31, 207, 61, 14);
		contentPane.add(lblSelQuantity);
		
		
		OrdersModel om=new OrdersModel();
	
		comboBoxClient=new JComboBox<Integer>();
		comboBoxClient.setBounds(137, 64, 417, 22);
		contentPane.add(comboBoxClient);
		
		comboBoxProduct = new JComboBox();
		comboBoxProduct.setBounds(137, 131, 417, 22);
		contentPane.add(comboBoxProduct);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(113, 204, 96, 20);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		btnOrder = new JButton("Order");
		btnOrder.setBounds(221, 270, 89, 23);
		contentPane.add(btnOrder);
	}
	 /**
     * Returns the text value entered in the quantity field.
     *
     * @return The text value of the quantity field.
     */
	public String getTextFieldQuantity() {
		return this.textFieldQuantity.getText();
	}
	
	/**
     * Returns the selected product from the product combo box.
     *
     * @return The selected product.
     */
	public Product getProductComboBox() {
		return (Product) this.comboBoxProduct.getSelectedItem();
	}
	  /**
     * Returns the selected client from the client combo box.
     *
     * @return The selected client.
     */
	public Client getClientComboBox() {
		return (Client) this.comboBoxClient.getSelectedItem();
	}
	
	public JComboBox<Integer> retComboBoxClient(){
		return comboBoxClient;
	
	}
	public JComboBox<String> retComboBoxProduct(){
		return comboBoxProduct;
	
	}
	  public void orderListener(ActionListener actionListener) {
	       this.btnOrder.addActionListener(actionListener);
	    }
	
	
}
