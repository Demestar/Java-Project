package CombinedAssignment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;


public class ManageItem extends javax.swing.JFrame {
    static String user;
    private final DefaultTableModel Stock = new DefaultTableModel();
    private final String[] columnName = {"ID","Name","Description","Price","Status"};
    private final List<Item> itemsList = new ArrayList<>();
    private int SelectedRow = -1;
    
    //File path saved in variable    
    String filePath = "Items"; // Define the file path
    
    public ManageItem(String user) {
        initComponents();
        Stock.setColumnIdentifiers(columnName);
        ImportStockData();
        populateTable(itemsList);
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
            item.getItemDesc(),
            item.getItemPrice(),
            item.getStatus()
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
        txtUpdatePrice = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblItem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUpdateName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        lblItemID = new javax.swing.JLabel();
        txtUpdateDescription = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpdatePanel.setEnabled(false);
        UpdatePanel.setMaximumSize(new java.awt.Dimension(0, 0));

        StockData.setModel(Stock);
        StockData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StockDataMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(StockData);

        jLabel5.setText("Price(RM)/unit");
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

        jLabel3.setText("Description");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnEdit.setBackground(new java.awt.Color(255, 204, 51));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblItemID.setText("<ID>");

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpdatePanelLayout = new javax.swing.GroupLayout(UpdatePanel);
        UpdatePanel.setLayout(UpdatePanelLayout);
        UpdatePanelLayout.setHorizontalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(lblItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtUpdatePrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(txtUpdateDescription, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtUpdateName, javax.swing.GroupLayout.Alignment.LEADING))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        UpdatePanelLayout.setVerticalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
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
                            .addComponent(txtUpdateDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUpdatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpdatePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        int confirm = JOptionPane.showConfirmDialog(this, "Editing an item resets its status to Not Paid. Proceed to edit?", "Confirm", JOptionPane.YES_NO_OPTION);
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
                selectedItem.setItemDesc(txtUpdateDescription.getText());
                selectedItem.setItemPrice(Double.parseDouble(txtUpdatePrice.getText()));
                
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
            txtUpdateDescription.setText(selectedItem.getItemDesc());
            txtUpdatePrice.setText(String.valueOf(selectedItem.getItemPrice()));
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row.");
        }
    }//GEN-LAST:event_StockDataMouseReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    clearTextField();
    }//GEN-LAST:event_btnCancelActionPerformed
public void clearTextField(){
    lblItemID.setText("<ID>");
    txtUpdateName.setText("");
    txtUpdateDescription.setText("");
    txtUpdatePrice.setText("");
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
            java.util.logging.Logger.getLogger(ManageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageItem(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StockData;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JTextField txtUpdateDescription;
    private javax.swing.JTextField txtUpdateName;
    private javax.swing.JTextField txtUpdatePrice;
    // End of variables declaration//GEN-END:variables
}
