package presentation;

import javax.swing.*;

/**
 * The ClientInterface class represents the graphical user interface for managing clients.
 * It provides functionality to add, delete, update, and view client information.
 */
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionListener;

public class ClientInterface extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldClientId;
    private JTextField textFieldClientName;
    private JTextField textFieldClientAddress;
    private JTable table;
    private JButton btnDeleteClient;
    private JButton btnAddClient;
    private JButton btnUpdateClient;
    private JButton btnViewClients;
    
    /**
     * Constructs a new ClientInterface object.
     * Sets up the UI components and layout.
     */

    public ClientInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 985, 303);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        btnUpdateClient = new JButton("Update Client");
        btnUpdateClient.setBounds(278, 55, 124, 23);
        panel.add(btnUpdateClient);

        btnDeleteClient = new JButton("Delete Client");
        btnDeleteClient.setBounds(278, 114, 124, 23);
        panel.add(btnDeleteClient);

        btnAddClient = new JButton("Add Client");
        btnAddClient.setBounds(278, 11, 124, 23);
        panel.add(btnAddClient);

        JLabel lblClientId = new JLabel("ClientId");
        lblClientId.setBounds(10, 55, 49, 14);
        panel.add(lblClientId);

        JLabel lblClientName = new JLabel("Client Name");
        lblClientName.setBounds(10, 118, 84, 14);
        panel.add(lblClientName);

        JLabel lblClientAddress = new JLabel("Client Address");
        lblClientAddress.setBounds(10, 185, 101, 14);
        panel.add(lblClientAddress);

        textFieldClientId = new JTextField();
        textFieldClientId.setBounds(136, 56, 96, 20);
        panel.add(textFieldClientId);
        textFieldClientId.setColumns(10);

        textFieldClientName = new JTextField();
        textFieldClientName.setBounds(136, 115, 96, 20);
        panel.add(textFieldClientName);
        textFieldClientName.setColumns(10);

        textFieldClientAddress = new JTextField();
        textFieldClientAddress.setBounds(136, 182, 96, 20);
        panel.add(textFieldClientAddress);
        textFieldClientAddress.setColumns(10);

        btnViewClients = new JButton("View clients");
        btnViewClients.setBounds(278, 181, 124, 23);
        panel.add(btnViewClients);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(481, 11, 445, 230);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        
    }
    
    /**
     * Returns the "View clients" button.
     *
     * @return The "View clients" button.
     */
    public JButton getViewButton() {
    	return this.btnViewClients;
    }

    /**
     * Returns the client ID entered in the text field.
     *
     * @return The client ID.
     */
    public String getClientId() {
        return this.textFieldClientId.getText();
    }

    /**
     * Returns the client address entered in the text field.
     *
     * @return The client address.
     */
    public String getClientAddress() {
        return this.textFieldClientAddress.getText();
    }

    /**
     * Returns the client name entered in the text field.
     *
     * @return The client name.
     */
    public String getClientName() {
        return this.textFieldClientName.getText();
    }
    /**
     * Adds an ActionListener to the "Add Client" button.
     *
     * @param actionListener The ActionListener to be added.
     */
    public void additionClientListener(ActionListener actionListener) {
        this.btnAddClient.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the "Delete Client" button.
     *
     * @param actionListener The ActionListener to be added.
     */
    public void deletionClientListener(ActionListener actionListener) {
        this.btnDeleteClient.addActionListener(actionListener);
    }
    
    /**
     * Adds an ActionListener to the "Update Client" button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void updateOfClientListener(ActionListener actionListener) {
        this.btnUpdateClient.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the "View clients" button.
     *
     * @param actionListener The ActionListener to be added.
     */
    public void viewListener(ActionListener actionListener) {
        this.btnViewClients.addActionListener(actionListener);
    }

    public JTable getTable() {
        return this.table;
    }
    
    /**
     * Sets the data model for the table component.
     *
     * @param model The TableModel containing the data.
     */
    public void setTableData(TableModel model) {
        table.setModel(model);
        contentPane.revalidate();
        contentPane.repaint();
    }
}
