package CombinedAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Finance extends javax.swing.JFrame {
    static String user;
    
    // Attempts to load users, passwords and roles from the file
    Map<String, User> users = loadUsers("users.txt");
    
    public Finance(String user) {
        this.user = user;
        initComponents();
        lblTitle.setText("Welcome, " + user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        Verificationbtn = new javax.swing.JButton();
        checkbtn = new javax.swing.JButton();
        paymentbtn = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome, Finance Manager");

        Verificationbtn.setBackground(new java.awt.Color(153, 255, 153));
        Verificationbtn.setText("Verify Purchase Orders for Payment");
        Verificationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificationbtnActionPerformed(evt);
            }
        });

        checkbtn.setBackground(new java.awt.Color(255, 204, 51));
        checkbtn.setText("Check Stock Status");
        checkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtnActionPerformed(evt);
            }
        });

        paymentbtn.setBackground(new java.awt.Color(153, 153, 255));
        paymentbtn.setText("Make Payment");
        paymentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentbtnActionPerformed(evt);
            }
        });

        logoutbtn.setBackground(new java.awt.Color(255, 102, 102));
        logoutbtn.setText("Logout");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Verificationbtn)
                            .addComponent(paymentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(checkbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Verificationbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerificationbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificationbtnActionPerformed
        new VerifyPurchaseOrdersforpayment(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VerificationbtnActionPerformed

    private void checkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbtnActionPerformed
        new checkstockstatus(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_checkbtnActionPerformed

    private void paymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentbtnActionPerformed
        new makepayment(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_paymentbtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        String role = getRole(user, users);
        
        if (role.equals("Administrator")) {
            new AdminUI(user).setVisible(true);
            this.setVisible(false);
        }
        else {
            new LoginUI().setVisible(true);
            this.setVisible(false);
        }        
    }//GEN-LAST:event_logoutbtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Finance financeFrame = new Finance(user);
                financeFrame.setSize(600, 400);  // Set window size
                financeFrame.setVisible(true);
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
    private javax.swing.JButton Verificationbtn;
    private javax.swing.JButton checkbtn;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JButton paymentbtn;
    // End of variables declaration//GEN-END:variables
}
