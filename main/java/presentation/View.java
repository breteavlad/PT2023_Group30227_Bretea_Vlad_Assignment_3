package presentation;

import java.awt.EventQueue;

/**
 * The View class represents the main graphical user interface of the application.
 * It provides buttons for accessing different functionalities, such as clients, orders, and products.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Constructs a new View object.
 * Sets up the UI components and layout.
 */
public class View extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	JButton btnClients;
	JButton btnOrders;
	JButton btnProducts;

	
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setBounds(0, 11, 426, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 btnClients = new JButton("Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClients.setBounds(77, 57, 89, 23);
		panel.add(btnClients);
		
		 btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrders.setBounds(77, 123, 89, 23);
		panel.add(btnOrders);
		
		 btnProducts = new JButton("Product");
		btnProducts.setBounds(77, 200, 89, 23);
		panel.add(btnProducts);
	}
	
	public void addProductsListener(ActionListener actionListener) {
		this.btnProducts.addActionListener(actionListener);

	}
	public void addClientListener(ActionListener actionListener) {
		this.btnClients.addActionListener(actionListener);

	}
	
	public void addOrdersListener(ActionListener actionListener) {
		this.btnOrders.addActionListener(actionListener);

	}
}
