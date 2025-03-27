package CombinedAssignment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;


public class AddItem extends javax.swing.JFrame {
    static String user;
    private final DefaultTableModel Stock = new DefaultTableModel();
    private final String[] columnName = {"ID","Name","Description","Stock Level","Reorder Level","Price","SupplierID","Status"};
    private final List<Item> itemsList = new ArrayList<>();
    private int SelectedRow = -1;
    private final List<String> supplierIDs = new ArrayList<>();
    
    private static int idCounter = 1;
    
    //File path saved in variable    
    String filePath = "Items"; // Define the file path
    String filePath2 = "Suppliers";
    
    public AddItem(String user) {
        initComponents();
        Stock.setColumnIdentifiers(columnName);
        ImportStockData();
        populateTable(itemsList);
        initializeIDCounter();
        loadSupplierIDs();
        populateComboBox();
        this.user = user;
    }
    
     private void initializeIDCounter() {
        // Find the highest ID in the current itemsList to set the counter correctly
        for (Item item : itemsList) {
            String itemID = item.getItemID();
            if (itemID.startsWith("ID")) {
                try {
                    int num = Integer.parseInt(itemID.substring(2));
                    idCounter = Math.max(idCounter, num + 1);
                } catch (NumberFormatException e) {
                    // Ignore invalid ID formats
                }
            }
        }
    }

    private String generateNextID() {
        return String.format("ID%03d", idCounter++);
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
            item.getStockLevel(),
            item.getReorderLevel(),
            item.getItemPrice(),
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
            cmbSupplierID.addItem(supplierID); // Add each supplier ID to the combo box
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
        btnCancel = new javax.swing.JButton();
        lblItemID = new javax.swing.JLabel();
        txtUpdateDescription = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtUpdateStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUpdateReorder = new javax.swing.JTextField();
        lblSupplierID = new javax.swing.JLabel();
        cmbSupplierID = new javax.swing.JComboBox<>();

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

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Price(RM)/unit");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnBack.setBackground(new java.awt.Color(255, 102, 102));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblItem.setText("ID");
        lblItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Description");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Stock Level");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtUpdateStock.setAlignmentY(1.0F);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Reorder Level");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtUpdateReorder.setAlignmentY(1.0F);

        lblSupplierID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSupplierID.setText("SupplierID");
        lblSupplierID.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout UpdatePanelLayout = new javax.swing.GroupLayout(UpdatePanel);
        UpdatePanel.setLayout(UpdatePanelLayout);
        UpdatePanelLayout.setHorizontalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpdatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UpdatePanelLayout.createSequentialGroup()
                                .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(lblItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(UpdatePanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnCancel))
                            .addGroup(UpdatePanelLayout.createSequentialGroup()
                                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUpdateDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpdateStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpdateReorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUpdatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        UpdatePanelLayout.setVerticalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(txtUpdateDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUpdateReorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUpdatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSupplierID)
                            .addComponent(cmbSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpdatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpdatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearTextField();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            txtUpdateStock.setText(String.valueOf(selectedItem.getStockLevel()));
            txtUpdateReorder.setText(String.valueOf(selectedItem.getReorderLevel()));
            txtUpdatePrice.setText(String.valueOf(selectedItem.getItemPrice()));
            
            String supplierID = selectedItem.getSupplierID();
            cmbSupplierID.setSelectedItem(supplierID);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row.");
        }
    }//GEN-LAST:event_StockDataMouseReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Read data from text fields
        String itemID = generateNextID();
        lblItemID.setText(itemID);
        //Use generateNextID() for unique IDs
    
        String itemName = txtUpdateName.getText();
        String itemDesc = txtUpdateDescription.getText();
        String supplierID = cmbSupplierID.getSelectedItem().toString();

        int stockLevel, reorderLevel;
        double itemPrice;

        // Validate inputs
        if (itemID.equals("<ID>") || itemName.isEmpty() || itemDesc.isEmpty() || supplierID.equals("<ID>") || supplierID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            stockLevel = Integer.parseInt(txtUpdateStock.getText());
            reorderLevel = Integer.parseInt(txtUpdateReorder.getText());
            itemPrice = Double.parseDouble(txtUpdatePrice.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Stock Level, Reorder Level, and Price.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new Item object
        Item newItem = new Item(itemID, itemName, itemDesc, stockLevel, reorderLevel, itemPrice, supplierID, "Not Paid", "-", "-");

        // Add the new item to the list
        itemsList.add(newItem);

        // Write the updated list back to the file
        writeItemsToFile(filePath);

        // Refresh the table
        populateTable(itemsList);

        // Clear the input fields
        clearTextField();

        // Confirm addition
        JOptionPane.showMessageDialog(this, "Item successfully added.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAddActionPerformed

    public void clearTextField(){
        lblItemID.setText("<ID>");
        txtUpdateName.setText("");
        txtUpdateDescription.setText("");
        txtUpdateStock.setText("");
        txtUpdateReorder.setText("");
        txtUpdatePrice.setText("");
        cmbSupplierID.setSelectedIndex(0);
    }
    
    private void writeItemsToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Item item : itemsList) {
                // Serialize each Item object
                oos.writeObject(item);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StockData;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cmbSupplierID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblSupplierID;
    private javax.swing.JTextField txtUpdateDescription;
    private javax.swing.JTextField txtUpdateName;
    private javax.swing.JTextField txtUpdatePrice;
    private javax.swing.JTextField txtUpdateReorder;
    private javax.swing.JTextField txtUpdateStock;
    // End of variables declaration//GEN-END:variables
}
