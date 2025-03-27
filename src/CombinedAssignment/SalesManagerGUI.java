package CombinedAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SalesManagerGUI extends javax.swing.JFrame {
    static String user;

    // Attempts to load users, passwords and roles from the file
    Map<String, User> users = loadUsers("users.txt");
    
    public SalesManagerGUI(String user) {
        this.user = user;
        initComponents();
        lblTitle.setText("Welcome, " + this.user);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnCreatePR = new javax.swing.JButton();
        btnViewItem = new javax.swing.JButton();
        btnSalesReport = new javax.swing.JButton();
        btnSalesEntry = new javax.swing.JButton();
        btnViewPO = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome, Sales Manager");

        btnCreatePR.setBackground(new java.awt.Color(153, 255, 51));
        btnCreatePR.setText("Manage PR");
        btnCreatePR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePRActionPerformed(evt);
            }
        });

        btnViewItem.setBackground(new java.awt.Color(153, 153, 255));
        btnViewItem.setText("View items");
        btnViewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewItemActionPerformed(evt);
            }
        });

        btnSalesReport.setBackground(new java.awt.Color(255, 204, 102));
        btnSalesReport.setText("Sales Report");
        btnSalesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesReportActionPerformed(evt);
            }
        });

        btnSalesEntry.setBackground(new java.awt.Color(0, 204, 204));
        btnSalesEntry.setText("Sales Entry");
        btnSalesEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesEntryActionPerformed(evt);
            }
        });

        btnViewPO.setBackground(new java.awt.Color(255, 102, 255));
        btnViewPO.setText("View PO");
        btnViewPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPOActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(255, 51, 0));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreatePR, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btnViewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalesEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btnViewPO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(218, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreatePR, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalesEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewPO, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewItemActionPerformed
       new ViewItems(user).setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnViewItemActionPerformed

    private void btnCreatePRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePRActionPerformed
        new PurchaseRequisitionGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCreatePRActionPerformed

    private void btnSalesEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesEntryActionPerformed
        new SalesEntryGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalesEntryActionPerformed

    private void btnSalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesReportActionPerformed
        new SalesReportGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalesReportActionPerformed

    private void btnViewPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPOActionPerformed
        new ViewPurchaseOrders(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnViewPOActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        String role = getRole(user, users);
        
        if (role.equals("Administrator")) {
            new AdminUI(user).setVisible(true);
            this.setVisible(false);
        }
        else {
            new LoginUI().setVisible(true);
            this.setVisible(false);
        }        
    }//GEN-LAST:event_btnLogOutActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesManagerGUI(user).setVisible(true);
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePR;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSalesEntry;
    private javax.swing.JButton btnSalesReport;
    private javax.swing.JButton btnViewItem;
    private javax.swing.JButton btnViewPO;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
