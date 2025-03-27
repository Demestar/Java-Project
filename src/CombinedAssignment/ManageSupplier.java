package CombinedAssignment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;


public class ManageSupplier extends javax.swing.JFrame {
    static String user;
    private final DefaultTableModel Stock = new DefaultTableModel();
    private final String[] columnName = {"ID","Name","Contact No","Payment Status"};
    private final List<Supplier> SupplierList = new ArrayList<>();
    private int SelectedRow = -1;
    
    //File path saved in variable    
    String filePath = "Suppliers"; // Define the file path
    
    public ManageSupplier(String user) {
        initComponents();
        Stock.setColumnIdentifiers(columnName);
        ImportStockData();
        populateTable(SupplierList);
        this.user = user;
    }
    private String generateNextSupplierID() {
    int maxID = 0;

    for (Supplier supplier : SupplierList) {
        String id = supplier.getSupplierID();
        if (id.startsWith("S")) {
            try {
                int num = Integer.parseInt(id.substring(1));
                if (num > maxID) {
                    maxID = num;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid Supplier ID format: " + id);
            }
        }
    }

    return String.format("S%03d", maxID + 1);
}

    private void ImportStockData() {
    SupplierList.clear(); // Clear existing data before importing
    File file = new File(filePath);

    if (!file.exists()) {
        System.err.println("File not found: " + filePath);
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        while (true) {
            try {
                // Deserialize each Item object
                Supplier supply = (Supplier) ois.readObject();
                SupplierList.add(supply); // Add the item to the list
            } catch (EOFException e) {
                break; // End of file reached
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error reading file: " + e.getMessage());
        JOptionPane.showMessageDialog(this, 
                "Error loading stock data from file.\n" + e.getMessage(), 
                "File Read Error", 
                JOptionPane.ERROR_MESSAGE);
    }

    // Populate the table with the updated item list
    populateTable(SupplierList);
}
    
    private void populateTable(List<Supplier> SupplierList) {
     Stock.setRowCount(0); // Clear existing data in the table
    for (Supplier supply : SupplierList) {
        // Extract attributes from each Item object
        Object[] row = {
            supply.getSupplierID(),
            supply.getSupplierName(),
            supply.getSupplierContact(),
            supply.getPaymentStatus()
        };
        Stock.addRow(row); // Add the row to the table model
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpdatePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StockData = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblItem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUpdateName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        lblItemID = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cmbPaymentStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        UpdatePanel.setEnabled(false);
        UpdatePanel.setMaximumSize(new java.awt.Dimension(0, 0));

        StockData.setModel(Stock);
        StockData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StockDataMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StockDataMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(StockData);

        jLabel5.setText("Payment Status");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnBack.setBackground(new java.awt.Color(255, 102, 102));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblItem.setText("ID");
        lblItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setText("Name");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setText("Contact Number");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnEdit.setBackground(new java.awt.Color(255, 204, 51));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblItemID.setText("<ID>");

        btnAdd.setBackground(new java.awt.Color(0, 255, 0));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cmbPaymentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Unpaid", "Pending", "Cancelled" }));

        javax.swing.GroupLayout UpdatePanelLayout = new javax.swing.GroupLayout(UpdatePanel);
        UpdatePanel.setLayout(UpdatePanelLayout);
        UpdatePanelLayout.setHorizontalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContact)
                            .addComponent(txtUpdateName)
                            .addGroup(UpdatePanelLayout.createSequentialGroup()
                                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        UpdatePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit});

        UpdatePanelLayout.setVerticalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItem)
                            .addComponent(lblItemID))
                        .addGap(18, 18, 18)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UpdatePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UpdatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (SelectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row.");
        } else {
            try {
                // Correct reference to SupplierList
                Supplier selectedSupplier = SupplierList.get(SelectedRow);

                // Update the selected item with new values
                selectedSupplier.setSupplierName(txtUpdateName.getText());
                selectedSupplier.setSupplierContact(txtContact.getText());
                selectedSupplier.setPaymentStatus((String) cmbPaymentStatus.getSelectedItem()); // Use setSelectedItem instead

                // Update the table
                populateTable(SupplierList);

                // Write updated data to the file
                writeItemsToFile(filePath);

                // Clear text fields and reset selection
                clearTextField();
                SelectedRow = -1;

                JOptionPane.showMessageDialog(this, "Supplier updated successfully.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input format: " + ex.getMessage(),
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Inventory_Page inventoryPage = new Inventory_Page(user);
        inventoryPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void StockDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockDataMouseReleased
        SelectedRow = StockData.getSelectedRow();
        if (SelectedRow >= 0) {
        // Correct reference to SupplierList
        Supplier selectedSupplier = SupplierList.get(SelectedRow);
        lblItemID.setText(selectedSupplier.getSupplierID());
        txtUpdateName.setText(selectedSupplier.getSupplierName());
        txtContact.setText(selectedSupplier.getSupplierContact());
        
        // Set the payment status combobox to match the selected row
        cmbPaymentStatus.setSelectedItem(selectedSupplier.getPaymentStatus());
        } else {
        JOptionPane.showMessageDialog(this, "Please select a row.");
        }
    }//GEN-LAST:event_StockDataMouseReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    String supplierID = generateNextSupplierID(); // Generate new ID
    String supplierName = txtUpdateName.getText();
    String supplierContact = txtContact.getText();
    String paymentStatus = cmbPaymentStatus.getSelectedItem().toString();

    if (supplierName.isEmpty() || supplierContact.isEmpty() || paymentStatus.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Create a new Supplier object
    Supplier newSupplier = new Supplier(supplierID, supplierName, supplierContact, paymentStatus);

    // Add to the list
    SupplierList.add(newSupplier);

    // Update the table
    populateTable(SupplierList);

    // Save to file
    writeItemsToFile(filePath);

    // Clear text fields
    clearTextField();

    JOptionPane.showMessageDialog(this, "New Supplier added successfully.");
    }//GEN-LAST:event_btnAddActionPerformed

    private void StockDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockDataMouseExited

    }//GEN-LAST:event_StockDataMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    if (SelectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Selection Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Confirm deletion
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected supplier?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Remove the selected supplier from the list
        SupplierList.remove(SelectedRow);

        // Update the table
        populateTable(SupplierList);

        // Save the updated list to the file
        writeItemsToFile(filePath);

        // Clear text fields and reset selection
        clearTextField();
        SelectedRow = -1;

        JOptionPane.showMessageDialog(this, "Supplier deleted successfully.");
    }
    }//GEN-LAST:event_btnDeleteActionPerformed
public void clearTextField(){
    lblItemID.setText("<ID>");
    txtUpdateName.setText("");
    txtContact.setText("");
    cmbPaymentStatus.setSelectedIndex(0);
}
private void writeItemsToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        for (Supplier item : SupplierList) {
            // Serialize each Item object
            oos.writeObject(item);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(),
                "File Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSupplier(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StockData;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cmbPaymentStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtUpdateName;
    // End of variables declaration//GEN-END:variables
}
