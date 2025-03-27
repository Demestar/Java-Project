package CombinedAssignment;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PurchaseManagerGUI extends javax.swing.JFrame {
    static String user;
    static String filePath1 = "Items";
    static String filePath2 = "Suppliers";
    static String filePath3 = "purchase_requisition.txt";
    
    private DefaultTableModel modelView = new DefaultTableModel();
    private final List<Item> itemsList = new ArrayList<>();
    private final List<Supplier> SupplierList = new ArrayList<>();
    
    // Attempts to load users, passwords and roles from the file
    Map<String, User> users = loadUsers("users.txt");
    
    private void ImportStockData(String file_path) {
        itemsList.clear();
        File file = new File(file_path);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Item item = (Item) ois.readObject(); // Read each Item object
                    itemsList.add(item); // Add the Item object to the list
                } catch (EOFException e){
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    
    private void ImportStockData2(String file_path) {
        SupplierList.clear(); // Clear existing data before importing
        File file = new File(file_path);

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
    }
    
    private void populateTable(List<Item> itemsList) {
        modelView.setRowCount(0); // Clear existing data in the table
        for (Item item : itemsList) {
            // Extract attributes from each Item object
            Object[] row = {
                item.getItemID(),
                item.getItemName(),
                item.getItemDesc(),
                item.getStockLevel(),
                item.getReorderLevel(),
                item.getItemPrice(),
                item.getSupplierID()
            };
            modelView.addRow(row); // Add the row to the table model
        }
    }
    
    private void populateTable2 (List<Supplier> SupplierList) {
        modelView.setRowCount(0); // Clear existing data in the table
        for (Supplier supply : SupplierList) {
            // Extract attributes from each Item object
            Object[] row = {
                supply.getSupplierID(),
                supply.getSupplierName(),
                supply.getSupplierContact(),
                supply.getPaymentStatus()
            };
            modelView.addRow(row); // Add the row to the table model
        }
    }
    
    private void loadPR(String file_path) {
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assume data in item.txt is comma-separated: ItemID,ItemName,Price,Stock
                String[] rowData = line.split(",");
                modelView.addRow(rowData); // Add each row to the table
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading items: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    //Function that attempts to load usernames, passwords and roles
    private static Map<String, User> loadUsers(String fileName) {
        Map<String, User> users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 5) {
                    String username = parts[0];
                    String password = parts[1];
                    String role = parts[2];
                    String gender = parts[3];
                    String email = parts[4];
                    users.put(username, new User(username, password, role, gender, email));
                }
            }
        } catch (IOException e) {
        }
        return users;
    }
    
    //Function to get user's role
    private static String getRole(String username, Map<String, User> users) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return user.getRole();
        }
        else {
            return null;
        }
    }
    
    public PurchaseManagerGUI(String user) {
        this.user = user;
        initComponents();
        lblTitle.setText("Welcome, " + user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnViewSuppliers = new javax.swing.JButton();
        btnViewRequisitions = new javax.swing.JButton();
        ApproveRequisition = new javax.swing.JButton();
        PurchaseOrder = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        btnViewItems = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome, Purchase Manager");

        btnViewSuppliers.setBackground(new java.awt.Color(0, 255, 204));
        btnViewSuppliers.setText("View Suppliers");
        btnViewSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSuppliersActionPerformed(evt);
            }
        });

        btnViewRequisitions.setBackground(new java.awt.Color(255, 102, 255));
        btnViewRequisitions.setText("View Requisitions");
        btnViewRequisitions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequisitionsActionPerformed(evt);
            }
        });

        ApproveRequisition.setBackground(new java.awt.Color(204, 255, 204));
        ApproveRequisition.setText("Approve Requisitions");
        ApproveRequisition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveRequisitionActionPerformed(evt);
            }
        });

        PurchaseOrder.setBackground(new java.awt.Color(102, 102, 255));
        PurchaseOrder.setText("Purchase Order");
        PurchaseOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseOrderActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(255, 102, 102));
        Logout.setText("Log Out");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        btnViewItems.setBackground(new java.awt.Color(255, 204, 102));
        btnViewItems.setText("View Items");
        btnViewItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewItemsActionPerformed(evt);
            }
        });

        tblView.setModel(modelView);
        jScrollPane1.setViewportView(tblView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PurchaseOrder)
                    .addComponent(Logout)
                    .addComponent(ApproveRequisition)
                    .addComponent(btnViewRequisitions)
                    .addComponent(btnViewSuppliers)
                    .addComponent(btnViewItems))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewItems)
                .addGap(18, 18, 18)
                .addComponent(btnViewSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewRequisitions)
                .addGap(18, 18, 18)
                .addComponent(ApproveRequisition, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PurchaseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logout)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSuppliersActionPerformed
        modelView.setRowCount(0);
        String[] columnName = {"ID","Name","Contact No","Payment Status"};
        modelView.setColumnIdentifiers(columnName);
        ImportStockData2(filePath2);
        populateTable2(SupplierList);
    }//GEN-LAST:event_btnViewSuppliersActionPerformed

    private void btnViewRequisitionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequisitionsActionPerformed
        modelView.setRowCount(0);
        String[] columnName = {"Requisition ID", "Created Date", "Item Name", "Quantity", "Status"};
        modelView.setColumnIdentifiers(columnName);
        loadPR(filePath3);
    }//GEN-LAST:event_btnViewRequisitionsActionPerformed

    private void ApproveRequisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveRequisitionActionPerformed
        new ApproveRequisitionGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ApproveRequisitionActionPerformed

    private void PurchaseOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseOrderActionPerformed
        new PurchaseOrderGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_PurchaseOrderActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        String role = getRole(user, users);
        
        if (role.equals("Administrator")) {
            new AdminUI(user).setVisible(true);
            this.setVisible(false);
        }
        else {
            new LoginUI().setVisible(true);
            this.setVisible(false);
        }                
    }//GEN-LAST:event_LogoutActionPerformed

    private void btnViewItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewItemsActionPerformed
       modelView.setRowCount(0);
       String[] columnNames = {"ID","Name","Description","Stock Level","Reorder Level","Price(RM)/unit","SupplierID"};
       modelView.setColumnIdentifiers(columnNames);
       ImportStockData(filePath1); // Read data from the file
       populateTable(itemsList);
    }//GEN-LAST:event_btnViewItemsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PurchaseManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseManagerGUI(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApproveRequisition;
    private javax.swing.JButton Logout;
    private javax.swing.JButton PurchaseOrder;
    private javax.swing.JButton btnViewItems;
    private javax.swing.JButton btnViewRequisitions;
    private javax.swing.JButton btnViewSuppliers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblView;
    // End of variables declaration//GEN-END:variables
}
