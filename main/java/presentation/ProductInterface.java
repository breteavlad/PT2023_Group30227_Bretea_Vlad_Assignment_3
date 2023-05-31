package presentation;

import java.awt.EventQueue;

/**
 * The ProductInterface class represents the graphical user interface for managing products.
 * It provides functionality to add, delete, update, and view product information.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ProductInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldStock;
	private JTextField textFieldPrice;
	private JTable table;
	private JPanel panel;
	private JLabel StockLabel;
	private JScrollPane scrollPane;
	private JButton btnViewProducts;
	private JButton btnDeleteProduct;
	private JButton btnEditProduct;
	private JButton btnAddProduct;
	private JLabel lblPrice;
	private JTextField nameTextField;
	JButton btnEditStock;

	/**
	 * Constructs a new ProductInterface object. Sets up the UI components and
	 * layout.
	 */
	public ProductInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 917, 263);
		contentPane.add(panel);
		panel.setLayout(null);

		textFieldStock = new JTextField();
		textFieldStock.setBounds(100, 95, 96, 20);
		panel.add(textFieldStock);
		textFieldStock.setColumns(10);

		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(100, 160, 96, 20);
		panel.add(textFieldPrice);
		textFieldPrice.setColumns(10);

		StockLabel = new JLabel("Stock");
		StockLabel.setBounds(10, 98, 49, 14);
		panel.add(StockLabel);

		lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 166, 49, 14);
		panel.add(lblPrice);

		btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddProduct.setBounds(260, 27, 145, 23);
		panel.add(btnAddProduct);

		btnEditProduct = new JButton("Edit product price");
		btnEditProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditProduct.setBounds(260, 76, 145, 23);
		panel.add(btnEditProduct);

		btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteProduct.setBounds(260, 178, 145, 23);
		panel.add(btnDeleteProduct);

		btnViewProducts = new JButton("View products");
		btnViewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewProducts.setBounds(260, 229, 145, 23);
		panel.add(btnViewProducts);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(481, 11, 426, 228);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		nameTextField = new JTextField();
		nameTextField.setBounds(100, 41, 96, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);

		JLabel productNameVar = new JLabel("Name");
		productNameVar.setBounds(10, 44, 49, 14);
		panel.add(productNameVar);

		btnEditStock = new JButton("Edit product stock");
		btnEditStock.setBounds(260, 126, 145, 23);
		panel.add(btnEditStock);
	}

	/**
	 * Returns the text entered in the price text field.
	 *
	 * @return The price text.
	 */
	public String getTextPrice() {
		return this.textFieldPrice.getText();
	}

	/**
	 * Returns the text entered in the stock text field.
	 *
	 * @return The stock text.
	 */

	public String getTextStock() {
		return this.textFieldStock.getText();
	}

	/**
	 * Returns the text entered in the name text field.
	 *
	 * @return The name text.
	 */
	public String getTextName() {
		return this.nameTextField.getText();
	}

	public void insertProductListener(ActionListener actionListener) {
		this.btnAddProduct.addActionListener(actionListener);
	}

	public void deleteProductListener(ActionListener actionListener) {
		this.btnDeleteProduct.addActionListener(actionListener);

	}

	public void updateProductPriceListener(ActionListener actionListener) {
		this.btnEditProduct.addActionListener(actionListener);
	}

	public void viewProductListener(ActionListener actionListener) {
		this.btnViewProducts.addActionListener(actionListener);
	}

	public void updateProductStockListener(ActionListener actionListener) {
		this.btnEditStock.addActionListener(actionListener);
	}

	public JTable getTable() {
		return this.table;
	}

	/**
	 * Returns the "View products" button.
	 *
	 * @return The "View products" button.
	 */
	public JButton getViewButton() {
		return this.btnViewProducts;
	}
}
