package CombinedAssignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;
import javax.swing.table.TableRowSorter;

public class Inventory_Page extends javax.swing.JFrame {
    static String user;
    private final DefaultTableModel Stock = new DefaultTableModel();
    private final String[] columnName = {"ID","Name","Description","Stock Level","Reorder Level","Price","SupplierID","Status"};
    private final List<Item> itemsList = new ArrayList<>();

    // Attempts to load users, passwords and roles from the file
    Map<String, User> users = loadUsers("users.txt");
    
//File path saved in variable    
String filePath = "Items"; // Define the file path

//Rread Data from file Items.txt
    private void ImportStockData() {
    itemsList.clear();
    File file = new File(filePath);

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
    public Inventory_Page(String user) {
        this.user = user;
        initComponents();
        Stock.setColumnIdentifiers(columnName);
        ImportStockData(); // Read data from the file
        populateTable(itemsList);
        lblTitle.setText("Welcome, " + user);
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

    private void sortTableByAttribute(String attribute) {
        // Map the selected attribute to the table column index
    int columnIndex = switch (attribute) {
        case "ID" -> 0;
        case "Name" -> 1;
        case "Description" -> 2;
        case "Stock" -> 3;
        case "Price" -> 4;
        case "Reorder Level" -> 5;
        case "SupplierID" -> 6;
        default -> -1; // Invalid attribute
    };

    if (columnIndex != -1) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(Stock);
        StockData.setRowSorter(sorter); // Attach the sorter to the JTable

        // Apply custom comparators for numeric columns
        sorter.setComparator(3, (o1, o2) -> {
            int stock1 = Integer.parseInt(o1.toString());
            int stock2 = Integer.parseInt(o2.toString());
            return Integer.compare(stock1, stock2);
        });
        sorter.setComparator(4, (o1, o2) -> {
            double price1 = Double.parseDouble(o1.toString());
            double price2 = Double.parseDouble(o2.toString());
            return Double.compare(price1, price2);
        });
        sorter.setComparator(5, (o1, o2) -> {
            int reorder1 = Integer.parseInt(o1.toString());
            int reorder2 = Integer.parseInt(o2.toString());
            return Integer.compare(reorder1, reorder2);
        });

        // Apply ascending sorting based on the selected column
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort(); // Trigger the sorting
    }else {
        System.err.println("Invalid filter attribute selected.");
    }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        popupMenu1 = new java.awt.PopupMenu();
        javax.swing.JPanel InventoryPanel = new javax.swing.JPanel();
        btnManageStock = new javax.swing.JButton();
        btnManageItem = new javax.swing.JButton();
        btnManageSupplier = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        StockData = new javax.swing.JTable();
        cmbFilter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Manager Screen");
        setAutoRequestFocus(false);

        InventoryPanel.setEnabled(false);

        btnManageStock.setBackground(new java.awt.Color(0, 255, 204));
        btnManageStock.setText("Manage Stock");
        btnManageStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageStockActionPerformed(evt);
            }
        });

        btnManageItem.setBackground(new java.awt.Color(255, 102, 255));
        btnManageItem.setText("Manage Items");
        btnManageItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageItemActionPerformed(evt);
            }
        });

        btnManageSupplier.setBackground(new java.awt.Color(255, 204, 51));
        btnManageSupplier.setText("Manage Suppliers");
        btnManageSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSupplierActionPerformed(evt);
            }
        });

        StockData.setModel(Stock);
        StockData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StockDataMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(StockData);

        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Description", "Price", "Stock", "Reorder Level", "SupplierID" }));
        cmbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilterActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter by:");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome, InventoryManager");

        btnReturn.setBackground(new java.awt.Color(255, 102, 102));
        btnReturn.setText("Logout");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnAddItem.setBackground(new java.awt.Color(153, 153, 255));
        btnAddItem.setText("Add New Items");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
        InventoryPanel.setLayout(InventoryPanelLayout);
        InventoryPanelLayout.setHorizontalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnManageStock, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnManageItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnManageSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnReturn)
                .addGap(159, 159, 159)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InventoryPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddItem, btnManageItem, btnManageStock});

        InventoryPanelLayout.setVerticalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnReturn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageItem, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageStock, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InventoryPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InventoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StockDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockDataMouseReleased
     
    }//GEN-LAST:event_StockDataMouseReleased

    private void btnManageStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStockActionPerformed
    ManageStock updatestock = new ManageStock(user);
    updatestock.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnManageStockActionPerformed

    private void btnManageItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageItemActionPerformed
    ManageItem manageitem = new ManageItem(user);
    manageitem.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnManageItemActionPerformed

    private void btnManageSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSupplierActionPerformed
        ManageSupplier managesupplier = new ManageSupplier(user);    
        managesupplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManageSupplierActionPerformed

    private void cmbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilterActionPerformed
        String selectedFilter = (String) cmbFilter.getSelectedItem();
    if (selectedFilter != null) {
        sortTableByAttribute(selectedFilter);
    }
    }//GEN-LAST:event_cmbFilterActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        String role = getRole(user, users);
        
        if (role.equals("Administrator")) {
            new AdminUI(user).setVisible(true);
            this.setVisible(false);
        }
        else {
            new LoginUI().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
       AddItem additem = new AddItem(user);    
        additem.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddItemActionPerformed

   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Inventory_Page(user).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StockData;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnManageItem;
    private javax.swing.JButton btnManageStock;
    private javax.swing.JButton btnManageSupplier;
    private javax.swing.JButton btnReturn;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
