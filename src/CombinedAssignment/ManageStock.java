package CombinedAssignment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;


public class ManageStock extends javax.swing.JFrame {
    static String user;
    private final DefaultTableModel Stock = new DefaultTableModel();
    private final String[] columnName = {"ID","Name","Stock Level","Reorder Level","SupplierID","Status"};
    private final List<Item> itemsList = new ArrayList<>();
    private int SelectedRow = -1;
    private final List<String> supplierIDs = new ArrayList<>();
    
    //File path saved in variable    
    String filePath = "Items"; // Define the file path
    String filePath2 = "Suppliers";
    
    public ManageStock(String user) {
        initComponents();
        Stock.setColumnIdentifiers(columnName);
        ImportStockData();
        populateTable(itemsList);
        loadSupplierIDs();
        populateComboBox();
        this.user = user;
    }
    private void ImportStockData() {
    itemsList.clear(); // Clear existing data before importing
    File file = new File(filePath);

    if (!file.exists()) {
        System.err.println("File not found: " + filePath);
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        while (true) {
            try {
                // Deserialize each Item object
                Item item = (Item) ois.readObject();
                itemsList.add(item); // Add the item to the list
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
    populateTable(itemsList);
}
    
    private void populateTable(List<Item> itemsList) {
     Stock.setRowCount(0); // Clear existing data in the table
    for (Item item : itemsList) {
        // Extract attributes from each Item object
        Object[] row = {
            item.getItemID(),
            item.getItemName(),
            item.getStockLevel(),
            item.getReorderLevel(),
            item.getSupplierID(),
            item.getStatus()
        };
        Stock.addRow(row); // Add the row to the table model
    }
}
    private void loadSupplierIDs() {
        File file = new File(filePath2);

        if (!file.exists()) {
            System.err.println("File not found: " + filePath2);
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Supplier supplier = (Supplier) ois.readObject();
                    supplierIDs.add(supplier.getSupplierID());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading supplier IDs from file.\n" + e.getMessage(),
                    "File Read Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void populateComboBox() {
        for (String supplierID : supplierIDs) {
            cmbSupplier.addItem(supplierID); // Add each supplier ID to the combo box
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpdatePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StockData = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtUpdateReorder = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblItem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUpdateName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        lblItemID = new javax.swing.JLabel();
        txtUpdateStock = new javax.swing.JTextField();
        lblSupplier = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        cmbSupplier = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpdatePanel.setEnabled(false);

        StockData.setModel(Stock);
        StockData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StockDataMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(StockData);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Reorder Level");

        txtUpdateReorder.setAlignmentY(1.0F);

        btnBack.setBackground(new java.awt.Color(255, 102, 102));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblItem.setText("ID");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name");

        txtUpdateName.setAlignmentY(1.0F);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Stock Level");

        btnEdit.setBackground(new java.awt.Color(255, 204, 51));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblItemID.setText("<ID>");
        lblItemID.setAlignmentY(1.0F);

        txtUpdateStock.setAlignmentY(1.0F);

        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSupplier.setText("SupplierID");

        btnRemove.setBackground(new java.awt.Color(255, 51, 51));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpdatePanelLayout = new javax.swing.GroupLayout(UpdatePanel);
        UpdatePanel.setLayout(UpdatePanelLayout);
        UpdatePanelLayout.setHorizontalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpdatePanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUpdateReorder, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUpdateName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUpdateStock, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePanelLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                                        .addComponent(lblItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))))
                            .addGroup(UpdatePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        UpdatePanelLayout.setVerticalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItem)
                            .addComponent(lblItemID))
                        .addGap(18, 18, 18)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUpdateReorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSupplier)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UpdatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Editing a stock resets its status to Not Paid. Proceed to edit?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        if (SelectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row.");
        } else {
            try {
                // Correct reference to itemsList
                Item selectedItem = itemsList.get(SelectedRow);

                // Update the selected item with new values
                selectedItem.setItemName(txtUpdateName.getText());
                selectedItem.setStockLevel(Integer.parseInt(txtUpdateStock.getText()));
                selectedItem.setReorderLevel(Integer.parseInt(txtUpdateReorder.getText()));
                
                String selectedSupplierID = (String) cmbSupplier.getSelectedItem();
                selectedItem.setSupplierID(selectedSupplierID);
                
                selectedItem.setStatus("Not Paid");
                selectedItem.setPaidDate("-");
                selectedItem.setPaidTime("-");
                

                // Update the table
                populateTable(itemsList);

                // Write updated data to the file
                writeItemsToFile(filePath);

                // Clear text fields and reset selection
                clearTextField();
                SelectedRow = -1;

                JOptionPane.showMessageDialog(this, "Item updated successfully.");
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
            // Correct reference to itemsList
            Item selectedItem = itemsList.get(SelectedRow);
            lblItemID.setText(selectedItem.getItemID());
            txtUpdateName.setText(selectedItem.getItemName());
            txtUpdateStock.setText(String.valueOf(selectedItem.getStockLevel()));
            txtUpdateReorder.setText(String.valueOf(selectedItem.getReorderLevel()));
            
            String supplierID = selectedItem.getSupplierID();
            cmbSupplier.setSelectedItem(supplierID);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row.");
        }
    }//GEN-LAST:event_StockDataMouseReleased

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
    if (SelectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to remove.");
    } else {
        // Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete the selected item(s)?", 
                "Confirm Delete", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Remove the selected item from the list
            itemsList.remove(SelectedRow);

            // Update the table
            populateTable(itemsList);

            // Write updated list to the file
            writeItemsToFile(filePath);

            // Clear text fields and reset selection
            clearTextField();
            SelectedRow = -1;

            JOptionPane.showMessageDialog(this, "Item removed successfully.");
        }
    }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSupplierActionPerformed
public void clearTextField(){
    lblItemID.setText("<ID>");
    txtUpdateName.setText("");
    txtUpdateStock.setText("");
    txtUpdateReorder.setText("");
    if (cmbSupplier.getItemCount() > 0) {
        cmbSupplier.setSelectedIndex(0);
    }
}
private void writeItemsToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        for (Item item : itemsList) {
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
            java.util.logging.Logger.getLogger(ManageStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManageStock(user).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StockData;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JTextField txtUpdateName;
    private javax.swing.JTextField txtUpdateReorder;
    private javax.swing.JTextField txtUpdateStock;
    // End of variables declaration//GEN-END:variables
}
