package CombinedAssignment;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PurchaseOrderGUI extends javax.swing.JFrame {
    static int selectedIndex = -1;
    static String user;
    
    String[] columnNames = {"Order ID", "Item Name", "Price", "Stock", "Status"};
    private DefaultTableModel modelPurchaseOrders = new DefaultTableModel();
    
    public PurchaseOrderGUI(String user) {
        modelPurchaseOrders.setColumnIdentifiers(columnNames);
        this.user = user;
        initComponents();
        loadPO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtboxName = new javax.swing.JTextField();
        txtboxPrice = new javax.swing.JTextField();
        txtboxStock = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchaseOrders = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Stock");

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("Purchase Order Management");

        txtboxName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtboxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxNameActionPerformed(evt);
            }
        });

        txtboxPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtboxPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxPriceActionPerformed(evt);
            }
        });

        txtboxStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtboxStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxStockActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(51, 255, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 204, 51));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 102, 102));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblPurchaseOrders.setModel(modelPurchaseOrders);
        tblPurchaseOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPurchaseOrdersMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPurchaseOrders);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addGap(69, 69, 69)
                                        .addComponent(btnEdit))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(btnDelete)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtboxName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtboxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtboxStock, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtboxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtboxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtboxStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit))
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtboxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboxNameActionPerformed

    private void txtboxPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboxPriceActionPerformed

    private void txtboxStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboxStockActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new PurchaseManagerGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblPurchaseOrdersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPurchaseOrdersMouseReleased
        selectedIndex = tblPurchaseOrders.getSelectedRow();
    }//GEN-LAST:event_tblPurchaseOrdersMouseReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Get input values from text fields
        String name = txtboxName.getText();
        String priceText = txtboxPrice.getText();
        String stockText = txtboxStock.getText();

        // Validate input
        if (name.isEmpty() || priceText.isEmpty() || stockText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double price = (int)Double.parseDouble(priceText);
            int stock = Integer.parseInt(stockText);

            createPO(name, price, stock);

            // Show success message
            JOptionPane.showMessageDialog(this, "Purchase Order created successfully!");

            // Refresh the table data
            loadPO();
            
            // Clear input fields
            txtboxName.setText("");
            txtboxPrice.setText("");
            txtboxStock.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantity and Stock must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Get the selected row index
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get values from input fields
        String updatedName = txtboxName.getText();
        String updatedPriceText = txtboxPrice.getText();
        String updatedStockText = txtboxStock.getText();

        // Validate input
        if (updatedName.isEmpty() || updatedPriceText.isEmpty() || updatedStockText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Confirm edit
        int confirm = JOptionPane.showConfirmDialog(this, "Editing an order resets its status to Pending. Proceed with editing?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            double updatedPrice = (int)Double.parseDouble(updatedPriceText);
            int updatedStock = Integer.parseInt(updatedStockText);

            // Get the Order ID of the selected row
            String orderID = (String)modelPurchaseOrders.getValueAt(selectedIndex, 0);

            // Read all lines from the file
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("purchase_order.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] rowData = line.split(",");
                    if (rowData[0].equals(orderID)) {
                        // Replace the old data with updated data
                        line = orderID + "," + updatedName + "," + updatedPrice + "," + updatedStock + "," + "Pending";
                    }
                    lines.add(line);
                }
            }

            // Write the updated lines back to the file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("purchase_order.txt"))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }

             // Refresh the table data
            loadPO();
            
            // Clear input fields
            txtboxName.setText("");
            txtboxPrice.setText("");
            txtboxStock.setText("");

            JOptionPane.showMessageDialog(this, "Purchase Order updated successfully!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price and Stock must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating order: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this order?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Get the Requisition ID of the selected row
        String orderID = (String)modelPurchaseOrders.getValueAt(selectedIndex, 0);

        // Read all lines from the file
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("purchase_order.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                if (!rowData[0].equals(orderID)) {
                    lines.add(line); // Add all lines except the one to delete
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading orders: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Write the updated lines back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("purchase_order.txt"))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error deleting order: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Refresh the table data
        loadPO();

        JOptionPane.showMessageDialog(this, "Purchase Order deleted successfully!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void loadPO() {
        modelPurchaseOrders.setRowCount(0); // Clear existing data in the table
        
        try (BufferedReader br = new BufferedReader(new FileReader("purchase_order.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assume data in item.txt is comma-separated: ItemID,ItemName,Price,Stock
                String[] rowData = line.split(",");
                modelPurchaseOrders.addRow(rowData); // Add each row to the table
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading items: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void createPO(String itemName, double price, int stock) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("purchase_order.txt", true))) {
            // Generate a unique requisition ID
            String orderID = "PO" + System.currentTimeMillis();
            String status = "Pending"; // Default status

            // Write the purchase requisition details to the file
            String line = orderID + "," + itemName + "," + price + "," + stock + "," + status;
            bw.write(line);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrderGUI(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblPurchaseOrders;
    private javax.swing.JTextField txtboxName;
    private javax.swing.JTextField txtboxPrice;
    private javax.swing.JTextField txtboxStock;
    // End of variables declaration//GEN-END:variables
}
