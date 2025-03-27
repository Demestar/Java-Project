package CombinedAssignment;

public class AdminUI extends javax.swing.JFrame {
    static String user;

    public AdminUI(String user) {
        this.user = user;
        initComponents();
        lblTitle.setText("Welcome, " + this.user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnManageUsers = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnInventoryManager = new javax.swing.JButton();
        btnPurchaseManager = new javax.swing.JButton();
        btnSalesManager = new javax.swing.JButton();
        btnFinanceManager = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome, Admin");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("What would you like to do?");

        btnManageUsers.setBackground(new java.awt.Color(153, 153, 255));
        btnManageUsers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnManageUsers.setText("Manage Users");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 153, 153));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnInventoryManager.setBackground(new java.awt.Color(0, 204, 255));
        btnInventoryManager.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInventoryManager.setText("Inventory Manager");
        btnInventoryManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryManagerActionPerformed(evt);
            }
        });

        btnPurchaseManager.setBackground(new java.awt.Color(153, 255, 153));
        btnPurchaseManager.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPurchaseManager.setText("Purchase Manager");
        btnPurchaseManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseManagerActionPerformed(evt);
            }
        });

        btnSalesManager.setBackground(new java.awt.Color(255, 204, 102));
        btnSalesManager.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalesManager.setText("Sales Manager");
        btnSalesManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesManagerActionPerformed(evt);
            }
        });

        btnFinanceManager.setBackground(new java.awt.Color(255, 102, 255));
        btnFinanceManager.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinanceManager.setText("Finance Manager");
        btnFinanceManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceManagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalesManager)
                            .addComponent(btnInventoryManager)
                            .addComponent(btnManageUsers))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPurchaseManager)
                            .addComponent(btnFinanceManager)
                            .addComponent(btnLogout))
                        .addGap(44, 44, 44)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInventoryManager)
                    .addComponent(btnPurchaseManager))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalesManager)
                    .addComponent(btnFinanceManager))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageUsers)
                    .addComponent(btnLogout))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new LoginUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
        new UserManagementUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnInventoryManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryManagerActionPerformed
        new Inventory_Page(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInventoryManagerActionPerformed

    private void btnPurchaseManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseManagerActionPerformed
        new PurchaseManagerGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPurchaseManagerActionPerformed

    private void btnSalesManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesManagerActionPerformed
        new SalesManagerGUI(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalesManagerActionPerformed

    private void btnFinanceManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceManagerActionPerformed
        new Finance(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFinanceManagerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinanceManager;
    private javax.swing.JButton btnInventoryManager;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnPurchaseManager;
    private javax.swing.JButton btnSalesManager;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
